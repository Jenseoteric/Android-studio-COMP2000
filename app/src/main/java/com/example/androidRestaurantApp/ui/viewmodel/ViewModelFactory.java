package com.example.androidRestaurantApp.ui.viewmodel;
import androidx.lifecycle.ViewModelProvider;

import com.example.androidRestaurantApp.data.model.MenuItems;
import com.example.androidRestaurantApp.data.repository.MenuRepository;

//this class instructs android on how to create my viewmodel
//opting for a shared viewmodel factory rather than
//creating respective main, reservation, menu, settings vm factories for simplicity
//possibly ideal due to a smaller number of viewmodels total.



import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.androidRestaurantApp.data.repository.MenuRepository;

public class ViewModelFactory implements ViewModelProvider.Factory {

    private final MenuRepository menuRepository;

    public ViewModelFactory(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;

    }

    @NonNull


    @Override

    @SuppressWarnings("unchecked")

    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {

        if (modelClass.isAssignableFrom(MenuViewModel.class)) {
            return (T) new MenuViewModel(menuRepository);
        }

        throw new IllegalArgumentException("error: no Viewmodel class matched");
    }
}