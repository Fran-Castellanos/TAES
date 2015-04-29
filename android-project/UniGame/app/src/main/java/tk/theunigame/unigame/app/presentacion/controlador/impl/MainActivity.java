package tk.theunigame.unigame.app.presentacion.controlador.impl;

import tk.theunigame.unigame.R;
import tk.theunigame.unigame.app.fachadas.FachadaComunicador;
import tk.theunigame.unigame.app.presentacion.util.DialogLogin;
import tk.theunigame.unigame.app.presentacion.util.IActivityListaDatos;
import tk.theunigame.unigame.util.SystemUiHider;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;


/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 *
 * @see SystemUiHider
 */
public class MainActivity extends FragmentActivity {

    private Button btn_individual_mode;
    private Button btn_tournament_mode;
    private Button btn_download_questions;
    private Button btn_use_questions;

    private FachadaComunicador comunicador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Instanciamos los listener
        btn_individual_mode=(Button)findViewById(R.id.individual_mode);
        btn_individual_mode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Class<?> destino = null;
                try {
                    destino = Class.forName("JuegoIndividual");
                } catch (ClassNotFoundException e) {
                    new RuntimeException();
                }
                Intent intent= new Intent(MainActivity.this, ListaUniversidades.class);
                comunicador.ComunicarDestino(destino);
                startActivity(intent);
            }
        });
        btn_download_questions=(Button)findViewById(R.id.download_questions);
        btn_download_questions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this, BajarDB.class);
                startActivity(intent);
            }
        });
        btn_use_questions= (Button)findViewById(R.id.use_questions);
        btn_use_questions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this, GestionarDB.class);
                startActivity(intent);
            }
        });
    }


}
