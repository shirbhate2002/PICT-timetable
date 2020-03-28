package com.example.logintimetable.ui.feedback_1;

import android.content.Intent;
import android.net.Uri;
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

public class Feedback_1Fragment extends Fragment {

    LottieAnimationView imggfeedback;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_feedback, container, false);
        imggfeedback=root.findViewById(R.id.lottieAnimationView);
        imggfeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent feedback=new Intent(Intent.ACTION_VIEW, Uri.parse("https://docs.google.com/forms/d/e/1FAIpQLScGTtwxoDmtaEv5o34JOfElbfswirRIBPCWeKZ_jIeLpkIAgA/viewform?usp=sf_link"));
                startActivity(feedback);
            }
        });
        return root;
    }
}