package com.android.pariwisata.aplikasiandroid.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Wisata {
    @SerializedName("img")
    @Expose
    private String img;
    @SerializedName("nama_alam")
    @Expose
    private String namaAlam;

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getNamaAlam() {
        return namaAlam;
    }

    public void setNamaAlam(String namaAlam) {
        this.namaAlam = namaAlam;
    }
}
