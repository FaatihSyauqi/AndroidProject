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
import com.android.pariwisata.aplikasiandroid.model.Belanja;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;
import static com.google.android.gms.plus.PlusOneDummyView.TAG;

public class BelanjaClickAdapter extends RecyclerView.Adapter<BelanjaClickAdapter.ViewHolder> {
    private Context context;
    private List<Belanja> mItems;

    public BelanjaClickAdapter(Context context, List<Belanja> mItems) {
        this.context = context;
        this.mItems = mItems;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.grid_info, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        Belanja nature = mItems.get(i);
        Glide.with(context).load(nature.getFoto()).into(viewHolder.imageView);
        viewHolder.textView.setText(nature.getNama_belanja());
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.imageView)ImageView imageView;
        @BindView(R.id.textCard)TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
//            Intent i = new Intent(context, DetailActivity.class);
//            i.putExtra("nama_belanja",mItems.get(getPosition().nama_belanja));
//            context.startActivity(i);

        }
    }
}
