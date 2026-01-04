package com.example.androiduidesignlab2.data.repository;

import com.example.androiduidesignlab2.data.model.MenuItems;
import com.example.androiduidesignlab2.data.remote.RESTApiService;

public class MenuRepository {

    private RESTApiService restApiService;

    public MenuRepository(RESTApiService restApiService) {
        this.restApiService = restApiService;
    }

    public List<MenuItems> getMenu() {
        return RESTApiService.getMenuItems();
    }
}
