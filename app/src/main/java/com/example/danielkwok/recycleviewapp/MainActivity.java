package com.example.danielkwok.recycleviewapp;

import android.app.NotificationManager;
import android.content.Context;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private static final int UNIQUE_ID = 42069;

    Button createNotification;
    NotificationCompat.Builder newNotificationBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createNotification = findViewById(R.id.main_notification_btn);

        createNotification.setOnClickListener((v)->{
            createNewNotification();
        });
    }

    private void createNewNotification(){
        //builds the body of the notification itself
        newNotificationBuilder = new NotificationCompat.Builder(this);
        newNotificationBuilder.setSmallIcon(R.drawable.ic_launcher_background);
        newNotificationBuilder.setContentTitle("This is some title");
        newNotificationBuilder.setContentText("This is some text");
        newNotificationBuilder.setPriority(NotificationCompat.PRIORITY_LOW);

        //sends notification to phone
        NotificationManager notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(UNIQUE_ID, newNotificationBuilder.build());
    }
}
