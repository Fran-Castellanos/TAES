package tk.theunigame.unigame.app.presentacion.util.Listener;

import java.util.EventListener;

import tk.theunigame.unigame.app.logica_juego.temporizador.TemporizadorTimerTask;

/**
 * Created by John on 21/04/2015.
 */
public interface OnTiempoListener extends EventListener {
    public void onParar(TemporizadorTimerTask object);
    public void onContinuar(TemporizadorTimerTask object);
    public void onReiniciar(TemporizadorTimerTask object);
    public void onTiempoFinalizado(TemporizadorTimerTask object);
}
