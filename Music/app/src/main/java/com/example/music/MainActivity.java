package com.example.music;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.button);
        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button3);
        btn4 = findViewById(R.id.button5);

        btn1.setOnClickListener(view -> {
            goToScreen(1);
        });
        btn2.setOnClickListener(view -> {
            goToScreen(2);
        });
        btn3.setOnClickListener(view -> {
            goToScreen(3);
        });
        btn4.setOnClickListener(view -> {
            goToScreen(4);
        });
    }

    private void goToScreen(int screenNumber) {
        switch (screenNumber) {
            case 1:
                startActivity(new Intent(this, TrashMetal.class));
                break;
            case 2:
                startActivity(new Intent(this, Synthwave.class));
                break;
            case 3:
                startActivity(new Intent(this, ElectroSwing.class));
                break;
            case 4:
                startActivity(new Intent(this, webPage.class));
                break;
        }
    }
}