package tk.theunigame.unigame.app.presentacion.controlador.impl;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import juego.taes.domainmodel.Model.Cliente.Asignatura;
import juego.taes.domainmodel.Model.Cliente.BDPreguntas;
import juego.taes.domainmodel.Model.Cliente.Carrera;
import juego.taes.domainmodel.Model.Cliente.Universidad;
import tk.theunigame.unigame.R;
import tk.theunigame.unigame.app.fachadas.FachadaBDPreguntas;
import tk.theunigame.unigame.app.fachadas.FachadaComunicador;
import tk.theunigame.unigame.app.presentacion.util.AdaptadorListaBasesDatos;

/**
 * Created by John on 09/04/2015.
 */
public class ListaBasesDatosSinCB extends Activity {

    private ListView lv;
    private TextView txt;
    private Button btn;

    private FachadaComunicador fachadaComunicador;
    private FachadaBDPreguntas fachadaBasesDatos;

    private Universidad universidad;
    private Carrera carrera;
    private Asignatura asignatura;

    private Boolean[] posicionAsig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_bases_datos_sin_button);

        //Instanciamos elementos de la interfaz
        txt= (TextView) findViewById(R.id.txt_title2);
        lv=(ListView) findViewById(R.id.lv_bases_datos);
        btn = (Button) findViewById(R.id.btn_confirmar);

        //Instanciamos las fachadas
        fachadaComunicador = new FachadaComunicador();
        fachadaBasesDatos = new FachadaBDPreguntas();

        //Cargamos la información
        universidad = fachadaComunicador.RecibirUniversidadPosicion0();
        carrera = fachadaComunicador.RecibirCarreraPosicion1();
        asignatura = fachadaComunicador.RecibirAsignaturaPosicion2();
        txt.setText(asignatura.getNombre());

        //Creamos el adaptador para el ListView
        ArrayList<BDPreguntas> bdPreguntas= fachadaBasesDatos.obtenerBasesDatos(this, universidad, carrera, asignatura);//Recibimos la lista de preguntas
        BaseAdapter adapter= new AdaptadorListaBasesDatos(this, bdPreguntas);
        lv.setAdapter(adapter);

        //Instanciamos Listeners
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListaBasesDatosSinCB.this, JuegoIndividual.class);
                startActivity(intent);
            }
        });
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //Comunicador.setObject(parent.getAdapt         er().getItem(position));
                //Intent intent = new Intent(ListaBasesDatos.this, ListaUniversidades.class);
                //startActivity(intent);
            }
        });

        //Iniciamos los elementos del Array de los checkbox
        posicionAsig = new Boolean[adapter.getCount()];
        for(int i = 0 ; i<posicionAsig.length; i++){
            posicionAsig[i]=false;
        }
    }

    public void onCheckBoxClicked(View view){
        CheckBox chkBox = (CheckBox) view;

        //Recupera el objeto vinculado al checkbox para introducirlo en el arraylist
        if(chkBox.isChecked())
            posicionAsig[(Integer)chkBox.getTag()]=true;
        else
            posicionAsig[(Integer)chkBox.getTag()]=false;
    }

}
