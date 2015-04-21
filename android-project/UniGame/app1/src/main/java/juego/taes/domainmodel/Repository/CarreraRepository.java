package juego.taes.domainmodel.Repository;

import java.util.List;

import juego.taes.domainmodel.Data.Example.DatabaseHelper;
import juego.taes.domainmodel.Model.Cliente.Carrera;

/**
 * Created by Pedro on 21/04/2015.
 */
public class CarreraRepository {

    private DatabaseHelper db;

    public int create(Carrera carrera)
    {
        throw new RuntimeException("Not implemented yet");
    }
    public int update(Carrera carrera)
    {
        throw new RuntimeException("Not implemented yet");
    }
    public int delete(Carrera carrera)
    {
        throw new RuntimeException("Not implemented yet");
    }

    public List<Carrera> getAll()
    {
        throw new RuntimeException("Not implemented yet");
    }

    public Carrera getById(int id){throw new RuntimeException("Not implemented yet");}
    public List<Carrera> getByUniversidad(int id)
    {
        throw new RuntimeException("Not implemented yet");
    }
}
