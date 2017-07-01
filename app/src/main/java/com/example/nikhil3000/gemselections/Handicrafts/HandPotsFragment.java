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

public class HandPotsFragment extends Fragment {

    private ImageView _1, _2, _3, _4, _5, _6, _7, _8, _9, banner;
    
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_hand_pots, container, false);
        _1 = (ImageView)view.findViewById(R.id.handpot1);
        _2 = (ImageView)view.findViewById(R.id.handpot2);
        _3 = (ImageView)view.findViewById(R.id.handpot3);
        _4 = (ImageView)view.findViewById(R.id.handpot4);
        _5 = (ImageView)view.findViewById(R.id.handpot5);
        _6 = (ImageView)view.findViewById(R.id.handpot6);
        _7 = (ImageView)view.findViewById(R.id.handpot7);
        _8 = (ImageView)view.findViewById(R.id.handpot8);
        _9 = (ImageView)view.findViewById(R.id.handpot9);
        banner = (ImageView)view.findViewById(R.id.pot_banner);
        return view;
    }


    private void loadImage() {
        InputStream is;

        try {
            is = getActivity().getAssets().open("images/decorationitems/Candle-Holder-HGL01.jpg");
            _1.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/decorationitems/Flower-Pot-HGL02.jpg");
            _2.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/decorationitems/Flower-Pot-HGL03.jpg");
            _3.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/decorationitems/FlowerPot-HGL04.jpg");
            _4.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/decorationitems/Marble-Glass-HGL-05.jpg");
            _5.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/decorationitems/Flower-Pot-HGL06.jpg");
            _6.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/decorationitems/Flower-pot-HGL07.jpg");
            _7.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/decorationitems/Flower-Pot-HGL08.jpg");
            _8.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/decorationitems/Flower-Pot-HGL09.jpg");
            _9.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/handicrafts.jpg");
            banner.setImageBitmap(BitmapFactory.decodeStream(is));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loadImage();
        getActivity().setTitle("Pots");
    }
}
