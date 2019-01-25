package com.cartridryan14.portalti2016.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.cartridryan14.portalti2016.entity.Mahasiswa;

@Database(entities = {Mahasiswa.class}, version = 1, exportSchema = false)
public abstract class MahasiswaDatabase extends RoomDatabase {
    public abstract MahasiswaDao mahasiswaDao();
}
