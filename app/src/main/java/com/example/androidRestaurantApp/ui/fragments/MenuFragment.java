package com.example.androidRestaurantApp.ui.fragments;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidRestaurantApp.R;
import com.example.androidRestaurantApp.data.repository.MenuRepository;
import com.example.androidRestaurantApp.network.RESTApiService;
import com.example.androidRestaurantApp.ui.adapter.MenuAdapter;
import com.example.androidRestaurantApp.ui.viewmodel.MenuViewModel;
import com.example.androidRestaurantApp.ui.viewmodel.ViewModelFactory;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MenuFragment extends Fragment {

    private MenuViewModel viewModel;
    private MenuAdapter adapter;

    public MenuFragment() {
        super(R.layout.fragment_menu);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

        RecyclerView rv = view.findViewById(R.id.recyclerMenu);
        rv.setLayoutManager(new LinearLayoutManager(requireContext()));

        adapter = new MenuAdapter();
        rv.setAdapter(adapter);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.240.72.69/comp2000/coursework/") //this is the RESTAPI server url
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RESTApiService apiService = retrofit.create(RESTApiService.class);
        MenuRepository repo = new MenuRepository(apiService);
        ViewModelFactory factory = new ViewModelFactory(repo);

        viewModel = new ViewModelProvider(this, factory).get(MenuViewModel.class);

        viewModel.getMenuItems().observe(getViewLifecycleOwner(), menuItems -> {
            adapter.setItems(menuItems);
        });
    }
}