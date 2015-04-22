package tk.theunigame.unigame.app.presentacion.controlador.impl;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;

import tk.theunigame.unigame.R;
import tk.theunigame.unigame.app.presentacion.util.AdaptadorListaMultiItems;
import tk.theunigame.unigame.app.presentacion.util.Comunicador;

/**
 * Created by John on 09/04/2015.
 */
public class ListaAsignaturas extends Activity {

    private ListView lv;

    final private String[] datos = new String[]{"Asignaturas1", "Asignaturas2", "Asignaturas3"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_asignaturas);

        //Creamos el adaptador para el ListView
        BaseAdapter adapter= new AdaptadorListaMultiItems(this, datos);
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
