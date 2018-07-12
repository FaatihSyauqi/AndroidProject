package com.android.pariwisata.aplikasiandroid.api;

import com.android.pariwisata.aplikasiandroid.model.Value;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RegisterAPI {
    @GET("view_belanja.php")
    Call<Value> view_belanja();

    @GET("view_kuliner.php")
    Call<Value> view_kuliner();

    @GET("view_alam.php")
    Call<Value> view_alam();
}
