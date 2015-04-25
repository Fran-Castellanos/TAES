package tk.theunigame.unigame.app.logica_juego.temporizador;

import android.os.Handler;
import android.os.Message;

import java.util.Timer;
import java.util.TimerTask;

import tk.theunigame.unigame.app.presentacion.util.Listener.OnTiempoListener;

/**
 * Created by John on 25/04/2015.
 */
public class TemporizadorTimerTask {
    private Handler handler;
    private Timer timer;
    private TimerTask timerTask;
    private int tiempo;
    private OnTiempoListener listener;

    public TemporizadorTimerTask(){
        tiempo = 60;
        listener = null;
        initHandler();
    }


    public void setTiempo(int t)
    {
        tiempo = t;
    }

    //Handler para comunicarnos desde el hilo al Textiew
    private void initHandler(){

        handler=new Handler(){
            @Override
            public void handleMessage(Message msg) {
                tiempo--;
            }
        };

    }

    //Detiene la cuenta
    public void Parar() {
        if(timer!=null) {
            timer.cancel();
            timer=null;
        }
        if(listener != null)
            listener.onParar(this);
    }

    //Continua la cuenta
    public void Continuar() {
        if(timer==null) {
            timer = new Timer();

            //Iniciamos el timer task
            timerTask= new TimerTask() {
                @Override
                public void run() {
                    handler.sendEmptyMessage(0);
                }
            };

            //Programamos la tarea para que se ejecute una vez por segundo, es decir decremente en uno
            //el valor de la vista
            timer.schedule(timerTask, 0, 1000);
        }
        if(listener != null)
            listener.onContinuar(this);
    }

    //Reinicia la cuenta
    public void Reiniciar() {
        tiempo = 60;
        if(listener != null)
            listener.onReiniciar(this);
    }

    //Introduce un listner en el objeto
    public void setOnTiempoListener(OnTiempoListener listener){
        this.listener = listener;
    }

    //Devuelve el valor del tiempo
    public int getTiempo(){
        return tiempo;
    }
}
