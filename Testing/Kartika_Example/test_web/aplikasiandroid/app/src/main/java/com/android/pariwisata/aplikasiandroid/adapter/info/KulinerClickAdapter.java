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
import com.android.pariwisata.aplikasiandroid.model.Kuliner;
import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.ButterKnife;


public class KulinerClickAdapter extends RecyclerView.Adapter<KulinerClickAdapter.MyViewHolder> {
    private Context mContext;
    private List<Kuliner> albumList;

    public KulinerClickAdapter(Context mContext, List<Kuliner> albumList) {
        this.mContext = mContext;
        this.albumList = albumList;
    }

    @Override
    public KulinerClickAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_info, parent, false);
        KulinerClickAdapter.MyViewHolder holder = new KulinerClickAdapter.MyViewHolder(v);

        return holder;
    }

    @Override
    public void onBindViewHolder(KulinerClickAdapter.MyViewHolder holder, int position) {

        Kuliner kuliner = albumList.get(position);
        holder.textViewkuliner.setText(kuliner.getNamaKuliner());
        Glide.with(mContext).load(BaseURL.URL+kuliner.getImg()).into(holder.imgViewkuliner);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textViewkuliner;
        ImageView imgViewkuliner;

        public MyViewHolder(View itemView) {
            super(itemView);
            textViewkuliner = itemView.findViewById(R.id.textCard);
            imgViewkuliner = itemView.findViewById(R.id.imageView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d(ContentValues.TAG, "List ke " + getPosition() + " di klik.");
                    Intent intent = new Intent(v.getContext(), DetailActivity.class);
                    v.getContext().startActivity(intent);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return albumList.size();
    }
}
