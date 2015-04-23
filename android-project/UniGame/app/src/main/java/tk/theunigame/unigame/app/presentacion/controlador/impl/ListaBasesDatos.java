package tk.theunigame.unigame.app.presentacion.controlador.impl;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import juego.taes.domainmodel.Model.Cliente.Asignatura;
import tk.theunigame.unigame.R;
import tk.theunigame.unigame.app.presentacion.util.AdaptadorListaDefault;
import tk.theunigame.unigame.app.presentacion.util.Comunicador;

/**
 * Created by John on 09/04/2015.
 */
public class ListaBasesDatos extends Activity {

    private ListView lv;
    private TextView txt;
    private Asignatura asignatura;

    final private String[] datos = new String[]{"BaseDato1", "BaseDato2"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_bases_datos);

        txt= (TextView) findViewById(R.id.txt_title2);
        String s= (String) Comunicador.getObject();//Cuande esté implementado debe ser Asignatura
        txt.setText(s);

        //Creamos el adaptador para el ListView
        //Deberá realizarse un adaptador propio en caso de recibir objetos y no lista de nombres
        BaseAdapter adapter= new AdaptadorListaDefault(this, datos);
        lv=(ListView) findViewById(R.id.lv_bases_datos);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Comunicador.setObject(parent.getAdapter().getItem(position));
                //Intent intent = new Intent(ListaBasesDatos.this, ListaUniversidades.class);
                //startActivity(intent);
            }
        });
    }

}
