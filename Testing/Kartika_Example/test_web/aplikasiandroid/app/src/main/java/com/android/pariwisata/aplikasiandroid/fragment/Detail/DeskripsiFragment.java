package com.android.pariwisata.aplikasiandroid.fragment.Detail;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.pariwisata.aplikasiandroid.R;
import com.android.pariwisata.aplikasiandroid.adapter.info.BelanjaClickAdapter;
import com.android.pariwisata.aplikasiandroid.api.RegisterAPI;
import com.android.pariwisata.aplikasiandroid.api.ResponJsonAlam;
import com.android.pariwisata.aplikasiandroid.api.ResponseJsonBelanjaHome;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DeskripsiFragment extends Fragment {
//    public String BASE_URL = "http://192.168.1.10/pariwisata/";
//
//    TextView tvDeskripsi;
//    FragmentManager manager;
//
//    public DeskripsiFragment() {
//        // Required empty public constructor
//    }
//
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        View view = inflater.inflate(R.layout.fragment_deskripsi, container, false);
//        String textDeskripsi = view.findViewById(R.id.deskripsi_content);
//        String alamatDeskripsi = view.findViewById(R.id.alamat);
//        String websiteDeskripsi = view.findViewById(R.id.website);
//        String jamDeskripsi = view.findViewById(R.id.jam);
//        String fasilitas = view.findViewById(R.id.fasilitas);
//
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(BASE_URL)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//
//        RegisterAPI api = retrofit.create(RegisterAPI.class);
//        Call<ResponJsonAlam> call = api.view_alam();
//
//        call.enqueue(new Callback<ResponJsonAlam>() {
//            @Override
//            public void onResponse(Call<ResponJsonAlam> call, Response<ResponJsonAlam> response) {
//                wisata = response.body().getDeskripsiAlam();
//                mAdapter = new BelanjaClickAdapter(getContext(),wisata);
//                mRecycleView.setAdapter(mAdapter);
//            }
//
//            @Override
//            public void onFailure(Call<ResponseJsonBelanjaHome> call, Throwable t) {
//                Log.e("data_error", t.getMessage().toString());
//            }
//        });
//        return view;
//    }
//
//    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState){
        super.onViewCreated(view,savedInstanceState);
//        initView(view);
    }

//    public void initView(View view){
////        tvDeskripsi.setVisibility(View.VISIBLE);
////        tvDetail.setVisibility(View.VISIBLE);
////        tvUlasan.setVisibility(View.VISIBLE);
//        String text1 = "Detail Info";
//        SpannableString ss1 = new SpannableString(text1);
//        ClickableSpan clickableSpan1 = new ClickableSpan() {
//            @Override
//            public void onClick(View v) {
//                 getFragmentManager().beginTransaction().add(R.id.deskripsi, new DetailFragment()).addToBackStack("").commit();
////                Intent intent = new Intent(getContext(),DetailInfo.class);
////                startActivity(intent);
////                tvDeskripsi.setVisibility(View.GONE);
////                tvDetail.setVisibility(View.GONE);
////                tvUlasan.setVisibility(View.GONE);
//            }
//        };
//        ss1.setSpan(clickableSpan1,0,11,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//        tvDetail.setText(ss1);
//        tvDetail.setMovementMethod(LinkMovementMethod.getInstance());
//
//        String text2 = "Ulasan Tempat";
//        SpannableString ss2 = new SpannableString(text2);
//        ClickableSpan clickableSpan2 = new ClickableSpan() {
//            @Override
//            public void onClick(View view) {
//                getFragmentManager().beginTransaction().replace(R.id.deskripsi, new UlasanFragment()).addToBackStack("").commit();
////                Intent intent1 = new Intent(getContext(),Ulasan.class);
////                startActivity(intent1);
////                tvDeskripsi.setVisibility(View.GONE);
////                tvDetail.setVisibility(View.GONE);
////                tvUlasan.setVisibility(View.GONE);
//            }
//        };
//        ss2.setSpan(clickableSpan2,0,13, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//        tvUlasan.setText(ss2);
//        tvUlasan.setMovementMethod(LinkMovementMethod.getInstance());
//    }
}
