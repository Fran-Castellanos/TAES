package tk.theunigame.unigame.app.presentacion.controlador.impl;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import juego.taes.domainmodel.Model.Cliente.Asignatura;
import juego.taes.domainmodel.Model.Cliente.BDPreguntas;
import juego.taes.domainmodel.Model.Cliente.Universidad;
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
    private Button btn_crear_db;
    private FachadaBDPreguntas fachadaBDPreguntas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usar_bd);

        fachadaBDPreguntas= new FachadaBDPreguntas();
<<<<<<< HEAD

        btn_crear_db = (Button) findViewById(R.id.btn_crear_db);
        btn_crear_db.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UsarDB.this, CrearDB.class);
                startActivity(intent);
            }
        });

        //Creamos el adaptador para el ListView
        ArrayList<BDPreguntas> bdpreguntasguardadas = fachadaBDPreguntas.obtenerBasesTodasDatos(this);
=======
        Universidad universidad = new Universidad("Universidad de Alicante","UA");
        Asignatura asignatura = new Asignatura("PED");
        //Creamos el adaptador para el ListView
        ArrayList<BDPreguntas> bdpreguntasguardadas = fachadaBDPreguntas.obtenerBasesTodasDatos(this);
        bdpreguntasguardadas.add(new BDPreguntas("Examenes Finales",false,universidad,asignatura));
>>>>>>> 56dde78e5a0103a87cd39030f452c3d6754183ba

        //Creamos el adaptador para el ListView
        AdaptadorListaBasesDatos adapter= new AdaptadorListaBasesDatos(this, bdpreguntasguardadas);

        lv=(ListView) findViewById(R.id.lv_usar_db_preguntas);
        lv.setAdapter(adapter);

        //Instaciamos el evento para las pulsaciones en los botones de la lista
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent;
                Comunicador.setObject(parent.getAdapter().getItem(position));//Se envia un DBpreguntas
                intent= new Intent(UsarDB.this, ListaPreguntas.class);

                startActivity(intent);
            }
        });
    }

}
