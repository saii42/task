package com.example.movie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewActivity extends AppCompatActivity {
    private WebView webView;
    private WebSettings webSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        webView = findViewById(R.id.wv_movie);
        webView.setWebViewClient(new WebViewClient()); //클릭시 새창 뜨지않게

        webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        Intent intent = getIntent();
        String link = intent.getStringExtra("link");
        webView.loadUrl(link);



    }
}