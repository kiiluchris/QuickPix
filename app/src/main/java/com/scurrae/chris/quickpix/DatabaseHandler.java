package com.scurrae.chris.quickpix;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by chris on 3/21/16.
 */
public class DatabaseHandler extends SQLiteOpenHelper {
    // Static vars
    // DB version
    private  static final int DATABASE_VERSION = 1;
    // DB name
    private  static final String DATABASE_NAME = "picturesManager";
    // Contacts table name
    private  static final String TABLE_CONTACTS = "pictures";
    // Tables column names
    private  static final String KEY_ID = "id";
    private  static final String KEY_NAME = "picture";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
