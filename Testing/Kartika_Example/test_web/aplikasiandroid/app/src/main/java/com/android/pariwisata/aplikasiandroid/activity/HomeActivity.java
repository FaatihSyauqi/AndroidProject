package com.android.pariwisata.aplikasiandroid.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;

import com.android.pariwisata.aplikasiandroid.adapter.home.BelanjaAdapter;
import com.android.pariwisata.aplikasiandroid.adapter.home.KulinerAdapter;
import com.android.pariwisata.aplikasiandroid.adapter.home.WisataAdapter;
import com.android.pariwisata.aplikasiandroid.R;
import com.android.pariwisata.aplikasiandroid.api.RegisterAPI;
import com.android.pariwisata.aplikasiandroid.api.ResponseJsonAlamHome;
import com.android.pariwisata.aplikasiandroid.api.ResponseJsonBelanjaHome;
import com.android.pariwisata.aplikasiandroid.api.ResponseJsonKulinerHome;
import com.android.pariwisata.aplikasiandroid.model.Belanja;
import com.android.pariwisata.aplikasiandroid.model.Kuliner;
import com.android.pariwisata.aplikasiandroid.model.Wisata;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeActivity extends AppCompatActivity {
    public String BASE_URL = "http://192.168.1.10/pariwisata/";

    private List<Belanja> listbelanja = new ArrayList<>();
    private BelanjaAdapter belanjaAdapter;
    RecyclerView recyclerBelanja;
    private ProgressBar progressBar1;

    private List<Kuliner> listkuliner = new ArrayList<>();
    private KulinerAdapter kulinerAdapter;
    RecyclerView recyclerKuliner;
    private ProgressBar progressBar2;

    private List<Wisata> listwisata = new ArrayList<>();
    private WisataAdapter wisataAdapter;
    RecyclerView recyclerWisata;
    private ProgressBar progressBar3;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    return true;
                case R.id.navigation_info:
                    Intent intent1 = new Intent(HomeActivity.this, InfoActivity.class);
                    startActivity(intent1);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setSelectedItemId(R.id.navigation_home);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        recyclerBelanja = (RecyclerView) findViewById(R.id.recycler_belanja);
        progressBar1 = (ProgressBar)findViewById(R.id.progress_bar1);
        RecyclerView.LayoutManager mLayoutmanager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false);
        recyclerBelanja.setLayoutManager(mLayoutmanager);
        recyclerBelanja.setItemAnimator(new DefaultItemAnimator());
        LoadDataBelanja();

        recyclerKuliner = (RecyclerView) findViewById(R.id.recycler_kuliner);
        progressBar2 = (ProgressBar)findViewById(R.id.progress_bar2);
        RecyclerView.LayoutManager mLayoutmanager1 = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false);
        recyclerKuliner.setLayoutManager(mLayoutmanager1);
        recyclerKuliner.setItemAnimator(new DefaultItemAnimator());
        LoadDataKuliner();

        recyclerWisata = (RecyclerView) findViewById(R.id.recycler_alam);
        progressBar3 = (ProgressBar)findViewById(R.id.progress_bar3);
        RecyclerView.LayoutManager mLayoutmanager2 = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false);
        recyclerWisata.setLayoutManager(mLayoutmanager2);
        recyclerWisata.setItemAnimator(new DefaultItemAnimator());
        LoadDataWisata();
    }

    private void LoadDataBelanja() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RegisterAPI api = retrofit.create(RegisterAPI.class);
        Call<ResponseJsonBelanjaHome> call = api.view_belanja_home();

        call.enqueue(new Callback<ResponseJsonBelanjaHome>() {
            @Override
            public void onResponse(Call<ResponseJsonBelanjaHome> call, Response<ResponseJsonBelanjaHome> response) {
                listbelanja = response.body().getBelanja();
                setAdapterBelanja(listbelanja);
            }

            @Override
            public void onFailure(Call<ResponseJsonBelanjaHome> call, Throwable t) {
                Log.e("data_error", t.getMessage().toString());
            }
        });
    }

    private void LoadDataKuliner() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RegisterAPI api = retrofit.create(RegisterAPI.class);
        Call<ResponseJsonKulinerHome> call = api.view_kuliner_home();

        call.enqueue(new Callback<ResponseJsonKulinerHome>() {
            @Override
            public void onResponse(Call<ResponseJsonKulinerHome> call, Response<ResponseJsonKulinerHome> response) {
                listkuliner = response.body().getKuliner();
                setAdapterKuliner(listkuliner);
            }

            @Override
            public void onFailure(Call<ResponseJsonKulinerHome> call, Throwable t) {
                Log.e("data_error", t.getMessage().toString());
            }
        });
    }

    private void LoadDataWisata() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RegisterAPI api = retrofit.create(RegisterAPI.class);
        Call<ResponseJsonAlamHome> call = api.view_alam_home();

        call.enqueue(new Callback<ResponseJsonAlamHome>() {
            @Override
            public void onResponse(Call<ResponseJsonAlamHome> call, Response<ResponseJsonAlamHome> response) {
                listwisata = response.body().getWisata();
                setAdapterWisata(listwisata);
            }

            @Override
            public void onFailure(Call<ResponseJsonAlamHome> call, Throwable t) {
                Log.e("data_error", t.getMessage().toString());
            }
        });
    }



    public  void setAdapterBelanja(List<Belanja> listbelanja){
        progressBar1.setVisibility(View.GONE);
        belanjaAdapter = new BelanjaAdapter(getApplicationContext(),listbelanja);
        recyclerBelanja.setAdapter(belanjaAdapter);

    }

    public  void setAdapterKuliner(List<Kuliner> listkuliner){
        progressBar2.setVisibility(View.GONE);
        kulinerAdapter = new KulinerAdapter(getApplicationContext(),listkuliner);
        recyclerKuliner.setAdapter(kulinerAdapter);

    }

    public  void setAdapterWisata(List<Wisata> listwisata){
        progressBar3.setVisibility(View.GONE);
        wisataAdapter = new WisataAdapter(getApplicationContext(),listwisata);
        recyclerWisata.setAdapter(wisataAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

}
