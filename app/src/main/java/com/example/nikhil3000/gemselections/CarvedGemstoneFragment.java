package com.example.nikhil3000.gemselections;

import android.app.ProgressDialog;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by anonymous on 19/6/17.
 */

public class CarvedGemstoneFragment extends Fragment {

    private ImageView go1, go2, go3, go4, go5, go6, go7, go8, go9, g10, g11, g12, g13, g14, g15, g16, g17, g18, g19, g20;

    //Do not use. Memory to be saved. Not enough memory to allocate all
    /* g21, g22, g23, g24, g25, g26, g27, g28, g29, g30, g31, g32, g33, g34, g35, g36, g37, g38, g39, g40, g41, g42, g43, g44, g45, g46, g47, g48, g49, g50, g51, g52;*/


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_carved_gemstone, container, false);

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

        //DO NOT USE
        /*g21 = (ImageView) view.findViewById(R.id.g21);
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
        g41 = (ImageView) view.findViewById(R.id.g41);
        g42 = (ImageView) view.findViewById(R.id.g42);
        g43 = (ImageView) view.findViewById(R.id.g43);
        g44 = (ImageView) view.findViewById(R.id.g44);
        g45 = (ImageView) view.findViewById(R.id.g45);
        g46 = (ImageView) view.findViewById(R.id.g46);
        g47 = (ImageView) view.findViewById(R.id.g47);
        g48 = (ImageView) view.findViewById(R.id.g48);
        g49 = (ImageView) view.findViewById(R.id.g49);
        g50 = (ImageView) view.findViewById(R.id.g50);
        g51 = (ImageView) view.findViewById(R.id.g51);
        g52 = (ImageView) view.findViewById(R.id.g52);
        */
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Carved Gemstones");
        load_Images();
    }
    private void load_Images() {
        InputStream is;

        try {
            is = getActivity().getAssets().open("images/carving-gems/carved-amethyst.jpg");
            go1.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/carving-gems/carved-amethyst-2.jpg");
            go2.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/carving-gems/carved-blue-topaz.jpg");
            go3.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/carving-gems/carved-blue-topaz-2.jpg");
            go4.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/carving-gems/carved-citrine.jpg");
            go5.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/carving-gems/carved-fish.jpg");
            go6.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/carving-gems/carved-flower.jpg");
            go7.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/carving-gems/carved-gemstone-flowers.jpg");
            go8.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/carving-gems/carved-gemstone-jewelry.jpg");
            go9.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/carving-gems/carved-gemstone-rings.jpg");
            g10.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/carving-gems/carved-golden-topaz.jpg");
            g11.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/carving-gems/carved-image.jpg");
            g12.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/carving-gems/carved-image1.jpg");
            g13.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/carving-gems/carved-image-2.jpg");
            g14.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/carving-gems/carved-image-3.jpg");
            g15.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/carving-gems/carved-image-4.jpg");
            g16.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/carving-gems/carved-image-5.jpg");
            g17.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/carving-gems/carved-image-6.jpg");
            g18.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/carving-gems/carved-image-10.jpg");
            g19.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/carving-gems/carved-image-12.jpg");
            g20.setImageBitmap(BitmapFactory.decodeStream(is));
            /*is = getActivity().getAssets().open("images/carving-gems/carved-images-13.jpg");
            g21.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/carving-gems/carved-lepiz-lazuli.jpg");
            g22.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/carving-gems/carved-stone.jpg");
            g23.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/carving-gems/carved-stone-animals.jpg");
            g24.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/carving-gems/carved-stone-creations.jpg");
            g25.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/carving-gems/carving.jpg");
            g26.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/carving-gems/carving-butterfly.jpg");
            g27.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/carving-gems/carving-fish.jpg");
            g28.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/carving-gems/carving-gem.jpg");
            g29.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/carving-gems/carving-gem-12.jpg");
            g30.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/carving-gems/Carving-gems-1.jpg");
            g31.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/carving-gems/Carving-gems-2.jpg");
            g32.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/carving-gems/Carving-gems-3.jpg");
            g33.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/carving-gems/Carving-gems-4.jpg");
            g34.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/carving-gems/Carving-gems-5.jpg");
            g35.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/carving-gems/Carving-gems-6.jpg");
            g36.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/carving-gems/Carving-gems-7.jpg");
            g37.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/carving-gems/Carving-gems-8.jpg");
            g38.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/carving-gems/Carving-gems-11.jpg");
            g39.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/carving-gems/Carving-gems-12.jpg");
            g40.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/carving-gems/Carving-gems-13.jpg");
            g41.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/carving-gems/Carving-gems-14.jpg");
            g42.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/carving-gems/Carving-gems-15.jpg");
            g43.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/carving-gems/carving-image.jpg");
            g44.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/carving-gems/carving-image-14.jpg");
            g45.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/carving-gems/carving-lemin-topaz.jpg");
            g46.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/carving-gems/carving-on-amethyst.jpg");
            g47.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/carving-gems/carving-on-fish.jpg");
            g48.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/carving-gems/carving-small-fish.jpg");
            g49.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/carving-gems/Gem-carving.jpg");
            g50.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/carving-gems/Gems-carving-history.jpg");
            g51.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/carving-gems/gemstone-carving.jpg");
            g52.setImageBitmap(BitmapFactory.decodeStream(is));*/

        } catch (IOException e) {
            e.printStackTrace();
        }catch (OutOfMemoryError error){
            Toast.makeText(getActivity(), error.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

}