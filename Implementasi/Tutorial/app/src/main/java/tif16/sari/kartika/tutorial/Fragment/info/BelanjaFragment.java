package tif16.sari.kartika.tutorial.Fragment.info;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import tif16.sari.kartika.tutorial.Adapter.GridAdapter;
import tif16.sari.kartika.tutorial.Fragment.infoDetail.DetailFragment;
import tif16.sari.kartika.tutorial.Fragment.infoDetail.UlasanFragment;
import tif16.sari.kartika.tutorial.InfoActivity;
import tif16.sari.kartika.tutorial.MainActivity;
import tif16.sari.kartika.tutorial.R;

public class BelanjaFragment extends Fragment {

    RecyclerView mRecycleView;
    RecyclerView.LayoutManager mLayoutManager;
    RecyclerView.Adapter mAdapter;
    CardView cardView;

    public BelanjaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_belanja, container, false);

        mRecycleView = (RecyclerView) view.findViewById(R.id.recyclerView);
        mRecycleView.setHasFixedSize(true);

        mLayoutManager = new GridLayoutManager(getActivity(),2);
        mRecycleView.setLayoutManager(mLayoutManager);

        mAdapter = new GridAdapter();
        mRecycleView.setAdapter(mAdapter);

        return view;
    }
}

