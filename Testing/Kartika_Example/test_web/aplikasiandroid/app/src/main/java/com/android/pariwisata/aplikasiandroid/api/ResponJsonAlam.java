package com.android.pariwisata.aplikasiandroid.api;

import com.android.pariwisata.aplikasiandroid.model.WisataDetail;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by KartikaSari on 7/21/2018.
 */

public class ResponJsonAlam {
    @SerializedName("value")
    @Expose
    private Integer value;
    @SerializedName("result")
    @Expose
    private List<WisataDetail> result = null;

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public List<WisataDetail> getResult() {
        return result;
    }

    public void setResult(List<WisataDetail> result) {
        this.result = result;
    }
}
