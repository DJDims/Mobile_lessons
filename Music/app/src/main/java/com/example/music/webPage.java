package com.example.music;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class webPage extends AppCompatActivity {

    private EditText addressBar;
    private WebView webView;
    private Button buttonGo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_page);

        buttonGo =(Button)findViewById(R.id.btn_search);
        addressBar =(EditText)findViewById(R.id.adrerss_bar);
        webView =(WebView)findViewById(R.id.webView);

        webView.setWebViewClient(new MyWebClient(addressBar));
        buttonGo.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                goUrl();
            }
        });
    }

    private void goUrl() {
        String url = addressBar.getText().toString().trim();
        if(url.isEmpty()) {
            Toast.makeText(this,"Please enter url",
                    Toast.LENGTH_SHORT).show();
            return;
        }
        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webView.loadUrl(url);
    }
}