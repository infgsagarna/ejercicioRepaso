package com.example.ejerciciorepaso;

import com.example.ejerciciorepaso.data.EmpresaDataBase;
import com.example.ejerciciorepaso.data.entities.Ciudad;
import com.example.ejerciciorepaso.data.entities.Departamento;
import com.example.ejerciciorepaso.data.entities.Empresa;

public class PrecargaDatos {

    public static void insertarDatos(EmpresaDataBase bd){

        Ciudad c=new Ciudad("Bilbo","Bizkaia",true);
        Ciudad c2=new Ciudad("Eibar","Gipuzkoa",false);
        Ciudad c3=new Ciudad("Donostia","Gipuzkoa",true);
        Ciudad c4=new Ciudad("Tutera","Nafarroa",false);
        Ciudad c5=new Ciudad("Gasteiz","Araba",true);
        bd.ciudadDao().insertCiudades(c,c2,c3,c4,c5);

        Empresa e=new Empresa("Nagusia", "Kale Nagusia, 80", 1200000, 1);
        Empresa e2=new Empresa("Erdialdea", "Saratsuegi 32", 1150000, 2);
        Empresa e3=new Empresa("Hegoaldea", "Carr. Alfaro, s/n", 800000, 4);

        bd.empresaDao().insertEmpresas(e,e2,e3);

        Departamento d=new Departamento("BERRI","Berrikuntza",400000,3,"KALIT");
        Departamento d2=new Departamento("IK+DI","Ikerkuntza eta diseinua",350000,3,"KALIT");
        Departamento d3=new Departamento("KALIT","Kalitatea",180000,2,"ZUZEN");
        Departamento d4=new Departamento("NOMIN","Nominak",400000,2,"RR.HH");
        Departamento d5=new Departamento("PRODU","Produkzioa",240000,1,"ZUZEN");
        Departamento d6=new Departamento("RR.HH","Giza Baliabideak",350000,1,"ZUZEN");
        Departamento d7=new Departamento("SALME","Salmentak",380000,2,"ZUZEN");
        Departamento d8=new Departamento("ZUZEN","Zuzendaritza",500000,1,"");

        bd.departamentoDao().insertDepartamentos(d,d2,d3,d4,d5,d6,d7,d8);
    }
}
