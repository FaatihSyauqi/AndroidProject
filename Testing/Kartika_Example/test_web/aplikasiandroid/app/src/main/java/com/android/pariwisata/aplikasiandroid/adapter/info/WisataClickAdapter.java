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
import com.android.pariwisata.aplikasiandroid.model.Kuliner;
import com.android.pariwisata.aplikasiandroid.model.Wisata;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

import static com.google.android.gms.plus.PlusOneDummyView.TAG;

public class WisataClickAdapter extends RecyclerView.Adapter<WisataClickAdapter.MyViewHolder> {
    private Context mContext;
    private List<Wisata> albumList;

    public WisataClickAdapter(Context mContext, List<Wisata> albumList) {
        this.mContext = mContext;
        this.albumList = albumList;
    }

    @Override
    public WisataClickAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_info, parent, false);
        WisataClickAdapter.MyViewHolder holder = new WisataClickAdapter.MyViewHolder(v);

        return holder;
    }

    @Override
    public void onBindViewHolder(WisataClickAdapter.MyViewHolder holder, int position) {

        Wisata wisata = albumList.get(position);
        holder.textViewWisata.setText(wisata.getNamaAlam());
        Glide.with(mContext).load(BaseURL.URL+wisata.getImg()).into(holder.imgViewWisata);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textViewWisata;
        ImageView imgViewWisata;

        public MyViewHolder(View itemView) {
            super(itemView);
            textViewWisata = itemView.findViewById(R.id.textCard);
            imgViewWisata = itemView.findViewById(R.id.imageView);
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
