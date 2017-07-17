package tech.iosd.gemselections;

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
 * Created by anonymous on 20/6/17.
 */

public class MainJapaMalaFragment extends Fragment {

    private ImageView _1, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13, _14, _15, _16, _17;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(tech.iosd.gemselections.R.layout.frag_japa_mala, container, false);

        _1 = (ImageView)view.findViewById(tech.iosd.gemselections.R.id.japamala1);
        _2 = (ImageView)view.findViewById(tech.iosd.gemselections.R.id.japamala2);
        _3 = (ImageView)view.findViewById(tech.iosd.gemselections.R.id.japamala3);
        _4 = (ImageView)view.findViewById(tech.iosd.gemselections.R.id.japamala4);
        _5 = (ImageView)view.findViewById(tech.iosd.gemselections.R.id.japamala5);
        _6 = (ImageView)view.findViewById(tech.iosd.gemselections.R.id.japamala6);
        _7 = (ImageView)view.findViewById(tech.iosd.gemselections.R.id.japamala7);
        _8 = (ImageView)view.findViewById(tech.iosd.gemselections.R.id.japamala8);
        _9 = (ImageView)view.findViewById(tech.iosd.gemselections.R.id.japamala9);
        _10 = (ImageView)view.findViewById(tech.iosd.gemselections.R.id.japamala10);
        _11 = (ImageView)view.findViewById(tech.iosd.gemselections.R.id.japamala11);
        _12 = (ImageView)view.findViewById(tech.iosd.gemselections.R.id.japamala12);
        _13 = (ImageView)view.findViewById(tech.iosd.gemselections.R.id.japamala13);
        _14 = (ImageView)view.findViewById(tech.iosd.gemselections.R.id.japamala14);
        _15 = (ImageView)view.findViewById(tech.iosd.gemselections.R.id.japamala15);
        _16 = (ImageView)view.findViewById(tech.iosd.gemselections.R.id.japamala16);
        _17 = (ImageView)view.findViewById(tech.iosd.gemselections.R.id.japamala17);
        return view;
    }

    private void loadImage() {
        InputStream is;

        try {
            is = getActivity().getAssets().open("images/spiritual-mala/TULSI-MALA.jpg");
            _1.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/spiritual-mala/CHANDAN-MALA.jpg");
            _2.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/spiritual-mala/LAL-CHANDAN-MALA.jpg");
            _3.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/spiritual-mala/sphatic-mala.jpg");
            _4.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/spiritual-mala/rudraksha-sphatic-mala.jpg");
            _5.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/spiritual-mala/VAYAJANTI-MALA.jpg");
            _6.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/spiritual-mala/RUDRAKSHA-MALA.jpg");
            _7.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/spiritual-mala/PEARL-MALA.jpg");
            _8.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/spiritual-mala/MAGNET-MALA.jpg");
            _9.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/spiritual-mala/TIGER-EYE-MALA.jpg");
            _10.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/spiritual-mala/NAVRATTAN-MALA.jpg");
            _11.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/spiritual-mala/CORAL-MALA.jpg");
            _12.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/spiritual-mala/HALDI-MALA.jpg");
            _13.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/spiritual-mala/KAMAL-KATTA-MALA.jpg");
            _14.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/spiritual-mala/RUDRANI-MALA.jpg");
            _15.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/spiritual-mala/KALA-HAKIK.jpg");
            _16.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/spiritual-mala/PUTRA-JEEVA-MALA.jpg");
            _17.setImageBitmap(BitmapFactory.decodeStream(is));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loadImage();
        getActivity().setTitle("Japa Malas");
    }
}
