package com.example.logintimetable;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class loginscreen extends AppCompatActivity {
    TextView name,division,batch;
    Button login;
    String u_name,u_division,u_batch;
    Boolean skipLoginPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        name=findViewById(R.id.name);
        division=findViewById(R.id.division);
        batch=findViewById(R.id.batch);
        login=findViewById(R.id.login);
        //For First Login the value in true so the login page opens
        SharedPreferences sharedPreferences=getSharedPreferences("com.example.logintimetable2",MODE_PRIVATE);
        if(sharedPreferences.getBoolean("SkipTF",true)) {
            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (name.getText().toString().isEmpty() | division.getText().toString().isEmpty() | batch.getText().toString().isEmpty()) {
                        Toast.makeText(loginscreen.this, "Enter All Data ", Toast.LENGTH_SHORT).show();
                    } else {
                        u_name = name.getText().toString().trim();
                        u_division = division.getText().toString().trim();
                        u_batch = batch.getText().toString().trim();
                        SharedPreferences sharedPreferences=getSharedPreferences("com.example.logintimetable2",MODE_PRIVATE);
                        SharedPreferences.Editor editor=sharedPreferences.edit();
                        //adding value false so that login page will not open second time
                        editor.putBoolean("SkipTF",false);
                        // user name division batch is beaned saved after login
                        editor.putString("u_name",u_name);
                        editor.putString("u_division",u_division);
                        editor.putString("u_batch",u_batch);
                        editor.apply();
                        Toast.makeText(loginscreen.this, "Hi!! " + u_name + " From " + u_batch + u_division, Toast.LENGTH_SHORT).show();
                        Intent MaintoMain_app = new Intent(loginscreen.this, maintTimeTableapp.class);
                        startActivity(MaintoMain_app);
                        finish();
                    }
                }
            });
        }
        // after first time login it will go to else part
        else{
            //it will skip the login page
            Intent MaintoMain_app = new Intent(loginscreen.this, maintTimeTableapp.class);
            startActivity(MaintoMain_app);
            finish();

        }
    }
}
