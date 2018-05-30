package com.android.pariwisata.aplikasiandroid;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class intro extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        int WELCOME_TIMEOUT = 1500;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent welcome = new Intent(intro.this, HomeActivity.class);
                startActivity(welcome);
                overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
                finish();
            }
        }, WELCOME_TIMEOUT);
    }
}
