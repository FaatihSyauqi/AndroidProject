package com.android.pariwisata.aplikasiandroid.model;

import java.util.List;

public class Value {
    private String value;
    private String message;
    private List<Belanja> resultBelanja;
    private List<Kuliner> resultKuliner;
    private List<Wisata> resultAlam;

    public String getValue() {
        return value;
    }

    public String getMessage() {
        return message;
    }

    public List<Belanja> getBelanja() {
        return resultBelanja;
    }

    public List<Kuliner> getKuliner() {
        return resultKuliner;
    }

    public List<Wisata> getAlam() {
        return resultAlam;
    }
}
