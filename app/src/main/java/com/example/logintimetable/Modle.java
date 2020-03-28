package com.example.logintimetable;

public class Modle {
    private  int image;
    private String day;

    public Modle(int image, String day) {
        this.image = image;
        this.day = day;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }
}
