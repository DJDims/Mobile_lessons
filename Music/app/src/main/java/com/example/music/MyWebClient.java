package com.example.music;

import android.graphics.Bitmap;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

public class MyWebClient extends WebViewClient {

    private EditText address_bar;

    public MyWebClient(EditText addressBar) {
        this.address_bar = addressBar;
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url)
    {
        Log.i("MyLog",
                "Click on any interlink on webview that time you got url :-" + url);
        address_bar.setText(url);
        return super.shouldOverrideUrlLoading(view, url);
    }
    // When page loading
    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon)
    {
        super.onPageStarted(view, url, favicon);
        Log.i("MyLog", "Your current url when webpage loading.." + url);
    }
    // When page load finish.
    @Override
    public void onPageFinished(WebView view, String url)
    {
        Log.i("MyLog",
                "Your current url when webpage loading.. finish" + url);
        super.onPageFinished(view, url);
    }
    @Override
    public void onLoadResource(WebView view, String url) {
        super.onLoadResource(view, url);
    }
}
