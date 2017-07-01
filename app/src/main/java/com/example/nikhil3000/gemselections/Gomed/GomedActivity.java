package com.example.nikhil3000.gemselections.Gomed;

import android.app.Dialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.OrientationHelper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.nikhil3000.gemselections.Neelam.BangkokNeelam;
import com.example.nikhil3000.gemselections.Neelam.CeylonNeelam;
import com.example.nikhil3000.gemselections.Neelam.NeelamInfo;
import com.example.nikhil3000.gemselections.R;
import com.example.nikhil3000.gemselections.Ruby.AfricanRuby;
import com.example.nikhil3000.gemselections.WebViewActivity;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by anonymous on 29/6/17.
 */

public class GomedActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener, AdapterView.OnItemSelectedListener {

    private Button btn;
    private ImageView banner;
    private YouTubePlayerView playerView;
    private static final String DEVELOPER_KEY = "AIzaSyBKlHdEkS-X7Vb2mW2qQSlF1TOxKzWpSU8";
    private static final int RECOVERY_REQUEST = 1;

    private Spinner spinner;
    private ArrayAdapter<String> arrayAdapter;
    private String[] _options=
            {
                    "Gomed Info",
                    "Gaya Gomed",
                    "Orrisa Gomed",
                    "African Gomed",
                    "Ceylonese Gomed"
            };

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gomed);

        toolbar = (Toolbar)findViewById(R.id.gomed_toolbar);
        setActionBar(toolbar);
        getActionBar().setDisplayHomeAsUpEnabled(true);

        btn = (Button)findViewById(R.id.btn_gomed_price);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show_dialog("GOMED WEIGHT : PRICE(INR)",R.string.gomed_price);
            }
        });

        banner = (ImageView)findViewById(R.id.gomed_banner);
        try {
            InputStream is = getAssets().open("images/precious-gems/orrisa-gomed.jpg");
            banner.setImageBitmap(BitmapFactory.decodeStream(is));
        }catch (IOException e){
            e.printStackTrace();
        }

        playerView = (YouTubePlayerView)findViewById(R.id.gomed_video);
        playerView.initialize(DEVELOPER_KEY, this);

        spinner = (Spinner)findViewById(R.id.gomed_spinner);
        arrayAdapter = new ArrayAdapter<String>(GomedActivity.this, android.R.layout.simple_spinner_dropdown_item, _options);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.gomed_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.ac_buy_gomed:
                startActivity(
                        new Intent(GomedActivity.this, WebViewActivity.class)
                                .putExtra("URL","http://khannagems.com/index.php/gem-stones/gomed.html")
                                .putExtra("parent","GomedActivity")
                );
                return true;

            case R.id.ac_gomed_certi:
                display_image("images/govt-certified-Ceylonese-gomed.jpg","Govt. Certified Gomed");
                return true;

        }
        return super.onOptionsItemSelected(item);
    }

    private void display_image(String url, String title) {

        Dialog dialog = new Dialog(GomedActivity.this);
        dialog.setContentView(R.layout.dialog_display_images);
        dialog.setTitle(title);

        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(dialog.getWindow().getAttributes());

        layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
        layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT;

        dialog.show();
        dialog.getWindow().setAttributes(layoutParams);

        ImageView iv = (ImageView)dialog.findViewById(R.id.image_here);
        final InputStream in;
        Bitmap img=null;
        final Bitmap imgcpy;

        try {
            in = getAssets().open(url);
            img = BitmapFactory.decodeStream(in);
            iv.setImageBitmap(img);

        } catch (IOException e) {
            e.printStackTrace();
        }

        imgcpy = img;

        final FloatingActionButton save = (FloatingActionButton)dialog.findViewById(R.id.fab_save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                File filePath = Environment.getExternalStorageDirectory();

                File dir = new File(filePath.getAbsoluteFile()+"/SavedImage/");
                dir.mkdirs();

                File file = new File(dir, "image.jpg");

                FileOutputStream fos=null;

                try{
                    fos = new FileOutputStream(file);

                    imgcpy.compress(Bitmap.CompressFormat.JPEG, 90, fos);

                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    try{
                        assert fos != null;
                        fos.flush();
                        fos.close();
                        final String path = file.getAbsolutePath();
                        new AlertDialog.Builder(GomedActivity.this)
                                .setTitle("Image Saved Successfully")
                                .setIcon(R.drawable.ic_save)
                                .setMessage("Image saved at: "+path)
                                .setNeutralButton("OK", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                })
                                .setPositiveButton("Open", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Toast.makeText(getApplicationContext(), "Opening...", Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(Intent.ACTION_VIEW);
                                        intent.setDataAndType(Uri.parse("file://"+path), "image/*");
                                        startActivity(intent);
                                    }
                                })
                                .create().show();
                    }catch (Exception e){
                        e.printStackTrace();
                        Toast.makeText(getApplicationContext(), "Could Not Save Image", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });


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
            youTubePlayer.cueVideo("DQ9dWIpyNI");
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
            youTubeInitializationResult.getErrorDialog(GomedActivity.this, RECOVERY_REQUEST).show();
        } else {
            String error = String.format(getString(R.string.player_error), youTubeInitializationResult.toString());
            Toast.makeText(GomedActivity.this, error, Toast.LENGTH_LONG).show();
        }
    }


    private void show_dialog(String title, int content) {
        Dialog dialog = new Dialog(GomedActivity.this);
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
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (parent == spinner) {
            Fragment fragment = null;
            switch (position) {
                case 0:
                    fragment = new GomedInfo();
                    break;
                case 1:
                    fragment = new GayaGomed();
                    break;
                case 2:
                    fragment = new OrrisaGomed();
                    break;
                case 3:
                    fragment = new AfricanGomed();
                    break;
                case 4:
                    fragment = new CeyloneseGomed();
                    break;
            }
            if (fragment != null) {
                getFragmentManager().beginTransaction()
                        .replace(R.id.gomed_container, fragment)
                        .commit();
                View targetView = findViewById(R.id.gomed_container);
                targetView.getParent().requestChildFocus(targetView, targetView);
            }
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        parent.setSelection(0);
    }
}
