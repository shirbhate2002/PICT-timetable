package com.example.logintimetable;

import android.appwidget.AppWidgetManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Calendar;

public class maintTimeTableapp extends AppCompatActivity {
    String []a1={"# EM/CAD || CHEM || PPS || # PBL || CCA*",
            "PPS || BXE || # CHEM || CHEM || EM-2  || EG*",
            "ES-2 || EG || BXE || EM-2 || # PPS || CCA*",
            "# EG || BXE || EM-2 || ES _2 || CHEM || PBL*",
            "EM-2 || CS || # BXE || CHEM || PPS || PBL*",
            "#EG || PPS/BXE || SPORTS || # PBL || CCA"};

    BroadcastReceiver br = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {
            Calendar cal=Calendar.getInstance();
            String cd= DateFormat.getDateInstance(DateFormat.FULL).format(cal.getTime());
            // as cd we got is in form  of day, date month,year we are splitting it into date and day separately
            String []split_date=cd.split(",");
            String day=split_date[0];
            String date_month=split_date[1];
            String []split_date_month=date_month.split(" ");
            String date=split_date_month[1];
            SharedPreferences sharedPreferences=getSharedPreferences("com.example.logintimetable",MODE_PRIVATE);
            SharedPreferences.Editor editor=sharedPreferences.edit();
            editor.putString("day",day);
            editor.putString("date",date);

            //Toast.makeText(context, "onrecive is called", Toast.LENGTH_SHORT).show();
            switch(day.trim()){
                case "Monday":
                    editor.putString("tt",a1[0]);
                    break;
                case "Tuesday":
                    editor.putString("tt",a1[1]);
                    break;
                case "Wednesday":
                    editor.putString("tt",a1[2]);
                    break;
                case "Thursday":
                    editor.putString("tt",a1[3]);
                    break;
                case "Friday":
                    editor.putString("tt",a1[4]);
                    break;
                case "Saturday":
                    editor.putString("tt",a1[5]);
                    break;
                case "Sunday":
                    editor.putString("tt","Enjoy!!!");
                    break;
                default:
                    editor.putString("tt","un");

            }

            editor.apply();
            //Toast.makeText(context, "Date has been changed", Toast.LENGTH_SHORT).show();
            Intent intent1 = new Intent(context,timetable_app_widget.class);
            intent1.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE);
            int[] ids = AppWidgetManager.getInstance(getApplication())
                    .getAppWidgetIds(new ComponentName(getApplication(),timetable_app_widget.class));
            intent1.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, ids);
            sendBroadcast(intent1);
        }

    };


    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maint_time_tableapp);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow,
                R.id.nav_tools, R.id.nav_share, R.id.nav_send)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        filter.addAction(Intent.ACTION_DATE_CHANGED);
        this.registerReceiver(br, filter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.maint_time_tableapp, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}
