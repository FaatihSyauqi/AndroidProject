package tif16.sari.kartika.tutorial.Tab;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ImageSpan;

import tif16.sari.kartika.tutorial.Fragment.info.BelanjaFragment;
import tif16.sari.kartika.tutorial.Fragment.info.KulinerFragment;
import tif16.sari.kartika.tutorial.Fragment.info.WisataFragment;
import tif16.sari.kartika.tutorial.R;

import static android.text.Spanned.SPAN_EXCLUSIVE_EXCLUSIVE;

public class AdapterInfo extends FragmentPagerAdapter {
    private Context mContext;
    private String[] titles = {"Belanja","Wisata","Kuliner"};
  //  int[] icon = new int[]{R.drawable.ic_shopping_basket_black_24dp,R.drawable.ic_card_travel_black_24dp,R.drawable.ic_restaurant_black_24dp};
    private int heightIcon;

    public AdapterInfo(FragmentManager fm, Context c){
        super(fm);
        mContext = c;
        double scale = c.getResources().getDisplayMetrics().density;
        heightIcon = (int)(24*scale+0.5f);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment frag= null;

        if(position ==0){
            frag = new BelanjaFragment();
        }else if(position == 1){
            frag = new WisataFragment();
        }else if(position == 2){
            frag = new KulinerFragment();
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

