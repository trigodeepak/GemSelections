package com.example.nikhil3000.gemselections.SemiPreciousGems;

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
 * Created by anonymous on 25/6/17.
 */

public class Opal extends Fragment {

    private ImageView img1,img2,img3;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.opal, container, false);
        img1 = (ImageView)view.findViewById(R.id.opal1);
        img2 = (ImageView)view.findViewById(R.id.opal2);
        img3 = (ImageView)view.findViewById(R.id.opal3);
        InputStream is;
        try {
            is = getActivity().getAssets().open("images/semi-precious-gems/whiteopal.img.jpg");
            img1.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/semi-precious-gems/Opal.jpg");
            img2.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/semi-precious-gems/Blackfireopal.img.jpg");
            img3.setImageBitmap(BitmapFactory.decodeStream(is));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
