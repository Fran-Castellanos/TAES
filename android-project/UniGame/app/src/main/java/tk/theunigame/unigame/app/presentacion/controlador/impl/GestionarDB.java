package tk.theunigame.unigame.app.presentacion.controlador.impl;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;

import java.util.List;

import juego.taes.domainmodel.Model.Cliente.BDPreguntas;
import tk.theunigame.unigame.R;
import tk.theunigame.unigame.app.fachadas.FachadaBDPreguntas;
import tk.theunigame.unigame.app.fachadas.FachadaComunicador;
import tk.theunigame.unigame.app.logica_juego.bolsaPreguntas.BolsaPregunta;
import tk.theunigame.unigame.app.presentacion.util.AdaptadorListaGestionarPreguntas;

/**
 * Created by John on 09/04/2015.
 */
public class GestionarDB extends Activity {

    private ListView lv;
    private Button btn_crear_db;
    private FachadaBDPreguntas fachadaBDPreguntas;
    private FachadaComunicador comunicador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestionar_bd);

        //Instanciamos las fachadas
        fachadaBDPreguntas= new FachadaBDPreguntas();
        comunicador = new FachadaComunicador();

        //Instanciamos elementos db
        btn_crear_db = (Button) findViewById(R.id.btn_crear_db);
        btn_crear_db.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GestionarDB.this, ListaUniversidades.class);
                Class<?> destino= null;
                try {
                    destino = Class.forName("tk.theunigame.unigame.app.presentacion.controlador.impl.ListaAsignaturasCrearDB");
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                comunicador.ComunicarDestino(destino);
                startActivity(intent);
            }
        });

        //Creamos el adaptador para el ListView
        List<BDPreguntas> bdpreguntasguardadas = fachadaBDPreguntas.obtenerBasesTodasDatos(this);
        //Creamos el adaptador para el ListView
        BaseAdapter adapter= new AdaptadorListaGestionarPreguntas(this, bdpreguntasguardadas);

        lv=(ListView) findViewById(R.id.lv_usar_db_preguntas);
        lv.setAdapter(adapter);

        //Instaciamos el evento para las pulsaciones en los botones de la lista
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent;
                //Comunicador.setObject(parent.getAdapter().getItem(position));//Se envia un DBpreguntas
                BolsaPregunta.getInstance().SetBDPreguntas((BDPreguntas)parent.getAdapter().getItem(position));
                intent= new Intent(GestionarDB.this, ListaPreguntas.class);

                startActivity(intent);
            }
        });
    }

}
