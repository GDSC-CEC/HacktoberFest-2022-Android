package com.example.button_practice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class privacyPolicy extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy_policy);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
    }
}