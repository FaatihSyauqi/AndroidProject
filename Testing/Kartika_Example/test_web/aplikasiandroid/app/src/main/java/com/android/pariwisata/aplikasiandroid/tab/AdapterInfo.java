package com.android.pariwisata.aplikasiandroid.tab;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.android.pariwisata.aplikasiandroid.fragment.info.BelanjaFragment;
import com.android.pariwisata.aplikasiandroid.fragment.info.KulinerFragment;
import com.android.pariwisata.aplikasiandroid.fragment.info.WisataFragment;

public class AdapterInfo extends FragmentPagerAdapter {
    private String[] titles = {"Belanja","Wisata","Kuliner"};

    public AdapterInfo(FragmentManager fm, Context c){
        super(fm);
        Context mContext = c;
        double scale = c.getResources().getDisplayMetrics().density;
        int heightIcon = (int) (20 * scale + 0.5f);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment frag= null;

        switch (position) {
            case 0:
                frag = new BelanjaFragment();
                break;
            case 1:
                frag = new WisataFragment();
                break;
            case 2:
                frag = new KulinerFragment();
                break;
        }

        Bundle b = new Bundle();
        b.putInt("position", position);
        frag.setArguments(b);
        return frag;
    }


    @Override
    public int getCount() {
        return titles.length;
    }

    public CharSequence getPageTitle(int position){
        return titles[position];
    }


}

