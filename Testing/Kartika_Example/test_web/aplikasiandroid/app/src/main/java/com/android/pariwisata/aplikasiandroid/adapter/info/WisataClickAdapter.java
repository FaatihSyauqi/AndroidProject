package com.android.pariwisata.aplikasiandroid.adapter.info;

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
import com.android.pariwisata.aplikasiandroid.model.Wisata;

import java.util.ArrayList;
import java.util.List;

import static com.google.android.gms.plus.PlusOneDummyView.TAG;

public class WisataClickAdapter extends RecyclerView.Adapter<WisataClickAdapter.ViewHolder> {
    List<Wisata> mItems;

    public WisataClickAdapter() {
//        super();
//        mItems = new ArrayList<>();
//        Wisata nama = new Wisata();
//        nama.setFoto(R.drawable.bapa);
//        nama.setNama_alam("Tangkuban Perahu");
//        mItems.add(nama);
//
//        nama = new Wisata();
//        nama.setFoto(R.drawable.bapa);
//        nama.setNama_alam("Tangkuban Perahu");
//        mItems.add(nama);
//
//        nama = new Wisata();
//        nama.setFoto(R.drawable.bapa);
//        nama.setNama_alam("Tangkuban Perahu");
//        mItems.add(nama);
//
//        nama = new Wisata();
//        nama.setFoto(R.drawable.bapa);
//        nama.setNama_alam("Tangkuban Perahu");
//        mItems.add(nama);
//
//        nama = new Wisata();
//        nama.setFoto(R.drawable.bapa);
//        nama.setNama_alam("Tangkuban Perahu");
//        mItems.add(nama);
//
//        nama = new Wisata();
//        nama.setFoto(R.drawable.bapa);
//        nama.setNama_alam("Tangkuban Perahu");
//        mItems.add(nama);
//
//        nama = new Wisata();
//        nama.setFoto(R.drawable.bapa);
//        nama.setNama_alam("Tangkuban Perahu");
//        mItems.add(nama);
//
//        nama = new Wisata();
//        nama.setFoto(R.drawable.bapa);
//        nama.setNama_alam("Tangkuban Perahu");
//        mItems.add(nama);
//
//        nama = new Wisata();
//        nama.setFoto(R.drawable.bapa);
//        nama.setNama_alam("Tangkuban Perahu");
//        mItems.add(nama);
//
//        nama = new Wisata();
//        nama.setFoto(R.drawable.bapa);
//        nama.setNama_alam("Tangkuban Perahu");
//        mItems.add(nama);
//
//        nama = new Wisata();
//        nama.setFoto(R.drawable.bapa);
//        nama.setNama_alam("Tangkuban Perahu");
//        mItems.add(nama);
//
//        nama = new Wisata();
//        nama.setFoto(R.drawable.bapa);
//        nama.setNama_alam("Tangkuban Perahu");
//        mItems.add(nama);
//
//        nama = new Wisata();
//        nama.setFoto(R.drawable.bapa);
//        nama.setNama_alam("Tangkuban Perahu");
//        mItems.add(nama);
//
//        nama = new Wisata();
//        nama.setFoto(R.drawable.bapa);
//        nama.setNama_alam("Tangkuban Perahu");
//        mItems.add(nama);
//
//        nama = new Wisata();
//        nama.setFoto(R.drawable.bapa);
//        nama.setNama_alam("Tangkuban Perahu");
//        mItems.add(nama);
//
//        nama = new Wisata();
//        nama.setFoto(R.drawable.bapa);
//        nama.setNama_alam("Tangkuban Perahu");
//        mItems.add(nama);
//
//        nama = new Wisata();
//        nama.setFoto(R.drawable.bapa);
//        nama.setNama_alam("Tangkuban Perahu");
//        mItems.add(nama);
//
//        nama = new Wisata();
//        nama.setFoto(R.drawable.bapa);
//        nama.setNama_alam("Tangkuban Perahu");
//        mItems.add(nama);
//
//        nama = new Wisata();
//        nama.setFoto(R.drawable.bapa);
//        nama.setNama_alam("Tangkuban Perahu");
//        mItems.add(nama);
//
//        nama = new Wisata();
//        nama.setFoto(R.drawable.bapa);
//        nama.setNama_alam("Tangkuban Perahu");
//        mItems.add(nama);
//
//        nama = new Wisata();
//        nama.setFoto(R.drawable.bapa);
//        nama.setNama_alam("Tangkuban Perahu");
//        mItems.add(nama);
//
//        nama = new Wisata();
//        nama.setFoto(R.drawable.bapa);
//        nama.setNama_alam("Tangkuban Perahu");
//        mItems.add(nama);
    }

    public WisataClickAdapter(Context mContext, List<Wisata> mItems) {
        Context mContext1 = mContext;
        this.mItems =mItems;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.grid_info, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        Wisata nature = mItems.get(i);
        viewHolder.foto.setImageResource(nature.getFoto());
        viewHolder.text.setText(nature.getNama_alam());
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder  {

        public ImageView foto;
        public TextView text;

        public ViewHolder(View view) {
            super(view);
            foto = itemView.findViewById(R.id.imageView);
            text = itemView.findViewById(R.id.textCard);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d(TAG, "List ke " + getPosition() + " di klik.");
                    Intent intent = new Intent(v.getContext(),DetailActivity.class);
                    v.getContext().startActivity(intent);
                }
            });

        }
    }
}
