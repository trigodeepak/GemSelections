package tech.iosd.gemselections.MainContent;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import tech.iosd.gemselections.R;

public class FAQsActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    private YouTubePlayerView playerView;
    private static final String DEVELOPER_KEY = "AIzaSyBKlHdEkS-X7Vb2mW2qQSlF1TOxKzWpSU8";
    private static final int RECOVERY_REQUEST = 1;

    private android.widget.Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(tech.iosd.gemselections.R.layout.activity_faqs);

        LinearLayout hoToWear = (LinearLayout) findViewById(R.id.faq_how_towear);
        hoToWear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(FAQsActivity.this,FaqIntentAcitivity.class)
                .putExtra("title", R.string.faq1).putExtra("text" , R.string.faq2));


            }
        });

        LinearLayout linearLayout34 = (LinearLayout) findViewById(R.id.faq34);
        linearLayout34.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(FAQsActivity.this,FaqIntentAcitivity.class)
                        .putExtra("title", R.string.faq3).putExtra("text" , R.string.faq4));


            }
        });

        LinearLayout linearLayout56 = (LinearLayout) findViewById(R.id.faq56);
        linearLayout56.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(FAQsActivity.this,FaqIntentAcitivity.class)
                        .putExtra("title", R.string.faq5).putExtra("text" , R.string.faq6));


            }
        });


        LinearLayout linearLayout78 = (LinearLayout) findViewById(R.id.faq78);
        linearLayout78.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(FAQsActivity.this,FaqIntentAcitivity.class)
                        .putExtra("title", R.string.faq7).putExtra("text" , R.string.faq8));


            }
        });
        LinearLayout linearLayout910 = (LinearLayout) findViewById(R.id.faq910);
        linearLayout910.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(FAQsActivity.this,FaqIntentAcitivity.class)
                        .putExtra("title", R.string.faq9).putExtra("text" , R.string.faq10));


            }
        });

        LinearLayout linearLayout1112 = (LinearLayout) findViewById(R.id.faq1112);
        linearLayout1112.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(FAQsActivity.this,FaqIntentAcitivity.class)
                        .putExtra("title", R.string.faq11).putExtra("text" , R.string.faq12));


            }
        });

        LinearLayout linearLayout1314 = (LinearLayout) findViewById(R.id.faq1314);
        linearLayout1314.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(FAQsActivity.this,FaqIntentAcitivity.class)
                        .putExtra("title", R.string.faq13).putExtra("text" , R.string.faq14));


            }
        });

        LinearLayout linearLayout1516 = (LinearLayout) findViewById(R.id.faq1516);
        linearLayout1516.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(FAQsActivity.this,FaqIntentAcitivity.class)
                        .putExtra("title", R.string.faq15).putExtra("text" , R.string.faq16));


            }
        });






        toolbar = (android.widget.Toolbar) findViewById(R.id.faq_toolbar);
        setActionBar(toolbar);
        getActionBar().setDisplayHomeAsUpEnabled(true);

        playerView = (YouTubePlayerView)findViewById(tech.iosd.gemselections.R.id.faq_video);
        playerView.initialize(DEVELOPER_KEY, this);

        ScrollView scrollView = (ScrollView)findViewById(tech.iosd.gemselections.R.id.faq_scroll);
        scrollView.setBackground(getResources().getDrawable(tech.iosd.gemselections.R.drawable.back));


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == RECOVERY_REQUEST) {

            getYouTubePlayerProvider().initialize(DEVELOPER_KEY, this);
        }
    }

    protected YouTubePlayer.Provider getYouTubePlayerProvider() {
        return playerView;
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        if(!b){
            youTubePlayer.cueVideo("mdOWDD0YA7c");
            youTubePlayer.setOnFullscreenListener(new YouTubePlayer.OnFullscreenListener() {
                @Override
                public void onFullscreen(boolean b) {
                    if(!b){
                        //youTubePlayer.setFullscreen(false);
                        if(getResources().getConfiguration().orientation != Configuration.ORIENTATION_PORTRAIT)
                        {
                            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                        }
                    }
                }
            });
        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        if (youTubeInitializationResult.isUserRecoverableError()) {
            youTubeInitializationResult.getErrorDialog(FAQsActivity.this, RECOVERY_REQUEST).show();
        } else {
            String error = String.format(getString(tech.iosd.gemselections.R.string.player_error), youTubeInitializationResult.toString());
            Toast.makeText(FAQsActivity.this, error, Toast.LENGTH_LONG).show();
        }
    }
}
