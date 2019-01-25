package com.cartridryan14.portalti2016.data;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.os.AsyncTask;

import com.cartridryan14.portalti2016.entity.Mahasiswa;

import java.util.List;

public class MahasiswaRepository {

    private final static String DB_NAME = "datalokal";
    private MahasiswaDatabase mahasiswaDatabase;

    public MahasiswaRepository(Context context) {
        mahasiswaDatabase = Room.databaseBuilder(
                context,
                MahasiswaDatabase.class,
                DB_NAME
        ).build();
    }

    public void insertMahasiswa(final String name, final String nim) {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                Mahasiswa mahasiswa = new Mahasiswa();
                mahasiswa.setName(name);
                mahasiswa.setNim(nim);
                mahasiswaDatabase.mahasiswaDao().insert(mahasiswa);
                return null;
            }
        }.execute();
    }

    public List<Mahasiswa> getMahasiswas() {
        return mahasiswaDatabase.mahasiswaDao().getMahasiswa();
    }

}
