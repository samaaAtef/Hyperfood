package com.example.sm.hyperfood2.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.example.sm.hyperfood2.MainActivity;
import com.example.sm.hyperfood2.model.User;
import com.example.sm.hyperfood2.MainActivity;
import com.example.sm.hyperfood2.model.User;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class Session {
    private static Session instance;
    private Realm realm;

    public static Session getinstance(Context context)
    {
        if(instance == null)
        {
            instance=new Session(context);
        }
        return instance;
    }
    private Session(Context context){
        Realm.init(context);
        RealmConfiguration realmConfiguration= new RealmConfiguration.Builder()
                .deleteRealmIfMigrationNeeded().build();
        realm= Realm.getInstance(realmConfiguration);
    }
    //دا عشان نحتفظ ببيانات المستخدم
    public void LoginUser(final User user){
     if(realm.where(User.class).findFirst()==null){
        realm.executeTransaction(new Realm.Transaction() {
        public void execute(Realm realmm){
            realmm.copyToRealm(user);
        }
        });}
        else{
         logout();
         LoginUser(user);
        }
     /*   realm.beginTransaction();
        realm.copyToRealm(user);
        realm.commitTransaction();*/
    }

    private void logout() {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.delete(User.class);
            }
        });
    }
    public  boolean isUserLoggedIn(){
        return  realm.where(User.class).findFirst()!=null;
    }

    public User getUser(){
        return realm.where(User.class).findFirst();
    }

    public void logoutAndGoToLogin(Activity ac)
    {
        logout();
        ac.startActivity(new Intent(ac, MainActivity.class));
        ac.finish();
    }

}