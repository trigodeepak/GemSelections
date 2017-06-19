package com.example.nikhil3000.gemselections;

import android.app.Dialog;
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
import android.view.WindowManager;

public class Rudraksha extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rudraksha);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        display_selected_item(R.id.nav_rud_home);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
            getSupportFragmentManager().popBackStack("Rudraksha", 0);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.rudraksha, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.ac_rud_buy) {
            startActivity(
                    Intent.createChooser(
                            new Intent(Intent.ACTION_VIEW)
                                    .setData(Uri.parse("http://khannagems.com/index.php/rudraksha.html")),
                            "Open Shopping Page via...."
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

        switch (id) {

            case R.id.nav_rud_home:
                    fragment = new RudHomeFragment();
                break;
            case R.id.nav_rud_bead:
                    fragment = new RudBeadFragment();
                break;
            case R.id.nav_rud_mala:
                    fragment = new RudMalaFragment();
                break;
            case R.id.nav_rud_bracelet:
                    fragment = new RudBraceletFragment();
                break;
            case R.id.nav_rud_yugal:
                    fragment = new RudYugalFragment();
                break;
            case R.id.nav_rud_mantra:
                    show_dialog("RUDRAKSHA MANTRAS", R.layout.dialog_rudraksha_mantra);
                break;
            case R.id.nav_rud_how:
                    show_dialog("WEARING A RUDRAKSHA", R.layout.dialog_rudraksha_how);
                break;
            case R.id.nav_rud_authenticity:
                    show_dialog("AUTHENTICITY", R.layout.dialog_rudraksha_auth);
                break;
            case R.id.nav_rud_faq:
                    fragment = new RudFAQ();
                break;
        }

        if(fragment!=null){
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.rudraksha_container, fragment);
            fragmentTransaction.addToBackStack("Rudraksha");
            fragmentTransaction.commit();

            //getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment)
            //        .commit();

            //int homeFragmentIdentifier = fragmentTransaction.commit();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }

    private void show_dialog(String title, int layout) {

        Dialog dialog = new Dialog(Rudraksha.this);
        dialog.setTitle(title);
        dialog.setContentView(layout);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(dialog.getWindow().getAttributes());

        layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
        layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT;

        dialog.show();
        dialog.getWindow().setAttributes(layoutParams);
    }
}
