package com.example.music;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class TrashMetal extends AppCompatActivity {

    private ImageView poster;
    private TextView description;
    public int slide = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trash_metal);

        poster = findViewById(R.id.bandPoster);
        description = findViewById(R.id.bandDescription);

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
                poster.setImageResource(R.drawable.metallica);
                description.setText(R.string.metallica_descr);
                break;
            case 2:
                poster.setImageResource(R.drawable.megadeth);
                description.setText(R.string.megadeth_descr);
                break;
            case 3:
                poster.setImageResource(R.drawable.slayer);
                description.setText(R.string.slayer_descr);
                break;
        }
    }
}