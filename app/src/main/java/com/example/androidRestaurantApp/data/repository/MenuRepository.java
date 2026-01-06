package com.example.androidRestaurantApp.data.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.androidRestaurantApp.data.model.MenuItems;
import com.example.androidRestaurantApp.network.RESTApiService;

import java.util.Collections;
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

        apiService.getMenuItems().enqueue(new Callback<List<MenuItems>>() {

            @Override
            public void onResponse(Call<List<MenuItems>> call,
                                   Response<List<MenuItems>> response) {

            if (response.isSuccessful() && response.body() != null)   {
                data.setValue(response.body());

            } else {

                data.setValue(Collections.emptyList());

                }
            }

            @Override
            public void onFailure(Call<List<MenuItems>> call, Throwable t) {
                data.setValue(Collections.emptyList());
                //if something goes wrong, this returns an empty list to avoid system crashing just in case.

            }
        });

        return data;
    }
}
