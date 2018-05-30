package com.android.pariwisata.aplikasiandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import com.android.pariwisata.aplikasiandroid.Adapter.home.BelanjaAdapter;
import com.android.pariwisata.aplikasiandroid.Adapter.home.KulinerAdapter;
import com.android.pariwisata.aplikasiandroid.Adapter.home.WisataAdapter;
import com.android.pariwisata.aplikasiandroid.model.Belanja;
import com.android.pariwisata.aplikasiandroid.model.Kuliner;
import com.android.pariwisata.aplikasiandroid.model.Wisata;

public class HomeActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    Belanja belanja;
    BelanjaAdapter belanjaAdapter;
    private List<Belanja> list;
    Kuliner kuliner;
    KulinerAdapter kulinerAdapter;
    private List<Kuliner> listKuliner;
    Wisata wisata;
    WisataAdapter wisataAdapter;
    private List<Wisata> listWisata;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    return true;
                case R.id.navigation_info:
                    Intent intent1 = new Intent(HomeActivity.this,InfoActivity.class);
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

        //untuk recycler View
        list = new ArrayList<>();
        belanjaAdapter = new BelanjaAdapter(this, list);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_belanja);
        LinearLayoutManager horizontalLayoutManager
                = new LinearLayoutManager(HomeActivity.this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(horizontalLayoutManager);
        recyclerView.setAdapter(belanjaAdapter);
        DataBelanja();

        listKuliner = new ArrayList<>();
        kulinerAdapter = new KulinerAdapter(this, listKuliner);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_kuliner);
        LinearLayoutManager horizontalLayoutManager1
                = new LinearLayoutManager(HomeActivity.this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(horizontalLayoutManager1);
        recyclerView.setAdapter(kulinerAdapter);
        DataKuliner();

        listWisata = new ArrayList<>();
        wisataAdapter = new WisataAdapter(this, listWisata);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_alam);
        LinearLayoutManager horizontalLayoutManager2
                = new LinearLayoutManager(HomeActivity.this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(horizontalLayoutManager2);
        recyclerView.setAdapter(wisataAdapter);
        DataWisata();
    }

    private void DataBelanja(){
        int[] gambar = new int[]{
                R.drawable.bapa,
                R.drawable.bapa,
                R.drawable.bapa,
                R.drawable.bapa
        };
        Belanja belanja = new Belanja(gambar[0]);
        list.add(belanja);
        belanja = new Belanja(gambar[0]);
        list.add(belanja);
        belanja = new Belanja(gambar[1]);
        list.add(belanja);
        belanja = new Belanja(gambar[2]);
        list.add(belanja);
        belanja = new Belanja(gambar[3]);
        list.add(belanja);
    }

    private void DataKuliner(){
        int[] gambar = new int[]{
                R.drawable.bapa,
                R.drawable.bapa,
                R.drawable.bapa,
                R.drawable.bapa
        };
        Kuliner kuliner = new Kuliner(gambar[0]);
        listKuliner.add(kuliner);
        kuliner = new Kuliner(gambar[0]);
        listKuliner.add(kuliner);
        kuliner = new Kuliner(gambar[1]);
        listKuliner.add(kuliner);
        kuliner = new Kuliner(gambar[2]);
        listKuliner.add(kuliner);
        kuliner = new Kuliner(gambar[3]);
        listKuliner.add(kuliner);
    }

    private void DataWisata(){
        int[] gambar = new int[]{
                R.drawable.bapa,
                R.drawable.bapa,
                R.drawable.bapa,
                R.drawable.bapa
        };
        Wisata wisata = new Wisata(gambar[0]);
        listWisata.add(wisata);
        wisata = new Wisata(gambar[0]);
        listWisata.add(wisata);
        wisata = new Wisata(gambar[1]);
        listWisata.add(wisata);
        wisata = new Wisata(gambar[2]);
        listWisata.add(wisata);
        wisata = new Wisata(gambar[3]);
        listWisata.add(wisata);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

}