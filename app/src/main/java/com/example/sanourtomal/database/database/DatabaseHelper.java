package com.example.sanourtomal.database.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.sanourtomal.database.person.Person;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import static android.R.attr.id;
import static android.content.ContentValues.TAG;

/**
 * Created by Sanour Tomal on 2/11/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    // Database name and table name and version
    private static final String DATABASE_NAME = "Contactlist";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_CONTACT = "Contact";

    // Column name


    private static final String KEY_ID = "id";
    private static final String KEY_CREATED_AT="created_at";
    private static final String KEY_NAME="name";
    private static final String KEY_PHONE="phone";

    //private static final String CREATE_DATABASE="CREATE DATABASE"+DATABASE_NAME;

    //CREATE TABLE QUERY

    private static final String CREATE_TABLE_CONTACT = " CREATE TABLE " + TABLE_CONTACT + "(" + KEY_ID + " INTEGER PRIMARY KEY , " + KEY_NAME + " TEXT , " + KEY_PHONE + " TEXT , "  + KEY_CREATED_AT + " DATETIME " + ")";





    public DatabaseHelper(Context context) {

        super(context,DATABASE_NAME,null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

       // db.execSQL(CREATE_DATABASE);
        db.execSQL(CREATE_TABLE_CONTACT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_CONTACT);
        onCreate(db);
    }
    public void insertContect(Person person) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, person.getName());

        values.put(KEY_PHONE,person.getPhnNum());

        values.put(KEY_CREATED_AT,getDateTime());
        db.insert(TABLE_CONTACT, null, values);

        db.close();
    }




        public ArrayList<Person> getAll() {
            ArrayList<Person> personArrayList = new ArrayList<Person>();
            String selectQuery = "SELECT  * FROM " + TABLE_CONTACT ;
            SQLiteDatabase db = this.getWritableDatabase();
            Cursor cursor = db.rawQuery(selectQuery, null);

            // looping through all rows and adding to list
            if (cursor.moveToFirst()) {
                do {
                    Person person = new Person(cursor.getString(0),cursor.getString(1),cursor.getString(2));
                    person.setName(cursor.getString(1));
                    person.setPhnNum(cursor.getString(2));
                    personArrayList.add(person);
                } while (cursor.moveToNext());
            }
            cursor.close();
            db.close();
            return personArrayList;

        }

    private String getDateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd", Locale.getDefault());
        Date date = new Date();
        return dateFormat.format(date);
    }


    //Delete item
    public void Delete(String id){

        SQLiteDatabase db=this.getWritableDatabase();
        String query="DELETE FROM "+TABLE_CONTACT+" WHERE "+KEY_ID+"= "+id;

        int rowsDeleted = db.delete(TABLE_CONTACT, KEY_ID + " = " + id, null);
        Log.d(TAG, "Deleted rows = " + query);
         db.rawQuery(query, null);
        db.close();
    }
   /* public boolean deleteTitle(String name)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        return db.delete(TABLE_CONTACT, KEY_NAME + "LIKE" + name, null) > 0;
    }*/

    public void Update(String id){

        SQLiteDatabase db=this.getWritableDatabase();
        String query="UPDATE "+TABLE_CONTACT+" SET "+KEY_NAME+" = UPDATED WHERE "+KEY_ID+" LIKE "+id;
        db.rawQuery(query,null);
        db.close();
    }

    public String getKeyID(){
        return (KEY_ID);
    }

}
