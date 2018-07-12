package com.android.pariwisata.aplikasiandroid.tab;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ImageSpan;

import com.android.pariwisata.aplikasiandroid.R;
import com.android.pariwisata.aplikasiandroid.fragment.Detail.GaleryFragment;
import com.android.pariwisata.aplikasiandroid.fragment.Detail.DeskripsiFragment;
import com.android.pariwisata.aplikasiandroid.fragment.Detail.MapsFragment;

public class MyAdapter extends FragmentPagerAdapter {
    private Context mContext;
    private String[] titles ={"Galeri","Deskripsi","Peta"};
    int[] icon = new int[]{R.drawable.ic_image_black_24dp,R.drawable.ic_description_black_24dp,R.drawable.ic_map_black_24dp};
    private int heightIcon;
    private int widthIcon;

    public MyAdapter(FragmentManager fm, Context c){
        super(fm);
        mContext = c;
        double scale = c.getResources().getDisplayMetrics().density;
        heightIcon=(int)(18*scale+0.5f);
        widthIcon=(int)(20*scale+0.5f);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment frag= null;

        switch (position) {
            case 0:
                frag = new GaleryFragment();
                break;
            case 1:
                frag = new DeskripsiFragment();
                break;
            case 2:
                frag = new MapsFragment();
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
        Drawable d = mContext.getResources().getDrawable(icon[position]);
        d.setBounds(0,0,widthIcon,heightIcon);
        ImageSpan is = new ImageSpan(d);

        SpannableString sp = new SpannableString(" ");
        sp.setSpan(is,0,sp.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        return sp;
    }

}
