package tech.iosd.gemselections;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

import tech.iosd.gemselections.MainContent.MainActivity;
import tech.iosd.gemselections.Utils.CheckFirstTime;
import tech.iosd.gemselections.Utils.InternetConnectivity;

public class Splash extends AppCompatActivity {

    private TextView Splash;
    private ImageView Logo;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(tech.iosd.gemselections.R.layout.activity_splash);
        CheckFirstTime firstTime = new CheckFirstTime();

        if(firstTime.isFirstTime(Splash.this)){
            new InternetConnectivity(Splash.this);
        }

        Splash = (TextView)findViewById(tech.iosd.gemselections.R.id.splash_appname);
        Logo = (ImageView)findViewById(tech.iosd.gemselections.R.id.splash_image);

        Splash.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/Raleway-Regular.ttf"));

        InputStream is;
        Bitmap img;

        try{
            is = getAssets().open("images/GSlogo.png");
            img = BitmapFactory.decodeStream(is);
            Logo.setImageBitmap(img);
        }catch (IOException e){
            e.printStackTrace();
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(Splash.this, MainActivity.class));
                finish();
            }
        },400);
    }
}
