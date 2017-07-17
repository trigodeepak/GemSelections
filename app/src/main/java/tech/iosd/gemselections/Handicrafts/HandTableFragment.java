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

public class HandTableFragment extends Fragment {

    private ImageView _1, _2, _3, _4, _5;
    
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(tech.iosd.gemselections.R.layout.frag_hand_table, container, false);
        _1 = (ImageView)view.findViewById(tech.iosd.gemselections.R.id.handtable1);
        _2 = (ImageView)view.findViewById(tech.iosd.gemselections.R.id.handtable2);
        _3 = (ImageView)view.findViewById(tech.iosd.gemselections.R.id.handtable3);
        _4 = (ImageView)view.findViewById(tech.iosd.gemselections.R.id.handtable4);
        _5 = (ImageView)view.findViewById(tech.iosd.gemselections.R.id.handtable5);
        return view;
    }

    private void loadImage() {
        InputStream is;

        try {
            is = getActivity().getAssets().open("images/table-top-spiritual-item/Pen-Stand-TTS-01.jpg");
            _1.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/table-top-spiritual-item/Coaster-Set-TTS-02.jpg");
            _2.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/table-top-spiritual-item/Coaster-Set-TTS-03.jpg");
            _3.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/table-top-spiritual-item/Visiting-Card-Holder-TTS-04.jpg");
            _4.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/table-top-spiritual-item/Visiting-Card-Holder-TTS05.jpg");
            _5.setImageBitmap(BitmapFactory.decodeStream(is));

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loadImage();
        getActivity().setTitle("Spiritual Table Top Items");
    }
}
