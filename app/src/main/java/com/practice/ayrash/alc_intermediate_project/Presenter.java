package com.practice.ayrash.alc_intermediate_project;

import android.support.annotation.NonNull;
import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ibnahmadbello on 8/20/17.
 */

public class Presenter {
    private MainActivity activity;
    private static final String TAG = "Presenter";
    public Presenter(MainActivity activity){
        this.activity = activity;
    }
    public Retrofit createRetrofit(){
        return new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public void createInstance(){
        activity.showProgressBar();
        Retrofit retrofit = createRetrofit();
        CallAPI call = retrofit.create(CallAPI.class);
        call.getUsers().enqueue(new Callback<UserList>() {
            @Override
            public void onResponse(@NonNull Call<UserList> call, @NonNull Response<UserList> response) {
                activity.hideProgressBar();
                UserList list = response.body();
                Log.d(TAG,"Received response from GitHub with: " + list.getItems().size() + "users");
                activity.passList(list);
            }

            @Override
            public void onFailure(@NonNull Call<UserList> call, @NonNull Throwable t) {
                activity.hideProgressBar();
                Log.d(TAG, "Error getting response from GitHub", t);

            }
        });
    }
}

