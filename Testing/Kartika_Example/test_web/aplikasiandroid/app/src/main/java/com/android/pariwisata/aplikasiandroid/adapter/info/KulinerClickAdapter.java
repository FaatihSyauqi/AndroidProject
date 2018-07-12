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
import com.android.pariwisata.aplikasiandroid.model.Kuliner;

import java.util.ArrayList;
import java.util.List;

import static com.google.android.gms.plus.PlusOneDummyView.TAG;

public class KulinerClickAdapter extends RecyclerView.Adapter<KulinerClickAdapter.ViewHolder> {
    List<Kuliner> mItems;

    public KulinerClickAdapter() {
//        super();
//        mItems = new ArrayList<>();
//        Kuliner nama = new Kuliner();
//        nama.setFoto(R.drawable.bapa);
//        nama.setNama_kuliner("Cisangkuy");
//        mItems.add(nama);
//
//        nama = new Kuliner();
//        nama.setFoto(R.drawable.bapa);
//        nama.setNama_kuliner("Cisangkuy");
//        mItems.add(nama);
//
//        nama = new Kuliner();
//        nama.setFoto(R.drawable.bapa);
//        nama.setNama_kuliner("Cisangkuy");
//        mItems.add(nama);
//
//        nama = new Kuliner();
//        nama.setFoto(R.drawable.bapa);
//        nama.setNama_kuliner("Cisangkuy");
//        mItems.add(nama);
//
//        nama = new Kuliner();
//        nama.setFoto(R.drawable.bapa);
//        nama.setNama_kuliner("Cisangkuy");
//        mItems.add(nama);
//
//        nama = new Kuliner();
//        nama.setFoto(R.drawable.bapa);
//        nama.setNama_kuliner("Cisangkuy");
//        mItems.add(nama);
//
//        nama = new Kuliner();
//        nama.setFoto(R.drawable.bapa);
//        nama.setNama_kuliner("Cisangkuy");
//        mItems.add(nama);
//
//        nama = new Kuliner();
//        nama.setFoto(R.drawable.bapa);
//        nama.setNama_kuliner("Cisangkuy");
//        mItems.add(nama);
//
//        nama = new Kuliner();
//        nama.setFoto(R.drawable.bapa);
//        nama.setNama_kuliner("Cisangkuy");
//        mItems.add(nama);
//
//        nama = new Kuliner();
//        nama.setFoto(R.drawable.bapa);
//        nama.setNama_kuliner("Cisangkuy");
//        mItems.add(nama);
//
//        nama = new Kuliner();
//        nama.setFoto(R.drawable.bapa);
//        nama.setNama_kuliner("Cisangkuy");
//        mItems.add(nama);
//
//        nama = new Kuliner();
//        nama.setFoto(R.drawable.bapa);
//        nama.setNama_kuliner("Cisangkuy");
//        mItems.add(nama);
//
//        nama = new Kuliner();
//        nama.setFoto(R.drawable.bapa);
//        nama.setNama_kuliner("Cisangkuy");
//        mItems.add(nama);
//
//        nama = new Kuliner();
//        nama.setFoto(R.drawable.bapa);
//        nama.setNama_kuliner("Cisangkuy");
//        mItems.add(nama);
//
//        nama = new Kuliner();
//        nama.setFoto(R.drawable.bapa);
//        nama.setNama_kuliner("Cisangkuy");
//        mItems.add(nama);
//
//        nama = new Kuliner();
//        nama.setFoto(R.drawable.bapa);
//        nama.setNama_kuliner("Cisangkuy");
//        mItems.add(nama);
//
//        nama = new Kuliner();
//        nama.setFoto(R.drawable.bapa);
//        nama.setNama_kuliner("Cisangkuy");
//        mItems.add(nama);
//
//        nama = new Kuliner();
//        nama.setFoto(R.drawable.bapa);
//        nama.setNama_kuliner("Cisangkuy");
//        mItems.add(nama);
//
//        nama = new Kuliner();
//        nama.setFoto(R.drawable.bapa);
//        nama.setNama_kuliner("Cisangkuy");
//        mItems.add(nama);
//
//        nama = new Kuliner();
//        nama.setFoto(R.drawable.bapa);
//        nama.setNama_kuliner("Cisangkuy");
//        mItems.add(nama);
//
//        nama = new Kuliner();
//        nama.setFoto(R.drawable.bapa);
//        nama.setNama_kuliner("Cisangkuy");
//        mItems.add(nama);
//
//        nama = new Kuliner();
//        nama.setFoto(R.drawable.bapa);
//        nama.setNama_kuliner("Cisangkuy");
//        mItems.add(nama);
    }

    public KulinerClickAdapter(Context mContext, List<Kuliner> mItems) {
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
        Kuliner nature = mItems.get(i);
        viewHolder.foto.setImageResource(nature.getFoto());
        viewHolder.text.setText(nature.getNama_kuliner());
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
