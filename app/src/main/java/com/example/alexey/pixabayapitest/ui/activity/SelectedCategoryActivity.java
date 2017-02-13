package com.example.alexey.pixabayapitest.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.alexey.pixabayapitest.R;
import com.example.alexey.pixabayapitest.controller.RestManager;
import com.example.alexey.pixabayapitest.model.Image;
import com.example.alexey.pixabayapitest.model.ImageList;
import com.example.alexey.pixabayapitest.model.adapter.ImageAdapter;
import com.example.alexey.pixabayapitest.model.helper.Constans;
import com.example.alexey.pixabayapitest.ui.tabs.CategoriesTab;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SelectedCategoryActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RestManager mRestManager;
    private ImageAdapter mImageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_category);

        Intent intent = getIntent();
        String category = (String)intent.getSerializableExtra(Constans.REFERENCE.CATEGORY);

        configViews();

        Toolbar mActionBarToolbar = (Toolbar) findViewById(R.id.toolbar_actionbar);
        setSupportActionBar(mActionBarToolbar);
        getSupportActionBar().setTitle(category);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mRestManager = new RestManager();

        getData(category);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        backToHome();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                backToHome();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_category_activity, menu);
        return super.onCreateOptionsMenu(menu);
    }

    private void backToHome() {
        startActivity(new Intent(SelectedCategoryActivity.this, MainActivity.class));
    }

    private void getData(String category) {
        Call<ImageList> imagesCall = mRestManager.getUserService().getImages(Constans.KEY, Constans.ORDER.LATEST, category);
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

    private void configViews() {
        mRecyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setRecycledViewPool(new RecyclerView.RecycledViewPool());
        mRecyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));
        mImageAdapter = new ImageAdapter();
        mRecyclerView.setAdapter(mImageAdapter);
    }
}
