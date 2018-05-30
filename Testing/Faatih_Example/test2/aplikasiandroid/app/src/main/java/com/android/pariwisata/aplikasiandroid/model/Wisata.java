package com.android.pariwisata.aplikasiandroid.model;

public class Wisata {
    private int foto;
    private String namaTempatWisata;

    public Wisata() {
    }
    public Wisata(int foto){
        this.foto = foto;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getNamaTempatWisata() {
        return namaTempatWisata;
    }

    public void setNamaTempatWisata(String namaTempatWisata) {
        this.namaTempatWisata = namaTempatWisata;
    }
}
