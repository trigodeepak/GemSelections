package tech.iosd.gemselections.MainContent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;

import tech.iosd.gemselections.JewelleryAlpha.JewelleryAlpha;
import tech.iosd.gemselections.R;

public class ActivityForDiamonds extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_for_diamonds);



        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.container_for_diamond_fragment, new MainDiamondFragment())
                .commit();
    }
}
