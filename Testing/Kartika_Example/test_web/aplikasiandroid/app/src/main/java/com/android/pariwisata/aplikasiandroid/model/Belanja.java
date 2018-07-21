package com.android.pariwisata.aplikasiandroid.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Faatih on 04/05/2018.
 */

public class Belanja {
    @SerializedName("img")
    @Expose
    private String img;
    @SerializedName("nama_belanja")
    @Expose
    private String namaBelanja;

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getNamaBelanja() {
        return namaBelanja;
    }

    public void setNamaBelanja(String namaBelanja) {
        this.namaBelanja = namaBelanja;
    }
}
