package com.example.androidRestaurantApp.data.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.androidRestaurantApp.data.model.MenuItems;
import com.example.androidRestaurantApp.network.RESTApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Callback;
import retrofit2.Call;
import retrofit2.Response;

public class MenuRepository {

    private RESTApiService apiService;
    //this is used to communicate with the REST api itself

    public MenuRepository(RESTApiService apiService) {

        this.apiService = apiService;

    }

    //used to wrap network calls.
    public LiveData<List<MenuItems>> getMenuItems() {

        MutableLiveData<List<MenuItems>> data = new MutableLiveData<>();

        // ---------
        // commented out because I was not able to get it to work for now.)


        /*
        apiService.getMenuItems().enqueue(new Callback<List<MenuItems>>() {

            @Override
            public void onResponse(Call<List<MenuItems>> call,
                                   Response<List<MenuItems>> response) {

                if (response.isSuccessful() && response.body() != null) {

                    data.setValue(response.body());

                } else {

                    // fallback menu items so UI still works even if endpoint is missing
                    List<MenuItems> fallback = new ArrayList<>();
                    fallback.add(new MenuItems("Cheeseburger", 8.99));
                    fallback.add(new MenuItems("Pizza", 10.50));
                    fallback.add(new MenuItems("Fries", 3.25));

                    data.setValue(fallback);

                }
            }

            @Override
            public void onFailure(Call<List<MenuItems>> call, Throwable t) {

                // fallback menu items
                List<MenuItems> fallback = new ArrayList<>();
                fallback.add(new MenuItems("Fish and Chips", 8.99));
                fallback.add(new MenuItems("Pizza", 10.50));
                fallback.add(new MenuItems("Burger", 3.25));

                data.setValue(fallback);

            }
        });
        */

        // fallback menu items


        List<MenuItems> fallback = new ArrayList<>();

        fallback.add(new MenuItems("Cheeseburger", 8.99));

        fallback.add(new MenuItems("Pizza", 10.50));

        fallback.add(new MenuItems("Fish and Chips", 9.25));

        data.setValue(fallback);

        return data;
    }
}
