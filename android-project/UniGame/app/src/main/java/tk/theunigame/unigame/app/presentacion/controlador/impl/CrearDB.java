package tk.theunigame.unigame.app.presentacion.controlador.impl;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import java.util.ArrayList;
import juego.taes.domainmodel.Model.Cliente.*;
import tk.theunigame.unigame.R;
import tk.theunigame.unigame.app.fachadas.FachadaBDPreguntas;
import tk.theunigame.unigame.app.fachadas.FachadaComunicador;

/**
 * Created by John on 08/04/2015.
 */


public class CrearDB extends Activity{

    private FachadaBDPreguntas fachadaBD;
    private FachadaComunicador comunicador;
    private Universidad universidad;
    private Carrera carrera;
    private Asignatura asignatura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_db);

    }


    public void Crear_BD(View v){
        String nombreBD= ((EditText)findViewById(R.id.etxt_name_db)).getText().toString();
        carrera = comunicador.RecibirCarreraPosicion1();
        universidad = comunicador.RecibirUniversidadPosicion0();
        asignatura = comunicador.RecibirAsignaturaPosicion2();
        fachadaBD.crearBaseDatos(nombreBD,this);
        fachadaBD.setDatos(carrera,universidad,asignatura);

    }
}
