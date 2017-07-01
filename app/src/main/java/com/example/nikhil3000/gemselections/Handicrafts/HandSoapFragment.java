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

public class HandSoapFragment extends Fragment {

    private ImageView _1, _2, _3, _4, _5, _6;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_hand_soap, container, false);
        _1 = (ImageView)view.findViewById(R.id.handsoap1);
        _2 = (ImageView)view.findViewById(R.id.handsoap2);
        _3 = (ImageView)view.findViewById(R.id.handsoap3);
        _4 = (ImageView)view.findViewById(R.id.handsoap4);
        _5 = (ImageView)view.findViewById(R.id.handsoap5);
        _6 = (ImageView)view.findViewById(R.id.handsoap6);
        return view;
    }

    private void loadImage() {
        InputStream is;

        try {
            is = getActivity().getAssets().open("images/table-top-soap-stone/Pen-Stand-Inlay-TSS-01.jpg");
            _1.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/table-top-soap-stone/Coaster-Inlay-work-TSS-02.jpg");
            _2.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/table-top-soap-stone/Visiting-Card-Holder-TSS-03.jpg");
            _3.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/table-top-soap-stone/Pen-Stand-Visiting-Card-Holder-TSS-04.jpg");
            _4.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/table-top-soap-stone/Paper-Holder-TSS-05.jpg");
            _5.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/table-top-soap-stone/Paper-Weight0-TSS-06.jpg");
            _6.setImageBitmap(BitmapFactory.decodeStream(is));

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loadImage();
        getActivity().setTitle("Soap Stone Items");
    }
}
