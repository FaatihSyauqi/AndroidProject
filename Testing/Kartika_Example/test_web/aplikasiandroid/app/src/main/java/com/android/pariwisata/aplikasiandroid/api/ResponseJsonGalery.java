package com.android.pariwisata.aplikasiandroid.api;

import com.android.pariwisata.aplikasiandroid.model.Galery;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import javax.xml.transform.Result;

/**
 * Created by KartikaSari on 7/21/2018.
 */

public class ResponseJsonGalery {
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
