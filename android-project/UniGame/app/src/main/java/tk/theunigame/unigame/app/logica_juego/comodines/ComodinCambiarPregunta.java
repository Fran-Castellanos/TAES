package tk.theunigame.unigame.app.logica_juego.comodines;

import java.util.List;

import juego.taes.domainmodel.Model.Cliente.Pregunta;

/**
 * Created by Paco on 22/04/2015.
 */
public class ComodinCambiarPregunta extends Comodin {

    private final static String nombre = "Comodín del público";


    private static ComodinCambiarPregunta ourInstance = new ComodinCambiarPregunta();

    public static ComodinCambiarPregunta getInstance() {
        return ourInstance;
    }

    private ComodinCambiarPregunta() {
        super();
    }




    @Override
    public Pregunta usarComodin()throws Exception{
        consumirComodin();

        return p;
    }



}
