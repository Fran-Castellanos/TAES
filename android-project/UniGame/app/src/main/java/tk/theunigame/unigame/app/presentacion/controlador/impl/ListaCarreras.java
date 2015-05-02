package tk.theunigame.unigame.app.presentacion.controlador.impl;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import juego.taes.domainmodel.Model.Cliente.Carrera;
import juego.taes.domainmodel.Model.Cliente.Universidad;
import tk.theunigame.unigame.R;
import tk.theunigame.unigame.app.fachadas.FachadaCarrera;
import tk.theunigame.unigame.app.fachadas.FachadaComunicador;
import tk.theunigame.unigame.app.presentacion.util.AdaptadorListaCarreras;
import tk.theunigame.unigame.app.presentacion.util.AdaptadorListaDefault;
import tk.theunigame.unigame.app.presentacion.util.Comunicador;

/**
 * Created by John on 09/04/2015.
 */
public class ListaCarreras extends Activity {

    private ListView lv;
    private TextView txt;
    private Universidad universidad;
    private FachadaCarrera fachadaCarrera;
    private FachadaComunicador fachadaComunicador;
    private Class<?> destino;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_carreras);

        //Instanciamo elementos de la vista
        txt= (TextView) findViewById(R.id.txt_title2);

        //Instanciamos las fachadas
        fachadaCarrera = new FachadaCarrera();
        fachadaComunicador = new FachadaComunicador();

        //Cargamos la información
        universidad = fachadaComunicador.RecibirUniversidadPosicion0();
        txt.setText(universidad.getNombre());
        destino = null;

        //Creamos el adaptador para el ListView
        ArrayList<Carrera> carreras = fachadaCarrera.obtenerCarreras(this, universidad);
        BaseAdapter adapter= new AdaptadorListaCarreras(this, carreras);
        lv=(ListView) findViewById(R.id.lv_carreras);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ProgressDialog dialog = ProgressDialog.show(ListaCarreras.this, "",
                        "Cargando...", true);
                //Si retorna de la activity podemos perder la referencia al destino. Así aseguramos su permanencia
                if(destino == null)
                    destino = fachadaComunicador.RecibirDestinoPosicionFinal();

                fachadaComunicador.ComunicarUniversidadCarrera(universidad, (Carrera)parent.getAdapter().getItem(position), null);
                Intent intent= new Intent(ListaCarreras.this, destino);
                startActivity(intent);
                dialog.cancel();
            }
        });
    }

}
