package tk.theunigame.unigame.app.presentacion.util.Views;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by John on 21/04/2015.
 */
public class Tiempo extends TextView implements OnTiempoListener{
    private Handler handler;
    Timer timer;
    TimerTask timerTask;

    public Tiempo(Context context){
        super(context);
        setText("0");
        initHandler();
    }

    public Tiempo(Context context, AttributeSet attr, int defStyle){
        super(context, attr, defStyle);
        setText("0");
        initHandler();
    }

    public Tiempo(Context context, AttributeSet attr){
        super(context, attr);
        setText("0");
        initHandler();
    }

    //Handler para comunicarnos desde el hilo al Textiew
    private void initHandler(){

        handler=new Handler(){
            @Override
            public void handleMessage(Message msg) {
                setText(Integer.toString(Integer.parseInt(getText().toString()) + 1));
            }
        };

    }

    //Detenemos la ejecución
    @Override
    public void onParar() {
        if(timer!=null) {
            timer.cancel();
            timer=null;
        }
    }

    //Continuamos la ejecución
    @Override
    public void onContinuar() {
        if(timer==null) {
            timer = new Timer();

            //Iniciamos el timer task
            timerTask= new TimerTask() {
                @Override
                public void run() {
                    handler.sendEmptyMessage(0);
                }
            };

            //Programamos la tarea para que se ejecute una vez por segundo, es decir incremente en uno
            //el valor de la vista
            timer.schedule(timerTask, 0, 1000);
        }
    }

    @Override
    public void onReiniciar() {
        setText("0");
    }
}
