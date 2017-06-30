package com.example.nikhil3000.gemselections;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class MoongaActivity extends AppCompatActivity implements View.OnClickListener{

    private Button buy_coral;
    private ImageView italian, srilankan, jap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moonga);

        buy_coral = (Button)findViewById(R.id.buy_coral);
        buy_coral.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(
                                new Intent(MoongaActivity.this, WebViewActivity.class)
                                        .putExtra("URL","http://khannagems.com/index.php/gem-stones/moonga.html")
                                        .putExtra("parent","MoongaActivity")
                        );
                    }
                }
        );

        italian  = (ImageView)findViewById(R.id.italiancoral);
        italian.setOnClickListener(this);
        jap = (ImageView)findViewById(R.id.japcoral);
        jap.setOnClickListener(this);
        srilankan = (ImageView)findViewById(R.id.srilankancoral);
        srilankan.setOnClickListener(this);

        InputStream is;

        try{
            is = getAssets().open("images/precious-gems/italian_Coral.jpg");
            italian.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getAssets().open("images/precious-gems/japanese-coral.jpg");
            jap.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getAssets().open("images/precious-gems/sri-lankan-coral.jpg");
            srilankan.setImageBitmap(BitmapFactory.decodeStream(is));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View v) {

        if(v == italian){
            show_dialog("ITALIAN MOONGA | CORAL", R.string.moongaitalian1, R.string.moongaitalian2);
        }
        if(v == jap){
            show_dialog("JAPANESE MOONGA | CORAL", R.string.moongajap1, R.string.moongajap2);
        }
        if(v == srilankan){
            show_dialog("SRI LANKAN MOONGA | CORAL", R.string.moongasrilanka1, R.string.moongasrilanka2);
        }
    }

    private void show_dialog(String title, int content1, int content2){
        Dialog dialog = new Dialog(MoongaActivity.this);
        dialog.setContentView(R.layout.dialog_moonga_layout);
        dialog.setTitle(title);

        WindowManager.LayoutParams params = new WindowManager.LayoutParams();
        params.copyFrom(dialog.getWindow().getAttributes());
        params.width = WindowManager.LayoutParams.MATCH_PARENT;
        params.height = WindowManager.LayoutParams.WRAP_CONTENT;

        dialog.show();
        dialog.getWindow().setAttributes(params);

        TextView t1, t2;
        t1 = (TextView)dialog.findViewById(R.id._moongatext1);
        t2 = (TextView)dialog.findViewById(R.id._moongatext2);

        t1.setText(getString(content1));
        t2.setText(getString(content2));
    }
}
