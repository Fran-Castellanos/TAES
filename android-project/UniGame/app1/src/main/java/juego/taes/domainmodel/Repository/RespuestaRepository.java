package juego.taes.domainmodel.Repository;

import android.content.Context;

import java.sql.SQLException;
import java.util.List;

import juego.taes.domainmodel.Data.Dao.IRespuestaDao;
import juego.taes.domainmodel.Data.DatabaseHelper;
import juego.taes.domainmodel.Data.DatabaseManager;
import juego.taes.domainmodel.Data.Example.DatabaseHelperExample;
import juego.taes.domainmodel.Model.Cliente.Respuesta;

/**
 * Created by Pedro on 21/04/2015.
 */
public class RespuestaRepository {
    private DatabaseHelper db;
    private IRespuestaDao dao;

    public RespuestaRepository(Context ctx)
    {
        try {
            DatabaseManager dbManager = new DatabaseManager();
            db = dbManager.getHelper(ctx);
            dao = db.getIRespuestaDao();
        } catch (SQLException e) {
            // TODO: Exception Handling
            e.printStackTrace();
        }

    }

    public int create(Respuesta respuesta)
    {
        try {
            return dao.create(respuesta);
        } catch (SQLException e) {
            //TODO GESTION DE ERRORES
            e.printStackTrace();
        }
        return 0;
    }

    public int update(Respuesta respuesta)
    {
        try {
            return dao.update(respuesta);
        } catch (SQLException e) {
            //TODO GESTION DE ERRORES
            e.printStackTrace();
        }
        return 0;
    }

    public int delete(Respuesta respuesta)
    {
        try {
            return dao.delete(respuesta);
        } catch (SQLException e) {
            //TODO GESTION DE ERRORES
            e.printStackTrace();
        }
        return 0;
    }

    public List<Respuesta> getAll()
    {
        try {
            return dao.queryForAll();
        } catch (SQLException e) {
            //TODO GESTION DE ERRORES
            e.printStackTrace();
        }
        return null;
    }

    public Respuesta getById(int id)
    {
        try {
            return dao.queryForId(id);
        } catch (SQLException e) {
            //TODO GESTION DE ERRORES
            e.printStackTrace();
        }
        return null;
    }
}
