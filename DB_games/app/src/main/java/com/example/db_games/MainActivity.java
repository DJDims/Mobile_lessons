package com.example.db_games;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView myList;
    private TextView my_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SQLiteDatabase db = getBaseContext().openOrCreateDatabase("app.db", MODE_PRIVATE, null);
//        db.execSQL("DROP TABLE games");
        db.execSQL("CREATE TABLE IF NOT EXISTS games (id INTEGER PRIMARY KEY AUTOINCREMENT, title TEXT, year INTEGER)");
//        db.execSQL("INSERT OR IGNORE INTO games VALUES (null, 'Tom Smith', 23),(null, 'John Dow', 31);");

        myList = findViewById(R.id.myList);
        ArrayList<String> arrayList = new ArrayList<String>();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList);
        myList.setAdapter(adapter);

        try {
            Cursor query = db.rawQuery("SELECT * FROM games;", null);
            while(query.moveToNext()){
                int id  = query.getInt(0);
                String title = query.getString(1);
                int year = query.getInt(2);
                arrayList.add(Integer.toString(id) + " " + title + " " + Integer.toString(year));
                adapter.notifyDataSetChanged();
            }

            query.close();
            db.close();
        } catch (Exception e) {
            arrayList.clear();
            arrayList.add("Нет данных");
            adapter.notifyDataSetChanged();
        }
    }

    TextView myText;

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