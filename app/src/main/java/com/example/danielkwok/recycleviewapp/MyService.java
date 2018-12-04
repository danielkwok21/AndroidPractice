package com.example.danielkwok.recycleviewapp;

import android.app.Service;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;

import static java.lang.Thread.sleep;

/**
* myService to keep proving a every second counter, displayed in log
* works even when app is closed
* */
public class MyService extends Service {
    private static final String TAG = "MyService";
    private static int counter = 0;
    
    public MyService() {
    }

    /**
     * 1. onStartCommand() gets called first when myService starts
     * a new thread is used to log to prevent blocking main thread
     * */
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        new Thread(new Runnable(){
            @Override
            public void run() {
                try {
                    for(int i=0 ;i<1000; i++){
                        Log.d(TAG, "counter: "+counter++);
                        sleep(1000);
                    }
                } catch (InterruptedException e) {
                    Log.d(TAG, "run: "+e);
                }
            }
        }).start();

        return START_STICKY;
    }

    /**
     * 3. onBind() is a function called when an external class,
     * ie in this case, MainActivity.java wants to bind to it, ie use it
     * */
    @Override
    public IBinder onBind(Intent intent) {
        return iBinder;
    }

    /**
     *This class is used to create a MyServiceBinder object, which
     * would be used by onBind() to return an instance of this myService
     * */
    class MyServiceBinder extends Binder {
        public MyService getService(){
            return MyService.this;
        }
    }
    private IBinder iBinder = new MyServiceBinder();

    public static int getCounter() {
        return counter;
    }
}
