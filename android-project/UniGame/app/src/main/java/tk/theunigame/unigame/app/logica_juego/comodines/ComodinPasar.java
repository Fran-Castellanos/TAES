package tk.theunigame.unigame.app.logica_juego.comodines;

import com.j256.ormlite.dao.ForeignCollection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import juego.taes.domainmodel.Model.Cliente.Pregunta;
import juego.taes.domainmodel.Model.Cliente.Respuesta;

/**
 * Created by Paco on 22/04/2015.
 */
public class ComodinPasar extends Comodin {

    private final static String nombre = "Comodín de pasar pregunta";

    private boolean disponible;


    public ComodinPasar()
    {
        disponible=true;
        cantidad++;

    }
    public Pregunta usarComodin(List<Pregunta>preguntas,Pregunta p)throws Exception
    {
        Pregunta resp;
        try {
            resp=preguntas.get(preguntas.indexOf(p)+1);
            cantidad--;
            disponible=false;
        }catch (Exception ex){
            throw new Exception("No se ha podido usar comodin pasar"+ex.getMessage());
        }
        return resp;
    }



    @Override
    public boolean comodinDisponible() {
        return disponible;
    }
}
