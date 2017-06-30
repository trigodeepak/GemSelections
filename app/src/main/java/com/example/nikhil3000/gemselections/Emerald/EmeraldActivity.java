package com.example.nikhil3000.gemselections.Emerald;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nikhil3000.gemselections.R;
import com.example.nikhil3000.gemselections.WebViewActivity;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class EmeraldActivity extends YouTubeBaseActivity implements AdapterView.OnItemSelectedListener, YouTubePlayer.OnInitializedListener {

    private ImageView banner;

    private YouTubePlayerView playerView;
    private static final String DEVELOPER_KEY = "AIzaSyBKlHdEkS-X7Vb2mW2qQSlF1TOxKzWpSU8";
    private static final int RECOVERY_REQUEST = 1;

    private String[] _options =
            {
                    "ABOUT PANNA | EMERALD",
                    "EMERALD CABOCHON",
                    "ZAMBIAN EMERALD",
                    "COLUMBIAN EMERALD",
                    "BRAZILIAN EMERALD",
                    "SWAT EMERALD"
            };

    private String[] _quality =
            {
                    "----- NONE -----",
                    "A Quality",
                    "B Quality",
                    "C Quality",
                    "D Quality",
                    "E Quality",
                    "F Quality",
                    "G Quality",
                    "H Quality",
                    "I Quality",
                    "J Quality",
                    "K Quality"
            };
    private Spinner spinner1, spinner2;
    private ArrayAdapter<String> arrayAdapter1, arrayAdapter2;
    private android.widget.Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emerald);

        toolbar = (android.widget.Toolbar) findViewById(R.id.emerald_toolbar);
        setActionBar(toolbar);
        getActionBar().setDisplayHomeAsUpEnabled(true);

        banner = (ImageView)findViewById(R.id.emerald_banner);
        try{
            InputStream is = getAssets().open("images/precious-gems/Emerald/african-emerald.jpg");
            banner.setImageBitmap(BitmapFactory.decodeStream(is));
        }catch (IOException e){
            e.printStackTrace();
        }
        spinner1 = (Spinner)findViewById(R.id.emerald_spinner);
        spinner2 = (Spinner)findViewById(R.id.emerald_spinner2);

        arrayAdapter1 = new ArrayAdapter<String>(EmeraldActivity.this, android.R.layout.simple_spinner_dropdown_item, _options);
        arrayAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(arrayAdapter1);
        spinner1.setOnItemSelectedListener(this);

        arrayAdapter2 = new ArrayAdapter<String>(EmeraldActivity.this, android.R.layout.simple_spinner_dropdown_item, _quality);
        arrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(arrayAdapter2);
        spinner2.setOnItemSelectedListener(this);

        playerView = (YouTubePlayerView)findViewById(R.id.emerald_video);
        playerView.initialize(DEVELOPER_KEY, this);
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

    private void display_image(String url, String title) {

        Dialog dialog = new Dialog(EmeraldActivity.this);
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
                        new AlertDialog.Builder(EmeraldActivity.this)
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
                    }catch (IOException e){
                        e.printStackTrace();
                        Toast.makeText(getApplicationContext(), "Could Not Save Image", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.ac_buy_panna:
                    startActivity(
                            new Intent(EmeraldActivity.this, WebViewActivity.class)
                            .putExtra("URL","http://khannagems.com/index.php/gem-stones/panna-stone.html")
                            .putExtra("parent", "EmeraldActivity")
                    );
                return true;

            case R.id.ac_emerald_faq:
                    show_dialog("FAQs on Panna", R.string.emerald_faq);
                break;

            case R.id.ac_emerald_certi:
                    display_image("images/Government-lab-certified-Panna-stone.jpg", "Govt. Certified");
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.emerald_menu, menu);
        return true;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if(parent == spinner1){
            android.app.Fragment fragment = null;
            switch (position){
                case 0:
                    fragment = new EmeraldInfo();
                    break;
                case 1:
                    fragment = new EmeraldCabochon();
                    break;
                case 2:
                    fragment = new ZambianEmerald();
                    break;
                case 3:
                    fragment = new ColumbianEmerald();
                    break;
                case 4:
                    fragment = new BrazilianEmerald();
                    break;
                case 5:
                    fragment = new SwatEmerald();
                    break;
            }
            if(fragment!=null){
                getFragmentManager().beginTransaction()
                        .replace(R.id.emerald_container, fragment)
                        .commit();
                View targetView = findViewById(R.id.emerald_container);
                targetView.getParent().requestChildFocus(targetView,targetView);
            }
        }
        if (parent == spinner2){
            switch (position){
                case 0:
                    break;
                case 1:
                    show_dialog("A Grade", R.string.emerald_a);
                    break;
                case 2:
                    show_dialog("B Grade", R.string.emerald_b);
                    break;
                case 3:
                    show_dialog("C Grade", R.string.emerald_c);
                    break;
                case 4:
                    show_dialog("D Grade", R.string.emerald_d);
                    break;
                case 5:
                    show_dialog("E Grade", R.string.emerald_e);
                    break;
                case 6:
                    show_dialog("F Grade", R.string.emerald_f);
                    break;
                case 7:
                    show_dialog("G Grade", R.string.emerald_g);
                    break;
                case 8:
                    show_dialog("H Grade", R.string.emerald_h);
                    break;
                case 9:
                    show_dialog("I Grade", R.string.emerald_i);
                    break;
                case 10:
                    show_dialog("J Grade", R.string.emerald_j);
                    break;
                case 11:
                    show_dialog("K Grade", R.string.emerald_k);
                    break;

            }
        }
    }

    private void show_dialog(String title, int content) {
        Dialog dialog = new Dialog(EmeraldActivity.this);
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
    public void onNothingSelected(AdapterView<?> parent) {
        parent.setSelection(0);
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        if(!b){
            youTubePlayer.cueVideo("KC4t6RbeB9Y");
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
            youTubeInitializationResult.getErrorDialog(EmeraldActivity.this, RECOVERY_REQUEST).show();
        } else {
            String error = String.format(getString(R.string.player_error), youTubeInitializationResult.toString());
            Toast.makeText(EmeraldActivity.this, error, Toast.LENGTH_LONG).show();
        }
    }
}
