package com.example.androidRestaurantApp.ui.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.LiveData;
import com.example.androidRestaurantApp.data.model.MenuItems;
import com.example.androidRestaurantApp.data.repository.MenuRepository;
import java.util.List;

public class MenuViewModel extends ViewModel {
    private MenuRepository menuRepository;
    private LiveData<List<MenuItems>> menuItems;

    public MenuViewModel(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
        this.menuItems = menuRepository.getMenuItems();

    }

    public LiveData<List<MenuItems>> getMenuItems() {
        return menuItems;
    }
}