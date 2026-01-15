package com.example.androidRestaurantApp.data.model;


// simple wrapper for network results
public class ApiResult<T> {

    public boolean success;

    public T data;
    public String error;

    private ApiResult(boolean success, T data, String error) {

        this.success = success;
        this.data = data;
        this.error = error;

    }

    public static <T> ApiResult<T> ok(T data) {

        return new ApiResult<>(true, data, null);
    }

    public static <T> ApiResult<T> fail(String error) {

        return new ApiResult<>(false, null, error);

    }
}