package com.example.logintimetable.ui.logout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.logintimetable.R;
import com.example.logintimetable.splashscreen;

import static android.content.Context.MODE_PRIVATE;

public class LogoutFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_logout, container, false);
        Button logout=view.findViewById(R.id.logout_but);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences=LogoutFragment.this.getActivity().getSharedPreferences("com.example.logintimetable2",MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.clear();
                editor.apply();
                Intent back_to_login_screen=new Intent(getActivity().getApplication(), splashscreen.class);
                startActivity(back_to_login_screen);
                //finish();
            }
        });

        return view;

    }
}