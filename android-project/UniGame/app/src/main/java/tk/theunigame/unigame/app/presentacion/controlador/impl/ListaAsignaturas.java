package tk.theunigame.unigame.app.presentacion.controlador.impl;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
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

    private ListView lv;
    private TextView txt;
    private Button btn;
    private Universidad universidad;
    private Carrera carrera;
    private Boolean[] posicionAsig;
    private ArrayList<Asignatura> asignaturas;
    private ArrayList<Asignatura> asignaturasConsulta;

    private FachadaComunicador fachadaComunicador;
    private FachadaAsignatura fachadaAsignatura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_asignaturas);

        //Instanciamos elementos de la vista
        txt= (TextView) findViewById(R.id.txt_title2);
        btn = (Button) findViewById(R.id.btn_confirmar);
        lv = (ListView) findViewById(R.id.lv_asignaturas);

        //Instanciamos las fachadas
        fachadaComunicador = new FachadaComunicador();
        fachadaAsignatura = new FachadaAsignatura();

        //Cargamos la información
        universidad = fachadaComunicador.RecibirUniversidadPosicion0();
        carrera = fachadaComunicador.RecibirCarreraPosicion1();
        txt.setText(carrera.getNombre());

        asignaturas = new ArrayList<>();
        asignaturasConsulta = fachadaAsignatura.obtenerAsignaturas(this, universidad, carrera);
        //Creamos el adaptador para el ListView
        BaseAdapter adapter= new AdaptadorListaAsignaturas(this, asignaturasConsulta);
        lv.setAdapter(adapter);

        //Asignamos listener
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressDialog dialog = ProgressDialog.show(ListaAsignaturas.this, "",
                        "Cargando...", true);
                //Cargamos las asignaturas a enviar
                for(int i = 0 ; i<posicionAsig.length; i++){
                    if(posicionAsig[i])
                        asignaturas.add(asignaturasConsulta.get(i));
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
                    AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());
                    builder.setMessage("Seleccione una o más asignaturas").
                            setTitle("Información").setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
                    builder.create().show();
                }

                dialog.cancel();

            }
        });

        posicionAsig = new Boolean[asignaturasConsulta.size()];
        for(int i = 0 ; i<posicionAsig.length; i++){
            posicionAsig[i]=false;
        }
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


    @Override
    public void onBackPressed() {

        fachadaComunicador.volverAtras();
        super.onBackPressed();
    }
}
