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

public class SilverBraceletsFragment extends Fragment {

    private ImageView go1, go2, go3, go4, go5, go6, go7, go8, go9, g10, g11, g12, g13;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(tech.iosd.gemselections.R.layout.frag_silver_bracelets, container, false);
        go1 = (ImageView) view.findViewById(tech.iosd.gemselections.R.id.g01);
        go2 = (ImageView) view.findViewById(tech.iosd.gemselections.R.id.g02);
        go3 = (ImageView) view.findViewById(tech.iosd.gemselections.R.id.g03);
        go4 = (ImageView) view.findViewById(tech.iosd.gemselections.R.id.g04);
        go5 = (ImageView) view.findViewById(tech.iosd.gemselections.R.id.g05);
        go6 = (ImageView) view.findViewById(tech.iosd.gemselections.R.id.g06);
        go7 = (ImageView) view.findViewById(tech.iosd.gemselections.R.id.g07);
        go8 = (ImageView) view.findViewById(tech.iosd.gemselections.R.id.g08);
        go9 = (ImageView) view.findViewById(tech.iosd.gemselections.R.id.g09);
        g10 = (ImageView) view.findViewById(tech.iosd.gemselections.R.id.g10);
        g11 = (ImageView) view.findViewById(tech.iosd.gemselections.R.id.g11);
        g12 = (ImageView) view.findViewById(tech.iosd.gemselections.R.id.g12);
        g13 = (ImageView) view.findViewById(tech.iosd.gemselections.R.id.g13);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Silver Bracelets");
        load_Images();
    }
    private void load_Images() {
        InputStream is;

        try {
            is = getActivity().getAssets().open("images/silver-braclet/SB01.jpg");
            go1.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/silver-braclet/SB02.jpg");
            go2.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/silver-braclet/SB03.jpg");
            go3.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/silver-braclet/SB04.jpg");
            go4.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/silver-braclet/SB05.jpg");
            go5.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/silver-braclet/SB06.jpg");
            go6.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/silver-braclet/SB07.jpg");
            go7.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/silver-braclet/SB08.jpg");
            go8.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/silver-braclet/SB09.jpg");
            go9.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/silver-braclet/SB10.jpg");
            g10.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/silver-braclet/SB11.jpg");
            g11.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/silver-braclet/SB12.jpg");
            g12.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/silver-braclet/SB13.jpg");
            g13.setImageBitmap(BitmapFactory.decodeStream(is));

                 } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
