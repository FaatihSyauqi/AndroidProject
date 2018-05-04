package tif16.sari.kartika.tutorial.Adapter.home;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

import tif16.sari.kartika.tutorial.InfoActivity;
import tif16.sari.kartika.tutorial.MainActivity;
import tif16.sari.kartika.tutorial.R;
import tif16.sari.kartika.tutorial.model.Belanja;

import static android.content.ContentValues.TAG;

/**
 * Created by Faatih on 04/05/2018.
 */

public class BelanjaAdapter extends RecyclerView.Adapter<BelanjaAdapter.MyViewHolder> {

    private Context mContext;
    private List<Belanja> albumList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        // public TextView name;
        public ImageView imgBelanja, overflow;

        public MyViewHolder(View view) {
            super(view);
            imgBelanja = (ImageView) view.findViewById(R.id.img_belanja);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d(TAG, "List ke " + getPosition() + " di klik.");
                    Intent intent = new Intent(v.getContext(),MainActivity.class);
                    v.getContext().startActivity(intent);
                }
            });
        }
    }

    public BelanjaAdapter(Context mContext, List<Belanja> albumList) {
        this.mContext = mContext;
        this.albumList = albumList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_belanja, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Belanja belanja = albumList.get(position);
        // holder.name.setText(geopark.name);
        //    holder.lokasi.setText(geopark.location);


        // loading album cover using Glide library
        Glide.with(mContext).load(belanja.getFoto()).into(holder.imgBelanja);

    }

    /**
     * Showing popup menu when tapping on 3 dots
     */

    @Override
    public int getItemCount() {
        return albumList.size();
    }
}
