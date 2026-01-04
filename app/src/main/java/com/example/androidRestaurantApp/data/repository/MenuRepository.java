package com.example.androidRestaurantApp.data.repository;

import com.example.androidRestaurantApp.data.model.MenuItems;
import com.example.androidRestaurantApp.network.RESTApiService;

public class MenuRepository {

    private RESTApiService restApiService;

    public MenuRepository(RESTApiService restApiService) {
        this.restApiService = restApiService;
    }

    public List<MenuItems> getMenu() {
        return RESTApiService.getMenuItems();
    }
}
