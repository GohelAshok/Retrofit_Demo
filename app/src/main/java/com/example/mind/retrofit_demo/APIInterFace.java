package com.example.mind.retrofit_demo;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by mind on 3/7/17.
 */

public interface APIInterFace {

    @GET("/api/users?page=2")
    Call<Model> getDetail();
}
