package com.example.nikhil3000.gemselections;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by anonymous on 19/6/17.
 */

public class SilverSetFragment extends Fragment {
    private ImageView go1, go2, go3, go4, go5;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.frag_silver_set, container, false);
        go1 = (ImageView) view.findViewById(R.id.g01);
        go2 = (ImageView) view.findViewById(R.id.g02);
        go3 = (ImageView) view.findViewById(R.id.g03);
        go4 = (ImageView) view.findViewById(R.id.g04);
        go5 = (ImageView) view.findViewById(R.id.g05);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Silver Sets");
        load_Images();
    }
    private void load_Images() {
        InputStream is;

        try {
            is = getActivity().getAssets().open("images/silver-sets/STANS01.jpg");
            go1.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/silver-sets/STANS02.jpg");
            go2.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/silver-sets/STANS03.jpg");
            go3.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/silver-sets/STANS04.jpg");
            go4.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/silver-sets/STANS05.jpg");
            go5.setImageBitmap(BitmapFactory.decodeStream(is));

        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
