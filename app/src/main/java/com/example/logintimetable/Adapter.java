package com.example.logintimetable;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

public class Adapter extends PagerAdapter {
    private List<Modle> modles;
    private LayoutInflater layoutInflater;
    private Context context;

    public Adapter(List<Modle> modles, Context context) {
        this.modles = modles;
        this.context = context;
    }

    @Override
    public int getCount() {
        return modles.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater=layoutInflater.from(context);
        View view=layoutInflater.inflate(R.layout.item,container,false);

        ImageView imageView;
        TextView day;
        imageView=view.findViewById(R.id.image);
        day=view.findViewById(R.id.day);

        imageView.setImageResource(modles.get(position).getImage());
        day.setText(modles.get(position).getDay());

        container.addView(view,0);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
