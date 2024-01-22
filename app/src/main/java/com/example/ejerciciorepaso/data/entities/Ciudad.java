package com.example.ejerciciorepaso.data.entities;

import androidx.annotation.NonNull;
import androidx.room.*;

@Entity(tableName="ciudad", indices={@Index(value="nomCiudad", unique=true)})
public class Ciudad {

    @NonNull
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "codCiudad")
    public long codigoCiudad;

    @NonNull
    @ColumnInfo(name = "nomCiudad")
    public String nombreC;
    @NonNull
    public String provincia;
    @NonNull
    public boolean capital;

    public Ciudad(@NonNull String nombre, @NonNull String provincia, @NonNull boolean capital){
        this.nombreC = nombre;
        this.provincia = provincia;
        this.capital = capital;
    }

    public Ciudad() {
    }

    public long getCodigoCiudad() {
        return codigoCiudad;
    }

    public void setCodigoCiudad(long codigoCiudad) {
        this.codigoCiudad = codigoCiudad;
    }

    @NonNull
    public String getNombreC() {
        return nombreC;
    }

    public void setNombreC(@NonNull String nombreC) {
        this.nombreC = nombreC;
    }

    @NonNull
    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(@NonNull String provincia) {
        this.provincia = provincia;
    }

    public boolean isCapital() {
        return capital;
    }

    public void setCapital(boolean capital) {
        this.capital = capital;
    }
    public String datosCiudad(){
        if (capital)
            return codigoCiudad+" "+nombreC+" "+provincia+": es capital";
        else return codigoCiudad+" "+nombreC+" "+provincia+": no es capital";
    }
}
