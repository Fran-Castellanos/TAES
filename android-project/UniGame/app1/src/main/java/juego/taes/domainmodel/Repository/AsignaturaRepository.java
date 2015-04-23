package juego.taes.domainmodel.Repository;

import android.content.Context;

import java.sql.SQLException;
import java.util.List;

import juego.taes.domainmodel.Data.Dao.IAsignaturaDao;
import juego.taes.domainmodel.Data.DatabaseManager;
import juego.taes.domainmodel.Data.Example.DatabaseHelperExample;
import juego.taes.domainmodel.Model.Cliente.Asignatura;

/**
 * Created by Pedro on 21/04/2015.
 */
public class AsignaturaRepository {

    private DatabaseHelperExample db;
    private IAsignaturaDao dao;

    public AsignaturaRepository(Context ctx)
    {
        try {
            DatabaseManager dbManager = new DatabaseManager();
            db = dbManager.getHelper(ctx);
            dao = db.getDao();
        } catch (SQLException e) {
            // TODO: Exception Handling
            e.printStackTrace();
        }

    }

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
