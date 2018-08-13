package com.example.danielkwok.recycleviewapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    TextView nameLabel;
    EditText nameInput;
    TextView ageLabel;
    EditText ageInput;
    Button enterButton;

    Person p;
    String name;
    int age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameLabel = findViewById(R.id.nameLabel);
        nameInput = findViewById(R.id.nameInput);
        ageLabel = findViewById(R.id.ageLabel);
        ageInput = findViewById(R.id.ageInput);
        enterButton = findViewById(R.id.enterButton);

        enterButton.setOnClickListener((View v)->{
            save();
            Toast.makeText(this, "entered new person", Toast.LENGTH_LONG).show();
        });
    }

     private void save(){
        name = nameInput.getText().toString();
        try{
            age = Integer.parseInt(ageInput.getText().toString());
        }catch(NumberFormatException e){
            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
        }
        p = new Person(name, age);
        Log.d(TAG, p.toJSON());

    }

}
