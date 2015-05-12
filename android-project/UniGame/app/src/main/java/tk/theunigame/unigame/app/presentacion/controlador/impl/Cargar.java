package tk.theunigame.unigame.app.presentacion.controlador.impl;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;

import tk.theunigame.unigame.R;

/**
 * Created by Paco on 02/05/2015.
 */
public class Cargar extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cargar);


        ProgressDialog dialog = ProgressDialog.show(Cargar.this, "",
                "Cargando...", true);
    }

    @Override
    public void onBackPressed() {

        setContentView(R.layout.activity_cargar);
        super.onBackPressed();
    }
}
