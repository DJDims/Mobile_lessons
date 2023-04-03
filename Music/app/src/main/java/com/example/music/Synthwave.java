package com.example.music;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Synthwave extends AppCompatActivity {

    private ImageView poster;
    private TextView description;
    public int slide = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_synthwave);

        findViewById(R.id.button4).setOnClickListener(view -> {
            startActivity(new Intent(this, MainActivity.class));
        });

        findViewById(R.id.rightArrow).setOnClickListener(view -> {
            int i = slide > 3 ? slide = 1 : slide++;
            setSlide(slide);
        });

        findViewById(R.id.leftArrow).setOnClickListener(view -> {
            int i = slide < 1 ? slide = 3 : slide--;
            setSlide(slide);
        });
    }

    private void setSlide(int slideNum) {
        switch (slide) {
            case 1:
                poster.setImageResource(R.drawable.kavinsky);
                description.setText(R.string.kavinsky_descr);
                break;
            case 2:
                poster.setImageResource(R.drawable.ludowic);
                description.setText(R.string.ludowic_descr);
                break;
            case 3:
                poster.setImageResource(R.drawable.moon);
                description.setText(R.string.moon_descr);
                break;
        }
    }
}