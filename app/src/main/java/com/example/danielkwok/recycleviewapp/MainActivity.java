package com.example.danielkwok.recycleviewapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    //using toolbar with android.v7.widget
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolBar);

        //set toolbar as default action bar
        //as a result, the name of the activity is shown on this toolbar
        setSupportActionBar(toolbar);
    }
}
