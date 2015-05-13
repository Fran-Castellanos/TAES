package tk.theunigame.unigame.app.presentacion.controlador.impl;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
    private TextView txt,txt2;
    private Button btn_crear_pregunta;
    private Context context;
    private ArrayList <Pregunta> preguntas;

    private FachadaComunicador comunicador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_preguntas);

        //Instanciamo elementos de la vista
        txt2 = (TextView) findViewById(R.id.txt_title2);
        txt2.setText("Bolsa de Preguntas\n" + BolsaPregunta.getInstance().getBDPreguntas().getNombre());

        comunicador = new FachadaComunicador();
        context = this;

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


        lv=(ListView) findViewById(R.id.lv_preguntas);
        //Creamos el adaptador para el ListView donde pasaremos las preguntas que serán listadas
        //si es una base de datos local SQlite se recomienda AdaptadorCursorDB y que sea instanciada en OnCreate() ¿Recomendable usar true en newView?
        preguntas = BolsaPregunta.getInstance().DevolverListadoPreguntas();

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
    public void Confirmar_Cambios(View v) throws SQLException{

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        Boolean cambiado = false;
        String texto = BolsaPregunta.getInstance().getCambiosRealizados();

        try {
            BolsaPregunta.getInstance().RegistrarCambios(this);
            cambiado = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (cambiado) {
            builder.setMessage("Cambios Realizados\n"+texto).
                    setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();

                    Intent intent = new Intent(ListaPreguntas.this, MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                    startActivity(intent);
                }
            });
            builder.create().show();
        }
        else
        {
            builder.setMessage("¡Fallo al registrar!").
                    setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();

                            //Vacio la Bolsa Preguntas
                            BolsaPregunta.getInstance().VaciarBD();

                            Intent intent = new Intent(ListaPreguntas.this, MainActivity.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                            startActivity(intent);
                        }
                    });
            builder.create().show();
        }
    }

    @Override
    public void onBackPressed() {

    if(BolsaPregunta.getInstance().hayCambios()) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setMessage("¿Desea confirmar los cambios en la bolsa \"" + BolsaPregunta.getInstance().getBDPreguntas().getNombre() + "\" antes de salir?").
                setPositiveButton("Sí", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                        View v = new View(context);
                        try {
                            Confirmar_Cambios(v);
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }

                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                //Vacio la Bolsa Preguntas
                BolsaPregunta.getInstance().VaciarBD();

                Intent intent = new Intent(ListaPreguntas.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
            }
        });
        builder.create().show();
    }
    else
    {
        comunicador.volverAtras();
        super.onBackPressed();
    }
  }

}
