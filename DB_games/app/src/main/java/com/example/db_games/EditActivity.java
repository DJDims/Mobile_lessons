package com.example.db_games;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class EditActivity extends AppCompatActivity {

    private Spinner spinner;
    private Button button;
    private EditText title;
    private EditText year;
    private int currentId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        SQLiteDatabase db = getBaseContext().openOrCreateDatabase("app.db", MODE_PRIVATE, null);

        spinner = findViewById(R.id.spinner);
        button = findViewById(R.id.button);
        title = findViewById(R.id.game_title_input);
        year = findViewById(R.id.game_yaer_input);

        ArrayList<String> arraySpinner = new ArrayList<String>();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, arraySpinner);

        spinner.setAdapter(adapter);
        try {
            Cursor query = db.rawQuery("SELECT * FROM games;", null);
            while(query.moveToNext()){
                int id  = query.getInt(0);
                String title = query.getString(1);
                int year = query.getInt(2);
                arraySpinner.add(Integer.toString(id) + " " + title + " " + Integer.toString(year));
                adapter.notifyDataSetChanged();
            }
            query.close();
        } catch (Exception e) {
            arraySpinner.clear();
            arraySpinner.add("Нет данных");
        }

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                try {
                    currentId = (int) id+1;
                    Cursor query2 = db.rawQuery("SELECT * FROM games WHERE games.id = " + currentId +";", null);
                    query2.moveToFirst();
                    title.setText(query2.getString(1));
                    year.setText(Integer.toString(query2.getInt(2)));
                } catch (Exception e) {
                    Toast.makeText(EditActivity.this, "АШИБКА", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });

        button.setOnClickListener(view -> {
            String gameTitle = title.getText().toString();
            int gameYear = Integer.parseInt(year.getText().toString());
            db.execSQL("UPDATE games SET title ='" + gameTitle + "', year = '" + gameYear + "' WHERE games.id = '" + currentId +"';");
            Toast.makeText(EditActivity.this, "Запись обновлена", Toast.LENGTH_SHORT).show();
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, 1, 0, "Просмотр");
        menu.add(0, 2, 0, "Добавление");
        menu.add(0, 3, 0, "Изменение");
        menu.add(0, 4, 0, "Удаление");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        goToScreen(item.getItemId());
        return true;
    }

    public void goToScreen(int screenNumber) {
        switch (screenNumber) {
            case 1:
                startActivity(new Intent(this, MainActivity.class));
                break;
            case 2:
                startActivity(new Intent(this, AddActivity.class));
                break;
            case 3:
                startActivity(new Intent(this, EditActivity.class));
                break;
            case 4:
                startActivity(new Intent(this, DeleteActivity.class));
                break;
        }
    }
}