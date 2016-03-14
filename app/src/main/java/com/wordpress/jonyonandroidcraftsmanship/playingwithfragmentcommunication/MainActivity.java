package com.wordpress.jonyonandroidcraftsmanship.playingwithfragmentcommunication;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements FirstFragment.Communicator{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void respond(String data) {
        FragmentManager fragmentManager=getSupportFragmentManager();
        SecondFragment secondFragment= (SecondFragment) fragmentManager.findFragmentById(R.id.frgSecond);
        secondFragment.changeData(data);
    }
}
