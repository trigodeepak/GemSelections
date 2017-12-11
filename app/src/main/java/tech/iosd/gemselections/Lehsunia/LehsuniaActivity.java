package tech.iosd.gemselections.Lehsunia;

import android.app.Fragment;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.Toolbar;

import tech.iosd.gemselections.Utils.WebViewActivity;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by anonymous on 29/6/17.
 */

public class LehsuniaActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener, AdapterView.OnItemSelectedListener {

    private ImageView banner;
    private YouTubePlayerView playerView;
    private static final String DEVELOPER_KEY = "AIzaSyBKlHdEkS-X7Vb2mW2qQSlF1TOxKzWpSU8";
    private static final int RECOVERY_REQUEST = 1;

    private Spinner spinner;
    private ArrayAdapter<String> arrayAdapter;
    private String[] _options=
            {
                    "Cat's Eye Info",
                    "Chrysoberyl Cat's Eye",
                    "Quartz Cat's Eye",
                    "Apatite Cat's Eye",
                    "Sillimanite Cat's Eye",
                    "Prehnite Cat's Eye"
            };

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(tech.iosd.gemselections.R.layout.activity_lehsunia);

        toolbar = (Toolbar)findViewById(tech.iosd.gemselections.R.id.lehsunia_toolbar);
        setActionBar(toolbar);
        getActionBar().setDisplayHomeAsUpEnabled(true);

        banner = (ImageView)findViewById(tech.iosd.gemselections.R.id.lehsunia_banner);
        try {
            InputStream is = getAssets().open("images/precious-gems/Cat's-Eye.jpg");
            banner.setImageBitmap(BitmapFactory.decodeStream(is));
        }catch (IOException e){
            e.printStackTrace();
        }

        playerView = (YouTubePlayerView)findViewById(tech.iosd.gemselections.R.id.lehsunia_video);
        playerView.initialize(DEVELOPER_KEY, this);

        spinner = (Spinner)findViewById(tech.iosd.gemselections.R.id.lehsunia_spinner);
        arrayAdapter = new ArrayAdapter<String>(LehsuniaActivity.this, android.R.layout.simple_spinner_dropdown_item, _options);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(tech.iosd.gemselections.R.menu.lehsunia_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case tech.iosd.gemselections.R.id.ac_buy_lehsunia:
                startActivity(
                        new Intent(LehsuniaActivity.this, WebViewActivity.class)
                                .putExtra("URL","http://khannagems.com/index.php/gem-stones/lehsunia.html")
                                .putExtra("parent","LehsuniaActivity")
                );
                return true;
        }
        return super.onOptionsItemSelected(item);
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
            youTubePlayer.cueVideo("Ow_C4Kp2VpE");
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
            youTubeInitializationResult.getErrorDialog(LehsuniaActivity.this, RECOVERY_REQUEST).show();
        } else {
            String error = String.format(getString(tech.iosd.gemselections.R.string.player_error), youTubeInitializationResult.toString());
            Toast.makeText(LehsuniaActivity.this, error, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (parent == spinner) {
            Fragment fragment = null;
            switch (position) {
                case 0:
                    fragment = new LehsuniaInfo();
                    break;
                case 1:
                    fragment = new Chrysoberyl();
                    break;
                case 2:
                    fragment = new QuartzCatsEye();
                    break;
                case 3:
                    fragment = new ApatiteCatsEye();
                    break;
                case 4:
                    fragment = new SillimaniteCatsEye();
                    break;
                case 5:
                    fragment = new PrehniteCatsEye();
                    break;
            }
            if (fragment != null) {
                getFragmentManager().beginTransaction()
                        .replace(tech.iosd.gemselections.R.id.lehsunia_container, fragment)
                        .commit();
                View targetView = findViewById(tech.iosd.gemselections.R.id.lehsunia_container);
                targetView.getParent().requestChildFocus(targetView, targetView);
            }
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        parent.setSelection(0);
    }
}
