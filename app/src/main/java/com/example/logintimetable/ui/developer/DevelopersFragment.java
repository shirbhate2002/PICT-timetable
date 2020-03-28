package com.example.logintimetable.ui.developer;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.logintimetable.R;

public class DevelopersFragment extends Fragment {


    ImageButton ni_vaidilya,insta_vaidilya;
    ImageButton ni_atharva,insta_aniket;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_developers, container, false);
        ni_vaidilya= root.findViewById(R.id.linkdin);
        insta_vaidilya= root.findViewById(R.id.insta);
        ni_atharva= root.findViewById(R.id.Atharva_linkdin);
        insta_aniket= root.findViewById(R.id.ankiet_insta);
        ni_vaidilya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ni_intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/vaidilya-shirbhate-5b786019b"));
                startActivity(ni_intent);
            }
        });
        insta_vaidilya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent insta_intent=new Intent(Intent.ACTION_VIEW,Uri.parse("https://instagram.com/vaidilyashirbhate?igshid=1kvop81qh1m5p"));
                startActivity(insta_intent);

            }
        });
        ni_atharva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ni_intent=new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.google.com/url?sa=t&source=web&rct=j&url=https://in.linkedin.com/in/atharva-jainak-b16758191&ved=2ahUKEwiUgKjW-IfoAhUIfH0KHV4OBmYQFjAJegQIAhAB&usg=AOvVaw08gvKDHNdO7V4KLIseJC1e"));
                startActivity(ni_intent);
            }
        });
        insta_aniket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ni_intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://instagram.com/aniket.nikam.161446?igshid=1jl643c4rn8xs"));
                startActivity(ni_intent);
            }
        });
        return root;
    }
}