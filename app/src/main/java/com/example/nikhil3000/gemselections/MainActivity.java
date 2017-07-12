package com.example.nikhil3000.gemselections;

import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nikhil3000.gemselections.Adapters.ConnectAdapter;
import com.example.nikhil3000.gemselections.AuthRelated.LoginActivity;
import com.example.nikhil3000.gemselections.Handicrafts.Handicrafts;
import com.example.nikhil3000.gemselections.Ittar.Ittar;
import com.example.nikhil3000.gemselections.Jewellery.Jewellery;
import com.example.nikhil3000.gemselections.Lists.ConnectOptions;
import com.example.nikhil3000.gemselections.Rudraksha.Rudraksha;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private Bitmap img;

    private View header;
    private TextView _displayName, _displayEmail;
    private Button _login, _logout;

    private boolean ISHOMESHOWN;
    private FirebaseAuth mAuth;
    private FirebaseUser mUser;

    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fragmentManager = getSupportFragmentManager();

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
            if(fragmentManager.getBackStackEntryCount()!=0){
                fragmentManager.popBackStack();
                if(ISHOMESHOWN){
                    new AlertDialog.Builder(MainActivity.this)
                            .setMessage("Do you really want to exit?")
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    finish();
                                }
                            })
                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                    display_selected_item(R.id.nav_home);
                                }
                            })
                            .setTitle("Exit App")
                            .create().show();
                }else
                {
                    display_selected_item(R.id.nav_home);
                }
            }else {
                super.onBackPressed();
            }
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
                            new Intent(MainActivity.this, FAQsActivity.class)
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
                                display_selected_item(R.id.nav_home);
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
        img = null;
        try {
            in = getAssets().open(url);
            img = BitmapFactory.decodeStream(in);
            iv.setImageBitmap(img);

        } catch (IOException e) {
            e.printStackTrace();
        }

        final FloatingActionButton save = (FloatingActionButton)dialog.findViewById(R.id.fab_save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (ContextCompat.checkSelfPermission(getApplicationContext(),
                        android.Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(MainActivity.this,
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

        final File file = new File(dir, fName);
        if (file.exists()) {
            file.delete();
        }

        try {
            FileOutputStream out = new FileOutputStream(file);
            img.compress(Bitmap.CompressFormat.JPEG, 90, out);
            out.flush();
            out.close();
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Image Saved Successfully")
                    .setIcon(R.drawable.ic_save)
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
                            intent.setDataAndType(Uri.parse("file://" + file.getAbsolutePath()), "image/*");
                            startActivity(intent);
                        }
                    })
                    .create().show();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(MainActivity.this, "Could not save image", Toast.LENGTH_SHORT).show();
        } catch (NullPointerException e) {
            Toast.makeText(MainActivity.this, "Could not save image", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 1: {

                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                {
                    save_image();
                }else {
                    Toast.makeText(MainActivity.this, "Permission denied to read your External storage", Toast.LENGTH_SHORT).show();
                }
                return;
            }
        }
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

        ISHOMESHOWN = id == R.id.nav_home;
        switch (id){
            case R.id.nav_home:
                    fragment = new HomeFragment();
                ISHOMESHOWN =true;
                break;

            case R.id.nav_rudraksha:
                    startActivity(
                            new Intent(MainActivity.this, Rudraksha.class)
                    );
                    finish();
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
                finish();
                break;

            case R.id.nav_birthstone:
                    fragment = new MainBirthstoneFragment();
                break;

            case R.id.nav_semi_precious_gems:
                    fragment = new MainSemiPreciousGems();
                break;

            case R.id.nav_triangular_gems:
                    fragment = new TriangularGemsFragment();
                break;

            case R.id.nav_cabochon_gems:
                    fragment = new MainCabochonFragment();
                break;

            case R.id.nav_faq:

                startActivity(
                        new Intent(MainActivity.this, FAQsActivity.class)
                );

                break;

            case R.id.nav_yantra:
                    fragment = new MainYantraFragment();
                break;

            case R.id.nav_diamond:
                    fragment = new MainDiamondFragment();
                break;

            case R.id.nav_jewel:
                startActivity(
                        new Intent(MainActivity.this, Jewellery.class)
                );
                finish();
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

            case R.id.nav_connect:
                connect_with_us();
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
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container, fragment);
            fragmentTransaction.addToBackStack("Main");
            fragmentTransaction.commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }

    private void connect_with_us() {

        String[] _options = {
                "Facebook",
                "Twitter",
                "Instagram",
                "Youtube",
                "Linked In",
                "Flickr",
                "Snapchat",
                "Pinterest",
                "Tumblr",
                "Stuble upon",
                "Google Plus"
        };

        String[] _image = {
                "icons/fb.png",
                "icons/twitter.png",
                "icons/insta.jpg",
                "icons/youtube.png",
                "icons/linkedin.png",
                "icons/flickr.png",
                "icons/snapchat.png",
                "icons/pinterest-.png",
                "icons/tumblr.png",
                "icons/stumbleupon.png",
                "icons/Google-plus-icon.png"
        };

        String[] _links = {
                "https://www.facebook.com/GemSelections.in/",
                "https://www.twitter.com/Gem_Selections",
                "https://www.instagram.com/gemselections/",
                "https://www.youtube.com/channel/UCt3nkzLE2NKMuwu3V0KQtbw",
                "https://www.linkedin.com/company/khanna-gems-pvt.-limited",
                "https://www.flickr.com/photos/gemselections/",
                "snapchat",
                "https://www.pinterest.com/gemselections01/",
                "https://gemselections.tumblr.com/",
                "https://www.stumbleupon.com/stumbler/GemSelections",
                "https://plus.google.com/+GemSelectionsNewDelhi"
        };

        Dialog dialog = new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.dialog_connect);
        dialog.setTitle("Connect With Us");
        WindowManager.LayoutParams params = new WindowManager.LayoutParams();
        params.copyFrom(dialog.getWindow().getAttributes());
        params.width = (WindowManager.LayoutParams.MATCH_PARENT);
        params.height = (WindowManager.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setAttributes(params);
        dialog.show();

        RecyclerView view = (RecyclerView)dialog.findViewById(R.id.connect_recycler);
        view.setHasFixedSize(true);
        view.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        view.addItemDecoration(new DividerItemDecoration(MainActivity.this, DividerItemDecoration.VERTICAL));;

        List<ConnectOptions> optionses = new ArrayList<>();
        for(int i =0; i<11;i++){
            ConnectOptions options = new ConnectOptions(_image[i],_options[i],_links[i]);
            optionses.add(options);
        }

        ConnectAdapter adapter = new ConnectAdapter(optionses, MainActivity.this);
        view.setAdapter(adapter);
    }
}
