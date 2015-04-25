package juego.taes.domainmodel.Repository;

import android.content.Context;

import com.j256.ormlite.stmt.QueryBuilder;

import java.sql.SQLException;
import java.util.List;

import juego.taes.domainmodel.Data.Dao.IUniversidadDao;
import juego.taes.domainmodel.Data.Dao.UniversidadDao;
import juego.taes.domainmodel.Data.DatabaseHelper;
import juego.taes.domainmodel.Data.DatabaseManager;
import juego.taes.domainmodel.Model.Cliente.Universidad;

/**
 * Created by Pedro on 21/04/2015.
 */
public class UniversidadRepository {

    private DatabaseHelper db;
    private UniversidadDao dao;

    public UniversidadRepository(Context ctx)
    {
        try {
            DatabaseManager dbManager = new DatabaseManager();
            db = dbManager.getHelper(ctx);
            dao = db.getUniversidadDao();
        } catch (SQLException e) {
            // TODO: Exception Handling
            e.printStackTrace();
        }

    }

    public int create(Universidad universidad)
    {
        try {
            return dao.create(universidad);
        } catch (SQLException e) {
            //TODO GESTION DE ERRORES
            e.printStackTrace();
        }
        return 0;
    }

    public int update (Universidad universidad)
    {
        try {
            return dao.update(universidad);
        } catch (SQLException e) {
            //TODO GESTION DE ERRORES
            e.printStackTrace();
        }
        return 0;
    }

    public int delete(Universidad universidad)
    {
        try {
            return dao.delete(universidad);
        } catch (SQLException e) {
            //TODO GESTION DE ERRORES
            e.printStackTrace();
        }
        return 0;
    }

    public int refresh(Universidad univ)
    {
        try {
            return dao.refresh(univ);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    public List<Universidad> getAll()
    {
        try {

            QueryBuilder<Universidad,Integer> builder = dao.queryBuilder();
            builder.orderBy(Universidad.NOMBRE,true);
            return builder.query();

        } catch (SQLException e) {
            //TODO GESTION DE ERRORES
            e.printStackTrace();
        }
        return null;
    }

    public Universidad getById(int id)
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
