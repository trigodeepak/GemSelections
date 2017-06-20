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
 * Created by anonymous on 20/6/17.
 */

public class MainSphatikFragment extends Fragment {

    private ImageView _1, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_sphatik, container, false);
        _1 = (ImageView)view.findViewById(R.id.sphtik1);
        _2 = (ImageView)view.findViewById(R.id.sphtik2);
        _3 = (ImageView)view.findViewById(R.id.sphtik3);
        _4 = (ImageView)view.findViewById(R.id.sphtik4);
        _5 = (ImageView)view.findViewById(R.id.sphtik5);
        _6 = (ImageView)view.findViewById(R.id.sphtik6);
        _7 = (ImageView)view.findViewById(R.id.sphtik7);
        _8 = (ImageView)view.findViewById(R.id.sphtik8);
        _9 = (ImageView)view.findViewById(R.id.sphtik9);
        _10 = (ImageView)view.findViewById(R.id.sphtik10);
        _11 = (ImageView)view.findViewById(R.id.sphtik11);
        _12 = (ImageView)view.findViewById(R.id.sphtik12);
        _13 = (ImageView)view.findViewById(R.id.sphtik13);
        return view;
    }

    private void loadImage() {
        InputStream is;

        try {
            is = getActivity().getAssets().open("images/saphatic-items/Saphatic-Items/Sphatic-Shivling.jpg");
            _1.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/saphatic-items/Saphatic-Items/Sphatic-Ganesha.jpg");
            _2.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/saphatic-items/Saphatic-Items/Sphatic-BuddhaHead.jpg");
            _3.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/saphatic-items/Saphatic-Items/Sphatic-Laxm-Paduka.jpg");
            _4.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/saphatic-items/Saphatic-Items/sphatic-Little-shivlinga.jpg");
            _5.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/saphatic-items/Saphatic-Items/Sphatic-Tortoise.jpg");
            _6.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/saphatic-items/Saphatic-Items/tortoise-with-shri-yantra.jpg");
            _7.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/saphatic-items/Saphatic-Items/Sphatic-shri-shri-yantra.jpg");
            _8.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/saphatic-items/Saphatic-Items/Sphatic-Lakshmi.jpg");
            _9.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/saphatic-items/Saphatic-Items/Sphatic-Saraswati.jpg");
            _10.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/saphatic-items/Saphatic-Items/sphatic-pendant.jpg");
            _11.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/saphatic-items/Saphatic-Items/sphatic-shank.jpg");
            _12.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/saphatic-items/Saphatic-Items/sphatic-pyramid.jpg");
            _13.setImageBitmap(BitmapFactory.decodeStream(is));

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loadImage();
        getActivity().setTitle("Saphatic Items");
    }
}
