package com.android.pariwisata.aplikasiandroid.model;

/**
 * Created by Faatih on 04/05/2018.
 */

public class Belanja {
    private int foto;
    private String namaTempatBelanja;

    public Belanja() {
    }
    public Belanja(int foto){
        this.foto = foto;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getNamaTempatBelanja() {
        return namaTempatBelanja;
    }

    public void setNamaTempatBelanja(String namaTempatBelanja) {
        this.namaTempatBelanja = namaTempatBelanja;
    }
}
