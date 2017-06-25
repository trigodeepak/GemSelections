package com.example.nikhil3000.gemselections;

import android.app.Dialog;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by anonymous on 18/6/17.
 */

public class RudBeadFragment extends Fragment implements View.OnClickListener{

    private ImageView _1, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13, _14, _15, _16, _17, _18, _19, _20, _21, _trijuti, _ganesh, _gauri;

    private YouTubePlayer OneMukhiPlayer, GauriPlayer;
    private static final String DEVELOPER_KEY = "AIzaSyBKlHdEkS-X7Vb2mW2qQSlF1TOxKzWpSU8";
    private static final int RECOVERY_REQUEST = 1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_rud_beads,container ,false);

        YouTubePlayerSupportFragment youTubePlayerFragment = YouTubePlayerSupportFragment.newInstance();

        youTubePlayerFragment.initialize(DEVELOPER_KEY, new YouTubePlayer.OnInitializedListener() {

            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer player, boolean wasRestored) {

                if (!wasRestored) {
                    OneMukhiPlayer = player;
                    OneMukhiPlayer.cueVideo("vnP0lyisxAs");
                }

            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider arg0, YouTubeInitializationResult arg1) {
                if (arg1.isUserRecoverableError()) {
                    arg1.getErrorDialog(getActivity(), RECOVERY_REQUEST).show();
                } else {
                    String error = String.format(getString(R.string.player_error), arg1.toString());
                    Toast.makeText(getActivity(), error, Toast.LENGTH_LONG).show();
                }
            }
        });
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.add(R.id.yt_onemuki, youTubePlayerFragment).commit();

        YouTubePlayerSupportFragment youTubePlayerFragment1 = YouTubePlayerSupportFragment.newInstance();
        youTubePlayerFragment1.initialize(DEVELOPER_KEY, new YouTubePlayer.OnInitializedListener() {

            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer player, boolean wasRestored) {

                if (!wasRestored) {
                    GauriPlayer = player;
                    GauriPlayer.cueVideo("SbLQHuaeH_Q");
                }

            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider arg0, YouTubeInitializationResult arg1) {
                if (arg1.isUserRecoverableError()) {
                    arg1.getErrorDialog(getActivity(), RECOVERY_REQUEST).show();
                } else {
                    String error = String.format(getString(R.string.player_error), arg1.toString());
                    Toast.makeText(getActivity(), error, Toast.LENGTH_LONG).show();
                }
            }
        });
        FragmentTransaction transaction1 = getChildFragmentManager().beginTransaction();
        transaction1.add(R.id.yt_gauri, youTubePlayerFragment1).commit();

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

            is = getActivity().getAssets().open("images/rudraksha/sixteen-mukhi-rudraksha.gif");
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

            is = getActivity().getAssets().open("images/rudraksha/trijuti-rudraksha.gif");
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
        if(v==_2){
            show_dialog("TWO MUKHI", R.string.bead_2);
        }
        if(v==_3){
            show_dialog("THREE MUKHI", R.string.bead_3);
        }
        if(v==_4){
            show_dialog("FOUR MUKHI", R.string.bead_4);
        }
        if(v==_5){
            show_dialog("FIVE MUKHI", R.string.bead_5);
        }
        if(v==_6){
            show_dialog("SIX MUKHI", R.string.bead_6);
        }
        if(v==_7){
            show_dialog("SEVEN MUKHI", R.string.bead_7);
        }
        if(v==_8){
            show_dialog("EIGHT MUKHI", R.string.bead_8);
        }
        if(v==_9){
            show_dialog("NINE MUKHI", R.string.bead_9);
        }
        if(v==_10){
            show_dialog("TEN MUKHI", R.string.bead_10);
        }
        if(v==_11){
            show_dialog("ELEVEN MUKHI", R.string.bead_11);
        }
        if(v==_12){
            show_dialog("TWELVE MUKHI", R.string.bead_12);
        }
        if(v==_13){
            show_dialog("THIRTEEN MUKHI", R.string.bead_13);
        }
        if(v==_14){
            show_dialog("FOURTEEN MUKHI", R.string.bead_14);
        }
        if(v==_15){
            show_dialog("FIFTEEN MUKHI", R.string.bead_15);
        }
        if(v==_16){
            show_dialog("SIXTEEN MUKHI", R.string.bead_16);
        }
        if(v==_17){
            show_dialog("SEVENTEEN MUKHI", R.string.bead_17);
        }
        if(v==_18){
            show_dialog("EIGHTEEN MUKHI", R.string.bead_18);
        }
        if(v==_19){
            show_dialog("NINETEEN MUKHI", R.string.bead_19);
        }
        if(v==_20){
            show_dialog("TWENTY MUKHI", R.string.bead_20);
        }
        if(v==_21){
            show_dialog("TWENTY ONE MUKHI", R.string.bead_21);
        }
        if(v==_trijuti){
            show_dialog("TRIJUTI", R.string.bead_trijuti);
        }
        if(v==_ganesh){
            show_dialog("GANESH", R.string.bead_ganesh);
        }
        if(v==_gauri){
            show_dialog("GAURI SHANKER", R.string.bead_gauri);
        }
    }
}
