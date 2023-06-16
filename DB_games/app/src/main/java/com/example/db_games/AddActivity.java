package com.example.db_games;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddActivity extends AppCompatActivity {

    private Button button;
    private EditText title;
    private EditText year;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        SQLiteDatabase db = getBaseContext().openOrCreateDatabase("app.db", MODE_PRIVATE, null);

        button = findViewById(R.id.button);
        title = findViewById(R.id.game_title_input);
        year = findViewById(R.id.game_yaer_input);

        button.setOnClickListener(view -> {
            String gameTitle = title.getText().toString();
            int gameYear = Integer.parseInt(year.getText().toString());
            db.execSQL("INSERT OR IGNORE INTO games VALUES ( null,'" + gameTitle + "','" + gameYear + "');");
            Toast.makeText(AddActivity.this, "Запись добавлена", Toast.LENGTH_SHORT).show();
            title.setText("");
            year.setText("");
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