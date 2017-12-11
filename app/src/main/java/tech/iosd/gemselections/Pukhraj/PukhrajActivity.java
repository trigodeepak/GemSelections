package tech.iosd.gemselections.Pukhraj;

import android.app.Dialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
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
import android.widget.Toolbar;

import tech.iosd.gemselections.Utils.WebViewActivity;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

/**
 * Created by anonymous on 29/6/17.
 */

public class PukhrajActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener, AdapterView.OnItemSelectedListener {

    private ImageView banner;
    private boolean first = true;
    private Bitmap img;
    private YouTubePlayerView playerView;
    private static final String DEVELOPER_KEY = "AIzaSyBKlHdEkS-X7Vb2mW2qQSlF1TOxKzWpSU8";
    private static final int RECOVERY_REQUEST = 2;

    private Spinner spinner, spinner1, spinner2;
    private ArrayAdapter<String> arrayAdapter, arrayAdapter1, arrayAdapter2;

    private String[] _options=
            {
                    "Pukhraj Info",
                    "Ceylon Pukhraj",
                    "Bangkok Pukhraj",
                    "Treated Pukhraj"
            };

    private String[] _quality1 =
            {
                    "----- NONE -----",
                    "A Quality",
                    "B Quality",
                    "C Quality",
                    "D Quality",
                    "E Quality",
                    "F Quality"
            };

    private String[] _quality2 =
            {
                    "----- NONE -----",
                    "A Quality",
                    "B Quality",
                    "C Quality",
                    "D Quality",
                    "E Quality"
            };

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(tech.iosd.gemselections.R.layout.activity_pukhraj);

        toolbar = (Toolbar)findViewById(tech.iosd.gemselections.R.id.pukhraj_toolbar);
        setActionBar(toolbar);
        getActionBar().setDisplayHomeAsUpEnabled(true);

        banner = (ImageView)findViewById(tech.iosd.gemselections.R.id.pukhraj_banner);
        try {
            InputStream is = getAssets().open("images/precious-gems/gems/natural-yellow-sapphire.jpg");
            banner.setImageBitmap(BitmapFactory.decodeStream(is));
        }catch (IOException e){
            e.printStackTrace();
        }

        playerView = (YouTubePlayerView)findViewById(tech.iosd.gemselections.R.id.pukhraj_video);
        playerView.initialize(DEVELOPER_KEY, this);

        spinner = (Spinner)findViewById(tech.iosd.gemselections.R.id.pukhraj_spinner);
        arrayAdapter = new ArrayAdapter<String>(PukhrajActivity.this, android.R.layout.simple_spinner_dropdown_item, _options);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(this);

        spinner1 = (Spinner)findViewById(tech.iosd.gemselections.R.id.pukhraj_spinner2);
        arrayAdapter1 = new ArrayAdapter<String>(PukhrajActivity.this, android.R.layout.simple_spinner_dropdown_item, _quality1);
        arrayAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(arrayAdapter1);
        spinner1.setOnItemSelectedListener(this);

        spinner2 = (Spinner)findViewById(tech.iosd.gemselections.R.id.pukhraj_spinner3);
        arrayAdapter2 = new ArrayAdapter<String>(PukhrajActivity.this, android.R.layout.simple_spinner_dropdown_item, _quality2);
        arrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(arrayAdapter2);
        spinner2.setOnItemSelectedListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case tech.iosd.gemselections.R.id.ac_buy_pukhraj:
                startActivity(
                        new Intent(PukhrajActivity.this, WebViewActivity.class)
                                .putExtra("URL","http://khannagems.com/index.php/gem-stones/pukhraj.html")
                                .putExtra("parent","PukhrajActivity")
                );
                return true;

            case tech.iosd.gemselections.R.id.ac_natural_pukhraj:
                display_image("images/lab-certificate.jpg","Natural Pukhraj");
                break;

            case tech.iosd.gemselections.R.id.ac_heated_pukhraj:
                display_image("images/Heated-Sapphire.jpg","Heated Pukhraj");
                break;

            case tech.iosd.gemselections.R.id.ac_treated_pukhraj:
                display_image("images/Treated-Sapphire.jpg","Treated Neelam");
                break;

            case tech.iosd.gemselections.R.id.ac_pukhraj_astro:
                    Fragment fragment = new PukhrajAstro();
                if(fragment!=null){
                    getFragmentManager().beginTransaction()
                            .replace(tech.iosd.gemselections.R.id.pukhraj_container, fragment)
                            .commit();
                    View targetView = findViewById(tech.iosd.gemselections.R.id.pukhraj_container);
                    targetView.getParent().requestChildFocus(targetView, targetView);
                }
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void display_image(String url, String title) {

        Dialog dialog = new Dialog(PukhrajActivity.this);
        dialog.setContentView(tech.iosd.gemselections.R.layout.dialog_display_images);
        dialog.setTitle(title);

        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(dialog.getWindow().getAttributes());

        layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
        layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT;

        dialog.show();
        dialog.getWindow().setAttributes(layoutParams);

        ImageView iv = (ImageView)dialog.findViewById(tech.iosd.gemselections.R.id.image_here);
        final InputStream in;
        img = null;
        try {
            in = getAssets().open(url);
            img = BitmapFactory.decodeStream(in);
            iv.setImageBitmap(img);

        } catch (IOException e) {
            e.printStackTrace();
        }

        final FloatingActionButton save = (FloatingActionButton)dialog.findViewById(tech.iosd.gemselections.R.id.fab_save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (ContextCompat.checkSelfPermission(getApplicationContext(),
                        android.Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(PukhrajActivity.this,
                            new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
                }else{
                    save_image();
                }
            }
        });
    }

