package com.example.nikhil3000.gemselections;

import android.app.Dialog;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by anonymous on 18/6/17.
 */

public class RudBeadFragment extends Fragment implements View.OnClickListener{

    private ImageView _1, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13, _14, _15, _16, _17, _18, _19, _20, _21, _trijuti, _ganesh, _gauri;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_rud_beads,container ,false);

        _1 = (ImageView)view.findViewById(R.id.rud_bead_one);
        _1.setOnClickListener(this);
        _2 = (ImageView)view.findViewById(R.id.rud_bead_two);
        _2.setOnClickListener(this);
        _3 = (ImageView)view.findViewById(R.id.rud_bead_three);
        _3.setOnClickListener(this);
        _4 = (ImageView)view.findViewById(R.id.rud_bead_four);
        _4.setOnClickListener(this);
        _5 = (ImageView)view.findViewById(R.id.rud_bead_five);  _5.setOnClickListener(this);
        _6 = (ImageView)view.findViewById(R.id.rud_bead_six);   _6.setOnClickListener(this);
        _7 = (ImageView)view.findViewById(R.id.rud_bead_seven);   _7.setOnClickListener(this);
        _8 = (ImageView)view.findViewById(R.id.rud_bead_eight);   _8.setOnClickListener(this);
        _9 = (ImageView)view.findViewById(R.id.rud_bead_nine);   _9.setOnClickListener(this);
        _10 = (ImageView)view.findViewById(R.id.rud_bead_ten);   _10.setOnClickListener(this);
        _11 = (ImageView)view.findViewById(R.id.rud_bead_eleven);   _11.setOnClickListener(this);
        _12 = (ImageView)view.findViewById(R.id.rud_bead_twelve);   _12.setOnClickListener(this);
        _13 = (ImageView)view.findViewById(R.id.rud_bead_thirteen);   _13.setOnClickListener(this);
        _14 = (ImageView)view.findViewById(R.id.rud_bead_fourteen);   _14.setOnClickListener(this);
        _15 = (ImageView)view.findViewById(R.id.rud_bead_fifteen);   _15.setOnClickListener(this);
        _16 = (ImageView)view.findViewById(R.id.rud_bead_sixteen);   _16.setOnClickListener(this);
        _17 = (ImageView)view.findViewById(R.id.rud_bead_seventeen);   _17.setOnClickListener(this);
        _18 = (ImageView)view.findViewById(R.id.rud_bead_eighteen);   _18.setOnClickListener(this);
        _19 = (ImageView)view.findViewById(R.id.rud_bead_nineteen);   _19.setOnClickListener(this);
        _20 = (ImageView)view.findViewById(R.id.rud_bead_twenty);   _20.setOnClickListener(this);
        _21 = (ImageView)view.findViewById(R.id.rud_bead_21);   _21.setOnClickListener(this);
        _trijuti = (ImageView)view.findViewById(R.id.rud_bead_trijuti);   _trijuti.setOnClickListener(this);
        _ganesh = (ImageView)view.findViewById(R.id.rud_bead_ganesh);   _ganesh.setOnClickListener(this);
        _gauri = (ImageView)view.findViewById(R.id.rud_bead_gauri);
        _gauri.setOnClickListener(this);

        return view;
    }

    private void loadImage() {
        InputStream is;

        try{
            is = getActivity().getAssets().open("images/rudraksha/one-mukhi-rudraksha.jpg");
            _1.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/rudraksha/two-mukhi-rudraksha.jpg");
            _2.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/rudraksha/three-mukhi-rudraksha.jpg");
            _3.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/rudraksha/four-mukhi-rudraksha.jpg");
            _4.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/rudraksha/five-mukhi-rudraksha.jpg");
            _5.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/rudraksha/six-mukhi-rudraksha.jpg");
            _6.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/rudraksha/seven-mukhi-rudraksha.jpg");
            _7.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/rudraksha/eight-mukhi-rudraksha.jpg");
            _8.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/rudraksha/nine-mukhi-rudraksha.jpg");
            _9.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/rudraksha/ten-mukhi-rudraksha.jpg");
            _10.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/rudraksha/eleven-mukhi-rudraksha.jpg");
            _11.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/rudraksha/twelve-mukhi-rudraksha.jpg");
            _12.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/rudraksha/thirteen-mukhi-rudraksha.jpg");
            _13.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/rudraksha/fourteen-mukhi-rudraksha.jpg");
            _14.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/rudraksha/fifteen-mukhi-rudraksha.jpg");
            _15.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/rudraksha/sixteen-mukhi-rudraksha.jpg");
            _16.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/rudraksha/seventeen-mukhi-rudraksha.jpg");
            _17.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/rudraksha/eighteen-mukhi-rudraksha.jpg");
            _18.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/rudraksha/nineteen-mukhi-rudraksha.jpg");
            _19.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/rudraksha/twenty-mukhi-rudraksha.jpg");
            _20.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/rudraksha/twentyone-mukhi-rudraksha.jpg");
            _21.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/rudraksha/trijuti-rudraksha.jpg");
            _trijuti.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/rudraksha/ganesh-rudraksha.jpg");
            _ganesh.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/rudraksha/gauri-shanker-rudraksha.jpg");
            _gauri.setImageBitmap(BitmapFactory.decodeStream(is));
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        loadImage();

        getActivity().setTitle("Beads");
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

    @Override
    public void onClick(View v) {
        if(v==_1){
            show_dialog("ONE MUKHI", R.string.bead_1);
        }
    }
}
