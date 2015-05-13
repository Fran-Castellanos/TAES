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
public class ListaBasesDatos extends FragmentActivity {

    private ListView lv;
    private TextView txt;
    private Button btn;

    private FachadaComunicador fachadaComunicador;
    private FachadaBDPreguntas fachadaBasesDatos;

    private Universidad universidad;
    private Carrera carrera;
    private ArrayList<Asignatura> asignaturas;

    private Boolean[] posicionAsig;
    private ArrayList<BDPreguntas> bdPreguntas,bdPreguntasConsulta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_bases_datos);

        //Instanciamos elementos de la interfaz
        txt= (TextView) findViewById(R.id.txt_title2);
        lv=(ListView) findViewById(R.id.lv_bases_datos);
        btn = (Button) findViewById(R.id.btn_confirmar);

        //Instanciamos las fachadas
        fachadaComunicador = new FachadaComunicador();
        fachadaBasesDatos = new FachadaBDPreguntas();

        //Cargamos la información
        universidad = fachadaComunicador.RecibirUniversidadPosicion0();
        carrera = fachadaComunicador.RecibirCarreraPosicion1();
        asignaturas = fachadaComunicador.RecibirAsignaturasPosicion2();
        txt.setText(asignaturas.size() + " Asignaturas seleccionadas");

        //Creamos el adaptador para el ListView
        bdPreguntas = new ArrayList<>();
        try {
            bdPreguntasConsulta= fachadaBasesDatos.obtenerBasesDatos(this, universidad, carrera, asignaturas);//Recibimos la lista de preguntas
        } catch (SQLException e) {
            e.printStackTrace();
        }
        BaseAdapter adapter= new AdaptadorListaBasesDatos(this, bdPreguntasConsulta);
        lv.setAdapter(adapter);

        //Instanciamos Listeners
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Class<?> destino = null;
                //Cargamos las bolsas de preguntas a enviar
                for(int i = 0 ; i<posicionAsig.length; i++){
                    if(posicionAsig[i])
                        bdPreguntas.add(bdPreguntasConsulta.get(i));
                }

                if(bdPreguntas.size() > 0) {
                    //ProgressDialog dialog = ProgressDialog.show(ListaBasesDatos.this, "",
                    //        "Cargando...", true);
                    try {
                        destino = Class.forName("tk.theunigame.unigame.app.presentacion.controlador.impl.JuegoIndividual");
                    } catch (ClassNotFoundException e) {
                        new RuntimeException();
                    }

                    fachadaComunicador.ComunicarDestino(destino);

                    //Enviamos las bdPreguntas a traves de la fachada
                    fachadaComunicador.ComunicarBDPreguntas(bdPreguntas, destino);
                    FachadaPartida partida = new FachadaPartida();
                    partida.inicializarPartida();

                    FachadaPregunta fachadaPregunta = new FachadaPregunta();
                    try {
                        fachadaPregunta.cargarPreguntas(getApplicationContext(), bdPreguntas);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                    //Lanzamos la actividad
                    Intent intent = new Intent(ListaBasesDatos.this, JuegoIndividual.class);
                    startActivity(intent);
                    //dialog.cancel();
                }else {
                    AlertaDialogo ad = new AlertaDialogo();
                    ad.setMensaje("Seleccione una o más bolsas de preguntas");
                    ad.setTitulo("Información");
                    ad.setBoton1("OK");
                    ad.show(getSupportFragmentManager(), "FragmentAlert");
                }



            }
        });
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // ProgressDialog dialog = ProgressDialog.show(ListaBasesDatos.this, "",
                        //"Cargando...", true);


                //Comunicador.setObject(parent.getAdapt         er().getItem(position));
                //Intent intent = new Intent(ListaBasesDatos.this, ListaUniversidades.class);
                //startActivity(intent);

                //dialog.cancel();
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
