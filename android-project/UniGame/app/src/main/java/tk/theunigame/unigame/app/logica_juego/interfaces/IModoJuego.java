package tk.theunigame.unigame.app.logica_juego.interfaces;

/**
 * Created by Paco on 22/04/2015.
 */
public interface IModoJuego {

    public void jugar();
    public void obtenerPreguntas();
    public boolean comprobarRespuesta(IPregunta pregunta, Integer respuesta);

}
