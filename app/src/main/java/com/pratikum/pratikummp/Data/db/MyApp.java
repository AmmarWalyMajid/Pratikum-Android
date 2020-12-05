package com.pratikum.pratikummp.Data.db;

import android.app.Application;
import android.content.Context;

import androidx.room.Room;


public class MyApp extends Application {

    public static AppDatabase db;
    private static MyApp INSTANCE;

    public static MyApp getInstance(){return INSTANCE;}

    @Override
    public void onCreate() {
        super.onCreate();
        db =Room.databaseBuilder(this,
                AppDatabase.class,"mahasiswa").allowMainThreadQueries().build();
        INSTANCE = this;

    }

    public AppDatabase getDb() {
        return db;
    }
}

