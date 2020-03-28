package com.example.logintimetable.ui.rateusonplaystore;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.logintimetable.R;

public class RateusonplaystoreFragment extends Fragment {


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_rate_us, container, false);
        final TextView textView = root.findViewById(R.id.text_tools);
        Toast.makeText(getContext(), "rate", Toast.LENGTH_SHORT).show();
        return root;
    }
}