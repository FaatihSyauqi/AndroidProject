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
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import com.android.pariwisata.aplikasiandroid.adapter.home.BelanjaAdapter;
import com.android.pariwisata.aplikasiandroid.adapter.home.KulinerAdapter;
import com.android.pariwisata.aplikasiandroid.adapter.home.WisataAdapter;
import com.android.pariwisata.aplikasiandroid.R;
import com.android.pariwisata.aplikasiandroid.api.RegisterAPI;
import com.android.pariwisata.aplikasiandroid.model.Belanja;
import com.android.pariwisata.aplikasiandroid.model.Kuliner;
import com.android.pariwisata.aplikasiandroid.model.Value;
import com.android.pariwisata.aplikasiandroid.model.Wisata;
import com.bumptech.glide.load.engine.Resource;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeActivity extends AppCompatActivity {
    public static final String URL = "http://192.168.43.62/pariwisata/";
    private List<Belanja> listbelanja = new ArrayList<>();
    private List<Kuliner> listkuliner = new ArrayList<>();
    private List<Wisata> listwisata = new ArrayList<>();
    private BelanjaAdapter belanjaAdapter;
    private KulinerAdapter kulinerAdapter;
    private WisataAdapter wisataAdapter;
    @BindView(R.id.recycler_belanja)
    RecyclerView recyclerBelanja;
    @BindView(R.id.recycler_kuliner)
    RecyclerView recyclerKuliner;
    @BindView(R.id.recycler_alam)
    RecyclerView recyclerWisata;
    @BindView(R.id.progress_bar)
    private ProgressBar progressBar;

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

        ButterKnife.bind(this);
        belanjaAdapter = new BelanjaAdapter(this, listbelanja);
        RecyclerView.LayoutManager mLayoutmanager = new LinearLayoutManager(getApplicationContext());
        recyclerBelanja.setLayoutManager(mLayoutmanager);
        recyclerBelanja.setItemAnimator(new DefaultItemAnimator());
        recyclerBelanja.setAdapter(belanjaAdapter);
        LoadDataBelanja();

        ButterKnife.bind(this);
        kulinerAdapter = new KulinerAdapter(this, listkuliner);
        RecyclerView.LayoutManager mLayoutmanager2 = new LinearLayoutManager(getApplicationContext());
        recyclerKuliner.setLayoutManager(mLayoutmanager2);
        recyclerKuliner.setItemAnimator(new DefaultItemAnimator());
        recyclerKuliner.setAdapter(kulinerAdapter);
        LoadDataKuliner();

        ButterKnife.bind(this);
        wisataAdapter = new WisataAdapter(this, listwisata);
        RecyclerView.LayoutManager mLayoutmanager3 = new LinearLayoutManager(getApplicationContext());
        recyclerWisata.setLayoutManager(mLayoutmanager3);
        recyclerWisata.setItemAnimator(new DefaultItemAnimator());
        recyclerWisata.setAdapter(wisataAdapter);
        LoadDataWisata();
    }

    @Override
    protected void onResume(){
        super.onResume();
        LoadDataBelanja();
        LoadDataKuliner();
        LoadDataWisata();
    }

    private void LoadDataBelanja(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RegisterAPI api = retrofit.create(RegisterAPI.class);
        Call<Value> call = api.view_belanja();

        call.enqueue(new Callback<Value>(){
            @Override
            public void onResponse(Call<Value> call, Response<Value> response){
                String value = response.body().getValue();
                progressBar.setVisibility(View.GONE);

                if(value.equals("1")){
                    listbelanja =  response.body().getBelanja();
                    belanjaAdapter = new BelanjaAdapter(HomeActivity.this,listbelanja);
                    recyclerBelanja.setAdapter(belanjaAdapter);
                }
            }

            @Override
            public void onFailure(Call<Value> call,Throwable t){

            }
        });
    }

    private void LoadDataKuliner(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RegisterAPI api = retrofit.create(RegisterAPI.class);
        Call<Value> call = api.view_kuliner();

        call.enqueue(new Callback<Value>(){
            @Override
            public void onResponse(Call<Value> call, Response<Value> response){
                String value = response.body().getValue();
                progressBar.setVisibility(View.GONE);

                if(value.equals("1")){
                    listkuliner =  response.body().getKuliner();
                    kulinerAdapter = new KulinerAdapter(HomeActivity.this,listkuliner);
                    recyclerKuliner.setAdapter(kulinerAdapter);
                }
            }

            @Override
            public void onFailure(Call<Value> call,Throwable t){

            }
        });
    }

    private void LoadDataWisata(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RegisterAPI api = retrofit.create(RegisterAPI.class);
        Call<Value> call = api.view_alam();

        call.enqueue(new Callback<Value>(){
            @Override
            public void onResponse(Call<Value> call, Response<Value> response){
                String value = response.body().getValue();
                progressBar.setVisibility(View.GONE);

                if(value.equals("1")){
                    listwisata =  response.body().getAlam();
                    wisataAdapter = new WisataAdapter(HomeActivity.this,listwisata);
                    recyclerWisata.setAdapter(wisataAdapter);
                }
            }

            @Override
            public void onFailure(Call<Value> call,Throwable t){

            }
        });
    }

        @Override
        public boolean onCreateOptionsMenu (Menu menu){
//        getMenuInflater().inflate(R.menu.menu_main, menu);
            return true;
        }

    }
