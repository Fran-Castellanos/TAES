package tk.theunigame.unigame.app.fachadas;
import android.content.Context;

import com.j256.ormlite.dao.ForeignCollection;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import juego.taes.domainmodel.Model.Cliente.Asignatura;
import juego.taes.domainmodel.Model.Cliente.BDPreguntas;
import juego.taes.domainmodel.Model.Cliente.Carrera;
import juego.taes.domainmodel.Model.Cliente.Pregunta;
import juego.taes.domainmodel.Model.Cliente.Universidad;
import juego.taes.domainmodel.Model.Cliente.Usuario;
import juego.taes.domainmodel.Repository.AsignaturaRepository;
import juego.taes.domainmodel.Repository.BDPreguntasRepository;

/**
 * Created by Pedro on 21/04/2015.
 */
public class FachadaBDPreguntas {

    private BDPreguntasRepository bd;

    public void eliminarBDPreguntas(ArrayList<BDPreguntas> bds, Context c) throws SQLException
    {
        try
        {
            bd = new BDPreguntasRepository(c);

            for(BDPreguntas x : bds)
            {
                bd.delete(x);
            }
        }
        catch (SQLException e)
        {
            throw e;
        }
    }



    public BDPreguntas recuperarBDPreguntas(Context c, int id) throws SQLException {
        bd = new BDPreguntasRepository(c);
        return bd.getById(id);
    }

    public ForeignCollection<Pregunta> obtenerPreguntas(int carreraID, int asignaturaID, boolean buscarEnTodaBD)
    {
        throw new RuntimeException("Not implemented yet");
    }

    public void crearBaseDatos(String nombre,Context c, Asignatura a, Universidad u, Usuario usu) throws SQLException
    {
        BDPreguntas preguntas1 = new BDPreguntas(nombre,false,u,a);
        preguntas1.setUsuario(usu);

        bd = new BDPreguntasRepository(c);
        bd.create(preguntas1);
    }

    public void crearBDdelServidor(String nombre,Context c, Asignatura a, Universidad u, List<Pregunta> preguntas) throws SQLException {
        bd = new BDPreguntasRepository(c);
        bd.create((new BDPreguntas(nombre,true,u,a,preguntas)));
    }


    public ArrayList<BDPreguntas> obtenerBasesDatos(Context context, Universidad universidad, Carrera carrera, ArrayList<Asignatura> asignaturas) throws SQLException {

        return getBasesDatos(context,universidad,carrera,asignaturas,true);
    }


    public ArrayList<BDPreguntas> obtenerBasesDatosNoVacias(Context context, Universidad universidad, Carrera carrera, ArrayList<Asignatura> asignaturas) throws SQLException {

        return getBasesDatos(context,universidad,carrera,asignaturas,false);
    }

    /**
     * Devuelve las asignaturas de una carrera en una universidad
     * @param context
     * @param universidad
     * @param carrera
     * @param asignaturas
     * @return
     */
    public ArrayList<BDPreguntas> getBasesDatos(Context context, Universidad universidad, Carrera carrera, ArrayList<Asignatura> asignaturas, boolean mostrarVacios) throws SQLException {
        BDPreguntasRepository repository = new BDPreguntasRepository(context);
        ArrayList<BDPreguntas> bd = (ArrayList<BDPreguntas>) repository.getByAsignaturasYUniversidad((List<Asignatura>) asignaturas, universidad.getId());
        ArrayList<Integer> bdvacios = new ArrayList<Integer>();
        int i = 0;
        if (!mostrarVacios){

            for (BDPreguntas b : bd) {
                if (b.getPreguntas().size() <= 0)
                    bdvacios.add(i);

                ++i;
            }

            i = bdvacios.size() - 1;
            while (i >= 0) {
                bd.remove((int) bdvacios.get(i));
                --i;
            }
        }


        for(BDPreguntas b : bd)
        {
            b.setNombre(b.getNombre() + " (" + b.getPreguntas().size() + " preg.)");
        }
        return bd;
    }

    public ArrayList<BDPreguntas> obtenerBasesDatos(Context context, Universidad universidad, Carrera carrera, Asignatura asignatura) throws SQLException {
        BDPreguntasRepository repository = new BDPreguntasRepository(context);
        return (ArrayList<BDPreguntas>) repository.getByAsignaturaYUniversidad(asignatura.getId(), universidad.getId());
    }
    /**
     * Para recoger todas las BD registradas
     * @param context
     * @return Devuelve la lista de BD registradas
     */
    public List<BDPreguntas> obtenerBasesTodasDatos(Context context) throws SQLException {
        BDPreguntasRepository repository = new BDPreguntasRepository(context);
        List<BDPreguntas> bd =  repository.getAll();

        AsignaturaRepository asig = new AsignaturaRepository(context);
        for(BDPreguntas b : bd)
        {

            b.setNombre(asig.getById(b.getAsignatura().getId()).getNombre() + "-" + b.getNombre() + " (" + b.getPreguntas().size() + " preg.)");
        }

        return bd;
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
