package juego.taes.domainmodel.Repository;

import android.content.Context;

import java.sql.SQLException;
import java.util.List;

import juego.taes.domainmodel.Data.Dao.IRespuestaDao;
import juego.taes.domainmodel.Data.Dao.RespuestaDao;
import juego.taes.domainmodel.Data.DatabaseHelper;
import juego.taes.domainmodel.Data.DatabaseManager;
import juego.taes.domainmodel.Model.Cliente.Respuesta;

/**
 * Created by Pedro on 21/04/2015.
 */
public class RespuestaRepository {
    private DatabaseHelper db;
    private RespuestaDao dao;

    public RespuestaRepository(Context ctx) throws SQLException {
        try {
            DatabaseManager dbManager = new DatabaseManager();
            db = dbManager.getHelper(ctx);
            dao = db.getRespuestaDao();
        } catch (SQLException e) {
            // TODO: Exception Handling
            throw e;
        }

    }

    public int create(Respuesta respuesta) throws SQLException {
        try {
            return dao.create(respuesta);
        } catch (SQLException e) {
            //TODO GESTION DE ERRORES
            throw e;
        }
    }

    public int update(Respuesta respuesta) throws SQLException {
        try {
            return dao.update(respuesta);
        } catch (SQLException e) {
            //TODO GESTION DE ERRORES
            throw e;
        }
    }

    public int delete(Respuesta respuesta) throws SQLException {
        try {
            return dao.delete(respuesta);
        } catch (SQLException e) {
            //TODO GESTION DE ERRORES
            throw e;
        }
    }

    public int refresh(Respuesta resp) throws SQLException {
        try {
            return dao.refresh(resp);
        } catch (SQLException e) {
            throw e;
        }
    }

    public List<Respuesta> getAll() throws SQLException {
        try {
            return dao.queryForAll();
        } catch (SQLException e) {
            //TODO GESTION DE ERRORES
            throw e;
        }
    }

    public Respuesta getById(int id) throws SQLException {
        try {
            return dao.queryForId(id);
        } catch (SQLException e) {
            //TODO GESTION DE ERRORES
            throw e;
        }
    }
}
