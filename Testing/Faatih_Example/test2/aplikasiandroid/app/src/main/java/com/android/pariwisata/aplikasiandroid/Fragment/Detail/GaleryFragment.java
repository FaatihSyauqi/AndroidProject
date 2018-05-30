package com.android.pariwisata.aplikasiandroid.Fragment.Detail;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.pariwisata.aplikasiandroid.Adapter.info.GridAdapter;
import com.android.pariwisata.aplikasiandroid.R;

public class GaleryFragment extends Fragment {
    RecyclerView mRecycleView;
    RecyclerView.LayoutManager mLayoutManager;
    RecyclerView.Adapter mAdapter;

    public GaleryFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_galery, container, false);

        mRecycleView = view.findViewById(R.id.recyclerView);
        mRecycleView.setHasFixedSize(true);

        mLayoutManager = new GridLayoutManager(getActivity(),2);
        mRecycleView.setLayoutManager(mLayoutManager);

        mAdapter = new GridAdapter();
        mRecycleView.setAdapter(mAdapter);
        return view;
    }
}
