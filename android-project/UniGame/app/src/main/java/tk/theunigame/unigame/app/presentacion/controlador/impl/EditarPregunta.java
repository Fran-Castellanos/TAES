package tk.theunigame.unigame.app.presentacion.controlador.impl;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import com.j256.ormlite.dao.EagerForeignCollection;
import com.j256.ormlite.dao.ForeignCollection;

import java.util.ArrayList;
import java.util.List;

import juego.taes.domainmodel.Model.Cliente.Pregunta;
import juego.taes.domainmodel.Model.Cliente.Respuesta;
import juego.taes.domainmodel.Repository.PreguntaRepository;
import tk.theunigame.unigame.R;
import tk.theunigame.unigame.app.fachadas.FachadaComunicador;
import tk.theunigame.unigame.app.logica_juego.bolsaPreguntas.BolsaPregunta;
import tk.theunigame.unigame.app.presentacion.util.AlertaDialogo;
import tk.theunigame.unigame.app.presentacion.util.Comunicador;
import tk.theunigame.unigame.app.presentacion.util.EIDANSWER;

/**
 * Created by Pedro on 28/04/2015.
 */
public class EditarPregunta extends Activity implements View.OnClickListener
{
    private EditText etxt_a, etxt_b, etxt_c, etxt_d,etxt_question;
    private Button btn_a, btn_b, btn_c, btn_d;

    private FachadaComunicador fachadaComunicador;
    private Pregunta preguntarecuperada;
    private ArrayList<Respuesta> respuestasrecuperadas;

    private EIDANSWER id_answer_selected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_pregunta);

        fachadaComunicador = new FachadaComunicador();
        id_answer_selected = EIDANSWER.A;

        etxt_question = (EditText)findViewById(R.id.etxt_question);

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

        //Obtengo el objeto pregunta y la lista de respuestas
        preguntarecuperada = fachadaComunicador.RecibirPregunta();

        respuestasrecuperadas= new ArrayList<Respuesta>(preguntarecuperada.getRespuestas());

        //Actualizo los textView
        etxt_question.setText(preguntarecuperada.getContenido());

        etxt_a.setText(respuestasrecuperadas.get(0).getContenido());
        etxt_b.setText(respuestasrecuperadas.get(1).getContenido());
        etxt_c.setText(respuestasrecuperadas.get(2).getContenido());
        etxt_d.setText(respuestasrecuperadas.get(3).getContenido());

        for(int i=0;i<4;i++)
        {
            if(respuestasrecuperadas.get(i).getEsCorrecta()) {
                id_answer_selected = EIDANSWER.getById(i);
                View v = findViewById(id_answer_selected.getButtonId());
                v.setBackgroundResource(R.drawable.btn_selected_answer_pressed);
                break;
            }
        }
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

    public void Eliminar_Click(View v)
    {
        BolsaPregunta.getInstance().EliminarPregunta(preguntarecuperada);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("¡Eliminación Completada!").
                setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();

                        Intent intent = new Intent(EditarPregunta.this, ListaPreguntas.class);
                        startActivity(intent);
                    }
                });
        builder.create().show();

    }

    public void Modificar_Click(View v)
    {
        preguntarecuperada.setContenido(etxt_question.getText().toString());

        List<Respuesta> recuperadas = preguntarecuperada.getRespuestas();

        //Poner a false
        for(Respuesta x : recuperadas)
        {
            x.setEsCorrecta(false);
        }

        int i=0;
        for(Respuesta x : recuperadas)
        {
            switch (i) {
                case 0:
                    if(id_answer_selected.getId() == 0)
                        x.setEsCorrecta(true);
                    x.setContenido(etxt_a.getText().toString());
                    break;
                case 1:
                    if(id_answer_selected.getId() == 1)
                        x.setEsCorrecta(true);
                    x.setContenido(etxt_b.getText().toString());
                    break;
                case 2:
                    if(id_answer_selected.getId() == 2)
                        x.setEsCorrecta(true);
                    x.setContenido(etxt_c.getText().toString());
                    break;
                case 3:
                    if(id_answer_selected.getId() == 3)
                        x.setEsCorrecta(true);
                    x.setContenido(etxt_d.getText().toString());
                    break;
            }
            i++;
        }

        preguntarecuperada.setRespuestas(recuperadas);
        BolsaPregunta.getInstance().ModificarPreguntaInsertada(preguntarecuperada);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("¡Modificación Completada!").
                setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();

                        Intent intent = new Intent(EditarPregunta.this, ListaPreguntas.class);
                        startActivity(intent);
                    }
                });
        builder.create().show();

    }

    @Override
    public void onBackPressed() {

        fachadaComunicador.volverAtras();
        super.onBackPressed();
    }
}
