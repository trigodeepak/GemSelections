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

public class HandSpiritualFragment extends Fragment {

    private ImageView _1, _2, _3, _4, _5;
    
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_hand_spi_gifts, container, false);
        _1 = (ImageView)view.findViewById(R.id.handspi1);
        _2 = (ImageView)view.findViewById(R.id.handspi2);
        _3 = (ImageView)view.findViewById(R.id.handspi3);
        _4 = (ImageView)view.findViewById(R.id.handspi4);
        _5 = (ImageView)view.findViewById(R.id.handspi5);
        return view;
    }

    private void loadImage() {
        InputStream is;

        try {
            is = getActivity().getAssets().open("images/Other%20Spiritual%20Itmes/small-images/Undercut-Elephant-Pair-OSI-01.jpg");
            _1.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/Other%20Spiritual%20Itmes/small-images/Elephant-Pair-OSI-02.jpg");
            _2.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/Other%20Spiritual%20Itmes/small-images/Elephant-Pair-OSI-03.jpg");
            _3.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/Other%20Spiritual%20Itmes/small-images/Undercut-Owl-OSI04.jpg");
            _4.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/Other%20Spiritual%20Itmes/small-images/Undercut-Frog%20-OSI05.jpg");
            _5.setImageBitmap(BitmapFactory.decodeStream(is));

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loadImage();
        getActivity().setTitle("Spiritual Items");
    }
}
