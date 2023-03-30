package com.example.secondactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView txt;
    private TextView txt2;
    private TextView txt3;
    private TextView txt4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        txt = findViewById(R.id.textView);
        txt2 = findViewById(R.id.textView2);
        txt3 = findViewById(R.id.textView3);
        txt4 = findViewById(R.id.textView4);

        txt.setText(getIntent().getStringExtra("name"));
        txt2.setText(getIntent().getStringExtra("surname"));
        txt3.setText(getIntent().getStringExtra("phone"));
        txt4.setText(getIntent().getStringExtra("adress"));
    }
}