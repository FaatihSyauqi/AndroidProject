package com.android.pariwisata.aplikasiandroid.api;

import com.android.pariwisata.aplikasiandroid.model.Belanja;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by KartikaSari on 7/19/2018.
 */

public class ResponseJsonBelanjaHome {

    @SerializedName("value")
    @Expose
    private Integer value;
    @SerializedName("result")
    @Expose
    private List<Belanja> belanja = null;

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public List<Belanja> getBelanja() {
        return belanja;
    }

    public void setBelanja(List<Belanja> belanja) {
        this.belanja = belanja;
    }
}
