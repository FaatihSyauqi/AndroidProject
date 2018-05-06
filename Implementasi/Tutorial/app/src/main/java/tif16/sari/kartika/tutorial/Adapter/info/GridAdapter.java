package tif16.sari.kartika.tutorial.Adapter.info;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import tif16.sari.kartika.tutorial.R;
import tif16.sari.kartika.tutorial.model.Item;

import java.util.ArrayList;
import java.util.List;

public class GridAdapter extends RecyclerView.Adapter<GridAdapter.ViewHolder> {
    private Context mContext;
    List<Item> mItems;

    public GridAdapter() {
        super();
        mItems = new ArrayList<Item>();
        Item nama = new Item();
        nama.setFoto(R.drawable.bapa);
        mItems.add(nama);

        nama = new Item();
        nama.setFoto(R.drawable.bapa);
        mItems.add(nama);

        nama = new Item();
        nama.setFoto(R.drawable.bapa);
        mItems.add(nama);

        nama = new Item();
        nama.setFoto(R.drawable.bapa);
        mItems.add(nama);

        nama = new Item();
        nama.setFoto(R.drawable.bapa);
        mItems.add(nama);

        nama = new Item();
        nama.setFoto(R.drawable.bapa);
        mItems.add(nama);

        nama = new Item();
        nama.setFoto(R.drawable.bapa);
        mItems.add(nama);

        nama = new Item();
        nama.setFoto(R.drawable.bapa);
        mItems.add(nama);

        nama = new Item();
        nama.setFoto(R.drawable.bapa);
        mItems.add(nama);

        nama = new Item();
        nama.setFoto(R.drawable.bapa);
        mItems.add(nama);

        nama = new Item();
        nama.setFoto(R.drawable.bapa);
        mItems.add(nama);

        nama = new Item();
        nama.setFoto(R.drawable.bapa);
        mItems.add(nama);

        nama = new Item();
        nama.setFoto(R.drawable.bapa);
        mItems.add(nama);

        nama = new Item();
        nama.setFoto(R.drawable.bapa);
        mItems.add(nama);

        nama = new Item();
        nama.setFoto(R.drawable.bapa);
        mItems.add(nama);

        nama = new Item();
        nama.setFoto(R.drawable.bapa);
        mItems.add(nama);

        nama = new Item();
        nama.setFoto(R.drawable.bapa);
        mItems.add(nama);

        nama = new Item();
        nama.setFoto(R.drawable.bapa);
        mItems.add(nama);

        nama = new Item();
        nama.setFoto(R.drawable.bapa);
        mItems.add(nama);

        nama = new Item();
        nama.setFoto(R.drawable.bapa);
        mItems.add(nama);

        nama = new Item();
        nama.setFoto(R.drawable.bapa);
        mItems.add(nama);

        nama = new Item();
        nama.setFoto(R.drawable.bapa);
        mItems.add(nama);
    }

    public GridAdapter(Context mContext, List<Item> mItems) {
        this.mContext = mContext;
        this.mItems =mItems;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.grid_view, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        Item nature = mItems.get(i);
        viewHolder.foto.setImageResource(nature.getFoto());
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder  {

        public ImageView foto;

        public ViewHolder(View view) {
            super(view);
            foto = (ImageView)itemView.findViewById(R.id.imageView);

        }
    }
}
