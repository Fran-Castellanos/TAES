package tk.theunigame.unigame.app.logica_juego.comodines;

import java.util.List;

import juego.taes.domainmodel.Model.Cliente.Pregunta;
import tk.theunigame.unigame.app.logica_juego.juego.Juego;

/**
 * Created by Paco on 22/04/2015.
 */
public class ComodinCambiarPregunta extends Comodin {

    private static ComodinCambiarPregunta ourInstance = new ComodinCambiarPregunta();

    public static ComodinCambiarPregunta getInstance() {
        return ourInstance;
    }

    private ComodinCambiarPregunta() {
        super();
        nombre = "Ha usado el comodín del público";
    }




    @Override
    public Pregunta usarComodin()throws Exception{

        Juego j = Juego.getInstance();
        p = j.getPreguntas().get(j.getNumPreguntas());

        consumirComodin();

        return p;
    }



}
