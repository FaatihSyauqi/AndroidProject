package com.android.pariwisata.aplikasiandroid.api;

import com.android.pariwisata.aplikasiandroid.model.Galery;
import com.android.pariwisata.aplikasiandroid.model.WisataDetail;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by KartikaSari on 7/21/2018.
 */

public class ResponJsonAlam {
    @SerializedName("result")
    @Expose
    private List<Galery> galery = null;

    public List<Galery> getGalery() {
        return galery;
    }

    public void setGalery(List<Galery> galery) {
        this.galery = galery;
    }
}
