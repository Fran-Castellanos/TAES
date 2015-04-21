package juego.taes.domainmodel.Repository;

import java.util.List;

import juego.taes.domainmodel.Data.Example.DatabaseHelper;
import juego.taes.domainmodel.Model.Cliente.Asignatura;

/**
 * Created by Pedro on 21/04/2015.
 */
public class AsignaturaRepository {

    private DatabaseHelper db;

    public int create(Asignatura asig)
    {
        return 0;
    }
    public int update(Asignatura asig)
    {
        return 0;
    }
    public int delete(Asignatura asig)
    {
        return 0;
    }

    public List<Asignatura> getAll()
    {
        return null;
    }
    public List<Asignatura> getByUniversidad( int universidadId){ return null; }
}
