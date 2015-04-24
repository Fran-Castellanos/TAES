package tk.theunigame.unigame.app.presentacion.controlador.impl;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import juego.taes.domainmodel.Model.Cliente.Asignatura;
import juego.taes.domainmodel.Model.Cliente.Carrera;
import tk.theunigame.unigame.R;
import tk.theunigame.unigame.app.presentacion.util.AdaptadorListaAsignaturas;
import tk.theunigame.unigame.app.presentacion.util.AdaptadorListaDefault;
import tk.theunigame.unigame.app.presentacion.util.Comunicador;

/**
 * Created by John on 09/04/2015.
 */
public class ListaAsignaturas extends Activity {

    private ListView lv;
    private TextView txt;
    private Carrera carrera;

    final private String[] datos = new String[]{"Asignaturas1", "Asignaturas2", "Asignaturas3"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_asignaturas);

        txt= (TextView) findViewById(R.id.txt_title2);
        String s= (String)Comunicador.getObject();//Cuande esté implementado debe ser Asignatura
        txt.setText(s);

        //Creamos el adaptador para el ListView
        BaseAdapter adapter= new AdaptadorListaAsignaturas(this, datos);
        lv=(ListView) findViewById(R.id.lv_asignaturas);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //getItem(position) devuelve un item que es un Object del objeto que contiene el adapter
                //en esa posición
                Comunicador.setObject(parent.getAdapter().getItem(position));
                Intent intent= new Intent(ListaAsignaturas.this, ListaBasesDatos.class);
                startActivity(intent);
            }
        });
    }

}
