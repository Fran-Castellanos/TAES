package tk.theunigame.unigame.app.presentacion.controlador.impl;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.util.ArrayList;
import java.util.List;

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

        if(CamposRellenos(((EditText) findViewById(R.id.etxt_question)).getText().toString(),
                etxt_a.getText().toString(),etxt_b.getText().toString(),
                etxt_c.getText().toString(),etxt_d.getText().toString())) {

            List<Respuesta> respuestas = new ArrayList<Respuesta>();

            Pregunta pregunta1 = new Pregunta(((EditText) findViewById(R.id.etxt_question)).getText().toString(), false);
            pregunta1.setBdPreguntas(BolsaPregunta.getInstance().getBDPreguntas());


            Respuesta respuesta1 = new Respuesta(etxt_a.getText().toString(), false, false);
            respuesta1.setPregunta(pregunta1);
            Respuesta respuesta2 = new Respuesta(etxt_b.getText().toString(), false, false);
            respuesta2.setPregunta(pregunta1);
            Respuesta respuesta3 = new Respuesta(etxt_c.getText().toString(), false, false);
            respuesta3.setPregunta(pregunta1);
            Respuesta respuesta4 = new Respuesta(etxt_d.getText().toString(), false, false);
            respuesta4.setPregunta(pregunta1);

            respuestas.add(respuesta1);
            respuestas.add(respuesta2);
            respuestas.add(respuesta3);
            respuestas.add(respuesta4);

            respuestas.get(id_answer_selected.getId()).setEsCorrecta(true);

            pregunta1.setRespuestas(respuestas);

            //Añadimos las preguntas a la BD
            BolsaPregunta.getInstance().InsertarPregunta(pregunta1);

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("¡Creación Completada!").
                    setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();

                            //Haga lo que tenga que hacer
                            Intent intent = new Intent(CrearPregunta.this, ListaPreguntas.class);
                            startActivity(intent);
                        }
                    });
            builder.create().show();
        }
        else
        {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Introduce todos los campos").
                    setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
            builder.create().show();
        }
    }

    public void Cancelar_Click(View v)
    {
        onBackPressed();
    }

    public boolean CamposRellenos(String pregunta,String res1,String res2,String res3,String res4)
    {
        boolean comprobacion = false;
        if(!pregunta.equals("") && !res1.equals("") && !res2.equals("") && !res3.equals("") && !res4.equals(""))
        {
            comprobacion = true;
        }
     return comprobacion;
    }


    @Override
    public void onBackPressed() {

        super.onBackPressed();
    }

}
