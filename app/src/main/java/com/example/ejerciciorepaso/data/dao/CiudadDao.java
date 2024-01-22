package com.example.ejerciciorepaso.data.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.ejerciciorepaso.data.entities.Ciudad;

import java.util.List;

@Dao
public interface CiudadDao {

    @Insert
    void insertCiudades(Ciudad... ciudad);

    @Query("Select * From ciudad")
    List<Ciudad> getCiudades();

    @Query("Select * From ciudad where nomCiudad=:nombre")
    Ciudad getCiudad(String nombre);

    @Query("Select codCiudad from ciudad where nomCiudad=:nombreC")
    long getIDCiudadByNombre(String nombreC);

    @Delete
    void deleteCiudad(Ciudad ciudad);

}
