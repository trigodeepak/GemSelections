package com.example.nikhil3000.gemselections;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by anonymous on 22/6/17.
 */

public class MainKavachFragment extends android.support.v4.app.Fragment {

    private ImageView image;
    private FloatingActionButton shop;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_main_kavach, container, false);
        image = (ImageView)view.findViewById(R.id.kavach_image);
        shop = (FloatingActionButton)view.findViewById(R.id.fab_shop);
        shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(
                        Intent.createChooser(
                                new Intent(Intent.ACTION_VIEW)
                                .setData(Uri.parse("http://khannagems.com/index.php/yantra.html"))
                        ,"Open Shopping page via...")
                );
            }
        });
        InputStream is;
        try{
            is = getActivity().getAssets().open("images/Nazar-rurksha-kavach.jpg");
            image.setImageBitmap(BitmapFactory.decodeStream(is));
        }catch (IOException e){
            e.printStackTrace();
        }
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Kavach");
    }
}
