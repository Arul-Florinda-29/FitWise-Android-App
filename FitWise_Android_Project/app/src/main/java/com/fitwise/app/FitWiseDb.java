package com.fitwise.app;

import android.content.*;
import android.database.*;
import android.database.sqlite.*;

public class FitWiseDb extends SQLiteOpenHelper {
    public FitWiseDb(Context c) { super(c, "fitwise.db", null, 1); }
    @Override public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE users(id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT,email TEXT UNIQUE,password TEXT,age INTEGER,gender TEXT,height REAL,weight REAL,activity TEXT,goal TEXT,food TEXT)");
        db.execSQL("CREATE TABLE daily(id INTEGER PRIMARY KEY AUTOINCREMENT,user_id INTEGER,day TEXT,water REAL,sleep REAL,steps INTEGER,weight REAL)");
    }
    @Override public void onUpgrade(SQLiteDatabase db,int oldV,int newV) { }
    public boolean register(String name,String email,String password) {
        ContentValues v=new ContentValues(); v.put("name",name);v.put("email",email.toLowerCase().trim());v.put("password",password);
        return getWritableDatabase().insert("users",null,v)>0;
    }
    public Cursor login(String email,String password) {
        return getReadableDatabase().rawQuery("SELECT * FROM users WHERE email=? AND password=?",new String[]{email.toLowerCase().trim(),password});
    }
    public void saveProfile(int id,String name,int age,String gender,double height,double weight,String activity,String goal,String food) {
        ContentValues v=new ContentValues();v.put("name",name);v.put("age",age);v.put("gender",gender);v.put("height",height);v.put("weight",weight);v.put("activity",activity);v.put("goal",goal);v.put("food",food);
        getWritableDatabase().update("users",v,"id=?",new String[]{String.valueOf(id)});
    }
    public void saveDaily(int id,double water,double sleep,int steps,double weight) {
        ContentValues v=new ContentValues();v.put("user_id",id);v.put("day",java.text.DateFormat.getDateInstance().format(new java.util.Date()));v.put("water",water);v.put("sleep",sleep);v.put("steps",steps);v.put("weight",weight);getWritableDatabase().insert("daily",null,v);
    }
}
