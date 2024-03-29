package com.example.jptv20_10_03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button button = (Button) findViewById(R.id.btn_button);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //if button has pressed
    public void sendMessage(View view) {
        TextView textView = findViewById(R.id.text_sting);
        EditText editText = findViewById(R.id.input_name);
        textView.setText(getString(R.string.test) + editText.getText());
    }
}