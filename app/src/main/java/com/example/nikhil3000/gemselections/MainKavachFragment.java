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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by anonymous on 22/6/17.
 */

public class MainKavachFragment extends android.support.v4.app.Fragment {

    private ImageView image;
    private Button shop;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_main_kavach, container, false);

        ScrollView scrollView = (ScrollView)view.findViewById(R.id.scroll);
        scrollView.setBackground(getResources().getDrawable(R.drawable.back));

        image = (ImageView)view.findViewById(R.id.kavach_image);
        shop = (Button)view.findViewById(R.id.shop);
        shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(
                        new Intent(getActivity(), WebViewActivity.class)
                        .putExtra("URL", "http://khannagems.com/index.php/yantra.html")
                        .putExtra("parent", "MainActivity")
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
