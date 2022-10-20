package com.example.button_practice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

public class splashScreen extends AppCompatActivity {

    ImageView loader;

    Handler handle = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        loader = findViewById(R.id.loadingImage);
        loader.animate().rotation(3600).setDuration(3000);
        handle.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent main = new Intent(splashScreen.this,MainActivity.class);
                startActivity(main);
                finish();
            }
        },3000);
    }
}