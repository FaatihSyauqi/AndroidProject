package tif16.sari.kartika.tutorial.Fragment.info;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import tif16.sari.kartika.tutorial.Adapter.home.KulinerAdapter;
import tif16.sari.kartika.tutorial.Adapter.info.BelanjaClickAdapter;
import tif16.sari.kartika.tutorial.R;

public class KulinerFragment extends Fragment {
    RecyclerView mRecycleView;
    RecyclerView.LayoutManager mLayoutManager;
    RecyclerView.Adapter mAdapter;
    CardView cardView;

    public KulinerFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_kuliner, container, false);

        mRecycleView = (RecyclerView) view.findViewById(R.id.recyclerView);
        mRecycleView.setHasFixedSize(true);

        mLayoutManager = new GridLayoutManager(getActivity(),1);
        mRecycleView.setLayoutManager(mLayoutManager);

        mAdapter = new BelanjaClickAdapter();
        mRecycleView.setAdapter(mAdapter);

        return view;
    }
}
