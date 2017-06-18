package com.example.nikhil3000.gemselections;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class FAQs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faqs);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
