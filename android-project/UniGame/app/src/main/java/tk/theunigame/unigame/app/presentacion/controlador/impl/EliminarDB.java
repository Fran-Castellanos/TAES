package tk.theunigame.unigame.app.presentacion.controlador.impl;

import android.app.Activity;
import android.app.AlertDialog;
//import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import juego.taes.domainmodel.Model.Cliente.Asignatura;
import juego.taes.domainmodel.Model.Cliente.BDPreguntas;
import juego.taes.domainmodel.Model.Cliente.Carrera;
import juego.taes.domainmodel.Model.Cliente.Universidad;
import tk.theunigame.unigame.R;
import tk.theunigame.unigame.app.fachadas.FachadaBDPreguntas;
import tk.theunigame.unigame.app.fachadas.FachadaComunicador;
import tk.theunigame.unigame.app.fachadas.FachadaPartida;
import tk.theunigame.unigame.app.fachadas.FachadaPregunta;
import tk.theunigame.unigame.app.presentacion.util.AdaptadorListaBasesDatos;
import tk.theunigame.unigame.app.presentacion.util.AdaptadorListaDefault;
import tk.theunigame.unigame.app.presentacion.util.AlertaDialogo;
import tk.theunigame.unigame.app.presentacion.util.Comunicador;

/**
 * Created by John on 09/04/2015.
 */
public class EliminarDB extends FragmentActivity {

    private ListView lv;
    private TextView txt;
    private Button btn;

    private FachadaComunicador fachadaComunicador;


    private Boolean[] posicionAsig;
    private List<BDPreguntas> bdPreguntas,bdPreguntasConsulta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar_bases_datos);

        //Instanciamos elementos de la interfaz
        lv=(ListView) findViewById(R.id.lv_bases_datos);
        btn = (Button) findViewById(R.id.btn_eliminar);

        //Inicializamos las fachadas
        fachadaComunicador = new FachadaComunicador();

        bdPreguntasConsulta = fachadaComunicador.RecibirBDPreguntasPosicion0();

        BaseAdapter adapter= new AdaptadorListaBasesDatos(this, bdPreguntasConsulta);
        lv.setAdapter(adapter);

        //Instanciamos Listeners
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Cargamos las bolsas de preguntas a enviar
                for (int i = 0; i < posicionAsig.length; i++) {
                    if (posicionAsig[i])
                        bdPreguntas.add(bdPreguntasConsulta.get(i));
                }

                if (bdPreguntas.size() > 0) {

                    //Lanzamos la actividad
                    Intent intent = new Intent(EliminarDB.this, GestionarDB.class);
                    startActivity(intent);
                } else {
                    AlertaDialogo ad = new AlertaDialogo();
                    ad.setMensaje("Seleccione una o más bolsas de preguntas");
                    ad.setTitulo("Información");
                    ad.setBoton1("OK");
                    ad.show(getSupportFragmentManager(), "FragmentAlert");
                }
            }
        });

        //Iniciamos los elementos del Array de los checkbox
        posicionAsig = new Boolean[adapter.getCount()];
        for(int i = 0 ; i<posicionAsig.length; i++){
            posicionAsig[i]=false;
        }
    }

    public void onCheckBoxClicked(View view){
        CheckBox chkBox = (CheckBox) view;

        //Recupera el objeto vinculado al checkbox para introducirlo en el arraylist
        if(chkBox.isChecked())
            posicionAsig[(Integer)chkBox.getTag()]=true;
        else
            posicionAsig[(Integer)chkBox.getTag()]=false;
    }


    @Override
    public void onBackPressed() {

        fachadaComunicador.volverAtras();
        super.onBackPressed();
    }

}

