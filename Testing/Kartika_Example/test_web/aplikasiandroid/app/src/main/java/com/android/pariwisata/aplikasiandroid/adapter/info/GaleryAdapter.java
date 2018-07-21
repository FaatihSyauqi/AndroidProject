package com.android.pariwisata.aplikasiandroid.adapter.info;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.pariwisata.aplikasiandroid.R;
import com.android.pariwisata.aplikasiandroid.activity.DetailActivity;
import com.android.pariwisata.aplikasiandroid.api.BaseURL;
import com.android.pariwisata.aplikasiandroid.model.Belanja;
import com.android.pariwisata.aplikasiandroid.model.Galery;
import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by KartikaSari on 7/21/2018.
 */

public class GaleryAdapter extends RecyclerView.Adapter<GaleryAdapter.MyViewHolder>{
    private Context mContext;
    private List<Galery> albumList;

    public GaleryAdapter(Context mContext, List<Galery> albumList) {
        this.mContext = mContext;
        this.albumList = albumList;
    }

    @Override
    public GaleryAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_view, parent, false);
        GaleryAdapter.MyViewHolder holder = new GaleryAdapter.MyViewHolder(v);

        return holder;
    }

    @Override
    public void onBindViewHolder(GaleryAdapter.MyViewHolder holder, int position) {

        Galery foto = albumList.get(position);
        Glide.with(mContext).load(BaseURL.URL+foto.getAlamGaleri()).into(holder.imgViewGalery);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imgViewGalery;

        public MyViewHolder(View itemView) {
            super(itemView);
            imgViewGalery = itemView.findViewById(R.id.imageView);
            ButterKnife.bind(this, itemView);
        }
    }

    @Override
    public int getItemCount() {
        return albumList.size();
    }
}
