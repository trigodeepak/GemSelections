package tech.iosd.gemselections.MainContent;

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

public class MainStoneIdolFragment extends Fragment {

    private ImageView _1, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13, _14, _15;
    
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(tech.iosd.gemselections.R.layout.frag_stone_idol, container, false);
        _1 = (ImageView)view.findViewById(tech.iosd.gemselections.R.id.stoneidol1);
        _2 = (ImageView)view.findViewById(tech.iosd.gemselections.R.id.stoneidol2);
        _3 = (ImageView)view.findViewById(tech.iosd.gemselections.R.id.stoneidol3);
        _4 = (ImageView)view.findViewById(tech.iosd.gemselections.R.id.stoneidol4);
        _5 = (ImageView)view.findViewById(tech.iosd.gemselections.R.id.stoneidol5);
        _6 = (ImageView)view.findViewById(tech.iosd.gemselections.R.id.stoneidol6);
        _7 = (ImageView)view.findViewById(tech.iosd.gemselections.R.id.stoneidol7);
        _8 = (ImageView)view.findViewById(tech.iosd.gemselections.R.id.stoneidol8);
        _9 = (ImageView)view.findViewById(tech.iosd.gemselections.R.id.stoneidol9);
        _10 = (ImageView)view.findViewById(tech.iosd.gemselections.R.id.stoneidol10);
        _11 = (ImageView)view.findViewById(tech.iosd.gemselections.R.id.stoneidol11);
        _12 = (ImageView)view.findViewById(tech.iosd.gemselections.R.id.stoneidol12);
        _13 = (ImageView)view.findViewById(tech.iosd.gemselections.R.id.stoneidol13);
        _14 = (ImageView)view.findViewById(tech.iosd.gemselections.R.id.stoneidol14);
        _15 = (ImageView)view.findViewById(tech.iosd.gemselections.R.id.stoneidol15);
        return view;
    }

    private void loadImage() {
        InputStream is;

        try {
            is = getActivity().getAssets().open("images/stone-idol/small-image/SHIVA.jpg");
            _1.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/stone-idol/small-image/VANSI-DHARI-KRISHNA.jpg");
            _2.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/stone-idol/small-image/LAXMI-JI.jpg");
            _3.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/stone-idol/small-image/GANESHA.jpg");
            _4.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/stone-idol/small-image/HANUMA-JI.jpg");
            _5.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/stone-idol/small-image/GANESHA-JI.jpg");
            _6.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/stone-idol/small-image/KUBER.jpg");
            _7.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/stone-idol/small-image/bade-hanumanji.jpg");
            _8.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/stone-idol/small-image/Hanumanji.jpg");
            _9.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/stone-idol/small-image/Hanumanji-with-only-Gada.jpg");
            _10.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/stone-idol/small-image/Standing-Ganesha.jpg");
            _11.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/stone-idol/small-image/Gautam-Buddha.jpg");
            _12.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/stone-idol/small-image/Lord-Shiva.jpg");
            _13.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/stone-idol/small-image/Lord-Mahavira.jpg");
            _14.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/stone-idol/small-image/Buddha-Head.jpg");
            _15.setImageBitmap(BitmapFactory.decodeStream(is));

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loadImage();
        getActivity().setTitle("Stone Idols");
    }
}
