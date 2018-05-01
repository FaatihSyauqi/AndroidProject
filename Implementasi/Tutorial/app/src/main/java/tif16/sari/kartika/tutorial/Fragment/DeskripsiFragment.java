package tif16.sari.kartika.tutorial.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import tif16.sari.kartika.tutorial.R;

public class DeskripsiFragment extends Fragment {
    TextView mTextView;
    FragmentManager manager;

    public DeskripsiFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_deskripsi, container, false);
        return view;

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view,savedInstanceState);
        initView(view);
    }

    public void initView(View view){
        mTextView = (TextView) view.findViewById(R.id.detail);
        String text1 = "Detail Info";
        SpannableString ss1 = new SpannableString(text1);
        ClickableSpan clickableSpan1 = new ClickableSpan() {
            @Override
            public void onClick(View view) {
                getFragmentManager().beginTransaction().add(R.id.deskripsi, new DetailFragment()).addToBackStack("").commit();
            }
        };
        ss1.setSpan(clickableSpan1,0,11,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        mTextView.setText(ss1);
        mTextView.setMovementMethod(LinkMovementMethod.getInstance());

        mTextView = (TextView) view.findViewById(R.id.ulasan);
        String text2 = "Ulasan Tempat";
        SpannableString ss2 = new SpannableString(text2);
        ClickableSpan clickableSpan2 = new ClickableSpan() {
            @Override
            public void onClick(View view) {
                getFragmentManager().beginTransaction().replace(R.id.deskripsi, new UlasanFragment()).addToBackStack("").commit();
            }
        };
        ss2.setSpan(clickableSpan2,0,13, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        mTextView.setText(ss2);
        mTextView.setMovementMethod(LinkMovementMethod.getInstance());

    }
}
