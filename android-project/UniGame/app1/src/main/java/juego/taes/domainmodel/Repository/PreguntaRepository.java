package juego.taes.domainmodel.Repository;

import android.content.Context;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.stmt.QueryBuilder;

import java.sql.SQLException;
import java.util.List;

import juego.taes.domainmodel.Data.Dao.IPreguntaDao;
import juego.taes.domainmodel.Data.Dao.PreguntaDao;
import juego.taes.domainmodel.Data.DatabaseHelper;
import juego.taes.domainmodel.Data.DatabaseManager;
import juego.taes.domainmodel.Model.Cliente.Pregunta;
import juego.taes.domainmodel.Model.Cliente.Respuesta;

/**
 * Created by Pedro on 21/04/2015.
 */
public class PreguntaRepository {
    private DatabaseHelper db;
    private PreguntaDao dao;

    public PreguntaRepository(Context ctx) throws SQLException {
        try {
            DatabaseManager dbManager = new DatabaseManager();
            db = dbManager.getHelper(ctx);
            dao = db.getPreguntaDao();
        } catch (SQLException e) {
            // TODO: Exception Handling
            throw e;
        }

    }

    public int create(Pregunta pregunta) throws SQLException {
        try {
            return dao.create(pregunta);
        } catch (SQLException e) {
            //TODO GESTION DE ERRORES
            throw e;
        }
    }

    public int update(Pregunta pregunta) throws SQLException {
        try {
            return dao.update(pregunta);
        } catch (SQLException e) {
            //TODO GESTION DE ERRORES
            throw e;
        }
    }
    public int delete(Pregunta pregunta) throws SQLException {
        try {
            return dao.delete(pregunta);
        } catch (SQLException e) {
            //TODO GESTION DE ERRORES
            throw e;
        }
    }

    public List<Pregunta> getAll() throws SQLException {
        try {

            QueryBuilder<Pregunta,Integer> builder = dao.queryBuilder();
            builder.orderBy(Pregunta.CONTENIDO,true);
            return builder.query();

        } catch (SQLException e) {
            //TODO GESTION DE ERRORES
            throw e;
        }
    }

    public Pregunta getById(int id) throws SQLException {
        try {
            return dao.queryForId(id);
        } catch (SQLException e) {
            //TODO GESTION DE ERRORES
            throw e;
        }
    }

    public int refresh(Pregunta preg) throws SQLException {
        try {
            return dao.refresh(preg);
        } catch (SQLException e) {
            throw e;
        }
    }

    public Pregunta getRandomByBolsa(int bolsaId) throws SQLException {
        try {

            QueryBuilder<Pregunta,Integer> builder = dao.queryBuilder();

            builder.where().eq(Pregunta.BD, bolsaId);
            builder.orderByRaw("RANDOM()");
            Pregunta preg = builder.queryForFirst();
            return preg;

        } catch (SQLException e) {
            //TODO GESTION DE ERRORES
            throw e;
        }
    }


    public List<Pregunta> getAllByBDPregunta(int bolsaId) throws SQLException {
        try {

            QueryBuilder<Pregunta,Integer> builder = dao.queryBuilder();
            builder.where().eq(Pregunta.BD, bolsaId);
            builder.orderBy(Pregunta.CONTENIDO,true);
            return builder.query();

        } catch (SQLException e) {
            //TODO GESTION DE ERRORES
            throw e;
        }
    }
}
