package com.pratikum.pratikummp.Data.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.pratikum.pratikummp.Data.model.Mahasiswa;

import java.util.List;


@Dao
public interface MahasiswaDao {

    @Query("SELECT * FROM mahasiswa")
    List<Mahasiswa> getAll();

    @Query("SELECT * FROM mahasiswa WHERE nama LIKE :nama ")
    Mahasiswa findByName(String nama);

    @Insert
    void insertAll(Mahasiswa... mahasiswa);

    @Delete
    public void deleteUsers(Mahasiswa... users);

    @Update
    void update (Mahasiswa mahasiswa);




}
