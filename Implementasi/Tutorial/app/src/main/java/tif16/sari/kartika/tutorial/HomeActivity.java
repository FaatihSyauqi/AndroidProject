package tif16.sari.kartika.tutorial;

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

import tif16.sari.kartika.tutorial.Adapter.home.BelanjaAdapter;
import tif16.sari.kartika.tutorial.model.Belanja;

public class HomeActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    Belanja belanja;
    BelanjaAdapter belanjaAdapter;
    private List<Belanja> list;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    Intent intent = new Intent(HomeActivity.this,HomeActivity.class);
                    startActivity(intent);
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
        LinearLayoutManager horizontalLayoutManagaer
                = new LinearLayoutManager(HomeActivity.this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(horizontalLayoutManagaer);
        //  fotoAdapter.setClickListener(this);
        recyclerView.setAdapter(belanjaAdapter);
        DataBelanja();
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


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

}
