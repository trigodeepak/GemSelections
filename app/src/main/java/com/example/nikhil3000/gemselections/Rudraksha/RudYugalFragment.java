package com.example.nikhil3000.gemselections.Rudraksha;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;

import java.io.IOException;
import java.io.InputStream;

import com.example.nikhil3000.gemselections.R;
/**
 * Created by anonymous on 18/6/17.
 */

public class RudYugalFragment extends Fragment {

    private ImageView banner, akarshan;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_rud_yugal, container, false);

        ScrollView scrollView = (ScrollView)view.findViewById(R.id.scroll);
        scrollView.setBackground(getResources().getDrawable(R.drawable.back));

        akarshan = (ImageView)view.findViewById(R.id.akarshan_vridhi);
        banner = (ImageView)view.findViewById(R.id._rud_banner3);
        InputStream is;
        try{
            is = getActivity().getAssets().open("images/rudraksha-banner.jpg");
            banner.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/rudrakshayugal/BIG-IMAGE/aakarshanvriddhiyantra.jpg");
            akarshan.setImageBitmap(BitmapFactory.decodeStream(is));
        }catch (IOException e){
            e.printStackTrace();
        }
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getActivity().setTitle("Yugal");
    }
}
