package tech.iosd.gemselections.MainContent;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

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
