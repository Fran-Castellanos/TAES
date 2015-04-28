package tk.theunigame.unigame.app.logica_juego.juego;

import android.content.Context;

import java.util.List;

import juego.taes.domainmodel.Model.Cliente.BDPreguntas;
import juego.taes.domainmodel.Model.Cliente.Pregunta;
import tk.theunigame.unigame.app.logica_juego.comodines.Comodin;

/**
 * Created by Paco on 22/04/2015.
 */
public interface IModoJuego {



    public void guardarResultado();

    public Pregunta usarComodin(Comodin comodin) throws Exception;

    public void initComodines() throws Exception;

}
