package com.example.alexey.pixabayapitest;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.alexey.pixabayapitest.controller.RestManager;
import com.example.alexey.pixabayapitest.model.Image;
import com.example.alexey.pixabayapitest.model.ImageList;
import com.example.alexey.pixabayapitest.model.adapter.ImageAdapter;
import com.example.alexey.pixabayapitest.model.helper.Constans;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Alexey on 05.02.2017.
 */

public class LatestTab extends Fragment {

    private RecyclerView recyclerView;
    private RestManager restManager;
    private ImageAdapter imageAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.latest_tab, container, false);

        configViews(rootView);
        restManager = new RestManager();

        getData();

        return rootView;
    }

    private void getData() {
        Call<ImageList> imagesCall = restManager.getUserService().getImages(Constans.KEY, Constans.ORDER.LATEST);
        imagesCall.enqueue(new Callback<ImageList>() {
            @Override
            public void onResponse(Call<ImageList> call, Response<ImageList> response) {
                if (response.isSuccessful()) {
                    ImageList imageList = response.body();
                    for(int i = 0; i < imageList.getImages().size(); i++) {
                        Image image = imageList.getImages().get(i);
                        imageAdapter.addImage(image);
                    }
                }
            }

            @Override
            public void onFailure(Call<ImageList> call, Throwable t) {
                Log.d("TAG", t.getMessage());
            }
        });
    }

    private void configViews(View view) {
        recyclerView = (RecyclerView)view.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setRecycledViewPool(new RecyclerView.RecycledViewPool());
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        imageAdapter = new ImageAdapter();
        recyclerView.setAdapter(imageAdapter);
    }
}
