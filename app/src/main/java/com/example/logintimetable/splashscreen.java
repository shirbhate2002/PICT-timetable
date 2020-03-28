package com.example.logintimetable;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class splashscreen extends AppCompatActivity {
    private static int Splash_time=2500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent Home_to_main=new Intent(splashscreen.this, loginscreen.class);
                startActivity(Home_to_main);
                finish();
            }
        },Splash_time);

    }
}
