package com.seeksolution.dictionary;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbManager extends SQLiteOpenHelper {

    //abstract class abstract methods and implement methods hote hai

    public DbManager(Context context)
    {
      super(context, "dictdb",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query="create table dict(word text, meaning text )";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
