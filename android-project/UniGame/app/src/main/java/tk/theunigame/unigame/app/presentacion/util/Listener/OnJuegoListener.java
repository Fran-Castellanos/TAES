package tk.theunigame.unigame.app.presentacion.util.Listener;

import juego.taes.domainmodel.Model.Cliente.Pregunta;
import tk.theunigame.unigame.app.logica_juego.temporizador.TemporizadorTimerTask;

/**
 * Created by John on 27/04/2015.
 */
public interface OnJuegoListener {
    public void onTiempoFinalizado(String mensaje);
    public void onTiempoHaCambiado(int tiempo);
    public void onJuegoHaAcabado(int acertadas, int falladas, int comodinesUsados);
    public void onPreguntaHaCambiado(Pregunta pregunta);
    //Se enviará true si se ha acertado en caso contrario la respuesta no es correcta;
    public void onPreguntaRespondida(boolean acertado);
    public void onComodinUsado(Pregunta p, String mensaje);
}
