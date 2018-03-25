package tech.iosd.gemselections.abhimantrit;

import android.app.Dialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import tech.iosd.gemselections.Emerald.EmeraldActivity;
import tech.iosd.gemselections.Gomed.GomedActivity;
import tech.iosd.gemselections.Lehsunia.LehsuniaActivity;
import tech.iosd.gemselections.MoongaActivity;
import tech.iosd.gemselections.Neelam.NeelamActivity;
import tech.iosd.gemselections.Pukhraj.BainganiPukhraj;
import tech.iosd.gemselections.Pukhraj.GulabiPukhraj;
import tech.iosd.gemselections.Pukhraj.HaraPukhraj;
import tech.iosd.gemselections.Pukhraj.PitambariNeelam;
import tech.iosd.gemselections.Pukhraj.PukhrajActivity;
import tech.iosd.gemselections.Pukhraj.SafedPukhraj;
import tech.iosd.gemselections.R;
import tech.iosd.gemselections.Ruby.RubyActivity;
import tech.iosd.gemselections.SemiPreciousGems.MotiActivity;
import tech.iosd.gemselections.Utils.WebViewActivity;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


public class Abhimantrit extends Fragment {


    private YouTubePlayer YPlayer;
    private static final String DEVELOPER_KEY = "AIzaSyBKlHdEkS-X7Vb2mW2qQSlF1TOxKzWpSU8";
    private static final int RECOVERY_REQUEST = 1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_abhimantrit, container, false);

        YouTubePlayerSupportFragment youTubePlayerFragment = YouTubePlayerSupportFragment.newInstance();

        youTubePlayerFragment.initialize(DEVELOPER_KEY, new YouTubePlayer.OnInitializedListener() {

            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer player, boolean wasRestored) {

                if (!wasRestored) {
                    YPlayer = player;
                    List<String> videos = new ArrayList<String>();
                    videos.add("Pu_NqgEa0TQ");
                    videos.add("Kt99XEBQ3pw");
                    videos.add("QcjlAmjn_-U");
                    YPlayer.cueVideos(videos);

                    YPlayer.setOnFullscreenListener(new YouTubePlayer.OnFullscreenListener() {
                        @Override
                        public void onFullscreen(boolean b) {
                            if(!b){

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
        transaction.add(tech.iosd.gemselections.R.id.youtube_fragment, youTubePlayerFragment).commit();

        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getActivity().setTitle("Abhimantarit");
    }




}