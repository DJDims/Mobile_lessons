package com.example.trafficligth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button_red).setOnClickListener(v -> setBgColor("red"));
        findViewById(R.id.button_yellow).setOnClickListener(v -> setBgColor("yellow"));
        findViewById(R.id.button_green).setOnClickListener(v -> setBgColor("green"));
    }

    public void setBgColor(String color) {
        ConstraintLayout cl = findViewById(R.id.constraintLayout);

        switch (color) {
            case "red":
                cl.setBackgroundColor(ContextCompat.getColor(this, R.color.red));
                break;
            case "yellow":
                cl.setBackgroundColor(ContextCompat.getColor(this, R.color.yellow));
                break;
            case "green":
                cl.setBackgroundColor(ContextCompat.getColor(this, R.color.green));
                break;
        }
    }
}