package com.example.nikhil3000.gemselections.Jewellery;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.nikhil3000.gemselections.R;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by anonymous on 19/6/17.
 */

public class SilverEarringFragment extends Fragment {
    private ImageView go1, go2, go3, go4, go5, go6, go7, go8, go9, g10, g11, g12, g13, g14, g15, g16, g17, g18, g19, g20;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.frag_silver_earring, container, false);

        go1 = (ImageView) view.findViewById(R.id.g01);
        go2 = (ImageView) view.findViewById(R.id.g02);
        go3 = (ImageView) view.findViewById(R.id.g03);
        go4 = (ImageView) view.findViewById(R.id.g04);
        go5 = (ImageView) view.findViewById(R.id.g05);
        go6 = (ImageView) view.findViewById(R.id.g06);
        go7 = (ImageView) view.findViewById(R.id.g07);
        go8 = (ImageView) view.findViewById(R.id.g08);
        go9 = (ImageView) view.findViewById(R.id.g09);
        g10 = (ImageView) view.findViewById(R.id.g10);
        g11 = (ImageView) view.findViewById(R.id.g11);
        g12 = (ImageView) view.findViewById(R.id.g12);
        g13 = (ImageView) view.findViewById(R.id.g13);
        g14 = (ImageView) view.findViewById(R.id.g14);
        g15 = (ImageView) view.findViewById(R.id.g15);
        g16 = (ImageView) view.findViewById(R.id.g16);
        g17 = (ImageView) view.findViewById(R.id.g17);
        g18 = (ImageView) view.findViewById(R.id.g18);
        g19 = (ImageView) view.findViewById(R.id.g19);
        g20 = (ImageView) view.findViewById(R.id.g20);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Silver Earring");
        load_Images();
    }
    private void load_Images() {
        InputStream is;

        try {
            is = getActivity().getAssets().open("images/silver-tops/GS_ST01.jpg");
            go1.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/silver-tops/GS_ST02.jpg");
            go2.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/silver-tops/GS_ST03.jpg");
            go3.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/silver-tops/GS_ST04.jpg");
            go4.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/silver-tops/GS_ST05.jpg");
            go5.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/silver-tops/GS_ST06.jpg");
            go6.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/silver-tops/GS_ST07.jpg");
            go7.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/silver-tops/GS_ST08.jpg");
            go8.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/silver-tops/GS_ST09.jpg");
            go9.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/silver-tops/GS_ST10.jpg");
            g10.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/silver-tops/GS_ST11.jpg");
            g11.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/silver-tops/GS_ST12.jpg");
            g12.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/silver-tops/GS_ST13.jpg");
            g13.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/silver-tops/GS_ST14.jpg");
            g14.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/silver-tops/GS_ST15.jpg");
            g15.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/silver-tops/GS_ST16.jpg");
            g16.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/silver-tops/GS_ST17.jpg");
            g17.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/silver-tops/GS_ST18.jpg");
            g18.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/silver-tops/GS_ST19.jpg");
            g19.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/silver-tops/GS_ST29.jpg");
            g20.setImageBitmap(BitmapFactory.decodeStream(is));
        } catch (IOException e) {
            e.printStackTrace();
        }catch (OutOfMemoryError error){
            Toast.makeText(getActivity(), error.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }


}
