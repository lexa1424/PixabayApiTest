package com.example.alexey.pixabayapitest.model.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alexey.pixabayapitest.R;
import com.example.alexey.pixabayapitest.model.Category;
import com.example.alexey.pixabayapitest.model.Image;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexey on 06.02.2017.
 */

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.Holder> {

    private List<Category> mCategories;

    public CategoryAdapter () {
        mCategories = new ArrayList<>();
    }

    @Override
    public CategoryAdapter.Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_card, null, false);
        return new Holder(row);
    }

    @Override
    public void onBindViewHolder(CategoryAdapter.Holder holder, int position) {
        Category currentCategory = mCategories.get(position);
        holder.mCategoryName.setText(currentCategory.getName());
        holder.mImage.setImageResource(currentCategory.getImageID());
    }

    @Override
    public int getItemCount() {
        return mCategories.size();
    }

    public void addCategory(Category category){
        mCategories.add(category);
        notifyDataSetChanged();
    }

    public class Holder extends RecyclerView.ViewHolder {

        private ImageView mImage;
        private TextView mCategoryName;

        public Holder(View itemView) {
            super(itemView);

            mImage = (ImageView)itemView.findViewById(R.id.category_image);
            mCategoryName = (TextView) itemView.findViewById(R.id.category_name);
        }
    }
}
