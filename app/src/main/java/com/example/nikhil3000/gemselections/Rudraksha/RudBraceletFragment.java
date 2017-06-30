package com.example.nikhil3000.gemselections.Rudraksha;

import android.app.Dialog;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nikhil3000.gemselections.R;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by anonymous on 18/6/17.
 */

public class RudBraceletFragment extends Fragment implements View.OnClickListener {

    private ImageView banner, img1, img2, img3, img4;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_rud_bracelet, container, false);

        banner = (ImageView)view.findViewById(R.id._rud_banner);
        img1 = (ImageView)view.findViewById(R.id.bracelet_img1);
        img2 = (ImageView)view.findViewById(R.id.bracelet_img2);
        img3 = (ImageView)view.findViewById(R.id.bracelet_img3);
        img4 = (ImageView)view.findViewById(R.id.bracelet_img4);
        InputStream is = null;

        try{
            is = getActivity().getAssets().open("images/rudraksha-banner.jpg");
            banner.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/rudrakshabracelect/rudrakshabracelet.jpg");
            img1.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/rudrakshabracelect/rudraksha-bracelet1.jpg");
            img2.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/rudrakshabracelect/seven-mukhi-rudraksha-bracelet.jpg");
            img3.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/rudrakshabracelect/rudraksha-pearl-bracelet.jpg");
            img4.setImageBitmap(BitmapFactory.decodeStream(is));
        }catch (IOException e){
            e.printStackTrace();
        }

        img1.setOnClickListener(this);
        img2.setOnClickListener(this);
        img3.setOnClickListener(this);
        img4.setOnClickListener(this);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getActivity().setTitle("Bracelets");
    }

    @Override
    public void onClick(View v) {
        if(v == img1){
            show_dialog("RUDRAKSHA BRACELET", R.string._bracelet);
        }
        if(v == img2){
            show_dialog("TWO MUKHI", R.string._bracelet_two);
        }
        if(v == img3){
            show_dialog("THREE MUKHI", R.string._bracelet_three);
        }
        if(v == img4){
            show_dialog("PEARL COMBINATION", R.string._bracelet_four);
        }
    }

    private void show_dialog(String title, int content) {
        Dialog dialog = new Dialog(getActivity());
        dialog.setTitle(title);
        dialog.setContentView(R.layout.dialog_bracelet);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(dialog.getWindow().getAttributes());

        layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
        layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT;

        dialog.show();
        dialog.getWindow().setAttributes(layoutParams);

        TextView textView  = (TextView)dialog.findViewById(R.id.content);
        textView.setText(getString(content));
    }
}
