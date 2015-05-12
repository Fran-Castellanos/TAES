package tk.theunigame.unigame.app.presentacion.controlador.impl;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import juego.taes.domainmodel.Model.Cliente.Asignatura;
import juego.taes.domainmodel.Model.Cliente.Carrera;
import juego.taes.domainmodel.Model.Cliente.Universidad;
import tk.theunigame.unigame.R;
import tk.theunigame.unigame.app.fachadas.FachadaAsignatura;
import tk.theunigame.unigame.app.fachadas.FachadaComunicador;
import tk.theunigame.unigame.app.presentacion.util.AdaptadorListaAsignaturasSinCB;

/**
 * Created by John on 09/04/2015.
 */
public class ListaAsignaturasSinCB extends Activity {

    private ListView lv;
    private TextView txt;
    private Universidad universidad;
    private Carrera carrera;
    private ArrayList<Asignatura> asignaturasConsulta;

    private FachadaComunicador fachadaComunicador;
    private FachadaAsignatura fachadaAsignatura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_asignaturas_sin_button);

        //Instanciamos elementos de la vista
        txt= (TextView) findViewById(R.id.txt_title2);
        lv = (ListView) findViewById(R.id.lv_asignaturas);

        //Instanciamos las fachadas
        fachadaComunicador = new FachadaComunicador();
        fachadaAsignatura = new FachadaAsignatura();

        //Cargamos la información
        universidad = fachadaComunicador.RecibirUniversidadPosicion0();
        carrera = fachadaComunicador.RecibirCarreraPosicion1();
        txt.setText(carrera.getNombre());

        asignaturasConsulta = fachadaAsignatura.obtenerAsignaturas(this, universidad, carrera);
        //Creamos el adaptador para el ListView
        BaseAdapter adapter= new AdaptadorListaAsignaturasSinCB(this, asignaturasConsulta);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Class<?> destino = fachadaComunicador.RecibirDestinoPosicionFinal();
                //Enviamos las asignaturas a traves de la fachada
                fachadaComunicador.ComunicarUniversidadCarreraAsignatura(universidad,
                        carrera, (Asignatura)parent.getAdapter().getItem(position), destino);

                //Lanzamos la actividad
                Intent intent = new Intent(ListaAsignaturasSinCB.this, ListaBasesDatosSinCB.class);
                startActivity(intent);

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }


    @Override
    public void onBackPressed() {

        fachadaComunicador.volverAtras();
        super.onBackPressed();
    }
}
