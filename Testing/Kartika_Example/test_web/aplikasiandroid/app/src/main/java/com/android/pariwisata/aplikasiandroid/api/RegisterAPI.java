package com.android.pariwisata.aplikasiandroid.api;

import com.android.pariwisata.aplikasiandroid.model.Value;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RegisterAPI {
    @GET("view_belanja_home.php")
    Call<ResponseJsonBelanjaHome> view_belanja_home();

    @GET("view_kuliner_home.php")
    Call<ResponseJsonKulinerHome> view_kuliner_home();

    @GET("view_alam_home.php")
    Call<ResponseJsonAlamHome> view_alam_home();
}
