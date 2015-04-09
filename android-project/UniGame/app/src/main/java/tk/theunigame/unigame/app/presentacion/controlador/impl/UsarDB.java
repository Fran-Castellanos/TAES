package tk.theunigame.unigame.app.presentacion.controlador.impl;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import tk.theunigame.unigame.R;
import tk.theunigame.unigame.app.presentacion.util.AdaptadorListaMultiItems;

/**
 * Created by John on 09/04/2015.
 */
public class UsarDB extends Activity {

    private ListView lv;

    final private String[] datos = new String[]{"CrearDB", "Probando2", "Probando3", "Probando4", "Probando5", "Probando6", "Probando7", "Probando8", "Probando9"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usar_bd);

        //Creamos el adaptador para el ListView
        AdaptadorListaMultiItems adapter= new AdaptadorListaMultiItems(this, datos);
        //ArrayAdapter<String> arrayAdapter= new ArrayAdapter<String>(this,R.layout.list_item_db, datos);
        lv=(ListView) findViewById(R.id.lv_usar_db_preguntas);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String opcion= ((String)parent.getAdapter().getItem(position));

                if(opcion.equals("CrearDB")){
                    Intent intent= new Intent(UsarDB.this, CrearDB.class);
                    startActivity(intent);
                }

            }
        });
    }

}
