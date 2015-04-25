package tk.theunigame.unigame.app.logica_juego.temporizador;

import android.content.Context;

import tk.theunigame.unigame.app.presentacion.util.Listener.OnTiempoListener;

/**
 * Created by Paco on 24/04/2015.
 */
public class Temporizador extends Thread implements ITemporizador {

    private static Temporizador ourInstance = new Temporizador();

    private int tiempo;
    private int tiempoMax;

    private long pidCronometro;

    private Context c;





    public static Temporizador getInstance() {
        return ourInstance;
    }

    private Temporizador() {
        super();
        tiempoMax = 30;
        pidCronometro =-1;
        c = null;
        reset();
    }

    public void setContext(Context c)
    {
        this.c = c;
    }

    public long getPidCronometro()
    {
        return pidCronometro;
    }



    public int getTiempoMax() {
        return tiempoMax;
    }

    @Override
    public void setTiempoMax(int tiempoMax) {
        this.tiempoMax = tiempoMax;
    }



    @Override
    public void reset() {
        tiempo = tiempoMax;

    }

    @Override
    public void run() {
        pidCronometro = this.getId();
        //OnTiempoListener tiempoListener = new Tiempo(c);
        //tiempoListener.onReset(tiempo);
        try {
            while (tiempo>0){//mientras que haya tiempo, continúa el cronómetro.
                if(tiempo!=0) {
                    tiempo--;//Reduce el tiempo en 1 seg

                }else{
                     break;//se acabó el tiempo
                }
            }
            sleep(999);//Espera 1 segundo
            //tiempoListener.onContinue(tiempo);
        } catch (InterruptedException ex) {

        }
        //tiempoListener.onStop(tiempo);
    }




}
