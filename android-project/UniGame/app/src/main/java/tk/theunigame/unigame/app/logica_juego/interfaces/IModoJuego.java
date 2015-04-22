package tk.theunigame.unigame.app.logica_juego.interfaces;

import java.util.List;

import juego.taes.domainmodel.Model.Cliente.BDPreguntas;
import juego.taes.domainmodel.Model.Cliente.Pregunta;

/**
 * Created by Paco on 22/04/2015.
 */
public interface IModoJuego {

    public void jugar(List<Pregunta> preguntas);
    public List<Pregunta> obtenerPreguntas(List<BDPreguntas> bolsas);
    public boolean comprobarRespuesta(Pregunta pregunta, Integer respuesta);

}
