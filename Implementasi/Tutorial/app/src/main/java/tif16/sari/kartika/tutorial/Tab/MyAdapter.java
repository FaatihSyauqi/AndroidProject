package tif16.sari.kartika.tutorial.Tab;

/**
 * Created by KartikaSari on 4/27/2018.
 */

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ImageSpan;

import tif16.sari.kartika.tutorial.R;
import tif16.sari.kartika.tutorial.Fragment.infoDetail.GaleryFragment;
import tif16.sari.kartika.tutorial.Fragment.infoDetail.DeskripsiFragment;
import tif16.sari.kartika.tutorial.Fragment.infoDetail.MapsFragment;

public class MyAdapter extends FragmentPagerAdapter {
    private Context mContext;
    private String[] titles ={"Galeri","Deskripsi","Peta"};
    int[] icon = new int[]{R.drawable.ic_image_black_24dp,R.drawable.ic_description_black_24dp,R.drawable.ic_map_black_24dp};
    private int heightIcon;

    public MyAdapter(FragmentManager fm, Context c){
        super(fm);
        mContext = c;
        double scale = c.getResources().getDisplayMetrics().density;
        heightIcon=(int)(24*scale+0.5f);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment frag= null;

        if(position ==0){
            frag = new GaleryFragment();
        }else if(position == 1){
            frag = new DeskripsiFragment();
        }else if(position == 2){
            frag = new MapsFragment();
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
        d.setBounds(0,0,heightIcon,heightIcon);
        ImageSpan is = new ImageSpan(d);

        SpannableString sp = new SpannableString(" ");
        sp.setSpan(is,0,sp.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        return sp;
    }

}
