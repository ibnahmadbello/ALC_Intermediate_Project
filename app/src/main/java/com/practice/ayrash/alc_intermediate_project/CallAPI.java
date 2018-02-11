package com.practice.ayrash.alc_intermediate_project;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by ibnahmadbello on 8/20/17.
 */

public interface CallAPI {
    @GET("search/users?q=location:lagos+language:java")
    Call<UserList> getUsers();
}
