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
import com.android.pariwisata.aplikasiandroid.model.Wisata;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.content.ContentValues.TAG;

public class WisataAdapter extends RecyclerView.Adapter<WisataAdapter.MyViewHolder> {

    private Context mContext;
    private List<Wisata> albumList;

    public WisataAdapter(Context mContext, List<Wisata> albumList) {
        this.mContext = mContext;
        this.albumList = albumList;
    }

    @Override
    public WisataAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_wisata, parent, false);
        WisataAdapter.MyViewHolder holder = new WisataAdapter.MyViewHolder(v);

        return holder;
    }

    @Override
    public void onBindViewHolder(WisataAdapter.MyViewHolder holder, int position) {

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
            imgViewWisata = itemView.findViewById(R.id.img_alam);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d(TAG, "List ke " + getPosition() + " di klik.");
                    String textWisata = textViewWisata.getText().toString();
                    String imgWisata = imgViewWisata.getDrawable().toString();
                    Intent intent = new Intent(v.getContext(), DetailActivity.class);
                    intent.putExtra("textWisata", textWisata);
                    intent.putExtra("imgWisata", imgWisata);
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
