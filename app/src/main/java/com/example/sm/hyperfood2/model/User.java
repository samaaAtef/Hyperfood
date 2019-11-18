package com.example.sm.hyperfood2.model;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

public class User extends RealmObject {
    @SerializedName("name")
    public String name;
    @SerializedName("phone")
    public String phone;
    @SerializedName("address")
    public String address;
    @SerializedName("email")
    public  String email;
    @SerializedName("password")
    public  String password;
    @SerializedName("password_confirmation")
    public String password_confirmation;


}