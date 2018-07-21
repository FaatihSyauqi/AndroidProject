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
import com.android.pariwisata.aplikasiandroid.model.WisataDetail;
import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by KartikaSari on 7/21/2018.
 */

public class DetailAdapter{
//    private Context mContext;
//    private List<WisataDetail> albumList;
//
//    public DetailAdapter(Context mContext, List<WisataDetail> albumList) {
//        this.mContext = mContext;
//        this.albumList = albumList;
//    }
//
//    @Override
//    public DetailAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_info, parent, false);
//        DetailAdapter.MyViewHolder holder = new DetailAdapter.MyViewHolder(v);
//
//        return holder;
//    }
//
//    @Override
//    public void onBindViewHolder(DetailAdapter.MyViewHolder holder, int position) {
//
//        WisataDetail wisata = albumList.get(position);
//        holder.textDeskripsi.setText(wisata.getDeskripsiAlam());
//        holder.textAlamat.setText(wisata.getAlamatAlam());
//        holder.textJam.setText(wisata.getJamAlam()+"-"+wisata.getJamakhirAlam());
//        holder.textFasilitas.setText(wisata.getFasilitasAlam());
//        Glide.with(mContext).load(BaseURL.URL+wisata.getImg()).into(holder.img);
//    }
//
//    public class MyViewHolder  {
//        TextView textDeskripsi;
//        TextView textAlamat;
//        TextView textJam;
//        TextView textFasilitas;
//        ImageView img;
//
//        public MyViewHolder(View itemView) {
//            super(itemView);
//            textDeskripsi = itemView.findViewById(R.id.deskripsi_content);
//            textAlamat = itemView.findViewById(R.id.alamat);
//            textJam = itemView.findViewById(R.id.jam);
//            textFasilitas = itemView.findViewById(R.id.fasilitas);
//            img = itemView.findViewById(R.id.image);
//        }
//    }
//
//    @Override
//    public int getItemCount() {
//        return albumList.size();
//    }
}
