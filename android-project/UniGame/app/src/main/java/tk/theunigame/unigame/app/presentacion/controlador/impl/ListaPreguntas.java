package tk.theunigame.unigame.app.presentacion.controlador.impl;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import juego.taes.domainmodel.Model.Cliente.BDPreguntas;
import juego.taes.domainmodel.Model.Cliente.Pregunta;
import tk.theunigame.unigame.R;
import tk.theunigame.unigame.app.fachadas.FachadaComunicador;
import tk.theunigame.unigame.app.logica_juego.bolsaPreguntas.BolsaPregunta;
import tk.theunigame.unigame.app.presentacion.util.AdaptadorListaDefault;
import tk.theunigame.unigame.app.presentacion.util.AdaptadorListaPreguntas;
import tk.theunigame.unigame.app.presentacion.util.Comunicador;
import tk.theunigame.unigame.app.presentacion.util.Constantes;

/**
 * Created by John on 09/04/2015.
 */
public class ListaPreguntas extends Activity {

    private ListView lv;
    private TextView txt;
    private Button btn_crear_pregunta;

    private FachadaComunicador comunicador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_preguntas);


        comunicador = new FachadaComunicador();

        //Evento al pulsar el botón crear
        btn_crear_pregunta = (Button) findViewById(R.id.btn_crear_pregunta);
        btn_crear_pregunta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListaPreguntas.this, CrearPregunta.class);
                startActivity(intent);
            }
        });

        txt= (TextView)findViewById(R.id.txt_title1);
        //txt.setText((String)Comunicador.getObject());


        lv=(ListView) findViewById(R.id.lv_preguntas);
        //Creamos el adaptador para el ListView donde pasaremos las preguntas que serán listadas
        //si es una base de datos local SQlite se recomienda AdaptadorCursorDB y que sea instanciada en OnCreate() ¿Recomendable usar true en newView?
        ArrayList <Pregunta> preguntas = BolsaPregunta.getInstance().DevolverPreguntasEnBD();

        for(Pregunta x : BolsaPregunta.getInstance().DevolverPreguntasCreadas())
        {
            preguntas.add(x);
        }

        AdaptadorListaPreguntas adapter= new AdaptadorListaPreguntas(this, preguntas);
        lv.setAdapter(adapter);

        //Evento para las pulsaciones en los items de la lista
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ProgressDialog dialog = ProgressDialog.show(ListaPreguntas.this, "",
                        "Cargando...", true);


                Class<?> destino=null;

                try {
                    destino = Class.forName("tk.theunigame.unigame.app.presentacion.controlador.impl.EditarPreguntaPregunta");
                } catch (ClassNotFoundException e) {
                    new RuntimeException();
                }

                comunicador.ComunicarDestino(destino);


                comunicador.ComunicarPregunta((Pregunta)parent.getAdapter().getItem(position), destino);

                Intent intent;
                intent = new Intent(ListaPreguntas.this, EditarPregunta.class);

                startActivity(intent);
                dialog.cancel();
            }
        });
    }

    //Confirmar los cambios de la BDPreguntas
    public void Confirmar_Cambios(View v) throws SQLException {
        BolsaPregunta.getInstance().RegistrarCambios(this);

        Intent intent = new Intent(ListaPreguntas.this, GestionarDB.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
    }

    //Eliminar pregunta de una BD
    public void eliminarPregunta(Pregunta p)
    {
        BolsaPregunta.getInstance().EliminarPregunta(p);
    }

    @Override
    public void onBackPressed() {

        comunicador.volverAtras();
        super.onBackPressed();
    }

}
