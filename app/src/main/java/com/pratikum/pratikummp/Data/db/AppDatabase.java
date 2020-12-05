package com.pratikum.pratikummp.Data.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.pratikum.pratikummp.Data.Dao.MahasiswaDao;
import com.pratikum.pratikummp.Data.model.Mahasiswa;

@Database(entities = {Mahasiswa.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract MahasiswaDao userDao();
}