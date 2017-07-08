package com.example.nikhil3000.gemselections;

import android.app.Dialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nikhil3000.gemselections.Ruby.RubyActivity;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import java.io.IOException;
import java.io.InputStream;

public class MoongaActivity extends YouTubeBaseActivity implements View.OnClickListener, YouTubePlayer.OnInitializedListener {

    private Button buy_coral;
    private ImageView italian, srilankan, jap;

    private YouTubePlayerView playerView;
    private static final String DEVELOPER_KEY = "AIzaSyBKlHdEkS-X7Vb2mW2qQSlF1TOxKzWpSU8";
    private static final int RECOVERY_REQUEST = 1;

    private android.widget.Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moonga);

        toolbar = (android.widget.Toolbar) findViewById(R.id.coral_toolbar);
        setActionBar(toolbar);
        getActionBar().setDisplayHomeAsUpEnabled(true);

        playerView = (YouTubePlayerView)findViewById(R.id.coral_video);
        playerView.initialize(DEVELOPER_KEY, this);

        buy_coral = (Button)findViewById(R.id.buy_coral);
        buy_coral.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(
                                new Intent(MoongaActivity.this, WebViewActivity.class)
                                        .putExtra("URL","http://khannagems.com/index.php/gem-stones/moonga.html")
                                        .putExtra("parent","MoongaActivity")
                        );
                    }
                }
        );

        italian  = (ImageView)findViewById(R.id.italiancoral);
        italian.setOnClickListener(this);
        jap = (ImageView)findViewById(R.id.japcoral);
        jap.setOnClickListener(this);
        srilankan = (ImageView)findViewById(R.id.srilankancoral);
        srilankan.setOnClickListener(this);

        InputStream is;

        try{
            is = getAssets().open("images/precious-gems/italian_Coral.jpg");
            italian.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getAssets().open("images/precious-gems/japanese-coral.jpg");
            jap.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getAssets().open("images/precious-gems/sri-lankan-coral.jpg");
            srilankan.setImageBitmap(BitmapFactory.decodeStream(is));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View v) {

        if(v == italian){
            show_dialog("ITALIAN MOONGA | CORAL", R.string.moongaitalian1, R.string.moongaitalian2);
        }
        if(v == jap){
            show_dialog("JAPANESE MOONGA | CORAL", R.string.moongajap1, R.string.moongajap2);
        }
        if(v == srilankan){
            show_dialog("SRI LANKAN MOONGA | CORAL", R.string.moongasrilanka1, R.string.moongasrilanka2);
        }
    }

    private void show_dialog(String title, int content1, int content2){
        Dialog dialog = new Dialog(MoongaActivity.this);
        dialog.setContentView(R.layout.dialog_moonga_layout);
        dialog.setTitle(title);

        WindowManager.LayoutParams params = new WindowManager.LayoutParams();
        params.copyFrom(dialog.getWindow().getAttributes());
        params.width = WindowManager.LayoutParams.MATCH_PARENT;
        params.height = WindowManager.LayoutParams.WRAP_CONTENT;

        dialog.show();
        dialog.getWindow().setAttributes(params);

        TextView t1, t2;
        t1 = (TextView)dialog.findViewById(R.id._moongatext1);
        t2 = (TextView)dialog.findViewById(R.id._moongatext2);

        t1.setText(getString(content1));
        t2.setText(getString(content2));
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
            youTubePlayer.cueVideo("IE2taW6_Xi4");
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
            youTubeInitializationResult.getErrorDialog(MoongaActivity.this, RECOVERY_REQUEST).show();
        } else {
            String error = String.format(getString(R.string.player_error), youTubeInitializationResult.toString());
            Toast.makeText(MoongaActivity.this, error, Toast.LENGTH_LONG).show();
        }
    }
}
