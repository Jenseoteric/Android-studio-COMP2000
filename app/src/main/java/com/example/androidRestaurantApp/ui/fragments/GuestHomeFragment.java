package com.example.androidRestaurantApp.ui.fragments;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.example.androidRestaurantApp.R;

public class GuestHomeFragment extends Fragment {

    public GuestHomeFragment() {

        super(R.layout.fragment_guest_home);

    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState );


        NavController nav = Navigation.findNavController( view);

        Button buttonMenu = view.findViewById(R.id.buttonGuestMenu);
        Button buttonReservations = view.findViewById(R.id.buttonGuestReservations);
        Button buttonAlerts = view.findViewById(R.id.buttonGuestAlerts);
        Button buttonSettings = view.findViewById(R.id.buttonGuestSettings);


        buttonMenu.setOnClickListener(v -> nav.navigate(R.id.menuFragment));

        buttonReservations.setOnClickListener(v -> nav.navigate(R.id.guestReservationsFragment));

        buttonAlerts.setOnClickListener(v -> nav.navigate(R.id.alertsFragment));

        buttonSettings.setOnClickListener(v -> nav.navigate(R.id.guestSettingsFragment));
    }






}
