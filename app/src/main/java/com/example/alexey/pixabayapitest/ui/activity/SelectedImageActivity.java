package com.example.alexey.pixabayapitest.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;

import com.example.alexey.pixabayapitest.R;
import com.example.alexey.pixabayapitest.model.Image;
import com.example.alexey.pixabayapitest.model.adapter.ImageAdapter;
import com.example.alexey.pixabayapitest.model.helper.Constans;
import com.squareup.picasso.Picasso;

public class SelectedImageActivity extends AppCompatActivity {

    private ImageView mImageView;
    private Toolbar mActionBarToolbar;
    private Image mImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_image);

        Intent intent = getIntent();
        Image image = (Image)intent.getSerializableExtra(Constans.REFERENCE.IMAGE);

        configViews();

        Picasso.with(getApplicationContext()).load(image.getWebformatURL()).into(mImageView);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                overridePendingTransition(R.anim.slide_enter, R.anim.slide_exit);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void configViews() {
        mImageView = (ImageView)findViewById(R.id.selected_image_view);
        mActionBarToolbar = (Toolbar) findViewById(R.id.toolbar_actionbar);
        setSupportActionBar(mActionBarToolbar);
        getSupportActionBar().setTitle("Title");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getSupportActionBar().isShowing()){
                    mActionBarToolbar.animate()
                            .translationY(-mActionBarToolbar.getBottom())
                            .setInterpolator(new AccelerateInterpolator())
                            .withEndAction(new Runnable() {
                                @Override
                                public void run() {
                                    getSupportActionBar().hide();
                                }
                            })
                            .start();
                }
                else {
                    mActionBarToolbar.animate()
                            .translationY(0)
                            .setInterpolator(new DecelerateInterpolator())
                            .start();
                    getSupportActionBar().show();
                }
            }
        });
    }
}
