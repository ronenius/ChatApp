package com.example.chatapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button LgnBtn =findViewById(R.id.LgnBtn);
        LgnBtn.setOnClickListener(v -> {
            Intent i = new Intent(this, Contacts.class);
            startActivity(i);
        });
        Button RegBtn = findViewById(R.id.RegBtn);
        RegBtn.setOnClickListener(v -> {
           Intent i = new Intent(this, Register.class);
           startActivity(i);
        });
    }


}