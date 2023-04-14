package com.example.firstpage;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class cons_viewrecordsfirst extends AppCompatActivity {
    final String[] Values_from = new String[] {DatabaseHelper._ID,
            DatabaseHelper.FARMER, DatabaseHelper.CROPS };
    final int[] Values_to = new int[] { R.id.id, R.id.farmer, R.id.crop };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cons_viewrecordsfirst);

        ListView listView = findViewById(R.id.list_view);
        listView.setEmptyView(findViewById(R.id.empty));

        DBManager dbManager = new DBManager(this);
        dbManager.open();
        Cursor cursor = dbManager.fetch();

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.activity_view_record, cursor, Values_from, Values_to, 0);
        adapter.notifyDataSetChanged();

        listView.setAdapter(adapter);
    }
}
