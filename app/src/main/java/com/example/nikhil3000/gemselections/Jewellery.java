package com.example.nikhil3000.gemselections;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class Jewellery extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jewellery);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        display_selected_item(R.id.nav_silver_pendant);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
            getSupportFragmentManager().popBackStack("Jewellery", 0);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.jewellery, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.ac_jewel_buy) {
            startActivity(
                    Intent.createChooser(
                            new Intent(Intent.ACTION_VIEW)
                                    .setData(Uri.parse("http://khannagems.com")),
                            "Open Shopping Page Via..."
                    )
            );
            return true;
        }

        return super.onOptionsItemSelected(item);
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

            case R.id.nav_silver_pendant:
                    fragment = new SilverPendantFragment();
                break;

            case R.id.nav_silver_earring:
                    fragment = new SilverEarringFragment();
                break;

            case R.id.nav_silver_set:
                    fragment = new SilverSetFragment();
                break;

            case R.id.nav_silver_broaches:
                    fragment = new SilverBroachesFragment();
                break;

            case R.id.nav_silver_bracelets:
                    fragment = new SilverBraceletsFragment();
                break;

            case R.id.nav_beads_precious:
                    fragment = new BeadsPreciousFragment();
                break;

            case R.id.nav_beads_semi_precious:
                    fragment = new BeadsSemiPreFragment();
                break;

            case R.id.nav_carved_gemstone:
                    fragment = new CarvedGemstoneFragment();
                break;

        }
        if(fragment!=null){
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.jewellery_container, fragment);
            fragmentTransaction.addToBackStack("Jewellery");
            fragmentTransaction.commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }
}
