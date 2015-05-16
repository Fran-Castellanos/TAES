package tk.theunigame.unigame.app.presentacion.controlador.impl;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.sql.SQLException;
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
    FachadaComunicador fachadaComunicador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_universidades);
        fachadaComunicador = new FachadaComunicador();
        fachadaUniversidad= new FachadaUniversidad();
        destino = null;

        Class<?> d = fachadaComunicador.RecibirDestinoPosicionFinal();
        //Creamos el adaptador para el ListView
        List<Universidad> universidades = null;
        try {
            if (d.equals(Class.forName("tk.theunigame.unigame.app.presentacion.controlador.impl.ListaAsignaturasSinCB"))) {
                universidades = fachadaUniversidad.obtenerUniversidades(this);
            }else
                universidades = fachadaUniversidad.obtenerUniversidadesNoVacios(this);
        }catch (SQLException e1) {
                e1.printStackTrace();
        }catch (Exception e2)
        {

        }





        AdaptadorListaUniversidades adapter= new AdaptadorListaUniversidades(this, universidades);
        lv=(ListView) findViewById(R.id.lv_universidades);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if(destino == null)
                    destino = fachadaComunicador.RecibirDestinoPosicionFinal();

                fachadaComunicador.ComunicarUniversidad((Universidad)parent.getAdapter().getItem(position), destino);
                Intent intent= new Intent(ListaUniversidades.this, ListaCarreras.class);
                startActivity(intent);
            }
        });
    }


    @Override
    public void onBackPressed() {

        fachadaComunicador.volverAtras();

        super.onBackPressed();
    }

}
