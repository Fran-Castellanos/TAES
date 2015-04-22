package juego.taes.domainmodel.Repository;

import java.util.List;

import juego.taes.domainmodel.Data.Example.DatabaseHelperExample;
import juego.taes.domainmodel.Model.Cliente.BDPreguntas;

/**
 * Created by Pedro on 21/04/2015.
 */
public class BDPreguntasRepository {
    private DatabaseHelperExample db;

    public int create(BDPreguntas bd)
    {
        throw new RuntimeException("Not implemented yet");
    }
    public int update(BDPreguntas bd)
    {
        throw new RuntimeException("Not implemented yet");
    }
    public int delete(BDPreguntas bd)
    {
        throw new RuntimeException("Not implemented yet");
    }

    public List<BDPreguntas> getAll()
    {
        throw new RuntimeException("Not implemented yet");
    }

    public BDPreguntas getById(int id)
    {
        throw new RuntimeException("Not implemented yet");
    }




    public List<BDPreguntas> getByUniversidad(int idAsig,int idUni){throw new RuntimeException("Not implemented yet");}
    public List<BDPreguntas> getByAsignatura(int idAsig){throw new RuntimeException("Not implemented yet");}

}
