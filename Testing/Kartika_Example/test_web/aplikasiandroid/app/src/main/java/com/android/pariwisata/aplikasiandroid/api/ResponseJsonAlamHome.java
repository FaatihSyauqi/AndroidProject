package com.android.pariwisata.aplikasiandroid.api;

import com.android.pariwisata.aplikasiandroid.model.Wisata;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by KartikaSari on 7/20/2018.
 */

public class ResponseJsonAlamHome {
    @SerializedName("value")
    @Expose
    private Integer value;
    @SerializedName("result")
    @Expose
    private List<Wisata> wisata = null;

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public List<Wisata> getWisata() {
        return wisata;
    }

    public void setWisata(List<Wisata> wisata) {
        this.wisata = wisata;
    }
}
