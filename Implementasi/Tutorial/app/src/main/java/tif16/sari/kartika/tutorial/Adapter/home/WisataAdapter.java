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

import tif16.sari.kartika.tutorial.DetailActivity;
import tif16.sari.kartika.tutorial.R;
import tif16.sari.kartika.tutorial.model.Wisata;

import static android.content.ContentValues.TAG;

public class WisataAdapter extends RecyclerView.Adapter<WisataAdapter.MyViewHolder> {

    private Context mContext;
    private List<Wisata> albumList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        // public TextView name;
        public ImageView imgWisata, overflow;

        public MyViewHolder(View view) {
            super(view);
            imgWisata = (ImageView) view.findViewById(R.id.img_wisata);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d(TAG, "List ke " + getPosition() + " di klik.");
                    Intent intent = new Intent(v.getContext(), DetailActivity.class);
                    v.getContext().startActivity(intent);
                }
            });
        }
    }

    public WisataAdapter(Context mContext, List<Wisata> albumList) {
        this.mContext = mContext;
        this.albumList = albumList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_wisata, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Wisata wisata = albumList.get(position);


        // loading album cover using Glide library
        Glide.with(mContext).load(wisata.getFoto()).into(holder.imgWisata);

    }

    /**
     * Showing popup menu when tapping on 3 dots
     */

    @Override
    public int getItemCount() {
        return albumList.size();
    }
}
