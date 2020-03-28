package com.example.logintimetable;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class logout extends AppCompatActivity {
    Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_logout);
        logout=findViewById(R.id.logout_but);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences=getSharedPreferences("com.example.logintimetable",MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.clear();
                editor.apply();
                Intent back_to_login_screen=new Intent(logout.this, splashscreen.class);
                startActivity(back_to_login_screen);
                finish();
            }
        });

    }
}
