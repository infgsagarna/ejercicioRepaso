package com.example.ejerciciorepaso.data.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.ejerciciorepaso.data.entities.Departamento;

import java.util.List;

@Dao
public interface DepartamentoDao {

    @Insert
    void insertDepartamentos(Departamento... departamento);

    @Query("select * from departamento where codDepartamentoJefe=:codDepartamento")
    List<Departamento> getDepartamentoByJefe(String codDepartamento);

    //@Query("SELECT * FROM departamento JOIN empresa ON empresa.codCiudad = :codigoCiudad ")
    //public Map<Ciudad, List<Empresa>> getd(long codCiudad);
}
