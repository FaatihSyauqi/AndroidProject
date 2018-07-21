package com.android.pariwisata.aplikasiandroid.api;

import com.android.pariwisata.aplikasiandroid.model.Kuliner;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by KartikaSari on 7/20/2018.
 */

public class ResponseJsonKulinerHome {
    @SerializedName("value")
    @Expose
    private Integer value;
    @SerializedName("result")
    @Expose
    private List<Kuliner> kuliner = null;

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public List<Kuliner> getKuliner() {
        return kuliner;
    }

    public void setKuliner(List<Kuliner> kuliner) {
        this.kuliner = kuliner;
    }

}
