package com.android.pariwisata.aplikasiandroid.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Galery {
    @SerializedName("alam_galeri")
    @Expose
    private String alamGaleri;

    public String getAlamGaleri() {
        return alamGaleri;
    }

    public void setAlamGaleri(String alamGaleri) {
        this.alamGaleri = alamGaleri;
    }
}