package tk.theunigame.unigame.app.presentacion.controlador.impl;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.support.v4.app.FragmentActivity;
import tk.theunigame.unigame.R;
import tk.theunigame.unigame.app.fachadas.FachadaComunicador;
import tk.theunigame.unigame.app.fachadas.FachadaPartida;
import tk.theunigame.unigame.app.logica_juego.comodines.ComodinCambiarPregunta;
import tk.theunigame.unigame.app.logica_juego.juego.Estadisticas;
import tk.theunigame.unigame.app.presentacion.util.AlertaDialogo;


/**
 * Created by Paco on 02/05/2015.
 */
public class EstadisticasPartida extends FragmentActivity {

    TextView txtNumPreguntas, txt_numCorrectas, txt_numIncorrectas, txt_nota;
    Button btn_finPartida;
    FachadaComunicador comunicador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estadisticas_partida);

        comunicador = new FachadaComunicador();

        //Instanciamos los TextView
        txtNumPreguntas = (TextView) findViewById(R.id.txtNumPreguntas);
        txt_numCorrectas = (TextView) findViewById(R.id.txt_numCorrectas);
        txt_numIncorrectas = (TextView) findViewById(R.id.txt_numIncorrectas);
        txt_nota = (TextView) findViewById(R.id.txt_nota);

        //Instanciamos Button
        btn_finPartida = (Button) findViewById(R.id.btn_finPartida);

        Estadisticas estadisticas = comunicador.RecibirEstadisticasPosicion0();

        txtNumPreguntas.setText(""+estadisticas.getNumPreguntas());
        txt_numCorrectas.setText("" + estadisticas.getAcertadas());
        txt_numIncorrectas.setText("" + estadisticas.getFalladas());
        double nota = estadisticas.getNota();
        txt_nota.setText("" + nota);

        if(nota<5)
            txt_nota.setTextColor(Color.RED);
        else
            txt_nota.setTextColor(Color.GREEN);



        btn_finPartida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Lanzamos la actividad
                Intent intent = new Intent(EstadisticasPartida.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                finish();
                startActivity(intent);
            }
        });
    }


    @Override
    public void onBackPressed() {


        AlertaDialogo ad = new AlertaDialogo();
        ad.setMensaje("¿Desea volver al menú principal?");
        ad.setTitulo("Salir");
        ad.setBoton1("Sí");
        ad.setBoton2("No");
        ad.setDestino(MainActivity.class);
        ad.setFlags(true);
        ad.show(getSupportFragmentManager(), "FragmentAlert");



    }

}
