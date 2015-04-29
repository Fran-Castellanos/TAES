package tk.theunigame.unigame.app.presentacion.controlador.impl;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import juego.taes.domainmodel.Model.Cliente.*;
import tk.theunigame.unigame.R;
import tk.theunigame.unigame.app.fachadas.FachadaBDPreguntas;
import tk.theunigame.unigame.app.fachadas.FachadaComunicador;
import tk.theunigame.unigame.app.presentacion.util.IActivityListaDatos;

/**
 * Created by John on 08/04/2015.
 */


public class CrearDB extends Activity {

    private FachadaComunicador comunicador;
    private Universidad universidad;
    private Carrera carrera;
    private Asignatura asignatura;
    private FachadaBDPreguntas fachadaBD = new FachadaBDPreguntas();

    private Button btn_university, btn_carrer;
    private EditText etxt_subject, etxt_name_db;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_db);

        btn_university = (Button) findViewById(R.id.btn_university);
        btn_carrer = (Button) findViewById(R.id.btn_carrer);
        etxt_subject = (EditText) findViewById(R.id.etxt_subject);
        etxt_name_db = (EditText) findViewById(R.id.etxt_carrer);



        btn_university.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Class<?> destino = null;
                try {
                    destino = Class.forName("ListaUniversidades");
                } catch (ClassNotFoundException e) {
                    new RuntimeException();
                }
                Intent intent= new Intent(CrearDB.this, ListaUniversidades.class);
                comunicador.ComunicarDestino(destino);
                startActivity(intent);
            }
        });

/*
        btn_carrer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Class<?> destino = null;
                try {
                    destino = Class.forName("ListaCarreras");
                } catch (ClassNotFoundException e) {
                    new RuntimeException();
                }
                Intent intent= new Intent(MainActivity.this, ListaUniversidades.class);
                comunicador.ComunicarDestino(destino);
                startActivity(intent);
            }
        });
        */

    }


    public void Crear_BD(View v){
        String nombreBD= ((EditText)findViewById(R.id.etxt_name_db)).getText().toString();
        universidad = comunicador.RecibirUniversidadPosicion0();
        carrera = comunicador.RecibirCarreraPosicion1();
        asignatura = comunicador.RecibirAsignaturaPosicion2();
        //comunicador.ComunicarUniversidadCarreraAsignatura(universidad,carrera,asignatura,comunicador.RecibirDestinoPosicionFinal());
        fachadaBD.crearBaseDatos(nombreBD,this,asignatura,universidad);
    }


    public void selectUniversidad(View v)
    {
        View view = findViewById(btn_university.getId());
        view.setBackgroundResource(R.drawable.btn_selected_answer_default);



        Intent intent= new Intent(CrearDB.this, ListaUniversidades.class);
        startActivity(intent);
    }


    public void selectCarrera(View v)
    {
        View view = findViewById(btn_carrer.getId());
        view.setBackgroundResource(R.drawable.btn_selected_answer_default);


    }
}
