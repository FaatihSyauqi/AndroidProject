package com.android.pariwisata.aplikasiandroid.model;

public class Kuliner {
    private int foto;
    private String namaTempatKuliner;

    public Kuliner() {
    }
    public Kuliner(int foto){
        this.foto = foto;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getNamaTempatKuliner() {
        return namaTempatKuliner;
    }

    public void setNamaTempatKuliner(String namaTempatKuliner) {
        this.namaTempatKuliner = namaTempatKuliner;
    }
}
