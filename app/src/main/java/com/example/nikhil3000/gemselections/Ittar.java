package com.example.nikhil3000.gemselections;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.TextView;

public class Ittar extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ittar);

        display_selected_item(R.id.ac_ittr_about);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        display_selected_item(item.getItemId());

        return super.onOptionsItemSelected(item);
    }

    private void display_selected_item(int itemId) {

        Fragment fragment = null;

        switch (itemId){
            case R.id.ac_ittr_about:
                        fragment = new IttrAboutFragment();
                break;

            case R.id.ac_ittr_buy:
                    startActivity(
                            Intent.createChooser(
                                    new Intent(Intent.ACTION_VIEW)
                                            .setData(Uri.parse("http://www.khannagems.com"))
                                    , "Open Shopping Page via..."
                            )
                    );
                break;

            case R.id.ac_ittr_types:
                        fragment = new IttrTypesFragment();
                break;

            case R.id.ac_ittr_storage:
                        new AlertDialog.Builder(Ittar.this)
                                .setTitle("How To Store?")
                                .setIcon(R.drawable.ic_ittr)
                                .setMessage(getString(R.string.ittr_storage))
                                .setNeutralButton("Ok", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                })
                                .create().show();
                break;

            case R.id.ac_ittr_uses:
                show_dialog("Uses Of Ittar", R.string.ittr_uses);
                break;
        }

        if(fragment!=null){
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.ittr_container, fragment);
            fragmentTransaction.addToBackStack("Ittar");
            fragmentTransaction.commit();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        getSupportFragmentManager().popBackStack("Ittar", 0);
    }

    private void show_dialog(String title, int content) {
        Dialog dialog = new Dialog(Ittar.this);
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
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.ittar, menu);
        return super.onCreateOptionsMenu(menu);
    }

}
