package com.example.androidRestaurantApp.network;

import com.example.androidRestaurantApp.data.model.MessageResponse;
import com.example.androidRestaurantApp.data.model.User;
import com.example.androidRestaurantApp.data.model.UserResponse;
import com.example.androidRestaurantApp.data.model.UsersResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface RESTApiService {

    @POST("create_student/{student_id}")
    Call<MessageResponse> createStudentDb(@Path("student_id") String studentId);

    @POST("create_user/{student_id}")
    Call<MessageResponse> createUser(
            @Path("student_id") String studentId,
            @Body User user
    );

    @GET("read_all_users/{student_id}")
    Call<UsersResponse> readAllUsers(@Path("student_id") String studentId);

    @GET("read_user/{student_id}/{username}")
    Call<UserResponse> readUser(
            @Path("student_id") String studentId,
            @Path("username") String username
    );

    @PUT("update_user/{student_id}/{username}")
    Call<MessageResponse> updateUser(
            @Path("student_id") String studentId,
            @Path("username") String username,
            @Body User user
    );

    @DELETE("delete_user/{student_id}/{username}")
    Call<MessageResponse> deleteUser(
            @Path("student_id") String studentId,
            @Path("username") String username
    );
}