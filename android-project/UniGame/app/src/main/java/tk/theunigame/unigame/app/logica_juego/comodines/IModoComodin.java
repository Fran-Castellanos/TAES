package tk.theunigame.unigame.app.logica_juego.comodines;

import juego.taes.domainmodel.Model.Cliente.Pregunta;
import tk.theunigame.unigame.app.logica_juego.comodines.Comodin;

/**
 * Created by Paco on 23/04/2015.
 */
public interface IModoComodin {


    public Pregunta usarComodin(Comodin c,Pregunta p) throws Exception;

}
