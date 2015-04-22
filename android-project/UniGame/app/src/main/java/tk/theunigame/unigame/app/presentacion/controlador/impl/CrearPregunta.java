package tk.theunigame.unigame.app.presentacion.controlador.impl;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import tk.theunigame.unigame.R;
import tk.theunigame.unigame.app.fachadas.FachadaBDPreguntas;
import tk.theunigame.unigame.app.fachadas.FachadaRespuesta;


/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 *
 * @see tk.theunigame.unigame.util.SystemUiHider
 */
public class CrearPregunta extends Activity implements View.OnClickListener{

    EditText etxt_a, etxt_b, etxt_c, etxt_d;
    Button btn_a, btn_b, btn_c, btn_d;


    //Fachadas a emplear
    FachadaBDPreguntas bolsaPreguntas;


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

      //  bolsaPreguntas.RecuperarBolsa(id);
        FachadaRespuesta respuestaA= new FachadaRespuesta(etxt_a.getText().toString());
        FachadaRespuesta respuestaB= new FachadaRespuesta(etxt_b.getText().toString());
        FachadaRespuesta respuestaC= new FachadaRespuesta(etxt_c.getText().toString());
        FachadaRespuesta respuestaD= new FachadaRespuesta(etxt_d.getText().toString());

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
