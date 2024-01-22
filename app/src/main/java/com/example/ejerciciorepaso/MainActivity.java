package com.example.ejerciciorepaso;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ejerciciorepaso.data.EmpresaDataBase;
import com.example.ejerciciorepaso.data.entities.Ciudad;
import com.example.ejerciciorepaso.data.entities.Departamento;
import com.example.ejerciciorepaso.data.entities.Empresa;

import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public EmpresaDataBase bd; //declaramos base de datos

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Crear o recoger instancia BD
        bd=EmpresaDataBase.getDatabase(this);

        //Precargar BD
        //PrecargaDatos.insertarDatos(bd);


        //mostrar();
        Button bmostrar = findViewById(R.id.bMostrarEmpresas);
        bmostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // leer productos
                mostrarEmpresas();
            }
        });

        Button binsertC = findViewById(R.id.bInsertCiudad);
        binsertC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // leer productos
                insertarCiudad();
            }
        });

        Button bmostrarDep = findViewById(R.id.bDepartDependientes);
        bmostrarDep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // leer productos
                mostrarDepartDepen();
            }
        });


        Button bEliminarCiudad = findViewById(R.id.bEliminarCiudad);
        bEliminarCiudad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // leer productos
                eliminarCiudad();
            }
        });

    }

    private void eliminarCiudad() {
        EditText etCiudad = findViewById(R.id.etDatos);
        String etCiuString=etCiudad.getText().toString().toLowerCase();
        String etCiuStringFinal=etCiuString.toUpperCase().charAt(0)+etCiuString.substring(1,etCiuString.length());

        Ciudad c=bd.ciudadDao().getCiudad(etCiuStringFinal);
        if (c != null) {
            // eliminar producto.
            bd.ciudadDao().deleteCiudad(c);
            // actualizar lista compra.
            //leerProductos();
        } else {
            Toast.makeText(MainActivity.this, "Ciudad inexistente: " + etCiuStringFinal,
                    Toast.LENGTH_SHORT).show();
        }


    }

    private void mostrarDepartDepen() {
        EditText etDepar=findViewById(R.id.etDatos);
        String etDepartDep=etDepar.getText().toString().toUpperCase();

        List<Departamento> lista = bd.departamentoDao().getDepartamentoByJefe(etDepartDep);

        String mostrarList="";
        for (Departamento d:lista){
            // System.out.println(e.mostrarDatosEmpresa());
            mostrarList += d.getNombreDepartamento()+" "+d.getPresupuesto()+"\n";
        }
        TextView tvMostrar = findViewById(R.id.tvMostrar);
        tvMostrar.setText(mostrarList);




    }

    private void insertarCiudad() {
        EditText etCiudad = findViewById(R.id.etDatos);
        String etCiuString=etCiudad.getText().toString();

        String cadena = etCiuString;
        String delimitadores= "[ .,;?!¡¿\'\"\\[\\]]+";
        String[] split = cadena.split(delimitadores);
        boolean capital=false;
        if (split[2]=="1")
            capital=true;

        Ciudad c=new Ciudad(split[0],split[1],capital);

        bd.ciudadDao().insertCiudades(c);
    }

    private void mostrarEmpresas() {
        EditText etCiudad = findViewById(R.id.etDatos);
        String etCiuString=etCiudad.getText().toString().toLowerCase();
        String etCiuStringFinal=etCiuString.toUpperCase().charAt(0)+etCiuString.substring(1,etCiuString.length());
        //System.out.println(etCiuString);


        long ciudadID=bd.ciudadDao().getIDCiudadByNombre(etCiuStringFinal);
        //System.out.println(ciudadID);
        //Map<Ciudad,List<Empresa>> mapa=bd.empresaDao().getEmpresaByIDCiudad(ciudadID);



        List<Empresa> lista=bd.empresaDao().getEmpresaByIDCiudad(ciudadID);
        //mostrar(Collections.singletonList(lista));
        //System.out.println(lista.size());
        String mostrarList="";
        for (Empresa e:lista){
            //System.out.println(e.mostrarDatosEmpresa());
            mostrarList += e.mostrarDatosEmpresa();
        }
        TextView tvMostrar = findViewById(R.id.tvMostrar);
        tvMostrar.setText(mostrarList);
    }

    public void mostrar(List<Object> lista){


        String mostrarList="";
        for(Object o: lista){

            mostrarList += o.toString();
        }
        TextView tvMostrar = findViewById(R.id.tvMostrar);
        tvMostrar.setText(mostrarList);
    }
    /*public void mostrar(){

        List<Ciudad> listaCiudades=bd.ciudadDao().getCiudades();
        String ciudadList="";
        for(Ciudad c: listaCiudades){

            ciudadList += c.datosCiudad()+ "\n";
        }
        TextView tvCiudades = findViewById(R.id.tvCiudades);
        tvCiudades.setText(ciudadList);
    }*/
}