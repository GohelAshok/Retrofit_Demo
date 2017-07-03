package com.example.mind.retrofit_demo;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by mind on 3/7/17.
 */

public class ApiClient {

    public static Retrofit getClient(){

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://reqres.in/")
                .addConverterFactory(GsonConverterFactory.create()).build();

        return retrofit;


    }
}
