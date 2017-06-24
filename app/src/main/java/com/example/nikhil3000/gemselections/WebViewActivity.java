package com.example.nikhil3000.gemselections;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class WebViewActivity extends AppCompatActivity {

    private WebView webView;
    private String _parent;
    private Class parent;
    private Toolbar toolbar;
    private String _URL;
    private ProgressDialog dialog;
    private boolean loadingFinished = true;
    private boolean redirect = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        dialog = new ProgressDialog(WebViewActivity.this);
        dialog.setIndeterminate(false);
        dialog.setMessage("Loading...");

        webView = (WebView)findViewById(R.id.webview);
        webView.setWebViewClient(new WebViewClient(){

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String urlNew) {
                if(!loadingFinished){
                    redirect = true;
                }
                loadingFinished = false;
                view.loadUrl(urlNew);
                getSupportActionBar().setTitle(urlNew);
                return true;
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                loadingFinished = false;
                if(!dialog.isShowing()){
                    dialog.show();
                }
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                if(!redirect){
                    loadingFinished = true;
                }
                getSupportActionBar().setTitle(url);
                if(loadingFinished && !redirect){
                    dialog.dismiss();
                }else {
                    redirect = false;
                }
            }
        });
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setJavaScriptEnabled(true);

        if(getIntent().getExtras() != null){
            _URL = getIntent().getStringExtra("URL");
            _parent = getIntent().getStringExtra("parent");
            try {
                parent = Class.forName(_parent);
            } catch (ClassNotFoundException e) {
                parent = MainActivity.class;
                e.printStackTrace();
            }
        }else {
             Snackbar.make(getCurrentFocus(), "Valid URL not found. Opening google search", Snackbar.LENGTH_SHORT).show();
            _URL = "http://www.google.co.in";
            parent = MainActivity.class;
        }
        webView.loadUrl(_URL);
    }

    @Override
    public void onBackPressed() {
        if(webView.canGoBack()) {
            webView.goBack();
        }
        else{
            super.onBackPressed();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){

            case R.id.home:
                //test
                Toast.makeText(getApplicationContext(), "Home CLICKED", Toast.LENGTH_SHORT).show();
                    startActivity(
                            new Intent(WebViewActivity.this, parent)
                            .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_NEW_TASK)
                    );
                break;

            case R.id.reload_url:
                    webView.loadUrl(_URL);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.webview, menu);
        return true;
    }

}
