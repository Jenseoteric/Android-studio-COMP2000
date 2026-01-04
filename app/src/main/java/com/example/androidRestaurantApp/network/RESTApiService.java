package com.example.androidRestaurantApp.network;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

import com.example.androidRestaurantApp.data.model.MenuItems;
import com.example.androidRestaurantApp.data.model.Reservation;
public interface RESTApiService {

    @GET("menu")
    Call<List<MenuItems>> getMenuItems();

    @POST("reservations")
    Call<Void> createReservation(@Body Reservation reservation);
}
