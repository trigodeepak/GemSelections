package tech.iosd.gemselections.MainContent;

import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.urbanairship.Autopilot;

import java.util.ArrayList;
import java.util.List;

import tech.iosd.gemselections.Adapters.ConnectAdapter;
import tech.iosd.gemselections.Astro_RemediesFragment;
import tech.iosd.gemselections.AuthRelated.LoginActivity;
import tech.iosd.gemselections.DataProviders.ConnectOptions;
import tech.iosd.gemselections.Handicrafts.Handicrafts;
import tech.iosd.gemselections.Ittar.Ittar;
import tech.iosd.gemselections.JewelleryAlpha.JewelleryAlpha;
import tech.iosd.gemselections.R;
import tech.iosd.gemselections.Rudraksha.Rudraksha;
import tech.iosd.gemselections.Utils.SharedPreferencesUtils;
import tech.iosd.gemselections.Utils.WebViewActivity;
import tech.iosd.gemselections.abhimantrit.Abhimantrit;

public class MyAccountActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    int k = 0;
    private Bitmap img;

    private View header;
    private TextView _displayName, _displayEmail;
    private Button _login, _logout;
    private boolean ISHOMESHOWN;
    private FragmentManager fragmentManager;

    private String mUser = "Deepak";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_account);

        Autopilot autopilot = new Autopilot();
        autopilot.allowEarlyTakeOff(getApplicationContext());

        Toolbar toolbar = (Toolbar) findViewById(tech.iosd.gemselections.R.id.toolbar);
        setSupportActionBar(toolbar);

        fragmentManager = getSupportFragmentManager();



        final DrawerLayout drawer = (DrawerLayout) findViewById(tech.iosd.gemselections.R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, tech.iosd.gemselections.R.string.navigation_drawer_open, tech.iosd.gemselections.R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(tech.iosd.gemselections.R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        header = navigationView.inflateHeaderView(R.layout.nav_header_main);
        header.setPadding(10, 10, 10, 10);
        _displayName = (TextView) header.findViewById(tech.iosd.gemselections.R.id.DisplayName);
        _displayEmail = (TextView) header.findViewById(tech.iosd.gemselections.R.id.DisplayEmail);

        display_selected_item(tech.iosd.gemselections.R.id.nav_home);

    }
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();

        display_selected_item(id);

        return true;
    }

    private void display_selected_item(int id) {
        ISHOMESHOWN = id == tech.iosd.gemselections.R.id.nav_home;
        Log.e("Print id",String.valueOf(id));

    }
}
