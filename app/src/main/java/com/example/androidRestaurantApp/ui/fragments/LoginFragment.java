package com.example.androidRestaurantApp.ui.fragments;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.androidRestaurantApp.R;
import com.example.androidRestaurantApp.data.model.User;
import com.example.androidRestaurantApp.data.repository.AuthRepository;
import com.example.androidRestaurantApp.network.RESTApiService;
import com.google.android.material.textfield.TextInputEditText;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginFragment extends Fragment {

    // fixed student database id (replace with your own student id)
    private final String studentId = "student_1"; //the student ID i used in postman

    public LoginFragment() {

        super(R.layout.fragment_login);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

        TextInputEditText editUsername = view.findViewById(R.id.editUsername);
        TextInputEditText editPassword = view.findViewById(R.id.editPassword);


        Button buttonLogin = view.findViewById(R.id.btnLogin);

        // nav controller for switching screens
        NavController nav = Navigation.findNavController(view);

        // retrofit and api service
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.240.72.69/comp2000/coursework/") // must end with /
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RESTApiService api = retrofit.create(RESTApiService.class);

        // repository to do login requests
        AuthRepository authRepository = new AuthRepository(api);

        buttonLogin.setOnClickListener(v -> {

            //AI helped me understand how to implement this part significantly .
            final String username =
                    editUsername.getText() != null
                            ? editUsername.getText().toString().trim()
                            : "";

            final String password =
                    editPassword.getText() != null
                            ? editPassword.getText().toString().trim()
                            : "";



            // quick validation so app doesnt crash
            if (username.isEmpty() || password.isEmpty()) {

                Toast.makeText(requireContext(), "Enter username + password", Toast.LENGTH_SHORT).show();
                return;

            }



            // fetch the user from the API
            authRepository.fetchUser(studentId, username).observe(getViewLifecycleOwner(), result -> {

                // request failed or network failed
                if (result == null || !result.success) {

                    String msg = "Login failed";

                    if (result != null && result.error != null) {
                        msg = result.error;
                    }

                    Toast.makeText(requireContext(), msg, Toast.LENGTH_SHORT).show();
                    return;

                }



                User user = result.data;

                if (user == null) {

                    Toast.makeText(requireContext(), "User not found", Toast.LENGTH_SHORT).show();
                        return;

                }



                // compare passwords
                if (user.password == null || !password.equals(user.password)) {

                    Toast.makeText(requireContext(), "Incorrect password", Toast.LENGTH_SHORT).show();
                    return;

                }



                // role routing
                if (user.usertype != null && user.usertype.equalsIgnoreCase("staff")) {

                    Toast.makeText(requireContext(), "Logged in as Staff", Toast.LENGTH_SHORT).show();

                    nav.navigate(R.id.staffHomeFragment);

                } else {

                    Toast.makeText(requireContext(), "Logged in as Guest", Toast.LENGTH_SHORT).show();
                    nav.navigate(R.id.guestHomeFragment);

                }

            });

        });

    }
}
