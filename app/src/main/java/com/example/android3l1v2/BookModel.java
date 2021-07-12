package com.example.android3l1v2;


public class BookModel {
    private String title;
    private int icon;

    public BookModel(String title, int icon) {
        this.title = title;
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public int getIcon() {
        return icon;
    }
}
