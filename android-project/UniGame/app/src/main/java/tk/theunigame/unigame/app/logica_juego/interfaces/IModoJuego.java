package tk.theunigame.unigame.app.logica_juego.interfaces;

import android.content.Context;

import java.util.List;

import juego.taes.domainmodel.Model.Cliente.BDPreguntas;
import juego.taes.domainmodel.Model.Cliente.Pregunta;

/**
 * Created by Paco on 22/04/2015.
 */
public interface IModoJuego {

    public void jugar(List<Pregunta> preguntas);
    public List<Pregunta> obtenerPreguntas(Context c, List<BDPreguntas> bolsas);
    public boolean comprobarRespuesta(Pregunta pregunta, Integer respuesta);


}
