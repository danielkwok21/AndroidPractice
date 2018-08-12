package com.example.danielkwok.recycleviewapp;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView nameLabel;
    EditText nameInput;
    TextView ageLabel;
    EditText ageInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameLabel = findViewById(R.id.ageLabel);
        nameInput = findViewById(R.id.nameInput);
        ageLabel = findViewById(R.id.ageLabel);
        ageInput = findViewById(R.id.ageInput);
    }
}
