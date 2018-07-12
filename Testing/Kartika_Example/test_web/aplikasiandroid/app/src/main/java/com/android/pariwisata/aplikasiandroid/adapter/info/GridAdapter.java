package com.android.pariwisata.aplikasiandroid.adapter.info;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.android.pariwisata.aplikasiandroid.R;
import com.android.pariwisata.aplikasiandroid.model.Item;

import java.util.ArrayList;
import java.util.List;

public class GridAdapter extends RecyclerView.Adapter<GridAdapter.ViewHolder> {
    List<Item> mItems;

    public GridAdapter() {
        super();
        mItems = new ArrayList<>();
        Item nama = new Item();
        nama.setFoto(R.drawable.bapa);
        mItems.add(nama);

        nama = new Item();
        nama.setFoto(R.drawable.bapa);
        mItems.add(nama);

        nama = new Item();
        nama.setFoto(R.drawable.bapa);
        mItems.add(nama);

        nama = new Item();
        nama.setFoto(R.drawable.bapa);
        mItems.add(nama);

        nama = new Item();
        nama.setFoto(R.drawable.bapa);
        mItems.add(nama);

        nama = new Item();
        nama.setFoto(R.drawable.bapa);
        mItems.add(nama);

        nama = new Item();
        nama.setFoto(R.drawable.bapa);
        mItems.add(nama);

        nama = new Item();
        nama.setFoto(R.drawable.bapa);
        mItems.add(nama);

        nama = new Item();
        nama.setFoto(R.drawable.bapa);
        mItems.add(nama);

        nama = new Item();
        nama.setFoto(R.drawable.bapa);
        mItems.add(nama);

        nama = new Item();
        nama.setFoto(R.drawable.bapa);
        mItems.add(nama);

        nama = new Item();
        nama.setFoto(R.drawable.bapa);
        mItems.add(nama);

        nama = new Item();
        nama.setFoto(R.drawable.bapa);
        mItems.add(nama);

        nama = new Item();
        nama.setFoto(R.drawable.bapa);
        mItems.add(nama);

        nama = new Item();
        nama.setFoto(R.drawable.bapa);
        mItems.add(nama);

        nama = new Item();
        nama.setFoto(R.drawable.bapa);
        mItems.add(nama);

        nama = new Item();
        nama.setFoto(R.drawable.bapa);
        mItems.add(nama);

        nama = new Item();
        nama.setFoto(R.drawable.bapa);
        mItems.add(nama);

        nama = new Item();
        nama.setFoto(R.drawable.bapa);
        mItems.add(nama);

        nama = new Item();
        nama.setFoto(R.drawable.bapa);
        mItems.add(nama);

        nama = new Item();
        nama.setFoto(R.drawable.bapa);
        mItems.add(nama);

        nama = new Item();
        nama.setFoto(R.drawable.bapa);
        mItems.add(nama);
    }

    public GridAdapter(Context mContext, List<Item> mItems) {
        Context mContext1 = mContext;
        this.mItems =mItems;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.grid_view, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        Item nature = mItems.get(i);
        viewHolder.foto.setImageResource(nature.getFoto());
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder  {

        public ImageView foto;

        public ViewHolder(View view) {
            super(view);
            foto = itemView.findViewById(R.id.imageView);

        }
    }
}
