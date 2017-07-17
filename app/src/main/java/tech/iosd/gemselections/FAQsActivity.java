package tech.iosd.gemselections;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ScrollView;

public class FAQsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(tech.iosd.gemselections.R.layout.activity_faqs);

        ScrollView scrollView = (ScrollView)findViewById(tech.iosd.gemselections.R.id.faq_scroll);
        scrollView.setBackground(getResources().getDrawable(tech.iosd.gemselections.R.drawable.back));

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
