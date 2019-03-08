package com.example.lenovo.meituanapp;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDatabaseHelper extends SQLiteOpenHelper{

    private static final String CREATE_USERS = "create table Users ("
            + "id integer primary key autoincrement, "
            + "Name text, "
            + "Code text)";
    private static final String CREATE_ORDERS = "create table Orders("
            + "id integer primary key autoincrement,"
            + "FoodName text,"
            + "Owner text,"
            + "Price real)";
    private static final String CREATE_FOODS = "create table Foods("
            + "id integer primary key autoincrement,"
            + "FoodName text,"
            + "Price real)";

    public MyDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);

    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USERS);
        db.execSQL(CREATE_ORDERS);
        db.execSQL(CREATE_FOODS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists User");
        db.execSQL("drop table if exists Orders");//升级数据库 = 删掉可能存在的旧表 + 创建新表
        db.execSQL("drop table if exists Foods");

        onCreate(db);

    }
}
