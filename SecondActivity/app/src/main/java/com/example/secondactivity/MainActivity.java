package com.example.secondactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText name;
    private EditText surname;
    private EditText phone;
    private EditText adress;
    private Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.editText);
        surname = findViewById(R.id.editText2);
        phone = findViewById(R.id.editText3);
        adress = findViewById(R.id.editText4);
        btn = findViewById(R.id.button);

        btn.setOnClickListener(v ->
        {
            sendMessage();
        });
    }

    public void sendMessage() {
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("name", name.getText().toString());
        intent.putExtra("surname", surname.getText().toString());
        intent.putExtra("phone", phone.getText().toString());
        intent.putExtra("adress", adress.getText().toString());
        startActivity(intent);
    }


}