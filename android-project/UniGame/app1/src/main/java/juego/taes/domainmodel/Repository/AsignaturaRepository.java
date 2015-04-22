package juego.taes.domainmodel.Repository;

import java.util.List;

import juego.taes.domainmodel.Data.Example.DatabaseHelperExample;
import juego.taes.domainmodel.Model.Cliente.Asignatura;

/**
 * Created by Pedro on 21/04/2015.
 */
public class AsignaturaRepository {

    private DatabaseHelperExample db;

    public int create(Asignatura asig)
    {
        throw new RuntimeException("Not implemented yet");
    }
    public int update(Asignatura asig)
    {
        throw new RuntimeException("Not implemented yet");
    }
    public int delete(Asignatura asig)
    {
        throw new RuntimeException("Not implemented yet");
    }

    public List<Asignatura> getAll()
    {
        throw new RuntimeException("Not implemented yet");
    }

    public Asignatura getById(int id)
    {
        throw new RuntimeException("Not implemented yet");
    }
    public List<Asignatura> getByCarrera( int carreraId){ return null; }
}
