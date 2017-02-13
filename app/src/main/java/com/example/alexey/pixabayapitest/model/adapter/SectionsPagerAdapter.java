package com.example.alexey.pixabayapitest.model.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.alexey.pixabayapitest.ui.tabs.CategoriesTab;
import com.example.alexey.pixabayapitest.ui.tabs.LatestTab;
import com.example.alexey.pixabayapitest.ui.tabs.PopularTab;

/**
 * Created by Alexey on 05.02.2017.
 */

public class SectionsPagerAdapter extends FragmentPagerAdapter {


    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        switch (position) {
            case 0:
                CategoriesTab categoriesTab = new CategoriesTab();
                return categoriesTab;
            case 1:
                PopularTab popularTab = new PopularTab();
                return popularTab;
            case 2:
                LatestTab latestTab = new LatestTab();
                return latestTab;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        // Show 3 total pages.
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "CATEGORIES";
            case 1:
                return "POPULAR";
            case 2:
                return "LATEST";
        }
        return null;
    }
}
