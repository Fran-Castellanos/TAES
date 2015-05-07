package tk.theunigame.unigame.app.presentacion.controlador.impl;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.util.ArrayList;
import juego.taes.domainmodel.Model.Cliente.*;
import tk.theunigame.unigame.R;
import tk.theunigame.unigame.app.fachadas.*;
import tk.theunigame.unigame.app.logica_juego.bolsaPreguntas.BolsaPregunta;
import tk.theunigame.unigame.app.presentacion.util.EIDANSWER;


/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 *
 * @see tk.theunigame.unigame.util.SystemUiHider
 */
public class CrearPregunta extends Activity implements View.OnClickListener{

    private EditText etxt_a, etxt_b, etxt_c, etxt_d;
    private Button btn_a, btn_b, btn_c, btn_d;

    private int idBD;
    //Fachadas a emplear
    private FachadaBDPreguntas bolsaPreguntas;
    private FachadaRespuesta respuestaFachada;
    private FachadaPregunta preguntaFachada;
    //arrays a usar
    private Pregunta pregunta;
    private ArrayList<Respuesta> respuestas;
    private ArrayList<String> contenido;


    private EIDANSWER id_answer_selected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_pregunta);

        id_answer_selected = EIDANSWER.A;

        etxt_a = (EditText)findViewById(R.id.etxt_edit_answer_a);
        etxt_b = (EditText)findViewById(R.id.etxt_edit_answer_b);
        etxt_c = (EditText)findViewById(R.id.etxt_edit_answer_c);
        etxt_d = (EditText)findViewById(R.id.etxt_edit_answer_d);

        btn_a = (Button)findViewById(R.id.btn_edit_answer_a);
        btn_b = (Button)findViewById(R.id.btn_edit_answer_b);
        btn_c = (Button)findViewById(R.id.btn_edit_answer_c);
        btn_d = (Button)findViewById(R.id.btn_edit_answer_d);

        btn_a.setOnClickListener(this);
        btn_b.setOnClickListener(this);
        btn_c.setOnClickListener(this);
        btn_d.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        if(v.getId() != id_answer_selected.getButtonId()){
            View view = findViewById(id_answer_selected.getButtonId());
            view.setBackgroundResource(R.drawable.btn_selected_answer_default);
        }

        id_answer_selected = EIDANSWER.getByButtonId(v.getId());
        v.setBackgroundResource(R.drawable.btn_selected_answer_pressed);
    }

    public void Crear_Click(View v){

        /*//Obtenemos el contenido de los texbox
        contenido.add(etxt_a.getText().toString());
        contenido.add(etxt_b.getText().toString());
        contenido.add(etxt_c.getText().toString());
        contenido.add(etxt_d.getText().toString());

        //Creamos la pregunta
        pregunta = preguntaFachada.crearPregunta(((EditText) findViewById(R.id.etxt_question)).getText().toString());

        //Creamos las respuestas
        respuestas = respuestaFachada.crearRespuestas(pregunta,contenido);

        //Indicamos a la pregunta sus respuestas
        preguntaFachada.indicarRespuestas(pregunta,respuestas);

        //indicamos la respuesta correcta
        preguntaFachada.respuestaCorrecta(pregunta,id_answer_selected.getId());

        //Añadimos las preguntas a la BD
        BolsaPregunta.getInstance().InsertarPregunta(pregunta);*/
        //Haga lo que tenga que hacer
        Intent intent = new Intent(CrearPregunta.this, ListaPreguntas.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
    }


    @Override
    public void onBackPressed() {

        super.onBackPressed();

    }

}
