package com.example.kavya.sample;

import android.app.Application;

import com.kinvey.android.Client;

/**
 * Created by KUSUMA on 8/9/2016.
 */
public class MainApplication extends Application {

   private static Client client;
    @Override

    public void onCreate(){
        super.onCreate();
        defineClient();

    }

    private void defineClient() {
         client = new Client.Builder("kid_H181PtvF","70541c2ff2b8466183762eee8bc4c4bb",getApplicationContext()).build();
    }

    public static Client getClient(){
        return client;
    }
}
