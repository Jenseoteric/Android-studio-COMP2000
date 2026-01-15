package com.example.androidRestaurantApp.ui.fragments;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.androidRestaurantApp.R;

public class StaffHomeFragment extends Fragment {

    public StaffHomeFragment() {

        super(R.layout.fragment_staff_home);

    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

        Button buttonStaffSettings = view.findViewById(R.id.buttonStaffSettings);
        Button buttonStaffReservations = view.findViewById(R.id.buttonStaffReservations);
        Button buttonStaffMenu = view.findViewById(R.id.buttonStaffMenu);
        Button buttonStaffMenu2 = view.findViewById(R.id.buttonStaffMenu2);

        NavController navController = Navigation.findNavController(view);


        // settings button
        buttonStaffSettings.setOnClickListener(v -> {

            navController.navigate(R.id.staffSettingsFragment);

        });


        // view reservations button
        buttonStaffReservations.setOnClickListener(v -> {

            navController.navigate(R.id.staffReservationsFragment);

        });


        // manage reservations button (same destination as view reservations for now)
        buttonStaffMenu.setOnClickListener(v -> {

            navController.navigate(R.id.staffReservationsFragment);

        });


        // manage menu items button
        buttonStaffMenu2.setOnClickListener(v -> {

            navController.navigate(R.id.staffMenuManagerFragment);

        });

    }
}
