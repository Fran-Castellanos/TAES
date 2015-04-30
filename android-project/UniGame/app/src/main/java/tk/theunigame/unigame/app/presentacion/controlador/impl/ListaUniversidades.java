package tk.theunigame.unigame.app.presentacion.controlador.impl;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import juego.taes.domainmodel.Model.Cliente.Universidad;
import tk.theunigame.unigame.R;
import tk.theunigame.unigame.app.fachadas.FachadaComunicador;
import tk.theunigame.unigame.app.fachadas.FachadaUniversidad;
import tk.theunigame.unigame.app.presentacion.util.AdaptadorListaDefault;
import tk.theunigame.unigame.app.presentacion.util.AdaptadorListaUniversidades;
import tk.theunigame.unigame.app.presentacion.util.Comunicador;

/**
 * Created by John on 09/04/2015.
 */
public class ListaUniversidades extends Activity {

    private ListView lv;
    FachadaUniversidad fachadaUniversidad;
    Class<?> destino;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_universidades);

        fachadaUniversidad= new FachadaUniversidad();
        destino = null;

        //Creamos el adaptador para el ListView
        List<Universidad> universidades = fachadaUniversidad.obtenerUniversidades(this);
        AdaptadorListaUniversidades adapter= new AdaptadorListaUniversidades(this, universidades);
        lv=(ListView) findViewById(R.id.lv_universidades);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                FachadaComunicador fachadaComunicador = new FachadaComunicador();
                if(destino == null)
                    destino = fachadaComunicador.RecibirDestinoPosicionFinal();

                fachadaComunicador.ComunicarUniversidad((Universidad)parent.getAdapter().getItem(position), destino);
                Intent intent= new Intent(ListaUniversidades.this, ListaCarreras.class);
                startActivity(intent);
            }
        });
    }

}
