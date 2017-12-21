package tech.iosd.gemselections.Ittar;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;

import java.io.IOException;
import java.io.InputStream;

import tech.iosd.gemselections.R;

/**
 * Created by anonymous on 19/6/17.
 */

public class IttrAboutFragment extends Fragment {

    private YouTubePlayer YPlayer;
    private static final String DEVELOPER_KEY = "AIzaSyBKlHdEkS-X7Vb2mW2qQSlF1TOxKzWpSU8";
    private static final int RECOVERY_REQUEST = 1;
    private ImageView banner;
    private ScrollView view1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(tech.iosd.gemselections.R.layout.frag_ittr_about, container, false);

        YouTubePlayerSupportFragment youTubePlayerFragment = YouTubePlayerSupportFragment.newInstance();
        youTubePlayerFragment.initialize(DEVELOPER_KEY, new YouTubePlayer.OnInitializedListener() {

            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer player, boolean wasRestored) {

                if (!wasRestored) {
                    YPlayer = player;
                    YPlayer.cueVideo("d4riYvxGYqA");
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
        transaction.add(R.id.ittar_video, youTubePlayerFragment).commit();

        view1 = (ScrollView)view.findViewById(tech.iosd.gemselections.R.id.scroll_ittar);
        view1.setBackground(getResources().getDrawable(tech.iosd.gemselections.R.drawable.back));

        banner = (ImageView)view.findViewById(tech.iosd.gemselections.R.id.ittar_banner1);
        InputStream is=null;
        try {
            is = getActivity().getAssets().open("logo/perf_logo.jpg");
        } catch (IOException e) {
            e.printStackTrace();
        }
        banner.setImageBitmap(BitmapFactory.decodeStream(is));
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
