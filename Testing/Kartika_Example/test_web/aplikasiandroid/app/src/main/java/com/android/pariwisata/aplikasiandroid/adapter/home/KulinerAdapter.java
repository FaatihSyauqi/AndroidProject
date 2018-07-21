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

import com.android.pariwisata.aplikasiandroid.api.BaseURL;
import com.android.pariwisata.aplikasiandroid.model.Belanja;
import com.bumptech.glide.Glide;

import java.util.List;

import com.android.pariwisata.aplikasiandroid.activity.DetailActivity;
import com.android.pariwisata.aplikasiandroid.R;
import com.android.pariwisata.aplikasiandroid.model.Kuliner;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.content.ContentValues.TAG;

public class KulinerAdapter extends RecyclerView.Adapter<KulinerAdapter.MyViewHolder> {

    private Context mContext;
    private List<Kuliner> albumList;

    public KulinerAdapter(Context mContext, List<Kuliner> albumList) {
        this.mContext = mContext;
        this.albumList = albumList;
    }

    @Override
    public KulinerAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_kuliner, parent, false);
        KulinerAdapter.MyViewHolder holder = new KulinerAdapter.MyViewHolder(v);

        return holder;
    }

    @Override
    public void onBindViewHolder(KulinerAdapter.MyViewHolder holder, int position) {

        Kuliner kuliner = albumList.get(position);
        holder.textViewKuliner.setText(kuliner.getNamaKuliner());
        Glide.with(mContext).load(BaseURL.URL+kuliner.getImg()).into(holder.imgViewKuliner);

    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textViewKuliner;
        ImageView imgViewKuliner;

        public MyViewHolder(View itemView) {
            super(itemView);
            textViewKuliner = itemView.findViewById(R.id.textCard);
            imgViewKuliner = itemView.findViewById(R.id.img_kuliner);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d(TAG, "List ke " + getPosition() + " di klik.");
                    String textKuliner = textViewKuliner.getText().toString();
                    String imgKuliner = imgViewKuliner.getDrawable().toString();
                    Intent intent = new Intent(v.getContext(), DetailActivity.class);
                    intent.putExtra("textKuliner", textKuliner);
                    intent.putExtra("imgKuliner", imgKuliner);
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