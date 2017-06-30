package com.example.nikhil3000.gemselections.Handicrafts;

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

public class HandPlatesFragment extends Fragment {

    private ImageView _1, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_hand_plates, container, false);
        _1 = (ImageView)view.findViewById(R.id.handplate1);
        _2 = (ImageView)view.findViewById(R.id.handplate2);
        _3 = (ImageView)view.findViewById(R.id.handplate3);
        _4 = (ImageView)view.findViewById(R.id.handplate4);
        _5 = (ImageView)view.findViewById(R.id.handplate5);
        _6 = (ImageView)view.findViewById(R.id.handplate6);
        _7 = (ImageView)view.findViewById(R.id.handplate7);
        _8 = (ImageView)view.findViewById(R.id.handplate8);
        _9 = (ImageView)view.findViewById(R.id.handplate9);
        _10 = (ImageView)view.findViewById(R.id.handplate10);
        _11 = (ImageView)view.findViewById(R.id.handplate11);
        _12 = (ImageView)view.findViewById(R.id.handplate12);
        return view;
    }

    private void loadImage() {
        InputStream is;

        try {
            is = getActivity().getAssets().open("images/Gold Painted - Marble Clocks/small-images/Marble-Tile-GPP01.jpg");
            _1.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/Gold Painted - Marble Clocks/small-images/Marble-Tile-GPP02.jpg");
            _2.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/Gold Painted - Marble Clocks/small-images/Marble-Tile-GPP03.jpg");
            _3.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/Gold Painted - Marble Clocks/small-images/MarbleTile-GPP-04.jpg");
            _4.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/Gold Painted - Marble Clocks/small-images/MarbleTile-GPP-05.jpg");
            _5.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/Gold Painted - Marble Clocks/small-images/Marble-Tile-GPP-06.jpg");
            _6.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/Gold Painted - Marble Clocks/small-images/Marble-Tile-GPP-07.jpg");
            _7.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/Gold Painted - Marble Clocks/small-images/Marble-Tile-GPP-08.jpg");
            _8.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/Gold Painted - Marble Clocks/small-images/Marble-Tile-GPP-09.jpg");
            _9.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/Gold Painted - Marble Clocks/small-images/Marble-Tile-GPP-10.jpg");
            _10.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/Gold Painted - Marble Clocks/small-images/Marble-Tile-GPP-11.jpg");
            _11.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/Gold Painted - Marble Clocks/small-images/Marble-Tile-GPP-12.jpg");
            _12.setImageBitmap(BitmapFactory.decodeStream(is));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loadImage();
        getActivity().setTitle("Plates And Tiles");
    }
}
