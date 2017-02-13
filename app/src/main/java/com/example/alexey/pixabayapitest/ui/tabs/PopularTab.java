package com.example.alexey.pixabayapitest.ui.tabs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alexey.pixabayapitest.R;
import com.example.alexey.pixabayapitest.controller.RestManager;
import com.example.alexey.pixabayapitest.model.Image;
import com.example.alexey.pixabayapitest.model.ImageList;
import com.example.alexey.pixabayapitest.model.adapter.ImageAdapter;
import com.example.alexey.pixabayapitest.model.helper.Constans;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;



public class PopularTab extends Fragment{

    private RecyclerView mRecyclerView;
    private RestManager mRestManager;
    private ImageAdapter mImageAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.popular_tab, container, false);

        configViews(rootView);
        mRestManager = new RestManager();

        getData();

        return rootView;
    }

    private void getData() {
        Call<ImageList> imagesCall = mRestManager.getUserService().getImages(Constans.KEY, Constans.ORDER.POPULAR);
        imagesCall.enqueue(new Callback<ImageList>() {
            @Override
            public void onResponse(Call<ImageList> call, Response<ImageList> response) {
                if (response.isSuccessful()) {
                    ImageList imageList = response.body();
                    for(int i = 0; i < imageList.getImages().size(); i++) {
                        Image image = imageList.getImages().get(i);
                        mImageAdapter.addImage(image);
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
        mRecyclerView = (RecyclerView)view.findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setRecycledViewPool(new RecyclerView.RecycledViewPool());
        mRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        mImageAdapter = new ImageAdapter();
        mRecyclerView.setAdapter(mImageAdapter);
    }
}
