package juego.taes.domainmodel.Repository;

import android.content.Context;

import com.j256.ormlite.dao.CloseableIterable;
import com.j256.ormlite.dao.CloseableIterator;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import juego.taes.domainmodel.Data.Dao.BDPreguntasDao;
import juego.taes.domainmodel.Data.Dao.IBDPreguntasDao;
import juego.taes.domainmodel.Data.Dao.IPreguntaDao;
import juego.taes.domainmodel.Data.Dao.PreguntaDao;
import juego.taes.domainmodel.Data.DatabaseHelper;
import juego.taes.domainmodel.Data.DatabaseManager;
import juego.taes.domainmodel.Model.Cliente.Asignatura;
import juego.taes.domainmodel.Model.Cliente.BDPreguntas;
import juego.taes.domainmodel.Model.Cliente.Carrera;
import juego.taes.domainmodel.Model.Cliente.Pregunta;
import juego.taes.domainmodel.Model.Cliente.Universidad;

/**
 * Created by Pedro on 21/04/2015.
 */
public class BDPreguntasRepository {
    private DatabaseHelper db;
    private BDPreguntasDao dao;
    private PreguntaDao preguntaDao;

    public BDPreguntasRepository(Context ctx) throws SQLException {
        try {
            DatabaseManager dbManager = new DatabaseManager();
            db = dbManager.getHelper(ctx);
            dao = db.getBDPreguntasDao();
            preguntaDao = db.getPreguntaDao();

        } catch (SQLException e) {
            // TODO: Exception Handling
            throw e;
        }

    }

    public int create(BDPreguntas bd) throws SQLException {
        try {
            return dao.create(bd);
        } catch (SQLException e) {
            //TODO GESTION DE ERRORES
            throw e;
        }
    }

    public int update(BDPreguntas bd) throws SQLException {
        try {
            return dao.update(bd);
        } catch (SQLException e) {
            //TODO GESTION DE ERRORES
            throw e;
        }
    }

    public int delete(BDPreguntas bd) throws SQLException {
        try {
            return dao.delete(bd);

        } catch (SQLException e) {
            //TODO GESTION DE ERRORES
            throw e;
        }
    }

    public int refresh(BDPreguntas bd) throws SQLException {
        try {
            return dao.refresh(bd);
        } catch (SQLException e) {
            throw e;
        }
    }

    public List<BDPreguntas> getAll() throws SQLException {
        try {

            QueryBuilder<BDPreguntas,Integer> builder = dao.queryBuilder();
            builder.orderBy(BDPreguntas.NOMBRE,true);
            return builder.query();

        } catch (SQLException e) {
            //TODO GESTION DE ERRORES
            throw e;
        }
    }

    public BDPreguntas getById(int id) throws SQLException {
        try {
            return dao.queryForId(id);
        } catch (SQLException e) {
            //TODO GESTION DE ERRORES
            throw e;
        }
    }

    public List<BDPreguntas> getByAsignaturaYUniversidad(int idAsig, int idUni) throws SQLException {
        try {

            QueryBuilder<BDPreguntas,Integer> builder = dao.queryBuilder();
            Where<BDPreguntas, Integer> con1= builder.where();
            con1.eq(BDPreguntas.ASIGNATURA,idAsig);
            con1.and();
            con1.eq(BDPreguntas.UNIVERSIDAD,idUni);
            builder.orderBy(BDPreguntas.NOMBRE,true);
            return builder.query();

        } catch (SQLException e) {
            //TODO GESTION DE ERRORES
            throw e;
        }
    }

    //Devuelve una lista de BDPreguntas en fución de una universidad y una lista de asignaturas
    public List<BDPreguntas> getByAsignaturasYUniversidad(List<Asignatura> asignaturas, int idUni) throws SQLException {
        try {
            List<Integer> listaAsignaturas = new ArrayList<>();
            for(Asignatura a : asignaturas)
                listaAsignaturas.add(a.getId());
            QueryBuilder<BDPreguntas,Integer> builder2 = dao.queryBuilder();
            Where<BDPreguntas, Integer> where = builder2.where();
            where.in(BDPreguntas.ASIGNATURA, listaAsignaturas);
            where.and();
            where.eq(BDPreguntas.UNIVERSIDAD, idUni);
            //TODO Falta relacionar con la and universidad
            builder2.orderBy(BDPreguntas.NOMBRE,true);
            return builder2.query();

        } catch (SQLException e) {
            //TODO GESTION DE ERRORES
            throw e;
        }
    }

    public List<BDPreguntas> getByAsignatura(int idAsig) throws SQLException {
        try {

            QueryBuilder<BDPreguntas,Integer> builder = dao.queryBuilder();
            builder.where().eq(BDPreguntas.ASIGNATURA,idAsig);
            builder.orderBy(BDPreguntas.NOMBRE,true);
            return builder.query();

        } catch (SQLException e) {
            //TODO GESTION DE ERRORES
            throw e;
        }
        }

    public List<BDPreguntas> getByUsuario(int idUsuario) throws SQLException {
        try {

            QueryBuilder<BDPreguntas,Integer> builder = dao.queryBuilder();
            builder.where().eq(BDPreguntas.USUARIO,idUsuario);
            builder.orderBy(BDPreguntas.NOMBRE,true);
            return builder.query();

        } catch (SQLException e) {
            //TODO GESTION DE ERRORES
            throw e;
        }
}

    //Modificar una bd
    public void GuardarCambios(BDPreguntas bd, List<Pregunta> creadas, List<Pregunta> modificadas, List<Pregunta> eliminadas) throws SQLException {
        try {

            dao.update(bd);

            //Crear preguntas
            for(Pregunta preg : creadas)
                preguntaDao.create(preg);

            //Modificar preguntas
            for(Pregunta preg : modificadas)
                preguntaDao.update(preg);

            //Borrar preguntas
            for(Pregunta preg : eliminadas)
                preguntaDao.delete(preg);


        } catch (SQLException e) {
            //TODO GESTION DE ERRORES
            throw e;
        }

    }

}
