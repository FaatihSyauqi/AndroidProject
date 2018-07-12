package com.android.pariwisata.aplikasiandroid.fragment.Detail;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import com.android.pariwisata.aplikasiandroid.R;

public class MapsFragment extends Fragment implements OnMapReadyCallback{
    GoogleMap googleMap;
    MapView mMapView;
    View view;
    public MapsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {super.onCreate(savedInstanceState);}

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_maps, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        mMapView = view.findViewById(R.id.map);
        if(mMapView != null){
            mMapView.onCreate(null);
            mMapView.onResume();
            mMapView.getMapAsync(this);
        }
    }

    @Override
    public void onMapReady (GoogleMap googleMap){
        MapsInitializer.initialize(getContext());

        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        googleMap.addMarker(new MarkerOptions().position(new LatLng(-6.87155669, 107.57301419)).title("Marker in POLBAN"));

        CameraPosition POLBAN = CameraPosition.builder().target(new LatLng(-6.87155669, 107.57301419)).zoom(16).bearing(8).tilt(45).build();
        googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(POLBAN));
    }
}
