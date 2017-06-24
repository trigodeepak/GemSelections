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

public class Handicrafts extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handicrafts);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        display_selected_item(R.id.nav_hand_pots);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.ac_hand_buy:
                    startActivity(
                            new Intent(Handicrafts.this, WebViewActivity.class)
                                    .putExtra("URL","http://khannagems.com")
                                    .putExtra("parent","Handicrafts")
                    );
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.handicraft, menu);
        return true;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
            getSupportFragmentManager().popBackStack("Handicraft", 0);
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item){
        int id = item.getItemId();

        display_selected_item(id);

        return true;
    }

    private void display_selected_item(int id) {

        Fragment fragment = null;

        switch (id){
            case R.id.nav_hand_pots:
                fragment = new HandPotsFragment();
                break;
            case R.id.nav_hand_clocks:
                fragment = new HandClocksFragment();
                break;
            case R.id.nav_hand_plates:
                fragment = new HandPlatesFragment();
                break;
            case R.id.nav_hand_gifts:
                fragment = new HandGiftsFragment();
                break;
            case R.id.nav_hand_spiritual:
                fragment = new HandSpiritualFragment();
                break;
            case R.id.nav_hand_spi_gifts:
                fragment = new HandSpiGiftsFragment();
                break;
            case R.id.nav_hand_black:
                fragment = new HandBlackFragment();
                break;
            case R.id.nav_hand_soap:
                fragment = new HandSoapFragment();
                break;
            case R.id.nav_hand_table:
                fragment = new HandTableFragment();
                break;
        }

        if(fragment!=null){
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.handicraft_container, fragment);
            fragmentTransaction.addToBackStack("Handicrafts");
            fragmentTransaction.commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }
}
