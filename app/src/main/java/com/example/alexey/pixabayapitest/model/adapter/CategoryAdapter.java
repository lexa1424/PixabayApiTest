package com.example.alexey.pixabayapitest.model.adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alexey.pixabayapitest.CategoriesTab;
import com.example.alexey.pixabayapitest.MainActivity;
import com.example.alexey.pixabayapitest.R;
import com.example.alexey.pixabayapitest.SelectedCategoryActivity;
import com.example.alexey.pixabayapitest.model.Category;
import com.example.alexey.pixabayapitest.model.Image;
import com.example.alexey.pixabayapitest.model.helper.Constans;

import java.util.ArrayList;
import java.util.List;



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

    public Category getSelectedCategory(int position) {
        return mCategories.get(position);
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
