package com.example.nikhil3000.gemselections;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    private TextView LabCertificate, Membership;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LabCertificate = (TextView)findViewById(R.id.tv_labCertificate);

        LabCertificate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final PopupMenu menu = new PopupMenu(MainActivity.this, LabCertificate);
                menu.getMenuInflater().inflate(R.menu.popup_certificates, menu.getMenu());

                menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        String certificate_url="";

                        switch (item.getItemId()){
                            case R.id.popup_natural_sapphire:
                                certificate_url = "images/lab-certificate.jpg";
                                display_image(certificate_url);
                                break;

                            case R.id.popup_treated_sapphire:
                                certificate_url = "images/Treated-Sapphire.jpg";
                                display_image(certificate_url);
                                break;

                            case R.id.popup_heated_sapphire:
                                certificate_url = "images/Heated-Sapphire.jpg";
                                display_image(certificate_url);
                                break;
                        }
                        return false;
                    }
                });
                menu.show();
            }
        });

        Membership = (TextView)findViewById(R.id.tv_membership);

        Membership.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final PopupMenu menu = new PopupMenu(MainActivity.this, Membership);
                menu.getMenuInflater().inflate(R.menu.popup_membership, menu.getMenu());

                menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        String certificate_url="";

                        switch (item.getItemId()){
                            case R.id.popup_aima:
                                certificate_url = "images/all-india-management.jpg";
                                display_image(certificate_url);
                                break;

                            case R.id.popup_idi:
                                certificate_url = "images/indian-diamond-institute.jpg";
                                display_image(certificate_url);
                                break;

                            case R.id.popup_sgi:
                                certificate_url = "images/surat-gemology-institute.jpg";
                                display_image(certificate_url);
                                break;
                        }
                        return false;
                    }
                });
                menu.show();
            }
        });

        ImageView cover_pic = (ImageView)findViewById(R.id.iv_home_);

        try {
            InputStream in = getAssets().open("images/Gemselection.jpg");
            Drawable drawable = Drawable.createFromStream(in,null);
            cover_pic.setImageDrawable(drawable);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void display_image(String _url) {
        Dialog dialog = new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.dialog_display_images);

        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(dialog.getWindow().getAttributes());

        layoutParams.width = WindowManager.LayoutParams.WRAP_CONTENT;
        layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT;

        dialog.show();
        dialog.getWindow().setAttributes(layoutParams);

        ImageView iv = (ImageView)dialog.findViewById(R.id.image_here);
        InputStream in = null;

        try {
            in = getAssets().open(_url);
            Drawable drawable = Drawable.createFromStream(in,null);
            iv.setImageDrawable(drawable);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void payment_method_click(View V){

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
    }

    public void about_shipment_click(View v){
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
    }

    public void astrology_click(View v){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("http://www.astropankaj.com"));
        startActivity(Intent.createChooser(intent, "Open www.astropankaj.com via..."));
    }

    public void puja_click(View v){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("http://www.vedmandirtrust.com"));
        startActivity(Intent.createChooser(intent, "Open Ved Mandir Trust via..."));
    }

    public void testimonials_click(View v){
        display_image("images/testimonials.jpg");
    }
}
