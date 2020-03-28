package com.example.logintimetable.ui.setting;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.airbnb.lottie.LottieAnimationView;
import com.example.logintimetable.R;

public class SettingFragment extends Fragment {

    LottieAnimationView imggsetting;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_setting, container, false);
        imggsetting=root.findViewById(R.id.imgsetting);
        imggsetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "No Need of setting", Toast.LENGTH_SHORT).show();
            }
        });
        return root;
    }
}