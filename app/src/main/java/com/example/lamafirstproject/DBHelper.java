package com.example.lamafirstproject;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {
public static final String DBName = "my.db";

    public DBHelper( Context context) {
        super(context, DBName, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE users(username TEXT PRIMARY KEY, password TEXT, full_name TEXT, phone TEXT)");

db.execSQL("create Table coursedetails (course_name Text primary key, Explanation Text )");

db.execSQL("create Table Admin(AUsername TEXT primary key, APassword TEXT)");


    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
db.execSQL("drop table if exists users");
        db.execSQL("drop table if exists coursedetails");
        db.execSQL("drop table if exists Admin");

    }
    public boolean insertadmin(String Username, String Password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues val = new ContentValues();
        val.put("AUsername", Username);
        val.put("APassword", Password );
        long result = db.insert("Admin", null, val);
        if (result == -1) return false;
        else return true;

    }
    public boolean checkAdminCredentials(String username, String password) {
        // Check against predefined usernames and passwords
        if ("MainAdmin".equals(username) && "Nai123".equals(password)) {
            return true;
        } else if ("Employee1".equals(username) && "emo1".equals(password)) {
            return true;
        } else if ("Employee2".equals(username) && "epol3".equals(password)) {
            return true;
        }

        return false;
    }


    public boolean insertData(String username, String password, String fullName, String phone) {
        SQLiteDatabase myDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);
        contentValues.put("full_name", fullName);
        contentValues.put("phone", phone);

        try {
            long result = myDB.insert("users", null, contentValues);

            if (result == -1) {
                Log.e("DBHelper", "Error inserting data into users table");
                return false;
            } else {
                Log.d("DBHelper", "Data inserted successfully into users table");
                return true;
            }
        } catch (Exception e) {
            Log.e("DBHelper", "Exception occurred: " + e.getMessage());
            return false;
        } finally {
            myDB.close();
        }
    }


public boolean insertcoursedata(String course_name, String Explanation){
    SQLiteDatabase myDB = this.getWritableDatabase();
    ContentValues contentValues = new ContentValues();
    contentValues.put("course_name", course_name);
    contentValues.put("Explanation", Explanation);
    long result = myDB.insert("coursedetails", null, contentValues);
    if (result == -1) return false;
    else return true;
}

    public boolean checkusername( String username){
        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery(" select * from users where username =?", new String[]{username});
        if(cursor.getCount()>0)
            return true;
        else return false;
    }


    public Cursor getdata(){
        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("select * from coursedetails",null);
return cursor;

    }
    public Cursor getUserData(String username) {
        SQLiteDatabase myDB = this.getReadableDatabase();
        return myDB.rawQuery("SELECT * FROM users WHERE username=?", new String[]{username});
    }


    public boolean checkUser( String username , String pwd){
        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("select * from users where username = ? and password = ?", new String[]{username, pwd });
        if(cursor.getCount()>0)
            return true;
        else return false;
    }
    public boolean deleteCourseData(String course_name) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("coursedetails", "course_name=?", new String[]{course_name}) > 0;
    }


}