package com.example.nikhil3000.gemselections;

import android.graphics.Bitmap;
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

public class BeadsSemiPreFragment extends Fragment {

    private ImageView go1, go2, go3, go4, go5, go6, go7, go8, go9, g10, g11, g12, g13, g14, g15, g16, g17, g18, g19, g20, g21, g22, g23, g24, g25, g26, g27, g28, g29, g30, g31, g32, g33, g34, g35, g36, g37, g38, g39, g40;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.frag_beads_semi, container, false);
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
        g12 = (ImageView) view.findViewById(R.id.g12);
        g13 = (ImageView) view.findViewById(R.id.g13);
        g14 = (ImageView) view.findViewById(R.id.g14);
        g15 = (ImageView) view.findViewById(R.id.g15);
        g16 = (ImageView) view.findViewById(R.id.g16);
        g17 = (ImageView) view.findViewById(R.id.g17);
        g18 = (ImageView) view.findViewById(R.id.g18);
        g19 = (ImageView) view.findViewById(R.id.g19);
        g20 = (ImageView) view.findViewById(R.id.g20);
        g21 = (ImageView) view.findViewById(R.id.g21);
        g22 = (ImageView) view.findViewById(R.id.g22);
        g23 = (ImageView) view.findViewById(R.id.g23);
        g24 = (ImageView) view.findViewById(R.id.g24);
        g25 = (ImageView) view.findViewById(R.id.g25);
        g26 = (ImageView) view.findViewById(R.id.g26);
        g27 = (ImageView) view.findViewById(R.id.g27);
        g28 = (ImageView) view.findViewById(R.id.g28);
        g29 = (ImageView) view.findViewById(R.id.g29);
        g30 = (ImageView) view.findViewById(R.id.g30);
        g31 = (ImageView) view.findViewById(R.id.g31);
        g32 = (ImageView) view.findViewById(R.id.g32);
        g33 = (ImageView) view.findViewById(R.id.g33);
        g34 = (ImageView) view.findViewById(R.id.g34);
        g35 = (ImageView) view.findViewById(R.id.g35);
        g36 = (ImageView) view.findViewById(R.id.g36);
        g37 = (ImageView) view.findViewById(R.id.g37);
        g38 = (ImageView) view.findViewById(R.id.g38);
        g39 = (ImageView) view.findViewById(R.id.g39);
        g40 = (ImageView) view.findViewById(R.id.g40);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        load_Images();
        getActivity().setTitle("Semi Precious Beads");

    }

    private void load_Images() {
        InputStream is = null;

        try {
            is = getActivity().getAssets().open("images/beads-images/amehtyst-round-shape.jpg");
            go1.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/beads-images/amethyst-beads.jpg");
            go2.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/beads-images/amethyst-drop-shape.jpg");
            go3.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/beads-images/amethyst-oval-shape.jpg");
            go4.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/beads-images/amethyst-ovel-shape.jpg");
            go5.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/beads-images/amethyst-round-shape.jpg");
            go6.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/beads-images/jade-beads.jpg");
            go7.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/beads-images/jade-coin-shape.jpg");
            go8.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/beads-images/jade-dholki-shape.jpg");
            go9.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/beads-images/jade-drop-shape.jpg");
            g10.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/beads-images/jade-heart-shape.jpg");
            g11.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/beads-images/jade-oval-shape.jpg");
            g12.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/beads-images/jade-rectangle-shape.jpg");
            g13.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/beads-images/jade-round-shape.jpg");
            g14.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/beads-images/jade-tube-shape.jpg");
            g15.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/beads-images/jade-wheel-shape.jpg");
            g16.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/beads-images/multi-moon-stone-drop-shape.jpg");
            g17.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/beads-images/pink-amethyst-drop-shape.jpg");
            g18.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/beads-images/pink-amethyst-ovel-shape.jpg");
            g19.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/beads-images/smoky-topaz-beads.jpg");
            g20.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/beads-images/smoky-topaz-coine-shape.jpg");
            g21.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/beads-images/Smoky-topaz-dark.jpg");
            g22.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/beads-images/smoky-topaz-drop-shape.jpg");
            g23.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/beads-images/smoky-topaz-heart-shape.jpg");
            g24.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/beads-images/smoky-topaz-kite-shape.jpg");
            g25.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/beads-images/smoky-topaz-oval-shape.jpg");
            g26.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/beads-images/smoky-topaz-rectangle-shape.jpg");
            g27.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/beads-images/smoky-topaz-strings.jpg");
            g28.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/beads-images/smoky-topaz-triangular-shape.jpg");
            g29.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/beads-images/smoky-topaz-twisted-shape.jpg");
            g30.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/beads-images/smoky-topaz-wheel-shape.jpg");
            g31.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/beads-images/sodalite-dholki-shape.jpg");
            g32.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/beads-images/sodalite-drop-shape.jpg");
            g33.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/beads-images/sodalite-oval-shape.jpg");
            g34.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/beads-images/sodalite-rectangle-shape.jpg");
            g35.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/beads-images/sodalite-round-shape.jpg");
            g36.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/beads-images/sodalite-strings.jpg");
            g37.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/beads-images/sodalite-tube-shape.jpg");
            g38.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/beads-images/sodalite-twisted-shape.jpg");
            g39.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/beads-images/sodalite-wheel-shape.jpg");
            g40.setImageBitmap((BitmapFactory.decodeStream(is)));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
