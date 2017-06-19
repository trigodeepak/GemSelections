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
 * Created by anonymous on 17/6/17.
 */

public class HomeFragment extends Fragment {

    private ImageView baingani, panna, pukhraj, manik, neelam, gomed, gulabi, pitambari, lehsunia, moti, moonga, heera, safed, hara;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_main_home, container, false);

        baingani = (ImageView) view.findViewById(R.id.home_baingani);
        panna = (ImageView) view.findViewById(R.id.home_panna);
        pukhraj = (ImageView) view.findViewById(R.id.home_stonePukhraj);
        manik = (ImageView) view.findViewById(R.id.home_manik);
        neelam = (ImageView) view.findViewById(R.id.home_neelam);
        gomed = (ImageView) view.findViewById(R.id.home_gomed);
        gulabi = (ImageView) view.findViewById(R.id.home_gulabi);
        pitambari = (ImageView) view.findViewById(R.id.home_pitambari);
        lehsunia = (ImageView) view.findViewById(R.id.home_lehsunia);
        moti = (ImageView) view.findViewById(R.id.home_moti);
        moonga = (ImageView) view.findViewById(R.id.home_moonga);
        heera = (ImageView) view.findViewById(R.id.home_heera);
        safed = (ImageView) view.findViewById(R.id.home_safed);
        hara = (ImageView) view.findViewById(R.id.home_hara);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        load_Images();
        getActivity().setTitle("Gem Selections:Home");
    }

    private void load_Images() {
        InputStream is = null;

        try {
            is = getActivity().getAssets().open("images/precious-gems/Purple-sapphire.jpg");
            baingani.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/precious-gems/Emerald.jpg");
            panna.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/precious-gems/peela-pukhraj.jpg");
            pukhraj.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/precious-gems/Indian-Ruby.jpg");
            manik.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/precious-gems/Blue-Sapphire.jpg");
            neelam.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/precious-gems/Gomedh.jpg");
            gomed.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/precious-gems/pink-sapphire.jpg");
            gulabi.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/precious-gems/Pitambari-neelam.jpg");
            pitambari.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/precious-gems/Cats-Eye.jpg");
            lehsunia.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/precious-gems/Pearl.jpg");
            moti.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/precious-gems/Red-Coral.jpg");
            moonga.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/precious-gems/diamond.jpg");
            heera.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/precious-gems/White-Sapphire.jpg");
            safed.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/precious-gems/green-sapphire.jpg");
            hara.setImageBitmap(BitmapFactory.decodeStream(is));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void baingani_click(View view){

    }

    public void panna_click(View view){

    }

}