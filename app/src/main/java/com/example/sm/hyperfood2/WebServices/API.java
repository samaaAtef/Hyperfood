package com.example.sm.hyperfood2.WebServices;

import com.example.sm.hyperfood2.model.ListCatogry;
import com.example.sm.hyperfood2.model.ListCatogry6;
import com.example.sm.hyperfood2.model.LoginResponce;
import com.example.sm.hyperfood2.model.MainResponce;
import com.example.sm.hyperfood2.model.User;
import com.example.sm.hyperfood2.model.ListCatogry;
import com.example.sm.hyperfood2.model.ListCatogry6;
import com.example.sm.hyperfood2.model.LoginResponce;
import com.example.sm.hyperfood2.model.MainResponce;
import com.example.sm.hyperfood2.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface API {
    @POST("login")
    Call<LoginResponce>loginUser(@Body User user);

    @POST("register")
    Call<MainResponce>registerUser(@Body User user);

    @GET("categories")
    Call<List<ListCatogry>>catogry();

    @GET("catogry/6")
    Call<List<ListCatogry6>>catsection();

}