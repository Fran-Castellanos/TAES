package tk.theunigame.unigame.app.presentacion.controlador.impl;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import juego.taes.domainmodel.Model.Cliente.Sexo;
import tk.theunigame.unigame.R;
import tk.theunigame.unigame.app.fachadas.FachadaComunicador;
import tk.theunigame.unigame.app.presentacion.util.AlertaDialogo;
import tk.theunigame.unigame.util.SystemUiHider;


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
    private TextView tv_login;

    private FachadaComunicador comunicador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        comunicador = new FachadaComunicador();


        btn_tournament_mode = (Button) findViewById(R.id.tournament_mode);

        btn_tournament_mode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this, "Próximamente...", Toast.LENGTH_SHORT).show();

            }
        });


        tv_login = (TextView) findViewById(R.id.tv_login);

        String sexo = "a";
        if(comunicador.RecibirUsuario().getSexo() == Sexo.HOMBRE)
        {
            sexo = "o";
        }
        tv_login.setText("Bienvenid" + sexo + ", " + comunicador.RecibirUsuario().getNick());

        //Instanciamos los listener
        btn_individual_mode=(Button)findViewById(R.id.individual_mode);
        btn_individual_mode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Class<?> destino = null;

                try {
                    destino = Class.forName("tk.theunigame.unigame.app.presentacion.controlador.impl.ListaAsignaturas");
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



    @Override
    protected void onResume() {

        super.onResume();
        comunicador.limpiarHistoria();

    }



    @Override
    public void onBackPressed() {

        AlertaDialogo ad = new AlertaDialogo();
        ad.setMensaje("¿Está seguro de querer salir del juego?");
        ad.setTitulo("Salir");
        ad.setBoton1("Sí");
        ad.setBoton2("No");
        ad.setDestino(MainActivity.class);
        ad.Salir();
        ad.setFlags(true);
        ad.show(getSupportFragmentManager(), "FragmentAlert");


    }
}
