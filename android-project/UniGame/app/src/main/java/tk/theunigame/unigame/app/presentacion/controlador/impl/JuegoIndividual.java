package tk.theunigame.unigame.app.presentacion.controlador.impl;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Scroller;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import juego.taes.domainmodel.Model.Cliente.Asignatura;
import juego.taes.domainmodel.Model.Cliente.BDPreguntas;
import juego.taes.domainmodel.Model.Cliente.Carrera;
import juego.taes.domainmodel.Model.Cliente.Pregunta;
import juego.taes.domainmodel.Model.Cliente.Respuesta;
import juego.taes.domainmodel.Model.Cliente.Universidad;
import tk.theunigame.unigame.R;
import tk.theunigame.unigame.app.fachadas.FachadaBDPreguntas;
import tk.theunigame.unigame.app.fachadas.FachadaComunicador;
import tk.theunigame.unigame.app.fachadas.FachadaPartida;
import tk.theunigame.unigame.app.fachadas.FachadaPregunta;
import tk.theunigame.unigame.app.fachadas.FachadaRespuesta;
import tk.theunigame.unigame.app.logica_juego.comodines.ComodinCambiarPregunta;
import tk.theunigame.unigame.app.logica_juego.comodines.ComodinPasar;
import tk.theunigame.unigame.app.logica_juego.juego.Estadisticas;
import tk.theunigame.unigame.app.logica_juego.juego.Juego;
import tk.theunigame.unigame.app.presentacion.util.IActivityListaDatos;
import tk.theunigame.unigame.app.presentacion.util.EIDANSWER;
import tk.theunigame.unigame.app.presentacion.util.Listener.OnJuegoListener;


/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 *
 * @see tk.theunigame.unigame.util.SystemUiHider
 */
public class JuegoIndividual extends Activity implements View.OnClickListener, OnJuegoListener {

    //OnTiempoListener
    private TextView txt_a, txt_b, txt_c, txt_d, txt_question;
    private TextView txt_tiempo;
    private Button btn_a, btn_b, btn_c, btn_d;
    private ImageButton cmd_1, cmd_2, cmd_3;
    private int idBD;
    //Fachadas a emplear
    private FachadaPartida fachadaPartida;
    private FachadaPregunta fachadaPregunta;
    private FachadaComunicador comunicador;

    private Timer timer;
    private TimerTask timerTask;
    Handler handler;

    private Universidad universidad;
    private ArrayList<Asignatura> asignaturas;
    private ArrayList<BDPreguntas> bdPreguntases;
    private Carrera carrera;

    private Pregunta pregunta;

    private EIDANSWER id_answer_selected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego_individual);

        //Instanaciamos fachadas
        fachadaPartida = new FachadaPartida();
        fachadaPregunta = new FachadaPregunta();
        comunicador = new FachadaComunicador();

        //Instanciamos los TextView
        txt_a = (TextView)findViewById(R.id.txt_answer_a);
        txt_b = (TextView)findViewById(R.id.txt_answer_b);
        txt_c = (TextView)findViewById(R.id.txt_answer_c);
        txt_d = (TextView)findViewById(R.id.txt_answer_d);


        txt_question = (TextView) findViewById(R.id.txt_question);
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

        //Instanciamos el handler
        handler = new Handler(){
            @Override
            public void handleMessage(Message msg){
                fachadaPartida.siguientePregunta();
            }
        };

        //Cargamos los datos
        bdPreguntases = comunicador.RecibirBDPreguntasPosicion0();
        fachadaPartida.inicializarPartida();
        fachadaPregunta.cargarPreguntas(this, bdPreguntases);

        Juego j = Juego.getInstance();
        j.setOnJuegoListener(this);
        fachadaPartida.siguientePregunta();
    }

    //Evento a realizar cuando se seleccione una respuesta de los cuatros botones
    @Override
    public void onClick(View v) {

        btn_a.setClickable(false);
        btn_b.setClickable(false);
        btn_c.setClickable(false);
        btn_d.setClickable(false);

        //TODO COntrolar bien los colores
        if(id_answer_selected != null && (v.getId() != id_answer_selected.getButtonId())){
            View view = findViewById(id_answer_selected.getButtonId());
            view.setBackgroundResource(R.drawable.etxt_edit_answer);
        }



        id_answer_selected = EIDANSWER.getByButtonId(v.getId());
        v.setBackgroundResource(R.drawable.btn_selected_answer_pressed);

        fachadaPartida.comprobarPregunta(id_answer_selected.getId());

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                fachadaPartida.siguientePregunta();
                btn_a.setClickable(true);
                btn_b.setClickable(true);
                btn_c.setClickable(true);
                btn_d.setClickable(true);
            }
        }, 2000);

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
        //TODO Comprobar si la ejecución de AlertDialog comparte hilo
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(mensaje).
                setTitle("Tiempo Agotado").setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                fachadaPartida.siguientePregunta();
            }
        });
        builder.create().show();


    }

    @Override
    public void onTiempoHaCambiado(int tiempo) {
        txt_tiempo.setText("" + tiempo);
    }

    @Override
    public void onJuegoHaAcabado(Estadisticas estadisticas) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setMessage("¡Ha acabado la partida!").
                setTitle("Fin de partida").setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();

                //Lanzamos la actividad
                Intent intent = new Intent(JuegoIndividual.this, EstadisticasPartida.class);
                startActivity(intent);
            }
        });
        builder.create().show();


        Class<?> destino = null;
        try {
            destino = Class.forName("tk.theunigame.unigame.app.presentacion.controlador.impl.EstadisticasPartida");
        } catch (ClassNotFoundException e) {
            new RuntimeException();
        }
        comunicador.ComunicarDestino(destino);

        //Enviamos las bdPreguntas a traves de la fachada
        comunicador.ComunicarEstadisticas(estadisticas, destino);
    }

    @Override
    public void onPreguntaHaCambiado(Pregunta pregunta) {
        //this.pregunta = pregunta;

        txt_question.setText(pregunta.getContenido());
        List<Respuesta> l = (List<Respuesta>)pregunta.getRespuestasList();
        txt_a.setText(l.get(0).getContenido());
        txt_b.setText(l.get(1).getContenido());
        txt_c.setText(l.get(2).getContenido());
        txt_d.setText(l.get(3).getContenido());

    }

    @Override
    public void onPreguntaRespondida(int correcta) {

        View view = findViewById(id_answer_selected.getButtonId());
        int id = id_answer_selected.getId();
        if(id == correcta)
        {
            view.setBackgroundResource(R.drawable.btn_selected_answer_pressed);
        }
        else
        {
            view.setBackgroundResource(R.drawable.btn_selected_answer_default);
        }

        fachadaPartida.apagarCronometro();
    }



    @Override
    public void onComodinUsado(Pregunta p, String mensaje) {
        //TODO
    }


    @Override
    public void onBackPressed() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setMessage("¿Está seguro de querer abandonar la partida?").
                setTitle("Salir de la partida").setPositiveButton("Salir", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                fachadaPartida.apagarCronometro();
                //Lanzamos la actividad
                Intent intent = new Intent(JuegoIndividual.this, MainActivity.class);
                startActivity(intent);
            }
        }).setNegativeButton("Seguir jugando", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();

            }
        });
        builder.create().show();




        }
    }
