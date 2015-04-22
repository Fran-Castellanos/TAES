package tk.theunigame.unigame.app.presentacion.controlador.impl;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.j256.ormlite.dao.ForeignCollection;

import java.util.ArrayList;

import juego.taes.domainmodel.Model.Cliente.*;
import tk.theunigame.unigame.R;
import tk.theunigame.unigame.app.fachadas.*;


/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 *
 * @see tk.theunigame.unigame.util.SystemUiHider
 */
public class CrearPregunta extends Activity implements View.OnClickListener{

    EditText etxt_a, etxt_b, etxt_c, etxt_d;
    Button btn_a, btn_b, btn_c, btn_d;
    private int idBD;
    //Fachadas a emplear
    FachadaBDPreguntas bolsaPreguntas;
    FachadaRespuesta respuestaFachada;
    FachadaPregunta preguntaFachada;
    //arrays a usar
    ArrayList<Pregunta> preguntas;
    ArrayList<Respuesta> respuestas;
    ArrayList<String> contenido;


    private EIDANSWER id_answer_selected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_pregunta);

        // bolsaPreguntas.RecuperarBDPreguntas(idDB);
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

        //obtenemos el contenido de los texbox
        contenido.add(etxt_a.getText().toString());
        contenido.add(etxt_b.getText().toString());
        contenido.add(etxt_c.getText().toString());
        contenido.add(etxt_d.getText().toString());
        //creamos las respuestas
        respuestas=respuestaFachada.obtenerRespuestas(contenido);
        //creamos la pregunta
        preguntas.add(preguntaFachada.crearPregunta(((EditText) findViewById(R.id.etxt_question)).getText().toString()));
        preguntaFachada.indicarRespuestas(preguntas.get(preguntas.size()-1),respuestas);

        id_answer_selected.getId();

    }

    private static enum EIDANSWER {
        A(0, R.id.btn_edit_answer_a), B(1, R.id.btn_edit_answer_b), C(2, R.id.btn_edit_answer_c), D(3, R.id.btn_edit_answer_d);

        private final int id;
        private final int b_id;

        private EIDANSWER(int id, int b_id){
            this.id=id;
            this.b_id=b_id;
        }

        //Devuelve el valor de la Id
        public int getId(){return id;}

        //Devuelve el id del batón
        public int getButtonId(){return b_id;}

        public static EIDANSWER getByButtonId(int id) {
            EIDANSWER salida;
            switch (id){
                case R.id.btn_edit_answer_a: salida= A;
                break;
                case R.id.btn_edit_answer_b: salida= B;
                break;
                case R.id.btn_edit_answer_c: salida= C;
                break;
                case R.id.btn_edit_answer_d: salida= D;
                break;
                default: throw new RuntimeException("No se ha introducido un Id de Botón válido");
            }

            return salida;
        }
    }
}
