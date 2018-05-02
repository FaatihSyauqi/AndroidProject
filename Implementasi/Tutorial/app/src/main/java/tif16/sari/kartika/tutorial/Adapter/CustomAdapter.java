package tif16.sari.kartika.tutorial.Adapter;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import tif16.sari.kartika.tutorial.MainActivity;
import tif16.sari.kartika.tutorial.R;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
    private static final String TAG = "CustomAdapter";

    private int[] mDataSet;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView bapa;

        public ViewHolder(View v) {
            super(v);
            bapa = (ImageView) v.findViewById(R.id.imageView);
        }
        public ImageView getImageView() {
            return bapa;
        }
    }

    public CustomAdapter(int[] dataSet) {
        this.mDataSet = dataSet;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view.
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.grid_view, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
    }

    @Override
    public int getItemCount() {
        return mDataSet.length;
    }
}
