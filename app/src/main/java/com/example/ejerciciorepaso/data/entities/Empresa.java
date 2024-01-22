package com.example.ejerciciorepaso.data.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "empresa",foreignKeys = @ForeignKey(entity = Ciudad.class,parentColumns = "codCiudad",childColumns = "codCiudad", onDelete = ForeignKey.CASCADE))
public class Empresa {
    @NonNull
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "codEmpresa")
    public long codigoEmpresa;
    @NonNull
    @ColumnInfo(name = "nomEmpresa")
    public String nombreEmpresa;
    @NonNull
    public String direccion;
    @NonNull
    public float presupuesto;
    @NonNull
    @ColumnInfo(name = "codCiudad")
    public long codigoCiudad;

    public Empresa(@NonNull String nombreEmpresa, @NonNull String direccion, float presupuesto, long codigoCiudad) {

        this.nombreEmpresa = nombreEmpresa;
        this.direccion = direccion;
        this.presupuesto = presupuesto;
        this.codigoCiudad = codigoCiudad;
    }

    public Empresa() {
    }

    public String mostrarDatosEmpresa(){

        return  codigoEmpresa+" "+nombreEmpresa+" "+direccion+" "+presupuesto+" "+codigoCiudad;
    }

    public long getCodigoEmpresa() {
        return codigoEmpresa;
    }

    public void setCodigoEmpresa(long codigoEmpresa) {
        this.codigoEmpresa = codigoEmpresa;
    }

    @NonNull
    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(@NonNull String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    @NonNull
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(@NonNull String direccion) {
        this.direccion = direccion;
    }

    public float getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(float presupuesto) {
        this.presupuesto = presupuesto;
    }

    public long getCodigoCiudad() {
        return codigoCiudad;
    }

    public void setCodigoCiudad(long codigoCiudad) {
        this.codigoCiudad = codigoCiudad;
    }
}
