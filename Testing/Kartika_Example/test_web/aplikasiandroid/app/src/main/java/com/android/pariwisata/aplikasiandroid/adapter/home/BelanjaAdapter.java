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
import com.bumptech.glide.Glide;

import java.util.List;

import com.android.pariwisata.aplikasiandroid.activity.DetailActivity;
import com.android.pariwisata.aplikasiandroid.R;
import com.android.pariwisata.aplikasiandroid.model.Belanja;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.content.ContentValues.TAG;

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
        holder.textViewBelanja.setText(blj.getNamaBelanja());
        Glide.with(mContext).load(BaseURL.URL+blj.getImg()).into(holder.imgViewBelanja);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
    TextView textViewBelanja;
    ImageView imgViewBelanja;

        public MyViewHolder(View itemView) {
            super(itemView);
            textViewBelanja = itemView.findViewById(R.id.textCard);
            imgViewBelanja = itemView.findViewById(R.id.img_belanja);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d(TAG, "List ke " + getPosition() + " di klik.");
//                    String textBelanja = textViewBelanja.getText().toString();
//                    String imgBelanja = imgViewBelanja.getDrawable().toString();
                    Intent intent = new Intent(v.getContext(), DetailActivity.class);
//                    intent.putExtra("textBelanja", textBelanja);
//                    intent.putExtra("imgBelanja", imgBelanja);
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
