package tk.theunigame.unigame.app.presentacion.controlador.impl;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.sql.SQLException;

import juego.taes.domainmodel.Model.Cliente.*;
import tk.theunigame.unigame.R;
import tk.theunigame.unigame.app.fachadas.FachadaBDPreguntas;
import tk.theunigame.unigame.app.fachadas.FachadaComunicador;
import tk.theunigame.unigame.app.presentacion.util.IActivityListaDatos;

/**
 * Created by John on 08/04/2015.
 */


public class CrearDB extends Activity {
    private Universidad universidad;
    private Carrera carrera;
    private Asignatura asignatura;
    private Usuario usuario;
    private FachadaBDPreguntas fachadaBD;
    private FachadaComunicador fachadaComunicador;

    private TextView txt_subject,txt_university, txt_carrer;
    private EditText etxt_name_db;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_db);




        imageView = (ImageView) findViewById(R.id.imageView);

        imageView.setClickable(true);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        //Recuperamos elementos de la interfaz
        txt_university = (TextView) findViewById(R.id.txt_university);
        txt_carrer = (TextView) findViewById(R.id.txt_carrer);
        txt_subject = (TextView) findViewById(R.id.txt_subject);
        etxt_name_db = (EditText) findViewById(R.id.etxt_name_db);

        //Instanciamos las fachadas
        fachadaComunicador = new FachadaComunicador();
        fachadaBD = new FachadaBDPreguntas();

        //Cargamos los datos
        universidad = fachadaComunicador.RecibirUniversidadPosicion0();
        carrera = fachadaComunicador.RecibirCarreraPosicion1();
        asignatura = fachadaComunicador.RecibirAsignaturaPosicion2();
        usuario = fachadaComunicador.RecibirUsuario();


        //Cambiamos los text_View
        txt_university.setText(universidad.getNombre());
        txt_carrer.setText(carrera.getNombre());
        txt_subject.setText(asignatura.getNombre());
    }

    public void Crear_BD(View v) throws SQLException {
        String nombreBD= etxt_name_db.getText().toString();

        //comunicador.ComunicarUniversidadCarreraAsignatura(universidad,carrera,asignatura,comunicador.RecibirDestinoPosicionFinal());
        fachadaBD.crearBaseDatos(nombreBD,this,asignatura,universidad,usuario);
        //Haga lo que tenga que hacer
        Intent intent = new Intent(CrearDB.this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
    }


    @Override
    public void onBackPressed() {

        fachadaComunicador.volverAtras();
        super.onBackPressed();
    }
}
