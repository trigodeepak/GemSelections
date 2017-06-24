package com.example.nikhil3000.gemselections;

import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private View header;
    private TextView _displayName, _displayEmail;
    private Button _login, _logout;

    private FirebaseAuth mAuth;
    private FirebaseUser mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        header = navigationView.inflateHeaderView(R.layout.nav_header_main);
        _displayName = (TextView)header.findViewById(R.id.DisplayName);
        _displayEmail = (TextView)header.findViewById(R.id.DisplayEmail);
        _login = (Button)header.findViewById(R.id.main_login);
        _logout = (Button)header.findViewById(R.id.main_logout);
        _logout.setEnabled(false);

        _logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();
                Intent intent = getIntent();
                finish();
                startActivity(intent);
            }
        });
        _login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(
                        new Intent(MainActivity.this, LoginActivity.class)
                );
            }
        });

        if(mUser != null){
            _displayName.setText(mUser.getDisplayName());
            _displayEmail.setText(mUser.getEmail());
            _login.setEnabled(false);
            _logout.setEnabled(true);
        }else {
            if(!_login.isEnabled()){
                _login.setEnabled(true);
            }
            if(_logout.isEnabled()){
                _logout.setEnabled(false);
            }
        }


        display_selected_item(R.id.nav_home);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
            getSupportFragmentManager().popBackStack("MainActivity", 0);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.ac_buy_now:

                startActivity(
                        new Intent(MainActivity.this, WebViewActivity.class)
                                .putExtra("URL", "http://khannagems.com")
                                .putExtra("parent", "MainActivity")

                );
                break;

            case R.id.ac_payment_methods:
                payment_options();
                break;

            case R.id.ac_natural_sapphire:
                    display_image("images/lab-certificate.jpg", "Natural Sapphire");
                break;
            case R.id.ac_treated_sapphire:
                    display_image("images/Treated-Sapphire.jpg", "Treated Sapphire");
                break;
            case R.id.ac_heated_sapphire:
                display_image("images/Heated-Sapphire.jpg", "Heated Sapphire");
                break;
            case R.id.ac_testimonials:
                display_image("images/testimonials.jpg", "Testimonials");
                break;
            case R.id.ac_shipment:
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Deliver in World")
                        .setIcon(R.drawable.ic_delivery)
                        .setMessage(getString(R.string.delivery_message))
                        .setNeutralButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .create().show();
                break;

            case R.id.ac_aima:
                display_image("images/all-india-management.jpg", "ALL INDIA MANAGEMENT ASSOCIATION");
                break;

            case R.id.ac_idi:
                display_image("images/indian-diamond-institute.jpg", "INDIAN DIAMOND INSTITUTE");
                break;

            case R.id.ac_sgi:
                display_image("images/surat-gemology-institute.jpg", "SURAT GEMOLOGY INSTITUTE");
                break;

            case R.id.ac_astro:
                startActivity(
                        new Intent(MainActivity.this, WebViewActivity.class)
                                .putExtra("URL", "http://www.astropankaj.com")
                                .putExtra("parent", "MainActivity")
                );
                break;

            case R.id.ac_puja:
                startActivity(
                        new Intent(MainActivity.this, WebViewActivity.class)
                                .putExtra("URL", "http://www.vedmandirtrust.com")
                                .putExtra("parent", "MainActivity")
                );

                break;

            case R.id.ac_faq:
                    startActivity(
                            new Intent(MainActivity.this, FAQs.class)
                    );
                break;

            case R.id.ac_about_us:
                    display_selected_item(R.id.ac_about_us);
                break;

            case R.id.ac_management:
                    display_selected_item(R.id.ac_management);
                break;

            case R.id.ac_pankaj:
                    dialog_pankaj();
                break;

            case R.id.ac_khanna_gems:
                    dialog_khanna_gems();
                break;

            case R.id.ac_sonipat:
                startActivity(
                        new Intent(MainActivity.this, WebViewActivity.class)
                                .putExtra("URL", "http://en.wikipedia.org/wiki/Sonipat")
                                .putExtra("parent", "MainActivity")
                );
                break;

            case R.id.ac_exit:

                new AlertDialog.Builder(MainActivity.this)
                        .setMessage("Do you really want to exit?")
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        })
                        .create().show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void dialog_khanna_gems() {
        Dialog dialog = new Dialog(MainActivity.this);
        dialog.setTitle("Khanna Gems Pvt. Ltd.");
        dialog.setContentView(R.layout.dialog_khanna_gems);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(dialog.getWindow().getAttributes());

        layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
        layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT;

        dialog.show();
        dialog.getWindow().setAttributes(layoutParams);
    }

    private void dialog_pankaj() {
        Dialog dialog = new Dialog(MainActivity.this);
        dialog.setTitle("Sh. Pankaj Khanna");
        dialog.setContentView(R.layout.dialog_pankaj_khanna);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(dialog.getWindow().getAttributes());

        layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
        layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT;

        dialog.show();
        dialog.getWindow().setAttributes(layoutParams);

        ImageView img = (ImageView)dialog.findViewById(R.id.dialog_pankaj_image);
        InputStream is;
        try{
            is = getAssets().open("images/pankaj-khanna.jpg");
            img.setImageBitmap(BitmapFactory.decodeStream(is));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private void payment_options() {
        final Dialog dialog = new Dialog(MainActivity.this);
        dialog.setTitle("$ Payment Methods");
        dialog.setContentView(R.layout.dialog_payment_method);

        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(dialog.getWindow().getAttributes());

        layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
        layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT;

        dialog.show();
        dialog.getWindow().setAttributes(layoutParams);

        Button OK = (Button)dialog.findViewById(R.id.ok_button);
        OK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        Button Buy = (Button)dialog.findViewById(R.id.buy);
        Buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(
                        new Intent(MainActivity.this, WebViewActivity.class)
                                .putExtra("URL", "http://www.khannagems.com")
                                .putExtra("parent", "MainActivity")
                );
            }
        });
    }

    private void display_image(String url, String title) {

        Dialog dialog = new Dialog(MainActivity.this);
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
                        fos.flush();
                        fos.close();
                        final String path = file.getAbsolutePath();
                        new AlertDialog.Builder(MainActivity.this)
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();

        display_selected_item(id);

        return true;
    }

    private void display_selected_item(int id) {

        Fragment fragment = null;

        switch (id){
            case R.id.nav_home:
                    fragment = new HomeFragment();
                break;

            case R.id.nav_rudraksha:
                    startActivity(
                            new Intent(MainActivity.this, Rudraksha.class)
                    );
                break;
            case R.id.nav_ittar:
                startActivity(
                        new Intent(MainActivity.this, Ittar.class)
                );
                break;

            case R.id.nav_japamala:
                    fragment = new MainJapaMalaFragment();
                break;

            case R.id.nav_stoneidols:
                    fragment = new MainStoneIdolFragment();
                break;

            case R.id.nav_kavach:
                    fragment = new MainKavachFragment();
                break;

            case R.id.nav_saphatic:
                    fragment = new MainSphatikFragment();
                break;

            case R.id.nav_handicrafts:
                startActivity(
                        new Intent(MainActivity.this, Handicrafts.class)
                );
                break;

            case R.id.nav_birthstone:
                    fragment = new MainBirthstoneFragment();
                break;

            case R.id.nav_semi_precious_gems:
                    fragment = new MainSemiPreciousGems();
                break;

            case R.id.nav_precious_gems:
                    Toast.makeText(getApplicationContext(), "Section Not Found! :/", Toast.LENGTH_SHORT).show();
                break;

            case R.id.nav_yantra:
                    Toast.makeText(getApplicationContext(), "Section Not Found! :/", Toast.LENGTH_SHORT).show();
                break;

            case R.id.nav_diamond:
                    Toast.makeText(getApplicationContext(), "Section Not Found! :/", Toast.LENGTH_SHORT).show();
                break;

            case R.id.nav_jewel:
                startActivity(
                        new Intent(MainActivity.this, Jewellery.class)
                );
                break;

            case R.id.nav_call:

                new AlertDialog.Builder(MainActivity.this)
                        .setMessage("Which number to open in dialer?")
                        .setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .setPositiveButton("+919213932017", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(Intent.ACTION_DIAL);
                                intent.setData(Uri.parse("tel:" + Uri.encode("+919213932017")));
                                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(intent);
                            }
                        })
                        .setNegativeButton("+919999136878", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(Intent.ACTION_DIAL);
                                intent.setData(Uri.parse("tel:" + Uri.encode("+919999136878")));
                                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(intent);
                            }
                        })
                        .create().show();

                break;

            case R.id.nav_mail:
                String uritext = "mailto:care@khannagems.com";
                Uri uri = Uri.parse(uritext);
                Intent intent1 = new Intent(Intent.ACTION_SENDTO);
                intent1.setData(uri);
                startActivity(Intent.createChooser(intent1, "Mail Via..."));
                break;

            case R.id.nav_visit:
                    fragment = new MainVisitUsFragment();
                break;

            case R.id.nav_fb_page:
                    startActivity(
                            new Intent(MainActivity.this, WebViewActivity.class)
                                    .putExtra("URL", "http://www.facebook.com/GemSelections.in/")
                                    .putExtra("parent", "MainActivity")
                    );
                break;

            case R.id.ac_about_us:
                    fragment = new MainAboutUsFragment();
                break;

            case R.id.ac_management:
                    fragment = new MainManagementFragment();
                break;

            case R.id.nav_share:
                Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String body = getString(R.string.Share);
                sharingIntent.putExtra(Intent.EXTRA_SUBJECT,"Get Gemselections on your phone!!!");
                sharingIntent.putExtra(Intent.EXTRA_TEXT, body);
                startActivity(Intent.createChooser(sharingIntent,"Share Via.."));
                break;

            case R.id.nav_rate:

                Uri uri1 = Uri.parse("market://details?id=tech.iosd.gemselections");
                Intent play_store = new Intent(Intent.ACTION_VIEW);
                play_store.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY|Intent.FLAG_ACTIVITY_NEW_DOCUMENT|Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
                try {
                    play_store.setData(uri1);
                    startActivity(play_store);
                }catch (ActivityNotFoundException e){
                    uri = Uri.parse("http://play.google.com/store/apps/details?id=tech.iosd.gemselections");
                    play_store.setData(uri);
                    startActivity(play_store);
                }

                break;
        }

        if(fragment!=null){
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.container, fragment);
            fragmentTransaction.addToBackStack("MainActivity");
            fragmentTransaction.commit();

            //getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment)
            //        .commit();

            //int homeFragmentIdentifier = fragmentTransaction.commit();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }
}
