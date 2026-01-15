package com.example.androidRestaurantApp.data.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.androidRestaurantApp.data.model.ApiResult;
import com.example.androidRestaurantApp.data.model.MessageResponse;
import com.example.androidRestaurantApp.data.model.User;
import com.example.androidRestaurantApp.data.model.UserResponse;
import com.example.androidRestaurantApp.network.RESTApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

// used AI to assist in outlining Code Architecture here.


// repo layer for authentication
public class AuthRepository {

    private RESTApiService api;

    public AuthRepository(RESTApiService api) {

        this.api = api;
    }

    //adds personal db to API

    public LiveData<ApiResult<Boolean>> createStudentDb(String studentId) {

        MutableLiveData<ApiResult<Boolean>> out = new MutableLiveData<>();


        api.createStudentDb(studentId).enqueue(new Callback<MessageResponse>()
        {
            @Override

            public void onResponse(Call<MessageResponse> call, Response<MessageResponse> response)
            {
                if (response.isSuccessful())
                {
                    out.setValue(ApiResult.ok(true));
                }
                else
                {
                    out.setValue(ApiResult.fail("Database creation failed. HTTP " + response.code()));
                }

            }


            @Override
            public void onFailure(Call<MessageResponse> call, Throwable t)
            {
                // connection to network error
                out.setValue(ApiResult.fail("Network error: " + t.getMessage()));
            }
        });
        return out;


    }

    //user registration for usertypes Guest or Staff

    public LiveData<ApiResult<Boolean>> registerUser(String studentId, User user)
    {

        MutableLiveData<ApiResult<Boolean>> out = new MutableLiveData<>();


        api.createUser(studentId, user).enqueue(new Callback<MessageResponse>()
        {
            @Override
            public void onResponse(Call<MessageResponse> call, Response<MessageResponse> response)
            {
                if (response.isSuccessful())
                {
                    out.setValue(ApiResult.ok(true));
                }
                else
                {
                    out.setValue(ApiResult.fail("Register failed. HTTP " + response.code()));
                }
            }

            @Override
            public void onFailure(Call<MessageResponse> call, Throwable t)
            {
                out.setValue(ApiResult.fail("Network error: " + t.getMessage()));
            }

        });

        return out; }


    //fetches user record
    //login screen will compare returned password with password user typed

    public LiveData<ApiResult<User>> fetchUser(String studentId, String username) {

        MutableLiveData<ApiResult<User>> out = new MutableLiveData<>();

        api.readUser(studentId, username).enqueue(new Callback<UserResponse>() {

            @Override

            public void onResponse(Call<UserResponse> call, Response<UserResponse> response )


            {

                if (response.isSuccessful() && response.body()  != null && response.body().user != null)

                {
                    out.setValue(ApiResult.ok(response.body().user));
                }
                else if ( response.code() == 404)
                {
                    out.setValue(ApiResult.fail("Error: User not found"));
                }
                else
                {
                    out.setValue(ApiResult.fail("fetch user request failed. HTTP " + response.code()));
                }


            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t)
            {

                out.setValue(ApiResult.fail("Network error: " + t.getMessage()));
            }

        });

        return out;
    }

}
