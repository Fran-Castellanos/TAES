package tk.theunigame.unigame.app.presentacion.controlador.impl;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;

import juego.taes.domainmodel.Model.Cliente.Asignatura;
import juego.taes.domainmodel.Model.Cliente.BDPreguntas;
import juego.taes.domainmodel.Model.Cliente.Carrera;
import juego.taes.domainmodel.Model.Cliente.Universidad;
import juego.taes.domainmodel.Repository.BDPreguntasRepository;
import tk.theunigame.unigame.R;
import tk.theunigame.unigame.app.fachadas.FachadaBDPreguntas;
import tk.theunigame.unigame.app.fachadas.FachadaComunicador;
import tk.theunigame.unigame.app.presentacion.util.AdaptadorListaBasesDatos;
import tk.theunigame.unigame.app.presentacion.util.AdaptadorListaUniversidades;

/**
 * Created by John on 08/04/2015.
 */
public class BajarDB extends Activity{

    private List<BDPreguntas> bdPreguntasList;
    private Universidad universidad;
    private Asignatura asignatura;
    private FachadaComunicador comunicador;
    private BDPreguntasRepository respositorio;
    private FachadaBDPreguntas fachada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bajar_db);
    }

    public void Bajar_BD(View v){

        String nombreuni= ((EditText)findViewById(R.id.etxt_university)).getText().toString();
        String nombreasig = ((EditText)findViewById(R.id.etxt_subject)).getText().toString();
        universidad = comunicador.RecibirUniversidadPosicion0();
        asignatura = comunicador.RecibirAsignaturaPosicion2();

        if(nombreasig!="" && nombreuni!="" ){
            bdPreguntasList = respositorio.getByAsignaturaYUniversidad(asignatura.getId(),universidad.getId());//Esto lo hace en local, habria que hacer una conexion con el servidor
            for(int i=0; i<bdPreguntasList.size(); ++i){
                //Como esto lo hace localmente, las BD se duplicaran
                fachada.crearBDdelServidor(bdPreguntasList.get(i).getNombre(),this,bdPreguntasList.get(i).getAsignatura(),bdPreguntasList.get(i).getUniversidad(),bdPreguntasList.get(i).getPreguntas());
            }
        }
        else if(nombreasig!="" && nombreuni=="" ){
            bdPreguntasList = respositorio.getByAsignatura(asignatura.getId());//Esto lo hace en local, habria que hacer una conexion con el servidor
            for(int i=0; i<bdPreguntasList.size(); ++i){
                //Como esto lo hace localmente, las BD se duplicaran
                fachada.crearBDdelServidor(bdPreguntasList.get(i).getNombre(),this,bdPreguntasList.get(i).getAsignatura(),bdPreguntasList.get(i).getUniversidad(),bdPreguntasList.get(i).getPreguntas());

            }
        }
        else if(nombreasig=="" && nombreuni!=""){
            //obtener por universidad
        }
        //else
        // no hara nada, pues no ha introducido ningun campo
    }


    @Override
    public void onBackPressed() {

        comunicador.volverAtras();
        super.onBackPressed();
    }


}
