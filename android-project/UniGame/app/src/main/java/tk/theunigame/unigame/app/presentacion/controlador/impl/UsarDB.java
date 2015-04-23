package tk.theunigame.unigame.app.presentacion.controlador.impl;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import tk.theunigame.unigame.R;
import tk.theunigame.unigame.app.presentacion.util.AdaptadorListaDefault;
import tk.theunigame.unigame.app.presentacion.util.Constantes;

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
        AdaptadorListaDefault adapter= new AdaptadorListaDefault(this, datos);
        //ArrayAdapter<String> arrayAdapter= new ArrayAdapter<String>(this,R.layout.list_item_db, datos);
        lv=(ListView) findViewById(R.id.lv_usar_db_preguntas);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String opcion_db= ((String)parent.getAdapter().getItem(position));

                Intent intent;
                if(opcion_db.equals("CrearDB")){
                    intent= new Intent(UsarDB.this, CrearDB.class);
                }else{
                    /**//**//**//**//**//**//**//**//**//**//**//**//**//**//**//**//**//**/
                    //Debe pasar alguna referencia a la base de datos o la base de datos
                    //Para generamos un Bundle y lo enviamos como un putExtras, o enviamos unicamente
                    //el identificador a la siguiente Activity
                    intent= new Intent(UsarDB.this, ListaPreguntas.class);
                    //Introducimos en el Intent lo que queremos enviar a la siguiente activity
                    intent.putExtra(Constantes.KDB_NOMBRE, opcion_db);
                }

                startActivity(intent);
            }
        });
    }

}
