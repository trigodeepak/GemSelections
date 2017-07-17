package tech.iosd.gemselections.Handicrafts;

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

public class HandGiftsFragment extends Fragment {

    private ImageView _1, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11;
    
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(tech.iosd.gemselections.R.layout.frag_hand_gifts, container, false);
        _1 = (ImageView)view.findViewById(tech.iosd.gemselections.R.id.handgift1);
        _2 = (ImageView)view.findViewById(tech.iosd.gemselections.R.id.handgift2);
        _3 = (ImageView)view.findViewById(tech.iosd.gemselections.R.id.handgift3);
        _4 = (ImageView)view.findViewById(tech.iosd.gemselections.R.id.handgift4);
        _5 = (ImageView)view.findViewById(tech.iosd.gemselections.R.id.handgift5);
        _6 = (ImageView)view.findViewById(tech.iosd.gemselections.R.id.handgift6);
        _7 = (ImageView)view.findViewById(tech.iosd.gemselections.R.id.handgift7);
        _8 = (ImageView)view.findViewById(tech.iosd.gemselections.R.id.handgift8);
        _9 = (ImageView)view.findViewById(tech.iosd.gemselections.R.id.handgift9);
        _10 = (ImageView)view.findViewById(tech.iosd.gemselections.R.id.handgift10);
        _11 = (ImageView)view.findViewById(tech.iosd.gemselections.R.id.handgift11);
        return view;
    }

    private void loadImage() {
        InputStream is;

        try {
            is = getActivity().getAssets().open("images/spiritual-gifts/ASG-01-GANESHA.jpg");
            _1.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/spiritual-gifts/ASG-02-GANESHA.jpg");
            _2.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/spiritual-gifts/ASG-03-GANESHA.jpg");
            _3.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/spiritual-gifts/ASG-04-GANESHA.jpg");
            _4.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/spiritual-gifts/ASG-05-KRISHANA.jpg");
            _5.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/spiritual-gifts/ASG-06-HANUMAN.jpg");
            _6.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/spiritual-gifts/ASG-07-RADHA-KRISHNA.jpg");
            _7.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/spiritual-gifts/ASG-08-Sai-Baba.jpg");
            _8.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/spiritual-gifts/ASG-09-JesusCrist.jpg");
            _9.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/spiritual-gifts/ASG-10-Jesus-Crist.jpg");
            _10.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/spiritual-gifts/ASG-11-Jesus-Crist.jpg");
            _11.setImageBitmap(BitmapFactory.decodeStream(is));

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loadImage();
        getActivity().setTitle("Gifts");
    }
}
