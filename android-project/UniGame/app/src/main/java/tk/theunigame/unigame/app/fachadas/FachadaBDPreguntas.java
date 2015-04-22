package tk.theunigame.unigame.app.fachadas;
import com.j256.ormlite.dao.ForeignCollection;
import juego.taes.domainmodel.Model.Cliente.BDPreguntas;
import juego.taes.domainmodel.Model.Cliente.Pregunta;
import juego.taes.domainmodel.Repository.BDPreguntasRepository;

/**
 * Created by Pedro on 21/04/2015.
 */
public class FachadaBDPreguntas {


    public BDPreguntas recuperarBDPreguntas(int id)
    {
        BDPreguntasRepository bd = new BDPreguntasRepository();
        return bd.getById(id);
    }

    public ForeignCollection<Pregunta> obtenerPreguntas(int carreraID, int asignaturaID, boolean buscarEnTodaBD)
    {
        throw new RuntimeException("Not implemented yet");
    }

}
