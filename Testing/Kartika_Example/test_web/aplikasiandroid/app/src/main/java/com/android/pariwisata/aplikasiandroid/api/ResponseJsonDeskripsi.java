package com.android.pariwisata.aplikasiandroid.api;

import com.android.pariwisata.aplikasiandroid.model.Wisata;
import com.android.pariwisata.aplikasiandroid.model.WisataDetail;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by KartikaSari on 7/21/2018.
 */

public class ResponseJsonDeskripsi {
    @SerializedName("value")
    @Expose
    private Integer value;
    @SerializedName("result")
    @Expose
    private List<WisataDetail> wisata = null;

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public List<WisataDetail> getWisata() {
        return wisata;
    }

    public void setWisata(List<WisataDetail> wisata) {
        this.wisata = wisata;
    }
}
