package tif16.sari.kartika.tutorial.model;

import java.util.List;

import tif16.sari.kartika.tutorial.HomeActivity;

/**
 * Created by Faatih on 04/05/2018.
 */

public class Belanja {
    private int foto;
    private String nama_tempat;
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

    public String getNama_tempat() {
        return nama_tempat;
    }

    public void setNama_tempat(String nama_tempat) {
        this.nama_tempat = nama_tempat;
    }
}
