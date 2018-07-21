package com.android.pariwisata.aplikasiandroid.fragment.info;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.android.pariwisata.aplikasiandroid.adapter.home.BelanjaAdapter;
import com.android.pariwisata.aplikasiandroid.adapter.info.BelanjaClickAdapter;
import com.android.pariwisata.aplikasiandroid.R;
import com.android.pariwisata.aplikasiandroid.api.BaseURL;
import com.android.pariwisata.aplikasiandroid.api.RegisterAPI;
import com.android.pariwisata.aplikasiandroid.api.ResponseJsonAlamHome;
import com.android.pariwisata.aplikasiandroid.api.ResponseJsonBelanjaHome;
import com.android.pariwisata.aplikasiandroid.model.Belanja;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class BelanjaFragment extends Fragment {

    private List<Belanja> listbelanja = new ArrayList<>();
    RecyclerView mRecycleView;
    RecyclerView.LayoutManager mLayoutManager;
    private ProgressBar progressBar;
    RecyclerView.Adapter mAdapter;

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

        progressBar = (ProgressBar)view.findViewById(R.id.progress_bar);
        //RecyclerView.LayoutManager mLayoutmanager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false);

        mLayoutManager = new GridLayoutManager(getActivity(),1);
        mRecycleView.setLayoutManager(mLayoutManager);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BaseURL.URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RegisterAPI api = retrofit.create(RegisterAPI.class);
        Call<ResponseJsonBelanjaHome> call = api.view_belanja_home();

        call.enqueue(new Callback<ResponseJsonBelanjaHome>() {
            @Override
            public void onResponse(Call<ResponseJsonBelanjaHome> call, Response<ResponseJsonBelanjaHome> response) {
                listbelanja = response.body().getBelanja();
                progressBar.setVisibility(View.GONE);
                mAdapter = new BelanjaClickAdapter(getContext(),listbelanja);
                mRecycleView.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<ResponseJsonBelanjaHome> call, Throwable t) {
                Log.e("data_error", t.getMessage().toString());
            }
        });
        return view;
    }

}

