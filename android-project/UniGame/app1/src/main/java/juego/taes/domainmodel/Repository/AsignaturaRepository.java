package juego.taes.domainmodel.Repository;

import android.content.Context;

import com.j256.ormlite.stmt.QueryBuilder;

import java.sql.SQLException;
import java.util.List;

import juego.taes.domainmodel.Data.Dao.AsignaturaCarreraDao;
import juego.taes.domainmodel.Data.Dao.AsignaturaDao;
import juego.taes.domainmodel.Data.Dao.IAsignaturaCarreraDao;
import juego.taes.domainmodel.Data.Dao.IAsignaturaDao;
import juego.taes.domainmodel.Data.DatabaseHelper;
import juego.taes.domainmodel.Data.DatabaseManager;
import juego.taes.domainmodel.Model.Cliente.Asignatura;
import juego.taes.domainmodel.Model.Cliente.AsignaturaCarrera;

/**
 * Created by Pedro on 21/04/2015.
 */
public class AsignaturaRepository {

    private DatabaseHelper db;
    private AsignaturaDao dao;
    private AsignaturaCarreraDao asignaturaCarreraDao;

    public AsignaturaRepository(Context ctx) throws SQLException {
        try {
            DatabaseManager dbManager = new DatabaseManager();
            db = dbManager.getHelper(ctx);
            dao = db.getAsignaturaDao();
            asignaturaCarreraDao = db.getAsignaturaCarreraDao();

        } catch (SQLException e) {
            // TODO: Exception Handling
            throw e;
        }

    }

    public int create(Asignatura asig) throws SQLException {
        try {
            return dao.create(asig);
        } catch (SQLException e) {
            //TODO GESTION DE ERRORES
           throw e;
        }
    }

    public int update(Asignatura asig) throws SQLException {
        try {
            return dao.update(asig);
        } catch (SQLException e) {
            //TODO GESTION DE ERRORES
            throw e;
        }
    }

    public int delete(Asignatura asig) throws SQLException {
        try {
            return dao.delete(asig);
        } catch (SQLException e) {
            //TODO GESTION DE ERRORES
            throw e;
        }
    }

    public int refresh(Asignatura asig) throws SQLException {
        try {
            return dao.refresh(asig);
        } catch (SQLException e) {
            throw e;
        }
    }

    public List<Asignatura> getAll() throws SQLException {
        try {
            return dao.queryForAll();
        } catch (SQLException e) {
            //TODO GESTION DE ERRORES
            throw e;
        }
    }

    public Asignatura getById(int id) throws SQLException {
        try {
            return dao.queryForId(id);
        } catch (SQLException e) {
            //TODO GESTION DE ERRORES
            throw e;
        }
    }

    public List<Asignatura> getByCarrera( int carreraId) throws SQLException {
        try {
            QueryBuilder<AsignaturaCarrera, Integer> builder = asignaturaCarreraDao.queryBuilder();
            builder.where().eq(AsignaturaCarrera.CARRERA, carreraId);

            return dao.queryBuilder().join(builder).query();
        }
        catch (SQLException e) {
            //TODO GESTION DE ERRORES
            throw e;
        }
    }
}
