package tk.theunigame.unigame.app.presentacion.controlador.impl;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import tk.theunigame.unigame.R;
import tk.theunigame.unigame.app.fachadas.FachadaBDPreguntas;

/**
 * Created by John on 08/04/2015.
 */


public class CrearDB extends Activity{

    FachadaBDPreguntas fachadaBD = new FachadaBDPreguntas();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_db);

    }


    public void Crear_BD(View v){
        String nombreBD= ((EditText)findViewById(R.id.etxt_name_db)).getText().toString();
        fachadaBD.crearBaseDatos(nombreBD,this);
    }
}
