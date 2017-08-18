package tech.iosd.gemselections.Jewellery;

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
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;

import tech.iosd.gemselections.R;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by anonymous on 19/6/17.
 */

public class SilverPendantFragment extends Fragment {
    private ImageView go1, go2, go3, go4, go5, go6, go7, go8, go9, g10, g11, g12, g13, g14, g15, g16, g17, g18, g19, g20;

    private YouTubePlayer YPlayer;
    private static final String DEVELOPER_KEY = "AIzaSyBKlHdEkS-X7Vb2mW2qQSlF1TOxKzWpSU8";
    private static final int RECOVERY_REQUEST = 1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.frag_silver_pendant, container, false);

        YouTubePlayerSupportFragment youTubePlayerFragment = YouTubePlayerSupportFragment.newInstance();

        youTubePlayerFragment.initialize(DEVELOPER_KEY, new YouTubePlayer.OnInitializedListener() {

            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer player, boolean wasRestored) {

                if (!wasRestored) {
                    YPlayer = player;
                    YPlayer.cueVideo("VOixudfTvFQ");

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
        transaction.add(R.id.jewellery_video, youTubePlayerFragment).commit();


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
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Silver Pendant");
        load_Images();
    }

    private void load_Images() {
        InputStream is;

        try {
            is = getActivity().getAssets().open("images/silver-pendant/SP01.jpg");
            go1.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/silver-pendant/SP02.jpg");
            go2.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/silver-pendant/SP03.jpg");
            go3.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/silver-pendant/SP04.jpg");
            go4.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/silver-pendant/SP05.jpg");
            go5.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/silver-pendant/SP06.jpg");
            go6.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/silver-pendant/SP07.jpg");
            go7.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/silver-pendant/SP08.jpg");
            go8.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/silver-pendant/SP09.jpg");
            go9.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/silver-pendant/SP10.jpg");
            g10.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/silver-pendant/SP11.jpg");
            g11.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/silver-pendant/SP12.jpg");
            g12.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/silver-pendant/SP13.jpg");
            g13.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/silver-pendant/SP14.jpg");
            g14.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/silver-pendant/SP15.jpg");
            g15.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/silver-pendant/SP16.jpg");
            g16.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/silver-pendant/SP17.jpg");
            g17.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/silver-pendant/SP18.jpg");
            g18.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/silver-pendant/SP19.jpg");
            g19.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/silver-pendant/SP20.jpg");
            g20.setImageBitmap(BitmapFactory.decodeStream(is));
        } catch (IOException e) {
            e.printStackTrace();
        }catch (OutOfMemoryError error){
            Toast.makeText(getActivity(), error.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
