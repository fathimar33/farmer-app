package com.example.firstpage;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DBManager {

    private DatabaseHelper dbHelper;
    private Context context;
    private SQLiteDatabase database;

    DBManager(Context c) {
        context = c;
    }

    //database open
    void open() throws SQLException {
        dbHelper = new DatabaseHelper(context);
        database = dbHelper.getWritableDatabase();
    }

    //database close
    public void close() {
        dbHelper.close();
    }

    //insert in database
    void insert(String name, String desc) {
        ContentValues contentValue = new ContentValues();
        contentValue.put(DatabaseHelper.FARMER, name);
        contentValue.put(DatabaseHelper.CROPS, desc);
        database.insert(DatabaseHelper.TABLE_NAME, null, contentValue);
    }


    //update in database
    void update(long _id, String name, String desc) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.FARMER, name);
        contentValues.put(DatabaseHelper.CROPS, desc);
        int i = database.update(DatabaseHelper.TABLE_NAME, contentValues, DatabaseHelper._ID + " = " + _id, null);
    }


    //delete in database
    void delete(long _id) {
        database.delete(DatabaseHelper.TABLE_NAME, DatabaseHelper._ID + "=" + _id, null);
    }


    Cursor fetch() {
        String[] columns = new String[] { DatabaseHelper._ID, DatabaseHelper.FARMER, DatabaseHelper.CROPS };
        Cursor cursor = database.query(DatabaseHelper.TABLE_NAME, columns, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }
}
