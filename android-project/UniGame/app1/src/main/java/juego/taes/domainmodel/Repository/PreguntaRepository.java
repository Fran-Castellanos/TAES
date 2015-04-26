package juego.taes.domainmodel.Repository;

import android.content.Context;

import com.j256.ormlite.stmt.QueryBuilder;

import java.sql.SQLException;
import java.util.List;

import juego.taes.domainmodel.Data.Dao.IPreguntaDao;
import juego.taes.domainmodel.Data.Dao.PreguntaDao;
import juego.taes.domainmodel.Data.DatabaseHelper;
import juego.taes.domainmodel.Data.DatabaseManager;
import juego.taes.domainmodel.Model.Cliente.Pregunta;

/**
 * Created by Pedro on 21/04/2015.
 */
public class PreguntaRepository {
    private DatabaseHelper db;
    private PreguntaDao dao;

    public PreguntaRepository(Context ctx)
    {
        try {
            DatabaseManager dbManager = new DatabaseManager();
            db = dbManager.getHelper(ctx);
            dao = db.getPreguntaDao();
        } catch (SQLException e) {
            // TODO: Exception Handling
            e.printStackTrace();
        }

    }

    public int create(Pregunta pregunta)
    {
        try {
            return dao.create(pregunta);
        } catch (SQLException e) {
            //TODO GESTION DE ERRORES
            e.printStackTrace();
        }
        return 0;
    }

    public int update(Pregunta pregunta)
    {
        try {
            return dao.update(pregunta);
        } catch (SQLException e) {
            //TODO GESTION DE ERRORES
            e.printStackTrace();
        }
        return 0;
    }
    public int delete(Pregunta pregunta)
    {
        try {
            return dao.delete(pregunta);
        } catch (SQLException e) {
            //TODO GESTION DE ERRORES
            e.printStackTrace();
        }
        return 0;
    }

    public List<Pregunta> getAll()
    {
        try {

            QueryBuilder<Pregunta,Integer> builder = dao.queryBuilder();
            builder.orderBy(Pregunta.CONTENIDO,true);
            return builder.query();

        } catch (SQLException e) {
            //TODO GESTION DE ERRORES
            e.printStackTrace();
        }
        return null;
    }

    public Pregunta getById(int id)
    {
        try {
            return dao.queryForId(id);
        } catch (SQLException e) {
            //TODO GESTION DE ERRORES
            e.printStackTrace();
        }
        return null;
    }

    public int refresh(Pregunta preg)
    {
        try {
            return dao.refresh(preg);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    public Pregunta getRandomByBolsa(int bolsaId)
    {
        try {

            QueryBuilder<Pregunta,Integer> builder = dao.queryBuilder();
            builder.selectRaw("select * from "+ Pregunta.TABLA +" where " + Pregunta.BD + " = " + bolsaId + "ORDER BY RANDOM() LIMIT 1");
            return builder.queryForFirst();

        } catch (SQLException e) {
            //TODO GESTION DE ERRORES
            e.printStackTrace();
        }
        return null;
    }


    public List<Pregunta> getAllByBDPregunta(int bolsaId)
    {
        try {

            QueryBuilder<Pregunta,Integer> builder = dao.queryBuilder();
            builder.where().eq(Pregunta.BD, bolsaId);
            builder.orderBy(Pregunta.CONTENIDO,true);
            return builder.query();

        } catch (SQLException e) {
            //TODO GESTION DE ERRORES
            e.printStackTrace();
        }
        return null;
    }

}
