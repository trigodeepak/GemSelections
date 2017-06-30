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

public class HandBlackFragment extends Fragment {

    private ImageView _1, _2, _3, _4, _5;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_hand_black, container, false);
        _1 = (ImageView)view.findViewById(R.id.handblack1);
        _2 = (ImageView)view.findViewById(R.id.handblack2);
        _3 = (ImageView)view.findViewById(R.id.handblack3);
        _4 = (ImageView)view.findViewById(R.id.handblack4);
        _5 = (ImageView)view.findViewById(R.id.handblack5);
        return view;
    }

    private void loadImage() {
        InputStream is;

        try {
            is = getActivity().getAssets().open("images/Table%20Top%20Items%20-%20Black%20Stone/small-images/Paper-Weight-ASG-01.jpg");
            _1.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/Table%20Top%20Items%20-%20Black%20Stone/small-images/Paper-Holder-ASG-02.jpg");
            _2.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/Gold%20Painted%20-%20Marble%20Clocks/small-image/Marble-Decoration-MMW-03.jpg");
            _3.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/Gold%20Painted%20-%20Marble%20Clocks/small-image/Marble-Decoration-MMW-04.jpg");
            _4.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/Gold%20Painted%20-%20Marble%20Clocks/small-image/Marble-Decoration-MMW-05.jpg");
            _5.setImageBitmap(BitmapFactory.decodeStream(is));

        }catch (IOException e){
            e.printStackTrace();
        }
    }
    
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loadImage();
        getActivity().setTitle("Black Stone Items");
    }
}
