package com.example.lamafirstproject;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class kay extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex);

        WebView webView = findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true); // Enable JavaScript
        webView.getSettings().setUserAgentString("Mozilla/5.0"); // Set User-Agent

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                super.onReceivedError(view, errorCode, description, failingUrl);
                // Log or handle the error here
            }
        });

        // Load the web page in the WebView
        webView.loadUrl("http://www.bestcolleges.com/bootcamps");
    }
}
