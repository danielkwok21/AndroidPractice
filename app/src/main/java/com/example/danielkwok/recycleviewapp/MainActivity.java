package com.example.danielkwok.recycleviewapp;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Services, when start, would run in the background till stopped explicitly.
 * To get a value from that service, the calling class would have to bind to it,
 * in order to get value from it.
 * A useful analogy would be service as a bingo ball randomizer
 * Binding to the service would be akin to reaching inside and grabbing a ball
 * */
public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MainActivity";

    boolean bounded;
    MyService myService;
    Intent i;

    TextView counter;
    Button getCounter;
    Button bindService;


    /**1. starts service the moment activity is created*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponents();
        i = new Intent(this, MyService.class);
        startService(i);
    }

    private void initComponents(){
        counter = findViewById(R.id.main_counter_tv);
        getCounter = findViewById(R.id.main_get_counter_btn);
        bindService = findViewById(R.id.main_bind_service_btn);

        getCounter.setOnClickListener((v)->{
            if(bounded){
                counter.setText(Integer.toString(myService.getCounter()));
            }else{
                counter.setText("Service not bounded");
            }
        });

        bindService.setOnClickListener((v)->{
            if(bounded){
                unbindService(connection);
                bounded = false;
            }else{
                bindService(i, connection, BIND_AUTO_CREATE);
            }
        });

    }

    /**
     * Create the connection
     */
    ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Toast.makeText(getApplicationContext(), "Service connected", Toast.LENGTH_SHORT).show();
            bounded = true;

            //creating object of MyServiceBinder from MyService.java
            //setting local variable myService to be the an instance of MyService
            MyService.MyServiceBinder binder = (MyService.MyServiceBinder) service;
            myService = binder.getService();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Toast.makeText(getApplicationContext(), "Service disconnected", Toast.LENGTH_SHORT).show();
            bounded = false;
            myService = null;

        }
    };

}
