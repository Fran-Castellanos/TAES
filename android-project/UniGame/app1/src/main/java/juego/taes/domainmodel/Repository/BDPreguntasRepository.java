package juego.taes.domainmodel.Repository;

import android.content.Context;

import com.j256.ormlite.stmt.QueryBuilder;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import juego.taes.domainmodel.Data.Dao.BDPreguntasDao;
import juego.taes.domainmodel.Data.Dao.IBDPreguntasDao;
import juego.taes.domainmodel.Data.Dao.IPreguntaDao;
import juego.taes.domainmodel.Data.Dao.PreguntaDao;
import juego.taes.domainmodel.Data.DatabaseHelper;
import juego.taes.domainmodel.Data.DatabaseManager;
import juego.taes.domainmodel.Model.Cliente.BDPreguntas;
import juego.taes.domainmodel.Model.Cliente.Pregunta;

/**
 * Created by Pedro on 21/04/2015.
 */
public class BDPreguntasRepository {
    private DatabaseHelper db;
    private BDPreguntasDao dao;
    private PreguntaDao preguntaDao;

    public BDPreguntasRepository(Context ctx)
    {
        try {
            DatabaseManager dbManager = new DatabaseManager();
            db = dbManager.getHelper(ctx);
            dao = db.getBDPreguntasDao();
            preguntaDao = db.getPreguntaDao();

        } catch (SQLException e) {
            // TODO: Exception Handling
            e.printStackTrace();
        }

    }

    public int create(BDPreguntas bd)
    {
        try {
            return dao.create(bd);
        } catch (SQLException e) {
            //TODO GESTION DE ERRORES
            e.printStackTrace();
        }
        return 0;
    }

    public int update(BDPreguntas bd)
    {
        try {
            return dao.update(bd);
        } catch (SQLException e) {
            //TODO GESTION DE ERRORES
            e.printStackTrace();
        }
        return 0;
    }

    public int delete(BDPreguntas bd)
    {
        try {
            return dao.delete(bd);

        } catch (SQLException e) {
            //TODO GESTION DE ERRORES
            e.printStackTrace();
        }
        return 0;
    }

    public int refresh(BDPreguntas bd)
    {
        try {
            return dao.refresh(bd);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    public List<BDPreguntas> getAll()
    {
        try {

            QueryBuilder<BDPreguntas,Integer> builder = dao.queryBuilder();
            builder.orderBy(BDPreguntas.NOMBRE,true);
            return builder.query();

        } catch (SQLException e) {
            //TODO GESTION DE ERRORES
            e.printStackTrace();
        }
        return null;
    }

    public BDPreguntas getById(int id)
    {
        try {
            return dao.queryForId(id);
        } catch (SQLException e) {
            //TODO GESTION DE ERRORES
            e.printStackTrace();
        }
        return null;
    }

    public List<BDPreguntas> getByAsignaturaYUniversidad(int idAsig, int idUni)
    {
        try {

            QueryBuilder<BDPreguntas,Integer> builder = dao.queryBuilder();
            builder.where().eq(BDPreguntas.ASIGNATURA,idAsig);
            builder.where().and();
            builder.where().eq(BDPreguntas.UNIVERSIDAD,idUni);
            builder.orderBy(BDPreguntas.NOMBRE,true);
            return builder.query();

        } catch (SQLException e) {
            //TODO GESTION DE ERRORES
            e.printStackTrace();
        }
        return null;
    }

    public List<BDPreguntas> getByAsignatura(int idAsig){
        try {

            QueryBuilder<BDPreguntas,Integer> builder = dao.queryBuilder();
            builder.where().eq(BDPreguntas.ASIGNATURA,idAsig);
            builder.orderBy(BDPreguntas.NOMBRE,true);
            return builder.query();

        } catch (SQLException e) {
            //TODO GESTION DE ERRORES
            e.printStackTrace();
        }
        return null;}

    public List<BDPreguntas> getByUsuario(int idUsuario){
        try {

            QueryBuilder<BDPreguntas,Integer> builder = dao.queryBuilder();
            builder.where().eq(BDPreguntas.USUARIO,idUsuario);
            builder.orderBy(BDPreguntas.NOMBRE,true);
            return builder.query();

        } catch (SQLException e) {
            //TODO GESTION DE ERRORES
            e.printStackTrace();
        }
        return null;}

    //Modificar una bd
    public void GuardarCambios(BDPreguntas bd, List<Pregunta> creadas, List<Pregunta> modificadas, List<Pregunta> eliminadas)
    {
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
            e.printStackTrace();
        }

    }

}
