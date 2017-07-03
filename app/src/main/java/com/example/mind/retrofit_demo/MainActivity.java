package com.example.mind.retrofit_demo;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView _listdata;
    ArrayList<Model> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        _listdata = (RecyclerView) findViewById(R.id._listdata);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
        _listdata.setLayoutManager(linearLayoutManager);
      /*  GridLayoutManager gridLayoutManager=new GridLayoutManager(MainActivity.this,1);
        _listdata.setLayoutManager(gridLayoutManager);*/


        final ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setTitle("Please wait");
        progressDialog.setCancelable(false);
        progressDialog.show();

        APIInterFace apiInterFace = ApiClient.getClient().create(APIInterFace.class);

        Call<Model> call = apiInterFace.getDetail();


        call.enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {

                progressDialog.dismiss();


                Model jsonResponse = response.body();
                arrayList= new ArrayList<>(Arrays.asList(jsonResponse.getData()));

                RVAdapter rvAdapter = new RVAdapter(MainActivity.this, arrayList);
                _listdata.setAdapter(rvAdapter);


            }

            @Override
            public void onFailure(Call<Model> call, Throwable t) {
                Log.e("Filure", "filure" + "   " + t.toString());
            }
        });
    }
}
