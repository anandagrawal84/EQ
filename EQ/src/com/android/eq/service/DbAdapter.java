package com.android.eq.service;

import java.util.ArrayList;
import java.util.Date;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.app.Application;

import com.android.eq.domain.Mood;

public class DbAdapter {

    public static String EMOTION_ID = "emotion_id";
    public static String MOOD_REASON = "reason";
    public static String MOOD_CREATED_ON = "created_on";
   
    
    private static class DatabaseHelper extends SQLiteOpenHelper {


        private static final String DATABASE_NAME = "SmilePlease";
        private static final int DATABASE_VERSION = 2;

        DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("create table moods (_id integer primary key autoincrement, "
                    + "emotion_id integer not null, reason text not null, created_on date not null);");
//            db.execSQL("create trigger insert_moods_timestamp AFTER INSERT on moods"+
//            "BEGIN"+
//            "UPDATE moods SET created_on = DATETIME('NOW')"+
//            "WHERE rowid = new.rowid;"+
//            "END;");
            
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//            db.execSQL("DROP TABLE IF EXISTS events");
//            db.execSQL("DROP TABLE IF EXISTS expenses");
//            db.execSQL("DROP TABLE IF EXISTS participants");
            onCreate(db);
        }
    }

    private Context mCtx;
    private DatabaseHelper mDbHelper;
    private SQLiteDatabase mDb;
    

    public DbAdapter(Context ctx) {
        this.mCtx = ctx;
    }

     
  	public DbAdapter open() throws SQLException {
        mDbHelper = new DatabaseHelper(mCtx);
        mDb = mDbHelper.getReadableDatabase();
        return this;
    }

    public DbAdapter openWritable() throws SQLException {
        mDbHelper = new DatabaseHelper(mCtx);
        mDb = mDbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        mDbHelper.close();
    }

    public void createMood(Mood mood) {
        openWritable();
        try {
            mDb.insert("moods", null, mood.toContentValues());
        } finally {
            close();
        }
    }

    public ArrayList<Mood> fetchAllMoods() {
    	ArrayList<Mood> moods = new ArrayList<Mood>();   
        open();
        Cursor cursor = null;
        try {
            cursor = mDb.query(true,"moods", null, null , null, null, null, null , null);
            if (cursor.moveToFirst()) {
                do {
                	moods.add(new Mood(cursor.getInt(1), cursor.getString(2), new Date(cursor.getString(3))));
                } while (cursor.moveToNext());
            }
        } finally {
            close();
            if (cursor != null) cursor.close();
        }
        return moods;
    }
}
