package com.example.alexey.pixabayapitest.controller;

import com.example.alexey.pixabayapitest.model.callback.UserService;
import com.example.alexey.pixabayapitest.model.helper.Constans;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Alexey on 26.01.2017.
 */

public class RestManager {

    private UserService userService;


    public UserService getUserService() {
        if(userService == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Constans.HTTP.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            userService = retrofit.create(UserService.class);
        }

        return userService;
    }
}
