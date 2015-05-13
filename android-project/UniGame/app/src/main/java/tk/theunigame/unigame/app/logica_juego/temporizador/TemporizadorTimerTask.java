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
    private OnTiempoListener listener;

    public TemporizadorTimerTask(){
        tiempoSet = 30;
        tiempo = tiempoSet;

        //listeners = new ArrayList<>();
        listener = null;
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
                //for(OnTiempoListener l: listeners)
                if(listener!=null )
                    listener.onTiempoHaCambiado(meTimer);
                if(tiempo == 0){
                    Parar();
                    //for(OnTiempoListener l: listeners)
                    if(listener!=null )
                        listener.onTiempoFinalizado(meTimer);
                    tiempo=0;
                }
            }
        };

    }

    //Detiene la cuenta
    public void Parar() {
        if(timer!=null) {
            timer.cancel();

            //timerTask.cancel();


            timer=null;
            timerTask=null;

        }
        //for(OnTiempoListener l: listeners)
        if(listener!=null )
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
        //for(OnTiempoListener l: listeners)
        if(listener!=null )
            listener.onContinuar(this);
    }

    //Reinicia la cuenta
    public void Reiniciar() {
        tiempo = tiempoSet;
        Continuar();

    }

    //Introduce un listener en el objeto
    public void setOnTiempoListener(OnTiempoListener listener){
        if(this.listener!=null)
            Parar();
        this.listener = listener;
    }

    //Devuelve el valor del tiempo
    public int getTiempo(){
        return tiempo;
    }
}
