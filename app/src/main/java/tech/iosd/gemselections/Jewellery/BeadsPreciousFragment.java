package tech.iosd.gemselections.Jewellery;

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
 * Created by anonymous on 19/6/17.
 */

public class BeadsPreciousFragment extends Fragment {

    private ImageView sapphire, ruby, iolite, panna, multi, green_garnet, green , tanzanite, red, peridot,multi_color,moti;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(tech.iosd.gemselections.R.layout.frag_beads_precious, container, false);

        sapphire = (ImageView) view.findViewById(tech.iosd.gemselections.R.id.beads_neelam);
        panna = (ImageView) view.findViewById(tech.iosd.gemselections.R.id.beads_panna);
        ruby = (ImageView) view.findViewById(tech.iosd.gemselections.R.id.beads_ruby);
        iolite = (ImageView) view.findViewById(tech.iosd.gemselections.R.id.beads_iolite);
        multi = (ImageView) view.findViewById(tech.iosd.gemselections.R.id.beads_multi_tourmaline);
        multi_color = (ImageView) view.findViewById(tech.iosd.gemselections.R.id.beads_multi);
        peridot = (ImageView) view.findViewById(tech.iosd.gemselections.R.id.beads_peridot);
        green = (ImageView) view.findViewById(tech.iosd.gemselections.R.id.beads_green_tourmaline);
        green_garnet = (ImageView) view.findViewById(tech.iosd.gemselections.R.id.beads_green_garnet);
        moti = (ImageView) view.findViewById(tech.iosd.gemselections.R.id.beads_pearl);
        tanzanite = (ImageView) view.findViewById(tech.iosd.gemselections.R.id.beads_tanzanite);
        red = (ImageView) view.findViewById(tech.iosd.gemselections.R.id.beads_red_tourmaline);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        load_Images();
        getActivity().setTitle("Precious Beads");

    }
    private void load_Images() {
        InputStream is = null;

        try {
            is = getActivity().getAssets().open("images/precious_beads/panna-beads.jpg");
            panna.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/precious_beads/ruby.jpg");
            ruby.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/precious_beads/sapphire.jpg");
            sapphire.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/precious_beads/multi-colour-beads.JPG");
            multi_color.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/precious_beads/moti-beads.jpg");
            moti.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/precious_beads/red-tourmaline-beads.jpg");
            red.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/precious_beads/iolite-beads.jpg");
            iolite.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/precious_beads/green-garnet-beads.jpg");
            green_garnet.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/precious_beads/multi-tourmaline-beads.jpg");
            multi.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/precious_beads/peridot-beads.JPG");
            peridot.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/precious_beads/green-tourmaline-beads.jpg");
            green.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/precious_beads/tanzanite-beads.jpg");
            tanzanite.setImageBitmap(BitmapFactory.decodeStream(is));



        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void baingani_click(View view){

    }

    public void panna_click(View view){

    }

}

