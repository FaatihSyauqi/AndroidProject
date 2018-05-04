package tif16.sari.kartika.tutorial.Fragment.infoDetail;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import tif16.sari.kartika.tutorial.R;

public class DeskripsiFragment extends Fragment {
    TextView tvDetail,tvUlasan,tvDeskripsi;
    FragmentManager manager;

    public DeskripsiFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_deskripsi, container, false);
        tvDetail = (TextView) view.findViewById(R.id.detail);
        tvDeskripsi = (TextView) view.findViewById(R.id.deskripsi_content);
        tvUlasan = (TextView) view.findViewById(R.id.ulasan);

        tvDeskripsi.setVisibility(View.GONE);
        tvDetail.setVisibility(View.GONE);
        tvUlasan.setVisibility(View.GONE);

        return view;

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view,savedInstanceState);
        initView(view);
    }

    public void initView(View view){

        String text1 = "Detail Info";
        SpannableString ss1 = new SpannableString(text1);
        tvDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().add(R.id.deskripsi, new DetailFragment()).addToBackStack(tvDeskripsi.toString()).commit();
                tvDeskripsi.setVisibility(View.GONE);
                tvDetail.setVisibility(View.GONE);
                tvUlasan.setVisibility(View.GONE);
            }
        });

        tvDeskripsi.setVisibility(View.VISIBLE);
        tvDetail.setVisibility(View.VISIBLE);
        tvUlasan.setVisibility(View.VISIBLE);

        ss1.setSpan(tvDetail,0,11,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        tvDetail.setText(ss1);
        tvDetail.setMovementMethod(LinkMovementMethod.getInstance());

        String text2 = "Ulasan Tempat";
        SpannableString ss2 = new SpannableString(text2);
        ClickableSpan clickableSpan2 = new ClickableSpan() {
            @Override
            public void onClick(View view) {
                getFragmentManager().beginTransaction().replace(R.id.deskripsi, new UlasanFragment()).addToBackStack("").commit();
                tvDeskripsi.setVisibility(View.GONE);
                tvDetail.setVisibility(View.GONE);
                tvUlasan.setVisibility(View.GONE);
            }
        };
        ss2.setSpan(clickableSpan2,0,13, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        tvUlasan.setText(ss2);
        tvUlasan.setMovementMethod(LinkMovementMethod.getInstance());

    }
}
