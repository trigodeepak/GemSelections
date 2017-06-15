package com.example.nikhil3000.gemselections;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView cover_pic = (ImageView)findViewById(R.id.iv_home_);
        try {
            InputStream in = getAssets().open("images/Gemselection.jpg");
            Drawable drawable = Drawable.createFromStream(in,null);
            cover_pic.setImageDrawable(drawable);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
