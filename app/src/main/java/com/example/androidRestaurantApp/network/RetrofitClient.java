package com.example.androidRestaurantApp.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {


    private static final String BASE_URL = "http://10.240.72.69/comp2000/coursework/";
    private static Retrofit retrofit;

    public static Retrofit getInstance() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()

                   // .baseUrl()


                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;

    }



}

