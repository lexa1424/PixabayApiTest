package com.example.alexey.pixabayapitest;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alexey.pixabayapitest.model.Category;
import com.example.alexey.pixabayapitest.model.adapter.CategoryAdapter;
import com.example.alexey.pixabayapitest.model.helper.Constans;

/**
 * Created by Alexey on 05.02.2017.
 */

public class CategoriesTab extends Fragment {

    private RecyclerView recyclerView;
    private CategoryAdapter categoryAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.categories_tab, container, false);

        configViews(rootView);

        createCategory(Constans.CATEGORIES.ANIMALS, R.drawable.animals);
        createCategory(Constans.CATEGORIES.BUILDINGS, R.drawable.buildings);
        createCategory(Constans.CATEGORIES.BACKGROUNDS, R.drawable.backgrounds);
        createCategory(Constans.CATEGORIES.FASION, R.drawable.fashion);
        createCategory(Constans.CATEGORIES.BUSINESS, R.drawable.business);
        createCategory(Constans.CATEGORIES.COMPUTER, R.drawable.computer);
        createCategory(Constans.CATEGORIES.EDUCATION, R.drawable.education);
        createCategory(Constans.CATEGORIES.FEELINGS, R.drawable.feelings);
        createCategory(Constans.CATEGORIES.FOOD, R.drawable.food);
        createCategory(Constans.CATEGORIES.HEALTH, R.drawable.health);
        createCategory(Constans.CATEGORIES.INDUSTRY, R.drawable.industry);
        createCategory(Constans.CATEGORIES.MUSIC, R.drawable.music);
        createCategory(Constans.CATEGORIES.NATURE, R.drawable.nature);
        createCategory(Constans.CATEGORIES.PEOPLE, R.drawable.people);
        createCategory(Constans.CATEGORIES.PLACES, R.drawable.places);
        createCategory(Constans.CATEGORIES.RELIGION, R.drawable.religion);
        createCategory(Constans.CATEGORIES.SCIENCE, R.drawable.science);
        createCategory(Constans.CATEGORIES.SPORTS, R.drawable.sport);
        createCategory(Constans.CATEGORIES.TRANSPORTATION, R.drawable.transportation);
        createCategory(Constans.CATEGORIES.TRAVEL, R.drawable.travel);

        return rootView;
    }

    private void createCategory(String name, int id) {
        Category category = new Category(name, id);
        categoryAdapter.addCategory(category);
    }

    private void configViews(View view) {
        recyclerView = (RecyclerView)view.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setRecycledViewPool(new RecyclerView.RecycledViewPool());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        categoryAdapter = new CategoryAdapter();
        recyclerView.setAdapter(categoryAdapter);
    }
}
