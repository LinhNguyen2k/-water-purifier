package com.example.waterpurifier.ui.home;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class SQL_Helper extends SQLiteOpenHelper {
    private static final String TAG = "SQL_Helper";

    static final String DB_NAME = "Water_Purifier.db";
    static final String DB_TABLE = "ConTact_list_car";
    static final int DB_VERSION = 1;
    SQLiteDatabase sqLiteDatabase;
    ContentValues contentValues;
    public SQL_Helper( Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCreateTable = "Create Table ConTact_list_car(" +
                "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                "status TEXT,"+
                "old_price TEXT,"+
                "content TEXT,"+
                "name TEXT,"+
                "new_price TEXT,"+
                "image TEXT)";

        db.execSQL(queryCreateTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        if(oldVersion != newVersion)
        {
            db.execSQL(" DROP TABLE IF EXISTS " + DB_TABLE);
            onCreate(db);
        }
    }


    public  void insertPhone( Contact_SPBanChay contact)
    {
        sqLiteDatabase = getWritableDatabase();
        contentValues = new ContentValues();

        contentValues.put("name",contact.getName_product());
        contentValues.put("new_price",contact.getNew_price());
        contentValues.put("image",contact.getImage());
        contentValues.put("old_price",contact.getOld_price());
        contentValues.put("status",contact.getStatus());
        contentValues.put("content",contact.getContent());
        sqLiteDatabase.insert(DB_TABLE, null, contentValues);

    }


    public List<Contact_SPBanChay> GetallPhoneNumber()
    {
        List<Contact_SPBanChay> contacts = new ArrayList<>();
        sqLiteDatabase = getWritableDatabase();
        Contact_SPBanChay contact;
        Cursor cursor = sqLiteDatabase.query(false, DB_TABLE,
                null,
                null,
                null,
                null,
                null,
                null,
                null);

        while (cursor.moveToNext()){
            String name = cursor.getString(cursor.getColumnIndex("name"));
            String  new_price =(cursor.getString(cursor.getColumnIndex("new_price")));
            String image = (cursor.getString(cursor.getColumnIndex("image")));
            String status = (cursor.getString(cursor.getColumnIndex("status")));
            String content = (cursor.getString(cursor.getColumnIndex("content")));
            String old_price = (cursor.getString(cursor.getColumnIndex("old_price")));
            contacts.add( new Contact_SPBanChay(new_price,old_price,content,image,name,status));
        }
        return contacts;
    }
}
