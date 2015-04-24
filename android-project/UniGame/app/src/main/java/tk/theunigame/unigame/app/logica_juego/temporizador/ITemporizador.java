package tk.theunigame.unigame.app.logica_juego.temporizador;

import android.content.Context;

/**
 * Created by Paco on 23/04/2015.
 */
public interface ITemporizador {
    public void reset();
    public void run();
    public void setTiempoMax(int tiempoMax);
    public void setContext (Context c);
}
