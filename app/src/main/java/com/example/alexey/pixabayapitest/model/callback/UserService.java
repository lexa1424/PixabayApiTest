package com.example.alexey.pixabayapitest.model.callback;

import com.example.alexey.pixabayapitest.model.ImageList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;



public interface UserService {

    @GET("/api/")
    Call<ImageList> getImages(@Query("key") String key,
                              @Query("q") String params,
                              @Query("page") Integer page,
                              @Query("per_page") Integer perPage,
                              @Query("order") String order);

    @GET("/api/")
    Call<ImageList> getImages(@Query("key") String key,
                              @Query("order") String order);

    @GET("/api/")
    Call<ImageList> getImages(@Query("key") String key,
                              @Query("order") String order,
                              @Query("category") String category);

}
