package com.example.androiduidesignlab2.data.remote;

public interface RESTApiService {

    List<MenuItems> getMenuItems();

    void createReservation(Reservation reservation);
}
