package tk.theunigame.unigame.app.presentacion.controlador.impl;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import tk.theunigame.unigame.R;
import tk.theunigame.unigame.app.presentacion.util.AdaptadorListaDefault;
import tk.theunigame.unigame.app.presentacion.util.Comunicador;

/**
 * Created by John on 09/04/2015.
 */
public class ListaUniversidades extends Activity {

    private ListView lv;

    final private String[] datos = new String[]{"Universidad1", "Universidad2", "Universidad3"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_universidades);

        //Creamos el adaptador para el ListView
        AdaptadorListaDefault adapter= new AdaptadorListaDefault(this, datos);
        lv=(ListView) findViewById(R.id.lv_universidades);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //getItem(position) devuelve un item que es un Object del objeto que contiene el adapter
                //en esa posición
                Comunicador.setObject(parent.getAdapter().getItem(position));
                Intent intent= new Intent(ListaUniversidades.this, ListaCarreras.class);
                startActivity(intent);
            }
        });
    }

}
