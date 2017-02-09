package com.example.alexey.pixabayapitest.model;

/**
 * Created by Alexey on 06.02.2017.
 */

public class Category {

    private String name;
    private Integer imageID;

    public Category(String name, Integer imageID) {
        this.name = name;
        this.imageID = imageID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getImageID() {
        return imageID;
    }

    public void setImageID(Integer imageID) {
        this.imageID = imageID;
    }
}
