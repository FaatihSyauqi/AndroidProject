package com.android.pariwisata.aplikasiandroid.adapter.home;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import com.android.pariwisata.aplikasiandroid.activity.DetailActivity;
import com.android.pariwisata.aplikasiandroid.R;
import com.android.pariwisata.aplikasiandroid.model.Belanja;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.content.ContentValues.TAG;

/**
 * Created by Faatih on 04/05/2018.
 */

public class BelanjaAdapter extends RecyclerView.Adapter<BelanjaAdapter.MyViewHolder> {

    private Context mContext;
    private List<Belanja> albumList;

    public BelanjaAdapter(Context mContext, List<Belanja> albumList) {
        this.mContext = mContext;
        this.albumList = albumList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_belanja, parent, false);
        MyViewHolder holder = new MyViewHolder(v);

        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Belanja blj = albumList.get(position);
        holder.textViewBelanja.setText(blj.getNama_belanja());
        Glide.with(mContext).load(blj.getFoto()).into(holder.imgViewBelanja);

    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.textCard)
        TextView textViewBelanja;
        @BindView(R.id.img_belanja)
        ImageView imgViewBelanja;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d(TAG, "List ke " + getPosition() + " di klik.");
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
