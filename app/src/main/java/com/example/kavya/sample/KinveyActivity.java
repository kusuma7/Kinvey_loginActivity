package com.example.kavya.sample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.kinvey.android.Client;

/**
 * Created by KUSUMA on 8/9/2016.
 */
public class KinveyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public Client getClient(){

       return ((MainApplication)getApplication()).getClient();
    }
}

