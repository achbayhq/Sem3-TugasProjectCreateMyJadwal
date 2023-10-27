package com.abayhq.login.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class dbProfileHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "kuliah.db";
    public static final int DB_VER = 2;

    public dbProfileHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql = "CREATE TABLE profile(no integer primary key, nama text null, nim text null, username text null, pass text null, email text null, telephone text null, tanggal_lahir text null, prodi text null, alamat text null, img text null);";
        Log.d("Data", "onCreate: "+ sql);
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion < 2) {
            // Menambahkan kolom "img" jika versi lama adalah 1
            db.execSQL("ALTER TABLE profile ADD COLUMN img TEXT;");
        }
    }
}
