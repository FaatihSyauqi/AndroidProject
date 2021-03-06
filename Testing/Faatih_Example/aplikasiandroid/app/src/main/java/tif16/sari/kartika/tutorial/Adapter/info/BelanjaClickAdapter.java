package tif16.sari.kartika.tutorial.Adapter.info;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import tif16.sari.kartika.tutorial.DetailActivity;
import tif16.sari.kartika.tutorial.R;
import tif16.sari.kartika.tutorial.model.Item;

import static com.google.android.gms.plus.PlusOneDummyView.TAG;

public class BelanjaClickAdapter extends RecyclerView.Adapter<BelanjaClickAdapter.ViewHolder> {
    private Context mContext;
    List<Item> mItems;

    public BelanjaClickAdapter() {
        super();
        mItems = new ArrayList<Item>();
        Item nama = new Item();
        nama.setFoto(R.drawable.bapa);
        nama.setNamaTempat("BEC");
        mItems.add(nama);

        nama = new Item();
        nama.setFoto(R.drawable.bapa);
        nama.setNamaTempat("BEC");
        mItems.add(nama);

        nama = new Item();
        nama.setFoto(R.drawable.bapa);
        nama.setNamaTempat("BEC");
        mItems.add(nama);

        nama = new Item();
        nama.setFoto(R.drawable.bapa);
        nama.setNamaTempat("BEC");
        mItems.add(nama);

        nama = new Item();
        nama.setFoto(R.drawable.bapa);
        nama.setNamaTempat("BEC");
        mItems.add(nama);

        nama = new Item();
        nama.setFoto(R.drawable.bapa);
        nama.setNamaTempat("BEC");
        mItems.add(nama);

        nama = new Item();
        nama.setFoto(R.drawable.bapa);
        nama.setNamaTempat("BEC");
        mItems.add(nama);

        nama = new Item();
        nama.setFoto(R.drawable.bapa);
        nama.setNamaTempat("BEC");
        mItems.add(nama);

        nama = new Item();
        nama.setFoto(R.drawable.bapa);
        nama.setNamaTempat("BEC");
        mItems.add(nama);

        nama = new Item();
        nama.setFoto(R.drawable.bapa);
        nama.setNamaTempat("BEC");
        mItems.add(nama);

        nama = new Item();
        nama.setFoto(R.drawable.bapa);
        nama.setNamaTempat("BEC");
        mItems.add(nama);

        nama = new Item();
        nama.setFoto(R.drawable.bapa);
        nama.setNamaTempat("BEC");
        mItems.add(nama);

        nama = new Item();
        nama.setFoto(R.drawable.bapa);
        nama.setNamaTempat("BEC");
        mItems.add(nama);

        nama = new Item();
        nama.setFoto(R.drawable.bapa);
        nama.setNamaTempat("BEC");
        mItems.add(nama);

        nama = new Item();
        nama.setFoto(R.drawable.bapa);
        nama.setNamaTempat("BEC");
        mItems.add(nama);

        nama = new Item();
        nama.setFoto(R.drawable.bapa);
        nama.setNamaTempat("BEC");
        mItems.add(nama);

        nama = new Item();
        nama.setFoto(R.drawable.bapa);
        nama.setNamaTempat("BEC");
        mItems.add(nama);

        nama = new Item();
        nama.setFoto(R.drawable.bapa);
        nama.setNamaTempat("BEC");
        mItems.add(nama);

        nama = new Item();
        nama.setFoto(R.drawable.bapa);
        nama.setNamaTempat("BEC");
        mItems.add(nama);

        nama = new Item();
        nama.setFoto(R.drawable.bapa);
        nama.setNamaTempat("BEC");
        mItems.add(nama);

        nama = new Item();
        nama.setFoto(R.drawable.bapa);
        nama.setNamaTempat("BEC");
        mItems.add(nama);

        nama = new Item();
        nama.setFoto(R.drawable.bapa);
        nama.setNamaTempat("BEC");
        mItems.add(nama);
    }

    public BelanjaClickAdapter(Context mContext, List<Item> mItems) {
        this.mContext = mContext;
        this.mItems =mItems;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.grid_info, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        Item nature = mItems.get(i);
        viewHolder.foto.setImageResource(nature.getFoto());
       // viewHolder.text.setText(nature.getNamaTempat());
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder  {

        public ImageView foto;
        public TextView text;

        public ViewHolder(View view) {
            super(view);
            foto = (ImageView)itemView.findViewById(R.id.imageView);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d(TAG, "List ke " + getPosition() + " di klik.");
                    Intent intent = new Intent(v.getContext(),DetailActivity.class);
                    v.getContext().startActivity(intent);
                }
            });

        }
    }
}
