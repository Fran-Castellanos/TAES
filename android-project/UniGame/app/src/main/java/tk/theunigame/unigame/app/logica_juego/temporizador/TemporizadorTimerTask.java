package tk.theunigame.unigame.app.logica_juego.temporizador;

import android.os.Handler;
import android.os.Message;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import tk.theunigame.unigame.app.presentacion.util.Listener.OnTiempoListener;

/**
 * Created by John on 25/04/2015.
 */
public class TemporizadorTimerTask {
    private  TemporizadorTimerTask meTimer= this;
    private Handler handler;
    private Timer timer;
    private TimerTask timerTask;
    private int tiempo;
    private int tiempoSet;
    private List<OnTiempoListener> listeners;

    public TemporizadorTimerTask(){
        tiempo = 60;
        listeners = new ArrayList<>();
        initHandler();
    }

    public void setTiempo(int t)
    {
        tiempoSet = t;
    }

    //Handler para comunicarnos desde el hilo al Textiew
    private void initHandler(){

        handler=new Handler(){
            @Override
            public void handleMessage(Message msg) {
                tiempo--;
                for(OnTiempoListener l: listeners)
                    l.onTiempoHaCambiado(meTimer);
                if(tiempo == 0){
                    Parar();
                    for(OnTiempoListener l: listeners)
                        l.onTiempoFinalizado(meTimer);
                }
            }
        };

    }

    //Detiene la cuenta
    public void Parar() {
        if(timer!=null) {
            timer.cancel();
            timer=null;
        }
        for(OnTiempoListener l: listeners)
            l.onParar(this);
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
        for(OnTiempoListener l: listeners)
            l.onContinuar(this);
    }

    //Reinicia la cuenta
    public void Reiniciar() {
        tiempo = tiempoSet;
        for(OnTiempoListener l: listeners)
            l.onReiniciar(this);
    }

    //Introduce un listener en el objeto
    public void setOnTiempoListener(OnTiempoListener listener){
        this.listeners.add(listener);
    }

    //Devuelve el valor del tiempo
    public int getTiempo(){
        return tiempo;
    }
}
