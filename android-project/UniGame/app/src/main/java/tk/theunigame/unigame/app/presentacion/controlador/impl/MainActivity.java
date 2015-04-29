package tk.theunigame.unigame.app.presentacion.controlador.impl;

import juego.taes.domainmodel.Model.Cliente.Universidad;
import tk.theunigame.unigame.R;
import tk.theunigame.unigame.app.presentacion.util.DialogLogin;
import tk.theunigame.unigame.util.SystemUiHider;

import android.app.Activity;
import android.app.DialogFragment;
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
    private Button btn_loggin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_loggin = (Button) findViewById(R.id.btn_login);
        btn_loggin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                android.support.v4.app.DialogFragment login = new DialogLogin();
                login.show(getSupportFragmentManager(), "LoginDialog");
            }
        });
        btn_individual_mode=(Button)findViewById(R.id.individual_mode);
        btn_individual_mode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this, ListaUniversidades.class);
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
                Intent intent= new Intent(MainActivity.this, UsarDB.class);
                startActivity(intent);
            }
        });
    }


}
