package com.example.danielkwok.recycleviewapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.UUID;

import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    TextView nameLabel;
    EditText nameInput;
    TextView ageLabel;
    EditText ageInput;
    Button enterButton;

    User user;
    String name;
    int age;

    Realm mRealm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //starting Realm
        Realm.init(this);
        mRealm = Realm.getDefaultInstance();

        nameLabel = findViewById(R.id.nameLabel);
        nameInput = findViewById(R.id.nameInput);
        ageLabel = findViewById(R.id.ageLabel);
        ageInput = findViewById(R.id.ageInput);
        enterButton = findViewById(R.id.enterButton);

        enterButton.setOnClickListener((View v)->{
            save();
            Toast.makeText(this, "entered new User", Toast.LENGTH_LONG).show();
        });

        read();

    }


     private void save(){
        name = nameInput.getText().toString();
        try{
            Log.d(TAG, ageInput.getText().toString());
            age = Integer.parseInt(ageInput.getText().toString());
        }catch(NumberFormatException e){
            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
        }
        user = new User(name, age);
        Log.d(TAG, user.toJSON());

        //realm write
        mRealm.beginTransaction();
        user = mRealm.createObject(User.class, UUID.randomUUID().toString());
        mRealm.commitTransaction();
    }

    private void read(){
        //realm read
        RealmResults<User> realmUsers = mRealm.where(User.class).findAll();
        for(User u:realmUsers){
            Log.d(TAG, u.toJSON());
        }
    }
}
