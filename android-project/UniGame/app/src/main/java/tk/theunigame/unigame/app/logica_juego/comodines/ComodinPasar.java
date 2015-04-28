package tk.theunigame.unigame.app.logica_juego.comodines;

import com.j256.ormlite.dao.ForeignCollection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import juego.taes.domainmodel.Model.Cliente.Pregunta;
import juego.taes.domainmodel.Model.Cliente.Respuesta;
import tk.theunigame.unigame.app.logica_juego.juego.Juego;

/**
 * Created by Paco on 22/04/2015.
 */
public class ComodinPasar extends Comodin {

    private final static String nombre = "Comodín de pasar pregunta";


    private static ComodinPasar ourInstance = new ComodinPasar();

    public static ComodinPasar getInstance() {
        return ourInstance;
    }

    private ComodinPasar() {
        super();
    }



    public Pregunta usarComodin()throws Exception
    {
        Juego j = Juego.getInstance();
        p = j.siguientePregunta();

        consumirComodin();

        return p;
    }


}
