package com.example.nikhil3000.gemselections.Rudraksha;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;

import com.example.nikhil3000.gemselections.R;

/**
 * Created by anonymous on 18/6/17.
 */

public class RudFAQ extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_rud_faq, container, false);
        ScrollView scrollView = (ScrollView)view.findViewById(R.id.scroll);
        scrollView.setBackground(getResources().getDrawable(R.drawable.back));
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("FAQs");
    }
}
