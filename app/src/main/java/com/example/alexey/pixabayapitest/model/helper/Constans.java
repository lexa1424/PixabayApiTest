package com.example.alexey.pixabayapitest.model.helper;

/**
 * Created by Alexey on 26.01.2017.
 */

public class Constans {

    public static final String KEY = "4398166-ba15100db23f77c642c6713af";

    public static final class HTTP {

        public static final String BASE_URL = "https://pixabay.com";
    }

    public static final class DATABASE {

    }

    public static final class ORDER {

        public static final String POPULAR = "popular";
        public static final String LATEST = "latest";
    }

    public static final class CATEGORIES {

        public static final String FASION = "fashion";
        public static final String NATURE = "nature";
        public static final String BACKGROUNDS = "backgrounds";
        public static final String SCIENCE = "science";
        public static final String EDUCATION = "education";
        public static final String PEOPLE = "people";
        public static final String FEELINGS = "feelings";
        public static final String RELIGION = "religion";
        public static final String HEALTH = "health";
        public static final String PLACES = "places";
        public static final String ANIMALS = "animals";
        public static final String INDUSTRY = "industry";
        public static final String FOOD = "food";
        public static final String COMPUTER = "computer";
        public static final String SPORTS = "sports";
        public static final String TRANSPORTATION = "transportation";
        public static final String TRAVEL = "travel";
        public static final String BUILDINGS = "buildings";
        public static final String BUSINESS = "business";
        public static final String MUSIC = "music";
    }

    public static final class REFERENCE {
        public static final String CATEGORY = Config.PACKAGE_NAME + "category";
        public static final String IMAGE = Config.PACKAGE_NAME + "image";
    }

    public static final class Config {
        public static final String PACKAGE_NAME = "com.exemple.alexey.pixabayapitest.";
    }
}
