package com.example.ejerciciorepaso.data.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity (tableName = "departamento", indices={@Index(value = "nomDepartamento", unique = true)},
foreignKeys = @ForeignKey(
        entity = Empresa.class,
        parentColumns = "codEmpresa", // Este es el nombre de Empresa
        childColumns = "codEmpresa", // Este es el nombre de esta clase
        onDelete = ForeignKey.CASCADE))
     //   @ForeignKey(entity = Departamento.class, parentColumns = "codDepartamento", childColumns = "codDepartamentoJefe"))
public class Departamento {

    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "codDepartamento")
    public String codigoDepartamento;
    @NonNull
    @ColumnInfo(name = "nomDepartamento")
    public String nombreDepartamento;
    @NonNull
    public float presupuesto;
    @NonNull
    @ColumnInfo(name = "codEmpresa")
    public long codigoEmpresa;
    @ColumnInfo(name = "codDepartamentoJefe")
    public String codigoDepartamentoJefe;

    public Departamento(@NonNull String codigoDepartamento, @NonNull String nombreDepartamento, float presupuesto, long codigoEmpresa, String codigoDepartamentoJefe) {
        this.codigoDepartamento = codigoDepartamento;
        this.nombreDepartamento = nombreDepartamento;
        this.presupuesto = presupuesto;
        this.codigoEmpresa = codigoEmpresa;
        this.codigoDepartamentoJefe = codigoDepartamentoJefe;
    }

    public Departamento(){

    }

    @NonNull
    public String getCodigoDepartamento() {
        return codigoDepartamento;
    }

    public void setCodigoDepartamento(@NonNull String codigoDepartamento) {
        this.codigoDepartamento = codigoDepartamento;
    }

    @NonNull
    public String getNombreDepartamento() {
        return nombreDepartamento;
    }

    public void setNombreDepartamento(@NonNull String nombreDepartamento) {
        this.nombreDepartamento = nombreDepartamento;
    }

    public float getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(float presupuesto) {
        this.presupuesto = presupuesto;
    }

    public long getCodigoEmpresa() {
        return codigoEmpresa;
    }

    public void setCodigoEmpresa(long codigoEmpresa) {
        this.codigoEmpresa = codigoEmpresa;
    }

    public String getCodigoDepartamentoJefe() {
        return codigoDepartamentoJefe;
    }

    public void setCodigoDepartamentoJefe(String codigoDepartamentoJefe) {
        this.codigoDepartamentoJefe = codigoDepartamentoJefe;
    }
}
