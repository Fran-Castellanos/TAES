package tk.theunigame.unigame.app.presentacion.util.Views;

import java.util.EventListener;

/**
 * Created by John on 21/04/2015.
 */
public interface OnTiempoListener extends EventListener {
    public void onParar();
    public void onContinuar();
    public void onReiniciar();

    public void onReset(int tiempo);
    public void onContinue(int tiempo);
    public void onStop(int tiempo);
}
