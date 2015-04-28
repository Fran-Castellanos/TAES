package tk.theunigame.unigame.app.presentacion.controlador.impl;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import juego.taes.domainmodel.Model.Cliente.BDPreguntas;
import tk.theunigame.unigame.R;
import tk.theunigame.unigame.app.fachadas.FachadaBDPreguntas;
import tk.theunigame.unigame.app.presentacion.util.AdaptadorListaBasesDatos;
import tk.theunigame.unigame.app.presentacion.util.AdaptadorListaDefault;
import tk.theunigame.unigame.app.presentacion.util.Comunicador;
import tk.theunigame.unigame.app.presentacion.util.Constantes;

/**
 * Created by John on 09/04/2015.
 */
public class UsarDB extends Activity {

    private ListView lv;
    private FachadaBDPreguntas fachadaBDPreguntas;

    //final private String[] datos = new String[]{"CrearDB", "Probando2", "Probando3", "Probando4", "Probando5", "Probando6", "Probando7", "Probando8", "Probando9"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usar_bd);

        fachadaBDPreguntas= new FachadaBDPreguntas();
        //Creamos el adaptador para el ListView
        ArrayList<BDPreguntas> bdpreguntasguardadas = fachadaBDPreguntas.obtenerBasesTodasDatos(this);
        bdpreguntasguardadas.add(new BDPreguntas("Pedro",false));

        //Creamos el adaptador para el ListView
        AdaptadorListaBasesDatos adapter= new AdaptadorListaBasesDatos(this, bdpreguntasguardadas);

        lv=(ListView) findViewById(R.id.lv_usar_db_preguntas);
        lv.setAdapter(adapter);

        //Instaciamos el evento para las pulsaciones en los botones de la lista
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String opcion_db= ((String)parent.getAdapter().getItem(position));

                Intent intent;
                if(opcion_db.equals("CrearDB")){
                    intent= new Intent(UsarDB.this, CrearDB.class);
                }else{
                    Comunicador.setObject(opcion_db);//Se envia un DBpreguntas
                    intent= new Intent(UsarDB.this, ListaPreguntas.class);
                }

                startActivity(intent);
            }
        });
    }

}
