package tk.theunigame.unigame.app.logica_juego.comodines;

import juego.taes.domainmodel.Model.Cliente.Pregunta;

/**
 * Created by Paco on 23/04/2015.
 */
public class JuegoConComodines implements IModoComodin {




    @Override
    public Pregunta usarComodin(Comodin c,Pregunta p) throws Exception {
        return c.usarComodin();
    }
}
