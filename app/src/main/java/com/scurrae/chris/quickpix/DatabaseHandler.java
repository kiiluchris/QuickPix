package com.scurrae.chris.quickpix;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

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
    private  static final String TABLE_PICTURES = "pictures";
    // Tables column names
    private  static final String KEY_ID = "id";
    private  static final String KEY_PICTURE = "picture";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        // String containing all vars needed
        String CREATE_PICTURES_TABLE = "CREATE TABLE " + TABLE_PICTURES +
                "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_PICTURE +
                " TEXT" + ")";
        // Execute the string
        db.execSQL(CREATE_PICTURES_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if it exists
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PICTURES);
        // Create new table
        onCreate(db);
    }
    // Adding new contact
    public void addImage(Images images){
        // Instanciate new DB
        SQLiteDatabase db = this.getWritableDatabase();

        // Values being added to db
        ContentValues values = new ContentValues();
        values.put(KEY_ID, images.get_id());
        values.put(KEY_PICTURE, images.get_image());

        // Adding new row
        db.insert(TABLE_PICTURES, null, values);
        db.close();

    }
    public List<Images> getAllImages(){
        List<Images> imagesList = new ArrayList<Images>();
        // Select All Query
        String selectQuery = "SELECT * FROM " + TABLE_PICTURES;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // Looping through all rows to add to list
        if(cursor.moveToFirst()){
            do{
                Images image = new Images();
                image.set_id(Integer.parseInt(cursor.getString(0)));
                image.set_image(Integer.parseInt(cursor.getString(1)));
                // Adding single contact to list
                imagesList.add(image);
            } while (cursor.moveToNext());

        }
        // Return contact list
        return imagesList;
    }
}
