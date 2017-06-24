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
            is = getActivity().getAssets().open("images/beads-images/carved-amethyst.jpg");
            go1.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/beads-images/carved-amethyst-2.jpg");
            go2.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/beads-images/carved-blue-topaz.jpg");
            go3.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/beads-images/carved-blue-topaz-2.jpg");
            go4.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/beads-images/carved-citrine.jpg");
            go5.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/beads-images/carved-fish.jpg");
            go6.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/beads-images/carved-flower.jpg");
            go7.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/beads-images/carved-gemstone-flowers.jpg");
            go8.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/beads-images/carved-gemstone-jewelry.jpg");
            go9.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/beads-images/carved-gemstone-rings.jpg");
            g10.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/beads-images/carved-golden-topaz.jpg");
            g11.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/beads-images/carved-image.jpg");
            g12.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/beads-images/carved-image1.jpg");
            g13.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/beads-images/carved-image-2.jpg");
            g14.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/beads-images/carved-image-3.jpg");
            g15.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/beads-images/carved-image-4.jpg");
            g16.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/beads-images/carved-image-5.jpg");
            g17.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/beads-images/carved-image-6.jpg");
            g18.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/beads-images/carved-image-10.jpg");
            g19.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/beads-images/carved-image-12.jpg");
            g20.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/beads-images/carved-images-13.jpg");
            g21.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/beads-images/carved-lepiz-lazuli.jpg");
            g22.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/beads-images/carved-stone.jpg");
            g23.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/beads-images/carved-stone-animals.jpg");
            g24.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/beads-images/carved-stone-creations.jpg");
            g25.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/beads-images/carving.jpg");
            g26.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/beads-images/carving-butterfly.jpg");
            g27.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/beads-images/carving-fish.jpg");
            g28.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/beads-images/carving-gem.jpg");
            g29.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/beads-images/carving-gem-12.jpg");
            g30.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/beads-images/beads-images-1.jpg");
            g31.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/beads-images/beads-images-2.jpg");
            g32.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/beads-images/beads-images-3.jpg");
            g33.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/beads-images/beads-images-4.jpg");
            g34.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/beads-images/beads-images-5.jpg");
            g35.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/beads-images/beads-images-6.jpg");
            g36.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/beads-images/beads-images-7.jpg");
            g37.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/beads-images/beads-images-8.jpg");
            g38.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/beads-images/beads-images-11.jpg");
            g39.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/beads-images/beads-images-12.jpg");
            g40.setImageBitmap((BitmapFactory.decodeStream(is)));


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
