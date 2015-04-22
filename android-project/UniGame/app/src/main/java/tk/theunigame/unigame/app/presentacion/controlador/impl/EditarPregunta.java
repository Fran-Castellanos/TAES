package tk.theunigame.unigame.app.presentacion.controlador.impl;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import tk.theunigame.unigame.R;


/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 *
 * @see tk.theunigame.unigame.util.SystemUiHider
 */
public class EditarPregunta extends Activity implements View.OnClickListener{

    EditText etxt_a;
    EditText etxt_b;
    EditText etxt_c;
    EditText etxt_d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_pregunta);

        /*etxt_a = (EditText)findViewById(R.id.etxt_answer_a);
        etxt_b = (EditText)findViewById(R.id.etxt_answer_b);
        etxt_c = (EditText)findViewById(R.id.etxt_answer_c);
        etxt_d = (EditText)findViewById(R.id.etxt_answer_d);

        etxt_a.setOnClickListener(this);
        etxt_b.setOnClickListener(this);
        etxt_c.setOnClickListener(this);
        etxt_d.setOnClickListener(this);*/
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
        }
    }
}
