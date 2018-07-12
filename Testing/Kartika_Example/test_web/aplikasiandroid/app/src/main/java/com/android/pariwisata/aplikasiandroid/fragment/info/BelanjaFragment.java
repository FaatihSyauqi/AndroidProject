package com.android.pariwisata.aplikasiandroid.fragment.info;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.pariwisata.aplikasiandroid.adapter.info.BelanjaClickAdapter;
import com.android.pariwisata.aplikasiandroid.R;


public class BelanjaFragment extends Fragment {

    RecyclerView mRecycleView;
    RecyclerView.LayoutManager mLayoutManager;
    RecyclerView.Adapter mAdapter;
    CardView cardView;

    public BelanjaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_belanja, container, false);

        mRecycleView = view.findViewById(R.id.recyclerView);
        mRecycleView.setHasFixedSize(true);

        mLayoutManager = new GridLayoutManager(getActivity(),1);
        mRecycleView.setLayoutManager(mLayoutManager);

//        mAdapter = new BelanjaClickAdapter();
//        mRecycleView.setAdapter(mAdapter);

        return view;
    }
}

