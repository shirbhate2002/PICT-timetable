package com.example.logintimetable;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.RemoteViews;

import java.text.DateFormat;
import java.util.Calendar;

import static android.content.Context.MODE_PRIVATE;

/**
 * Implementation of App Widget functionality.
 */
public class timetable_app_widget extends AppWidgetProvider {

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {
        Calendar cal=Calendar.getInstance();
        String cd= DateFormat.getDateInstance(DateFormat.FULL).format(cal.getTime());
        // as cd we got is in form  of day, date month,year we are splitting it into date and day separately
        String []split_date=cd.split(",");
        String day=split_date[0];
        String date_month=split_date[1];
        String []split_date_month=date_month.split(" ");
        String date=split_date_month[1];

        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.timetable_app_widget);

        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views);


        SharedPreferences sharedPreferences=context.getSharedPreferences("com.example.logintimetable",MODE_PRIVATE);
        //click activity of logo button is defined
        Intent intent=new Intent(context, loginscreen.class);
        PendingIntent pendingIntent=PendingIntent.getActivity(context,0,intent,0);
        views.setOnClickPendingIntent(R.id.go_to_app,pendingIntent);
        // Instruct the widget manager to update the widget

        views.setTextViewText(R.id.Date, date);
        views.setTextViewText(R.id.Day,day);
        views.setTextViewText(R.id.time_table,sharedPreferences.getString("tt","this"));
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }
    }

    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created
    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }
}

