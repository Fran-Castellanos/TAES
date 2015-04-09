package tk.theunigame.unigame.app.presentacion.controlador.impl;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import tk.theunigame.unigame.R;
import tk.theunigame.unigame.app.presentacion.util.AdaptadorListaPreguntas;

/**
 * Created by John on 09/04/2015.
 */
public class ListaPreguntas extends Activity {

    private ListView lv;
    private Button btn;

    final private String[] datos = new String[]{"Pregunta1", "Pregunta2", "Pregunta3", "Pregunta4", "Pregunta5", "Pregunta6", "Pregunta7", "Pregunta8", "Pregunta9", "Pregunta10", "Pregunta11", "Pregunta12", "Pregunta13", "Pregunta14", "Pregunta15", "Pregunta16", "Pregunta17", "Pregunta18", "Pregunta19", "Pregunta20", "Pregunta21", "Pregunta22", "Pregunta23", "Pregunta24", "Pregunta25"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_preguntas);

        btn= (Button) findViewById(R.id.btn_individual_mode);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        lv=(ListView) findViewById(R.id.lv_preguntas);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String opcion= ((String)parent.getAdapter().getItem(position));
            }
        });
    }

    //Debe ser usado cuando regrese de crear una pregunta
    @Override
    protected void onResume() {
        super.onResume();
        //Creamos el adaptador para el ListView donde pasaremos las preguntas que serán listadas
        //si es una base de datos local SQlite se recomienda AdaptadorCursorDB y que sea instanciada en OnCreate() ¿Recomendable usar true en newView?
        AdaptadorListaPreguntas adapter= new AdaptadorListaPreguntas(this, datos);
        lv.setAdapter(adapter);
    }
}
