package com.example.sm.hyperfood2.model;

import com.google.gson.annotations.SerializedName;

public class ListCatogry {

 /*  public String title;
    public ListCatogry(String title){
        this.title=title;
    }*/
   @SerializedName("id")
   public  int id;
    @SerializedName("title")
    public  String title ;
     @SerializedName("created_at")
    public  String created_at ;
     @SerializedName("updated_at")
    public  String updated_at ;

}