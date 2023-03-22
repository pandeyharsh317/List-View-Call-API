package com.seeksolution.userlisttask.Api;

import com.seeksolution.userlisttask.Model.UserResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    @GET("users?page=2")
    Call<UserResponse> GetUser();
}
