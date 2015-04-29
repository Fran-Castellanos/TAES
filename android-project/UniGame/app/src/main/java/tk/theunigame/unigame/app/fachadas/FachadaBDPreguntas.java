package tk.theunigame.unigame.app.fachadas;
import android.content.Context;

import com.j256.ormlite.dao.ForeignCollection;

import java.util.ArrayList;
import java.util.List;

import juego.taes.domainmodel.Model.Cliente.Asignatura;
import juego.taes.domainmodel.Model.Cliente.BDPreguntas;
import juego.taes.domainmodel.Model.Cliente.Carrera;
import juego.taes.domainmodel.Model.Cliente.Pregunta;
import juego.taes.domainmodel.Model.Cliente.Universidad;
import juego.taes.domainmodel.Repository.BDPreguntasRepository;

/**
 * Created by Pedro on 21/04/2015.
 */
public class FachadaBDPreguntas {

    private BDPreguntasRepository bd;

    public BDPreguntas recuperarBDPreguntas(Context c, int id)
    {
        bd = new BDPreguntasRepository(c);
        return bd.getById(id);
    }

    public ForeignCollection<Pregunta> obtenerPreguntas(int carreraID, int asignaturaID, boolean buscarEnTodaBD)
    {
        throw new RuntimeException("Not implemented yet");
    }

    public void crearBaseDatos(String nombre,Context c, Asignatura a, Universidad u)
    {
        bd = new BDPreguntasRepository(c);
        bd.create((new BDPreguntas(nombre,false,u,a)));
    }

    public void crearBDdelServidor(String nombre,Context c, Asignatura a, Universidad u, ForeignCollection<Pregunta> preguntas){
        bd = new BDPreguntasRepository(c);
        bd.create((new BDPreguntas(nombre,true,u,a,preguntas)));
    }

    /**
     * Devuelve las asignaturas de una carrera en una universidad
     * @param context
     * @param universidad
     * @param carrera
     * @param asignaturas
     * @return
     */
    public ArrayList<BDPreguntas> obtenerBasesDatos(Context context, Universidad universidad, Carrera carrera, ArrayList<Asignatura> asignaturas)
    {
        BDPreguntasRepository repository = new BDPreguntasRepository(context);
        return (ArrayList<BDPreguntas>) repository.getByAsignaturasYUniversidad((List<Asignatura>)asignaturas, universidad.getId());
    }

    /**
     * Para recoger todas las BD registradas
     * @param context
     * @return Devuelve la lista de BD registradas
     */
    public List<BDPreguntas> obtenerBasesTodasDatos(Context context)
    {
        BDPreguntasRepository repository = new BDPreguntasRepository(context);
        return repository.getAll();
    }

    /**
     * Devuelve la lista de bolsas de preguntas relacionadas con una asignatura y con
     * cualquier Universidad.
     * @param c Objeto Context
     * @param idAsig ID de la asignatura.
     * @return Lista de bolsas de preguntas.
     * @throws Exception
     */
    public List<BDPreguntas> getBDPreguntasTodasUnis(Context c, int idAsig) throws Exception {
        List<BDPreguntas> bases;

        try {

            BDPreguntasRepository base= new BDPreguntasRepository(c);
            bases = base.getByAsignatura(idAsig);

        }catch(Exception e){
            throw  new Exception("No se han obtenido asignaturas para la carrera"+e.getMessage());
        }
        return  bases;
    }

    /**
     * Devuelve la lista de bolsas de preguntas de una asignatura concreta impartida
     * en una Universidad concreta.
     * @param c Objeto Context
     * @param idAsig ID de la asignatura.
     * @param idUni ID de la Universidad.
     * @return Lista de bolsas de preguntas.
     * @throws Exception
     */
    public  List<BDPreguntas> getBDPreguntasUnaUni(Context c, int idAsig ,int idUni) throws Exception {
        List<BDPreguntas> bases;

        try {

            BDPreguntasRepository base= new BDPreguntasRepository(c);
            bases = base.getByAsignaturaYUniversidad(idAsig, idUni);

        }catch(Exception e){
            throw  new Exception("No se han obtenido asignaturas para la carrera"+e.getMessage());
        }
        return bases;

    }
}
