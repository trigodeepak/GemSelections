package com.example.nikhil3000.gemselections.Ittar;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nikhil3000.gemselections.R;
import com.example.nikhil3000.gemselections.WebViewActivity;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by anonymous on 19/6/17.
 */

public class IttrTypesFragment extends Fragment implements View.OnClickListener{

    private ImageView chandan, motia, gulab, chameli, musk, kewara, khuskhus, rat, shama, banner;

    private Button price_list;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_ittr_types, container, false);

        chandan = (ImageView)view.findViewById(R.id.ittar_chandan);  chandan.setOnClickListener(this);
        motia = (ImageView)view.findViewById(R.id.ittr_motia);   motia.setOnClickListener(this);
        gulab = (ImageView)view.findViewById(R.id.ittr_gulab);   gulab.setOnClickListener(this);
        chameli = (ImageView)view.findViewById(R.id.ittr_chameli);   chameli.setOnClickListener(this);
        musk = (ImageView)view.findViewById(R.id.ittr_musk);   musk.setOnClickListener(this);
        kewara = (ImageView)view.findViewById(R.id.ittr_kewara);   kewara.setOnClickListener(this);
        khuskhus = (ImageView)view.findViewById(R.id.ittr_khuskhus);   khuskhus.setOnClickListener(this);
        rat = (ImageView)view.findViewById(R.id.ittr_rat_ke_rani);   rat.setOnClickListener(this);
        shama = (ImageView)view.findViewById(R.id.ittr_shama);   shama.setOnClickListener(this);
        banner = (ImageView)view.findViewById(R.id.ittar_banner);

        price_list = (Button)view.findViewById(R.id.ittar_price_list);
        price_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(
                        new Intent(getActivity(), WebViewActivity.class)
                                .putExtra("URL","https://drive.google.com/open?id=0B8j7YKWrs-f1OUE1UmVQNVlYcVU")
                );
            }
        });

        return view;
    }
    private void loadImage() {
        InputStream is;

        try{
            is = getActivity().getAssets().open("images/attar/small-images/chandan-attar.jpg");
            chandan.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/attar/small-images/motia-attar.jpg");
            motia.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/attar/small-images/gulab-attar.jpg");
            gulab.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/attar/small-images/chameli-attar.jpg");
            chameli.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/attar/small-images/musk-attar.jpg");
            musk.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/attar/small-images/Kewara-attar.jpg");
            kewara.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/attar/small-images/Khuskhus-attar.jpg");
            khuskhus.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/attar/small-images/Rat-ke-Rani-attar.jpg");
            rat.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/attar/small-images/Shama-attar.jpg");
            shama.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("logo/perf_logo.jpg");
            banner.setImageBitmap(BitmapFactory.decodeStream(is));

        }catch (IOException e){
            e.printStackTrace();
        }

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loadImage();
    }

    @Override
    public void onClick(View v) {
        if(v==chandan){
            show_dialog("CHANDAN ATTAR", R.string.ittr_1);
        }
        if(v==motia){
            show_dialog("MOTIA ATTAR", R.string.ittr_2);
        }
        if(v==gulab){
            show_dialog("GULAB ATTAR", R.string.ittr_3);
        }
        if(v==chameli){
            show_dialog("CHAMELI ATTAR", R.string.ittr_4);
        }
        if(v==musk){
            show_dialog("MUSK ATTAR", R.string.ittr_5);
        }
        if(v==kewara){
            show_dialog("KEWARA ATTAR", R.string.ittr_6);
        }
        if(v==khuskhus){
            show_dialog("KHUSKHUS ATTAR", R.string.ittr_7);
        }
        if(v==rat){
            show_dialog("RAT KE RANI ATTAR", R.string.ittr_8);
        }
        if(v==shama){
            show_dialog("SHAMA ATTAR", R.string.ittr_9);
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