    private void save_image(){
        final String filePath = Environment.getExternalStorageDirectory().toString();

        File dir = new File(filePath + "/gemselections_images");
        dir.mkdirs();

        Random generate = new Random();
        int n = 10000;
        n = generate.nextInt(n);

        String fName = "Image-" + n + ".jpg";

        File file = new File(dir, fName);
        if (file.exists()) {
            n++;
            fName = "Image-" + n*10 + ".jpg";
            file = new File(dir, fName);
        }

        try {
            FileOutputStream out = new FileOutputStream(file);
            img.compress(Bitmap.CompressFormat.JPEG, 90, out);
            out.flush();
            out.close();
            final File finalFile = file;
            new AlertDialog.Builder(PukhrajActivity.this)
                    .setTitle("Image Saved Successfully")
                    .setIcon(tech.iosd.gemselections.R.drawable.ic_save)
                    .setMessage("Image saved at: " + file.getAbsolutePath())
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
                            intent.setDataAndType(Uri.parse("file://" + finalFile.getAbsolutePath()), "image/*");
                            startActivity(intent);
                        }
                    })
                    .create().show();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(PukhrajActivity.this, "Could not save image", Toast.LENGTH_SHORT).show();
        } catch (NullPointerException e) {
            Toast.makeText(PukhrajActivity.this, "Could not save image", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(tech.iosd.gemselections.R.menu.pukhraj_menu, menu);
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == RECOVERY_REQUEST) {

            getYouTubePlayerProvider().initialize(DEVELOPER_KEY, this);
        }
        if(requestCode == 1){
            save_image();
        }
    }

    protected YouTubePlayer.Provider getYouTubePlayerProvider() {
        return playerView;
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        if(!b){
            youTubePlayer.cueVideo("qOPYGLh4OkM");
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
            youTubeInitializationResult.getErrorDialog(PukhrajActivity.this, RECOVERY_REQUEST).show();
        } else {
            String error = String.format(getString(tech.iosd.gemselections.R.string.player_error), youTubeInitializationResult.toString());
            Toast.makeText(PukhrajActivity.this, error, Toast.LENGTH_LONG).show();
        }
    }


    private void show_dialog(String title, int content) {
        Dialog dialog = new Dialog(PukhrajActivity.this);
        dialog.setTitle(title);
        dialog.setContentView(tech.iosd.gemselections.R.layout.dialog_bracelet);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(dialog.getWindow().getAttributes());

        layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
        layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT;

        dialog.show();
        dialog.getWindow().setAttributes(layoutParams);

        TextView textView  = (TextView)dialog.findViewById(tech.iosd.gemselections.R.id.content);
        textView.setText(getString(content));
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (parent == spinner) {
            Fragment fragment = null;
            switch (position) {
                case 0:
                    fragment = new PukhrajInfo();
                    first = true;
                    break;
                case 1:
                    fragment = new CeylonPukhraj();
                    break;
                case 2:
                    fragment = new BangkokPukhraj();
                    break;
                case 3:
                    fragment = new TreatedPukhraj();
                    break;
            }
            if (fragment != null) {
                getFragmentManager().beginTransaction()
                        .replace(tech.iosd.gemselections.R.id.pukhraj_container, fragment)
                        .commit();
                if(first){
                    first = false;
                }else {
                    View targetView = findViewById(tech.iosd.gemselections.R.id.pukhraj_container);
                    targetView.getParent().requestChildFocus(targetView, targetView);
                }
            }
        }

        if (parent == spinner1) {
            switch (position) {
                case 0:
                    break;
                case 1:
                    show_dialog("A Grade", tech.iosd.gemselections.R.string.ceylon_pukhraj1);
                    break;
                case 2:
                    show_dialog("B Grade", tech.iosd.gemselections.R.string.ceylon_pukhraj2);
                    break;
                case 3:
                    show_dialog("C Grade", tech.iosd.gemselections.R.string.ceylon_pukhraj3);
                    break;
                case 4:
                    show_dialog("D Grade", tech.iosd.gemselections.R.string.ceylon_pukhraj4);
                    break;
                case 5:
                    show_dialog("E Grade", tech.iosd.gemselections.R.string.ceylon_pukhraj5);
                    break;
                case 6:
                    show_dialog("F Grade", tech.iosd.gemselections.R.string.ceylon_pukhraj6);
                    break;
            }
        }
        if (parent == spinner2) {
            switch (position) {
                case 0:
                    break;
                case 1:
                    show_dialog("A Grade", tech.iosd.gemselections.R.string.bangkok_neelam1);
                    break;
                case 2:
                    show_dialog("B Grade", tech.iosd.gemselections.R.string.bangkok_neelam2);
                    break;
                case 3:
                    show_dialog("C Grade", tech.iosd.gemselections.R.string.bangkok_neelam3);
                    break;
                case 4:
                    show_dialog("D Grade", tech.iosd.gemselections.R.string.bangkok_neelam4);
                    break;
                case 5:
                    show_dialog("E Grade", tech.iosd.gemselections.R.string.bangkok_neelam5);
                    break;
            }
        }
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        parent.setSelection(0);
    }
}
