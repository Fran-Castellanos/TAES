package tk.theunigame.unigame.app.presentacion.controlador.impl;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import juego.taes.domainmodel.Model.Cliente.Asignatura;
import juego.taes.domainmodel.Model.Cliente.Carrera;
import juego.taes.domainmodel.Model.Cliente.Universidad;
import tk.theunigame.unigame.R;
import tk.theunigame.unigame.app.fachadas.FachadaAsignatura;
import tk.theunigame.unigame.app.fachadas.FachadaComunicador;
import tk.theunigame.unigame.app.presentacion.util.AdaptadorListaAsignaturas;

/**
 * Created by John on 09/04/2015.
 */
public class ListaAsignaturas extends Activity {

    private Context c;
    private ListView lv;
    private TextView txt;
    private Universidad universidad;
    private Carrera carrera;
    private Boolean[] posicionAsig;
    private ArrayList<Asignatura> asignaturas;

    private FachadaComunicador fachadaComunicador;
    private FachadaAsignatura fachadaAsignatura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_asignaturas);

        //Instanciamos elementos de la vista
        txt= (TextView) findViewById(R.id.txt_title2);
        c=this;

        //Instanciamos las fachadas
        fachadaComunicador = new FachadaComunicador();
        fachadaAsignatura = new FachadaAsignatura();

        //Cargamos la información
        universidad = fachadaComunicador.RecibirUniversidadPosicion0();
        carrera = fachadaComunicador.RecibirCarreraPosicion1();
        txt.setText(carrera.getNombre());

        asignaturas = new ArrayList<>();
        //Creamos el adaptador para el ListView
        AdaptadorListaAsignaturas adapter= new AdaptadorListaAsignaturas(this, fachadaAsignatura.obtenerAsignaturas(this, universidad, carrera));

        posicionAsig = new Boolean[adapter.getAsignaturasCantidad()];
        for(int i = 0 ; i<posicionAsig.length; i++){
            posicionAsig[i]=false;
        }

        lv=(ListView) findViewById(R.id.lv_asignaturas);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){
                    //Cargamos las asignaturas a enviar
                    for(int i = 0 ; i<posicionAsig.length; i++){
                        if(posicionAsig[i])
                            asignaturas.add(((AdaptadorListaAsignaturas)parent.getAdapter()).getAsignatura(i));
                    }

                    if(asignaturas.size() > 0) {
                        Class<?> destino = fachadaComunicador.RecibirDestinoPosicionFinal();
                        //Enviamos las asignaturas a traves de la fachada
                        fachadaComunicador.ComunicarUniversidadCarreraAsignaturas(universidad,
                                carrera, asignaturas, destino);

                        //Lanzamos la actividad
                        Intent intent = new Intent(ListaAsignaturas.this, ListaBasesDatos.class);
                        startActivity(intent);
                    }else {
                        AlertDialog.Builder builder = new AlertDialog.Builder(c);
                        builder.setMessage("Seleccione una o mas asignaturas").
                                setTitle("Información").setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                        builder.create().show();
                    }

                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        asignaturas.clear();
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
