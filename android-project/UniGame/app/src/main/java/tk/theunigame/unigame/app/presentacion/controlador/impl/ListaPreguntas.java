package tk.theunigame.unigame.app.presentacion.controlador.impl;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import juego.taes.domainmodel.Model.Cliente.BDPreguntas;
import juego.taes.domainmodel.Model.Cliente.Pregunta;
import tk.theunigame.unigame.R;
import tk.theunigame.unigame.app.logica_juego.bolsaPreguntas.BolsaPregunta;
import tk.theunigame.unigame.app.presentacion.util.AdaptadorListaDefault;
import tk.theunigame.unigame.app.presentacion.util.Comunicador;
import tk.theunigame.unigame.app.presentacion.util.Constantes;

/**
 * Created by John on 09/04/2015.
 */
public class ListaPreguntas extends Activity {

    private ListView lv;
    private TextView txt;
    private BDPreguntas bd_preguntas;

    final private String[] datos = new String[]{"Añadir Pregunta","Pregunta1", "Pregunta2", "Pregunta3", "Pregunta4", "Pregunta5", "Pregunta6", "Pregunta7", "Pregunta8", "Pregunta9", "Pregunta10", "Pregunta11", "Pregunta12", "Pregunta13", "Pregunta14", "Pregunta15", "Pregunta16", "Pregunta17", "Pregunta18", "Pregunta19", "Pregunta20", "Pregunta21", "Pregunta22", "Pregunta23", "Pregunta24", "Pregunta25"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_preguntas);

        bd_preguntas = (BDPreguntas)Comunicador.getObject();

        //Cambiar la BDPreguntas en la Bolsa de Preguntas
        BolsaPregunta.getInstance().SetBDPreguntas(bd_preguntas);

        txt= (TextView)findViewById(R.id.txt_title1);
        txt.setText((String)Comunicador.getObject());
        lv=(ListView) findViewById(R.id.lv_preguntas);

        //Creamos el adaptador para el ListView donde pasaremos las preguntas que serán listadas
        //si es una base de datos local SQlite se recomienda AdaptadorCursorDB y que sea instanciada en OnCreate() ¿Recomendable usar true en newView?
        BaseAdapter adapter= new AdaptadorListaDefault(this, datos);
        lv.setAdapter(adapter);

        //Evento para las pulsaciones en los items de la lista
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String opcion = (String)parent.getAdapter().getItem(position);
                Comunicador.setObject(opcion);

                Intent intent;

                //Creamos la pregunta
                if(opcion.equals(getString(R.string.btn_add_question))){
                    intent = new Intent(ListaPreguntas.this, CrearPregunta.class);
                }else{//Modificamos la pregunta
                    intent = new Intent(ListaPreguntas.this, CrearPregunta.class);
                }

                startActivity(intent);
            }
        });
    }

    //Confirmar los cambios de la BDPreguntas
    public void Confirmar_Cambios(View v)
    {
        BolsaPregunta.getInstance().RegistrarCambios(this);
        //Log.d("CambiosConfirmados", "Funcion");
    }

    //Eliminar pregunta de una BD
    public void eliminarPregunta(Pregunta p)
    {
        BolsaPregunta.getInstance().EliminarPregunta(p);
    }
}
