package com.example.nikhil3000.gemselections.Jewellery;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.nikhil3000.gemselections.R;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by anonymous on 19/6/17.
 */

public class SilverBroachesFragment extends Fragment {
    private ImageView go1, go2, go3, go4, go5, go6;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.frag_silver_broaches, container, false);
        go1 = (ImageView) view.findViewById(R.id.g01);
        go2 = (ImageView) view.findViewById(R.id.g02);
        go3 = (ImageView) view.findViewById(R.id.g03);
        go4 = (ImageView) view.findViewById(R.id.g04);
        go5 = (ImageView) view.findViewById(R.id.g05);
        go6 = (ImageView) view.findViewById(R.id.g06);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Silver Broaches");
        load_Images();
    }
    private void load_Images() {
        InputStream is;

        try {
            is = getActivity().getAssets().open("images/broachese/SBR01.jpg");
            go1.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/broachese/SBR02.jpg");
            go2.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/broachese/SBR03.jpg");
            go3.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/broachese/SBR04.jpg");
            go4.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/broachese/SBR05.jpg");
            go5.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/broachese/SBR06.jpg");
            go6.setImageBitmap(BitmapFactory.decodeStream(is));
            }catch (IOException e) {
            e.printStackTrace();
        }
    }}
