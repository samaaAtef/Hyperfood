package com.example.sm.hyperfood2.WebServices;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WebServices {
    private static WebServices instance;
    private API api;

    public WebServices()
    {
        Retrofit retrofit=new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Urls.Main_URL)
                .build();

        api=retrofit.create(API.class);
    }
    public static WebServices getInstance(){
        if(instance==null){
            instance=new WebServices();
        }
        return instance;
    }
    public API getApi(){
        return api;
    }

}