package com.android.pariwisata.aplikasiandroid.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Kuliner {
    @SerializedName("img")
    @Expose
    private String img;
    @SerializedName("nama_kuliner")
    @Expose
    private String namaKuliner;

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getNamaKuliner() {
        return namaKuliner;
    }

    public void setNamaKuliner(String namaKuliner) {
        this.namaKuliner = namaKuliner;
    }
}
