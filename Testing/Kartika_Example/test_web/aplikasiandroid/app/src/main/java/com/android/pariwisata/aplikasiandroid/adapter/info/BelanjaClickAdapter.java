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
import com.android.pariwisata.aplikasiandroid.adapter.home.BelanjaAdapter;
import com.android.pariwisata.aplikasiandroid.api.BaseURL;
import com.android.pariwisata.aplikasiandroid.model.Belanja;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;
import static com.google.android.gms.plus.PlusOneDummyView.TAG;

public class BelanjaClickAdapter extends RecyclerView.Adapter<BelanjaClickAdapter.MyViewHolder> {
    private Context mContext;
    private List<Belanja> albumList;

    public BelanjaClickAdapter(Context mContext, List<Belanja> albumList) {
        this.mContext = mContext;
        this.albumList = albumList;
    }

    @Override
    public BelanjaClickAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_info, parent, false);
        BelanjaClickAdapter.MyViewHolder holder = new BelanjaClickAdapter.MyViewHolder(v);

        return holder;
    }

    @Override
    public void onBindViewHolder(BelanjaClickAdapter.MyViewHolder holder, int position) {

        Belanja blj = albumList.get(position);
        holder.textViewBelanja.setText(blj.getNamaBelanja());
        Glide.with(mContext).load(BaseURL.URL+blj.getImg()).into(holder.imgViewBelanja);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textViewBelanja;
        ImageView imgViewBelanja;

        public MyViewHolder(View itemView) {
            super(itemView);
            textViewBelanja = itemView.findViewById(R.id.textCard);
            imgViewBelanja = itemView.findViewById(R.id.imageView);
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
