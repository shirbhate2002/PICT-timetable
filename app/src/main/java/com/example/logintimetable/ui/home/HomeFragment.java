package com.example.logintimetable.ui.home;

import android.animation.ArgbEvaluator;
import android.app.ActionBar;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

import com.example.logintimetable.Adapter;
import com.example.logintimetable.Modle;
import com.example.logintimetable.R;

import java.util.ArrayList;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;

public class HomeFragment extends Fragment {

    String u_name,u_div,u_bat;
    ViewPager viewPager;
    Adapter adapter;
    List<Modle> modles;
    Integer[] colours=null;
    ArgbEvaluator argbEvaluator=new ArgbEvaluator();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        SharedPreferences sharedPreferences= this.getActivity().getSharedPreferences("com.example.logintimetable2",MODE_PRIVATE);
        u_name=sharedPreferences.getString("u_name","name").trim();
        u_bat=sharedPreferences.getString("u_batch","bat").trim();
        u_div=sharedPreferences.getString("u_division","div").trim();



        modles= new ArrayList<>();

        if (u_div.trim().equals("1")) {

            modles.add(new Modle(R.drawable.fe1mon, "MONDAY"));
            modles.add(new Modle(R.drawable.fe1tue, "TUESDAY"));
            modles.add(new Modle(R.drawable.fe1wed, "WEDNESDAY"));
            modles.add(new Modle(R.drawable.fe1thu, "THURSDAY"));
            modles.add(new Modle(R.drawable.fe1fri, "FRIDAY"));
            modles.add(new Modle(R.drawable.fe1sat, "SATURDAY"));
        }
        else if (u_div.trim().equals("2")) {

            modles.add(new Modle(R.drawable.fe2_mon, "MONDAY"));
            modles.add(new Modle(R.drawable.fe2_tue, "TUESDAY"));
            modles.add(new Modle(R.drawable.fe2_wed, "WEDNESDAY"));
            modles.add(new Modle(R.drawable.fe2_thu, "THURSDAY"));
            modles.add(new Modle(R.drawable.fe2_fri, "FRIDAY"));
            modles.add(new Modle(R.drawable.fe2_sat, "SATURDAY"));
        }
        else if (u_div.trim().equals("3")) {

            modles.add(new Modle(R.drawable.fe3_mon, "MONDAY"));
            modles.add(new Modle(R.drawable.fe3_tue, "TUESDAY"));
            modles.add(new Modle(R.drawable.fe3_wed, "WEDNESDAY"));
            modles.add(new Modle(R.drawable.fe3_thu, "THURSDAY"));
            modles.add(new Modle(R.drawable.fe3_fri, "FRIDAY"));
            modles.add(new Modle(R.drawable.fe3_sat, "SATURDAY"));
        }
        else if (u_div.trim().equals("4")) {

            modles.add(new Modle(R.drawable.fe4_mon, "MONDAY"));
            modles.add(new Modle(R.drawable.fe4_tue, "TUESDAY"));
            modles.add(new Modle(R.drawable.fe4_wed, "WEDNESDAY"));
            modles.add(new Modle(R.drawable.fe4_thu, "THURSDAY"));
            modles.add(new Modle(R.drawable.fe4_fri, "FRIDAY"));
            modles.add(new Modle(R.drawable.fe4_sat, "SATURDAY"));
        }
        else if (u_div.trim().equals("6")) {

            modles.add(new Modle(R.drawable.fe6_mon, "MONDAY"));
            modles.add(new Modle(R.drawable.fe6_tue, "TUESDAY"));
            modles.add(new Modle(R.drawable.fe6_wed, "WEDNESDAY"));
            modles.add(new Modle(R.drawable.fe6_thu, "THURSDAY"));
            modles.add(new Modle(R.drawable.fe6_fri, "FRIDAY"));
            modles.add(new Modle(R.drawable.fe6_sat, "SATURDAY"));
        }
        else if (u_div.trim().equals("5")) {

            modles.add(new Modle(R.drawable.fe_mon, "MONDAY"));
            modles.add(new Modle(R.drawable.fe5_tue, "TUESDAY"));
            modles.add(new Modle(R.drawable.fe5_wed, "WEDNESDAY"));
            modles.add(new Modle(R.drawable.fe5_thu, "THURSDAY"));
            modles.add(new Modle(R.drawable.fe5_fri, "FRIDAY"));
            modles.add(new Modle(R.drawable.fe5_sat, "SATURDAY"));
        }
        else {
            modles.add(new Modle(R.drawable.error404,"OOPS!!"));
        }


        adapter= new Adapter(modles,getContext());
        viewPager= root.findViewById(R.id.viewpager);
        viewPager.setAdapter(adapter);
        viewPager.setPadding(90,0,90,0);


        Integer[] colour_temp={
                getResources().getColor(R.color.bg1),
                getResources().getColor(R.color.bg2),
                getResources().getColor(R.color.bg3),
                getResources().getColor(R.color.bg4),
                getResources().getColor(R.color.bg5),
                getResources().getColor(R.color.bg6)};
        colours=colour_temp;
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if(position<(adapter.getCount()-1) && position<(colours.length-1)){
                    viewPager.setBackgroundColor((Integer) argbEvaluator.evaluate(positionOffset,colours[position],colours[position+1]));
                }
                else{
                    viewPager.setBackgroundColor(colours[colours.length-1]);
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        return root;
    }
}