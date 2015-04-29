package tk.theunigame.unigame.app.presentacion.controlador.impl;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import juego.taes.domainmodel.Model.Cliente.Pregunta;
import tk.theunigame.unigame.R;
import tk.theunigame.unigame.app.fachadas.FachadaBDPreguntas;
import tk.theunigame.unigame.app.fachadas.FachadaPartida;
import tk.theunigame.unigame.app.fachadas.FachadaPregunta;
import tk.theunigame.unigame.app.fachadas.FachadaRespuesta;
import tk.theunigame.unigame.app.logica_juego.comodines.ComodinCambiarPregunta;
import tk.theunigame.unigame.app.logica_juego.comodines.ComodinPasar;
import tk.theunigame.unigame.app.presentacion.util.IActivityListaDatos;
import tk.theunigame.unigame.app.presentacion.util.EIDANSWER;
import tk.theunigame.unigame.app.presentacion.util.Listener.OnJuegoListener;


/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 *
 * @see tk.theunigame.unigame.util.SystemUiHider
 */
public class JuegoIndividual extends Activity implements View.OnClickListener, OnJuegoListener, IActivityListaDatos {

    //OnTiempoListener
    private TextView txt_a, txt_b, txt_c, txt_d;
    private TextView txt_tiempo;
    private Button btn_a, btn_b, btn_c, btn_d;
    private ImageButton cmd_1, cmd_2, cmd_3;
    private int idBD;
    //Fachadas a emplear
    private FachadaBDPreguntas bolsaPreguntas;
    private FachadaRespuesta respuestaFachada;
    private FachadaPregunta preguntaFachada;
    private FachadaPartida fachadaPartida;

    private Pregunta pregunta;

    private EIDANSWER id_answer_selected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego_individual);

        //Instanaciamos fachadas
        fachadaPartida = new FachadaPartida();

        //Instanciamos los TextView
        txt_a = (TextView)findViewById(R.id.txt_answer_a);
        txt_b = (TextView)findViewById(R.id.txt_answer_b);
        txt_c = (TextView)findViewById(R.id.txt_answer_c);
        txt_d = (TextView)findViewById(R.id.txt_answer_d);
        txt_tiempo = (TextView)findViewById(R.id.txt_tiempo);

        //Instanciamos los Botones
        btn_a = (Button)findViewById(R.id.btn_edit_answer_a);
        btn_b = (Button)findViewById(R.id.btn_edit_answer_b);
        btn_c = (Button)findViewById(R.id.btn_edit_answer_c);
        btn_d = (Button)findViewById(R.id.btn_edit_answer_d);

        //Instanaciamos los ImageButton
        cmd_1 = (ImageButton) findViewById(R.id.comodin1);
        cmd_2 = (ImageButton) findViewById(R.id.comodin2);
        cmd_3 = (ImageButton) findViewById(R.id.comodin3);

        //Añadimos los listener
        btn_a.setOnClickListener(this);
        btn_b.setOnClickListener(this);
        btn_c.setOnClickListener(this);
        btn_d.setOnClickListener(this);
        fachadaPartida.setOnJuegoListenerToJuego(this);
        cmd_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    //Pregunta pfachadaPartida.usarComodin(Comodin50.getInstance());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        cmd_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    fachadaPartida.usarComodin(ComodinPasar.getInstance());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        cmd_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    fachadaPartida.usarComodin(ComodinCambiarPregunta.getInstance());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        fachadaPartida.inicializarPartida();
    }

    //Evento a realizar cuando se seleccione una respuesta de los cuatros botones
    @Override
    public void onClick(View v) {
        if(id_answer_selected != null && (v.getId() != id_answer_selected.getButtonId())){
            View view = findViewById(id_answer_selected.getButtonId());
            view.setBackgroundResource(R.drawable.etxt_edit_answer);
        }

        id_answer_selected = EIDANSWER.getByButtonId(v.getId());
        v.setBackgroundResource(R.drawable.btn_selected_answer_pressed);
    }

    //Evento a realizar para confirmar los cambios
    public void Confirmar_Click(View v){
        boolean correcto= false;
        //Comprobar si es correco
        View view = findViewById(id_answer_selected.getButtonId());
        if(!correcto) {
            //Cmabio de color de la respuesta incorrecta a btn_selected_answer_default
            view.setBackgroundResource(R.drawable.btn_selected_answer_default);

            //Cambiar el color de la respuesta correcta a btn_selected_answer_default
        }else{
            //Acción a realizar si es correcta la respuesta
        }
    }

    //Acción a realizar cuando se acabe el tiempo
    @Override
    public void onTiempoFinalizado(String mensaje) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(mensaje).
                setTitle("Información").setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.create().show();
        //Cambiar colores de botones en las que sean correctas
    }

    @Override
    public void onTiempoHaCambiado(int tiempo) {
        txt_tiempo.setText(tiempo);
    }

    @Override
    public void onJuegoHaAcabado(int acertadas, int falladas, int comodinesUsados) {
        //TODO
    }

    @Override
    public void onPreguntaHaCambiado(Pregunta pregunta) {
        //TODO
    }

    @Override
    public void onComodinUsado(Pregunta p, String mensaje) {
        //TODO
    }
}
