package tech.iosd.gemselections.MainContent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import tech.iosd.gemselections.R;

public class FaqIntentAcitivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq_intent_acitivity);
        TextView title, text;
        title = (TextView) findViewById(R.id.faq_intent_tittle);
        text = (TextView) findViewById(R.id.faq_intent_text);

        Bundle extras = getIntent().getExtras();

        title.setText(getResources().getString(extras.getInt("title")));
        text.setText(getResources().getString(extras.getInt("text")));

    }
}
