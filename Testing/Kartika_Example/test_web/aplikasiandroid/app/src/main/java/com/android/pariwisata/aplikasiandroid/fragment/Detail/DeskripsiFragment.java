package com.android.pariwisata.aplikasiandroid.fragment.Detail;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.pariwisata.aplikasiandroid.R;
import com.android.pariwisata.aplikasiandroid.activity.DetailActivity;
import com.android.pariwisata.aplikasiandroid.adapter.info.BelanjaClickAdapter;
import com.android.pariwisata.aplikasiandroid.api.BaseURL;
import com.android.pariwisata.aplikasiandroid.api.RegisterAPI;
import com.android.pariwisata.aplikasiandroid.api.ResponJsonAlam;
import com.android.pariwisata.aplikasiandroid.api.ResponseJsonBelanjaHome;
import com.android.pariwisata.aplikasiandroid.api.ResponseJsonDeskripsi;
import com.android.pariwisata.aplikasiandroid.model.Belanja;
import com.android.pariwisata.aplikasiandroid.model.Wisata;
import com.android.pariwisata.aplikasiandroid.model.WisataDetail;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DeskripsiFragment extends Fragment {

    private List<WisataDetail> listwisata = new ArrayList<>();
    private Context mContext;
    FragmentManager manager;
    TextView textDeskripsi;
    TextView alamatDeskripsi;
    TextView websiteDeskripsi;
    TextView jamDeskripsi;
    TextView fasilitas;
    ImageView foto;

    public DeskripsiFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_deskripsi, container, false);

        textDeskripsi = view.findViewById(R.id.deskripsi_content);
        alamatDeskripsi = view.findViewById(R.id.alamat);
        websiteDeskripsi = view.findViewById(R.id.website);
        jamDeskripsi = view.findViewById(R.id.jam);
        fasilitas = view.findViewById(R.id.fasilitas);
        foto = view.findViewById(R.id.image);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BaseURL.URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RegisterAPI api = retrofit.create(RegisterAPI.class);
        Call<ResponseJsonDeskripsi> call = api.view_alam();

        call.enqueue(new Callback<ResponseJsonDeskripsi>() {
            @Override
            public void onResponse(Call<ResponseJsonDeskripsi> call, Response<ResponseJsonDeskripsi> response) {
                listwisata = response.body().getWisata();
//                WisataDetail detail = listwisata;
//                textDeskripsi.setText(detail.getDeskripsiAlam());
//                alamatDeskripsi.setText(detail.getAlamatAlam());
//                websiteDeskripsi.setText(detail.getWebsiteAlam());
//                jamDeskripsi.setText(detail.getJamAlam()+"-"+detail.getJamakhirAlam());
//                fasilitas.setText(detail.getFasilitasAlam());
//                Glide.with(mContext).load(BaseURL.URL+detail.getImg()).into(foto);

            }

            @Override
            public void onFailure(Call<ResponseJsonDeskripsi> call, Throwable t) {
                Log.e("data_error", t.getMessage().toString());
            }
        });

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState){
        super.onViewCreated(view,savedInstanceState);
    }
}

