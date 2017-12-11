package tech.iosd.gemselections.Handicrafts;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import tech.iosd.gemselections.Utils.WebViewActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by anonymous on 19/6/17.
 */

public class HandPotsFragment extends Fragment {

    private ImageView _1, _2, _3, _4, _5, _6, _7, _8, _9, banner;

    private Button price_list;

    private YouTubePlayer YPlayer;
    private static final String DEVELOPER_KEY = "AIzaSyBKlHdEkS-X7Vb2mW2qQSlF1TOxKzWpSU8";
    private static final int RECOVERY_REQUEST = 1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(tech.iosd.gemselections.R.layout.frag_hand_pots, container, false);

        YouTubePlayerSupportFragment youTubePlayerFragment = YouTubePlayerSupportFragment.newInstance();

        youTubePlayerFragment.initialize(DEVELOPER_KEY, new YouTubePlayer.OnInitializedListener() {

            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer player, boolean wasRestored) {

                if (!wasRestored) {
                    YPlayer = player;
                    YPlayer.cueVideo("50d9vqSpZkM");

                    YPlayer.setOnFullscreenListener(new YouTubePlayer.OnFullscreenListener() {
                        @Override
                        public void onFullscreen(boolean b) {
                            if(!b){
                                //YPlayer.setFullscreen(false);
                                if(getActivity().getResources().getConfiguration().orientation != Configuration.ORIENTATION_PORTRAIT)
                                {
                                    getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                                }
                            }
                        }
                    });
                }


            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider arg0, YouTubeInitializationResult arg1) {
                if (arg1.isUserRecoverableError()) {
                    arg1.getErrorDialog(getActivity(), RECOVERY_REQUEST).show();
                } else {
                    String error = String.format(getString(tech.iosd.gemselections.R.string.player_error), arg1.toString());
                    Toast.makeText(getActivity(), error, Toast.LENGTH_LONG).show();
                }
            }
        });
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.add(tech.iosd.gemselections.R.id.hand_video, youTubePlayerFragment).commit();


        _1 = (ImageView)view.findViewById(tech.iosd.gemselections.R.id.handpot1);
        _2 = (ImageView)view.findViewById(tech.iosd.gemselections.R.id.handpot2);
        _3 = (ImageView)view.findViewById(tech.iosd.gemselections.R.id.handpot3);
        _4 = (ImageView)view.findViewById(tech.iosd.gemselections.R.id.handpot4);
        _5 = (ImageView)view.findViewById(tech.iosd.gemselections.R.id.handpot5);
        _6 = (ImageView)view.findViewById(tech.iosd.gemselections.R.id.handpot6);
        _7 = (ImageView)view.findViewById(tech.iosd.gemselections.R.id.handpot7);
        _8 = (ImageView)view.findViewById(tech.iosd.gemselections.R.id.handpot8);
        _9 = (ImageView)view.findViewById(tech.iosd.gemselections.R.id.handpot9);
        banner = (ImageView)view.findViewById(tech.iosd.gemselections.R.id.pot_banner);

        price_list = (Button)view.findViewById(tech.iosd.gemselections.R.id.hand_price_list);
        price_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(
                        new Intent(getActivity(), WebViewActivity.class)
                        .putExtra("URL","https://drive.google.com/open?id=0B8j7YKWrs-f1UzNqbEMtZnk5WlE")
                );
            }
        });
        return view;
    }


    private void loadImage() {
        InputStream is;

        try {
            is = getActivity().getAssets().open("images/decorationitems/Candle-Holder-HGL01.jpg");
            _1.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/decorationitems/Flower-Pot-HGL02.jpg");
            _2.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/decorationitems/Flower-Pot-HGL03.jpg");
            _3.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/decorationitems/FlowerPot-HGL04.jpg");
            _4.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/decorationitems/Marble-Glass-HGL-05.jpg");
            _5.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/decorationitems/Flower-Pot-HGL06.jpg");
            _6.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/decorationitems/Flower-pot-HGL07.jpg");
            _7.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/decorationitems/Flower-Pot-HGL08.jpg");
            _8.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("images/decorationitems/Flower-Pot-HGL09.jpg");
            _9.setImageBitmap(BitmapFactory.decodeStream(is));

            is = getActivity().getAssets().open("logo/hand_logo.jpg");
            banner.setImageBitmap(BitmapFactory.decodeStream(is));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loadImage();
        getActivity().setTitle("Pots");
    }
}
