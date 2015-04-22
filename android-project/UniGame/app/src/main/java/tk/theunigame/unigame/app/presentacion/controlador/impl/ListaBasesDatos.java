package tk.theunigame.unigame.app.presentacion.controlador.impl;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;

import tk.theunigame.unigame.R;

/**
 * Created by John on 09/04/2015.
 */
public class ListaBasesDatos extends Activity {

    private ListView lv;

    final private String[] datos = new String[]{"BaseDato1", "BaseDato2"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_bases_datos);

        //Creamos el adaptador para el ListView
        //Deberá realizarse un adaptador propio en caso de recibir objetos y no lista de nombres
        BaseAdapter adapter= new ArrayAdapter<String>(this,R.layout.list_item_pregunta, datos);
        lv=(ListView) findViewById(R.id.lv_bases_datos);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String opcion= ((String)parent.getAdapter().getItem(position));
            }
        });
    }

}
