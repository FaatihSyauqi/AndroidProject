package com.android.pariwisata.aplikasiandroid.fragment.info;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.android.pariwisata.aplikasiandroid.adapter.info.WisataClickAdapter;
import com.android.pariwisata.aplikasiandroid.R;
import com.android.pariwisata.aplikasiandroid.api.RegisterAPI;
import com.android.pariwisata.aplikasiandroid.api.ResponseJsonAlamHome;
import com.android.pariwisata.aplikasiandroid.model.Wisata;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WisataFragment extends Fragment {
    public String BASE_URL = "http://192.168.1.15/pariwisata/";

    private List<Wisata> listwisata = new ArrayList<>();
    RecyclerView mRecycleView;
    RecyclerView.LayoutManager mLayoutManager;
    private ProgressBar progressBar;
    RecyclerView.Adapter mAdapter;

    public WisataFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_wisata, container, false);

        mRecycleView = view.findViewById(R.id.recyclerView);
        mRecycleView.setHasFixedSize(true);

        progressBar = (ProgressBar)view.findViewById(R.id.progress_bar);
        //RecyclerView.LayoutManager mLayoutmanager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false);

        mLayoutManager = new GridLayoutManager(getActivity(),1);
        mRecycleView.setLayoutManager(mLayoutManager);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RegisterAPI api = retrofit.create(RegisterAPI.class);
        Call<ResponseJsonAlamHome> call = api.view_alam_home();

        call.enqueue(new Callback<ResponseJsonAlamHome>() {
            @Override
            public void onResponse(Call<ResponseJsonAlamHome> call, Response<ResponseJsonAlamHome> response) {
                listwisata = response.body().getWisata();
                progressBar.setVisibility(View.GONE);
                mAdapter = new WisataClickAdapter(getContext(),listwisata);
                mRecycleView.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<ResponseJsonAlamHome> call, Throwable t) {
                Log.e("data_error", t.getMessage().toString());
            }
        });
        return view;
    }
}
