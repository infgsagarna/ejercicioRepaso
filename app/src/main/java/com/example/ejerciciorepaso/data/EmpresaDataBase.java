package com.example.ejerciciorepaso.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.ejerciciorepaso.data.dao.CiudadDao;
import com.example.ejerciciorepaso.data.dao.DepartamentoDao;
import com.example.ejerciciorepaso.data.dao.EmpresaDao;
import com.example.ejerciciorepaso.data.entities.Ciudad;
import com.example.ejerciciorepaso.data.entities.Departamento;
import com.example.ejerciciorepaso.data.entities.Empresa;

@Database(entities = {Ciudad.class, Departamento.class, Empresa.class}, version = 1,exportSchema = false)

public abstract class EmpresaDataBase extends RoomDatabase {

    //Definimos los Daos
    public abstract CiudadDao ciudadDao();
    public abstract DepartamentoDao departamentoDao();
    public abstract EmpresaDao empresaDao();


    // Puedes crear una instancia única de la base de datos (Patrón Singleton)
    private static volatile EmpresaDataBase INSTANCE;

    public static EmpresaDataBase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (EmpresaDataBase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    EmpresaDataBase.class, "empresa_database").allowMainThreadQueries()
                            .build();
                }
            }
        }
        return INSTANCE;
    }

}
