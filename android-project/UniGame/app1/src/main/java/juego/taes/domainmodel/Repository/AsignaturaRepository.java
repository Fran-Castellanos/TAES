package juego.taes.domainmodel.Repository;

import android.content.Context;

import java.sql.SQLException;
import java.util.List;

import juego.taes.domainmodel.Data.Dao.AsignaturaDao;
import juego.taes.domainmodel.Data.Dao.IAsignaturaDao;
import juego.taes.domainmodel.Data.DatabaseHelper;
import juego.taes.domainmodel.Data.DatabaseManager;
import juego.taes.domainmodel.Data.Example.DatabaseHelperExample;
import juego.taes.domainmodel.Model.Cliente.Asignatura;

/**
 * Created by Pedro on 21/04/2015.
 */
public class AsignaturaRepository {

    private DatabaseHelper db;
    private IAsignaturaDao dao;

    public AsignaturaRepository(Context ctx)
    {
        try {
            DatabaseManager dbManager = new DatabaseManager();
            db = dbManager.getHelper(ctx);
            dao = db.getIAsignaturaDao();
        } catch (SQLException e) {
            // TODO: Exception Handling
            e.printStackTrace();
        }

    }

    public int create(Asignatura asig)
    {
        try {
            return dao.create(asig);
        } catch (SQLException e) {
            //TODO GESTION DE ERRORES
            e.printStackTrace();
        }
        return 0;
    }

    public int update(Asignatura asig)
    {
        try {
            return dao.update(asig);
        } catch (SQLException e) {
            //TODO GESTION DE ERRORES
            e.printStackTrace();
        }
        return 0;
    }

    public int delete(Asignatura asig)
    {
        try {
            return dao.delete(asig);
        } catch (SQLException e) {
            //TODO GESTION DE ERRORES
            e.printStackTrace();
        }
        return 0;
    }

    public List<Asignatura> getAll()
    {
        try {
            return dao.queryForAll();
        } catch (SQLException e) {
            //TODO GESTION DE ERRORES
            e.printStackTrace();
        }
        return null;
    }

    public Asignatura getById(int id)
    {
        try {
            return dao.queryForId(id);
        } catch (SQLException e) {
            //TODO GESTION DE ERRORES
            e.printStackTrace();
        }
        return null;
    }

    public List<Asignatura> getByCarrera( int carreraId)
    {
        try {
            return dao.queryForEq(Asignatura.CARRERA,carreraId);
        } catch (SQLException e) {
            //TODO GESTION DE ERRORES
            e.printStackTrace();
        }
        return null;
    }
}
