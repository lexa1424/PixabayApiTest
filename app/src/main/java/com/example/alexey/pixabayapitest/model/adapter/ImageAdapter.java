package com.example.alexey.pixabayapitest.model.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alexey.pixabayapitest.R;
import com.example.alexey.pixabayapitest.model.Image;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexey on 29.01.2017.
 */

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.Holder> {

    public static int VIEW_TYPE_BUTTON = 1;
    public static int VIEW_TYPE_CELL = 2;

    private List<Image> mImages;

    public ImageAdapter() {
        mImages = new ArrayList<>();
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_card, null, false);
        return new Holder(row);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        Image currentImage = mImages.get(position);
        holder.mUserName.setText("User: " + currentImage.getUser());
        holder.mLikesCount.setText("Likes: " + currentImage.getLikes().toString());
        Picasso.with(holder.itemView.getContext()).load(currentImage.getPreviewURL()).into(holder.mImage);
    }

    @Override
    public int getItemCount() {
        return mImages.size();
    }

    public Image getSelectedImage(int position) {
        return mImages.get(position);
    }

    public void addImage(Image image){
        mImages.add(image);
        notifyDataSetChanged();
    }

    public class Holder extends RecyclerView.ViewHolder {

        private ImageView mImage;
        private TextView mUserName;
        private TextView mLikesCount;

        public Holder(View itemView) {
            super(itemView);

            mImage = (ImageView)itemView.findViewById(R.id.thumbnail);
            mUserName = (TextView) itemView.findViewById(R.id.user_name);
            mLikesCount = (TextView) itemView.findViewById(R.id.likes_count);
        }
    }
}
