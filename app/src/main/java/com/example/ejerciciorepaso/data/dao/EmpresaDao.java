package com.example.ejerciciorepaso.data.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.ejerciciorepaso.data.entities.Ciudad;
import com.example.ejerciciorepaso.data.entities.Empresa;

import java.util.List;
import java.util.Map;

@Dao
public interface EmpresaDao {

    @Insert
    void insertEmpresas(Empresa... empresa);

    /*
    @Query("Select * from Empresa where ")
    List<Empresa> getEmpresaByNombreCiudad(String nombreC);
*/

    //@Query("SELECT * FROM empresa JOIN ciudad ON empresa.codCiudad = :codigoCiudad ")
    @Query("SELECT * FROM empresa where empresa.codCiudad = :codigoCiudad ")
    public List<Empresa> getEmpresaByIDCiudad(long codigoCiudad);
    //public Map<Ciudad, List<Empresa>> getEmpresaByIDCiudad(long codCiudad);


}
