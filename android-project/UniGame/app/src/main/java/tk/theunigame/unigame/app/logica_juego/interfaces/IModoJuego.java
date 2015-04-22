package tk.theunigame.unigame.app.logica_juego.interfaces;

import juego.taes.domainmodel.Model.Cliente.Pregunta;

/**
 * Created by Paco on 22/04/2015.
 */
public interface IModoJuego {

    public void jugar();
    public void obtenerPreguntas();
    public boolean comprobarRespuesta(Pregunta pregunta, Integer respuesta);

}
