package com.example.nikhil3000.gemselections;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ScrollView;

public class FAQsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faqs);

        ScrollView scrollView = (ScrollView)findViewById(R.id.faq_scroll);
        scrollView.setBackground(getResources().getDrawable(R.drawable.back));

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
