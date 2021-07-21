package com.example.android3l1v2;


import java.io.Serializable;

public class BookModel implements Serializable {
    private String title;
    private int icon;
    private String descr;

    public BookModel(String title, String
             descr, int icon) {
        this.title = title;
        this.descr =descr;
        this.icon = icon;
    }


    public String getTitle() {
        return title;
    }

    public int getIcon() {
        return icon;
    }

    public String getDescr() {
        return descr;
    }
}
