package com.android.pariwisata.aplikasiandroid.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by KartikaSari on 7/21/2018.
 */

public class WisataDetail {
    @SerializedName("img")
    @Expose
    private String img;
    @SerializedName("deskripsi_alam")
    @Expose
    private String deskripsiAlam;
    @SerializedName("alamat_alam")
    @Expose
    private String alamatAlam;
    @SerializedName("website_alam")
    @Expose
    private String websiteAlam;
    @SerializedName("jam_alam")
    @Expose
    private String jamAlam;
    @SerializedName("jamakhir_alam")
    @Expose
    private String jamakhirAlam;
    @SerializedName("fasilitas_alam")
    @Expose
    private String fasilitasAlam;

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDeskripsiAlam() {
        return deskripsiAlam;
    }

    public void setDeskripsiAlam(String deskripsiAlam) {
        this.deskripsiAlam = deskripsiAlam;
    }

    public String getAlamatAlam() {
        return alamatAlam;
    }

    public void setAlamatAlam(String alamatAlam) {
        this.alamatAlam = alamatAlam;
    }

    public String getWebsiteAlam() {
        return websiteAlam;
    }

    public void setWebsiteAlam(String websiteAlam) {
        this.websiteAlam = websiteAlam;
    }

    public String getJamAlam() {
        return jamAlam;
    }

    public void setJamAlam(String jamAlam) {
        this.jamAlam = jamAlam;
    }

    public String getJamakhirAlam() {
        return jamakhirAlam;
    }

    public void setJamakhirAlam(String jamakhirAlam) {
        this.jamakhirAlam = jamakhirAlam;
    }

    public String getFasilitasAlam() {
        return fasilitasAlam;
    }

    public void setFasilitasAlam(String fasilitasAlam) {
        this.fasilitasAlam = fasilitasAlam;
    }

}
