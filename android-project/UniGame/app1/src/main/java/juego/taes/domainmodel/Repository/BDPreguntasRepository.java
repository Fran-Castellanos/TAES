package juego.taes.domainmodel.Repository;

import android.content.Context;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import juego.taes.domainmodel.Data.Dao.IBDPreguntasDao;
import juego.taes.domainmodel.Data.DatabaseHelper;
import juego.taes.domainmodel.Data.DatabaseManager;
import juego.taes.domainmodel.Data.Example.DatabaseHelperExample;
import juego.taes.domainmodel.Model.Cliente.BDPreguntas;

/**
 * Created by Pedro on 21/04/2015.
 */
public class BDPreguntasRepository {
    private DatabaseHelper db;
    private IBDPreguntasDao dao;

    public BDPreguntasRepository(Context ctx)
    {
        try {
            DatabaseManager dbManager = new DatabaseManager();
            db = dbManager.getHelper(ctx);
            dao = db.getIBDPreguntasDao();
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

    public List<BDPreguntas> getAll()
    {
        try {
            return dao.queryForAll();
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

            Map<String,Object> atributos = new HashMap<String,Object>();
            atributos.put(BDPreguntas.ASIGNATURA,idAsig);
            atributos.put(BDPreguntas.UNIVERSIDAD,idUni);

            return dao.queryForFieldValues(atributos);

        } catch (SQLException e) {
            //TODO GESTION DE ERRORES
            e.printStackTrace();
        }
        return null;
    }

    public List<BDPreguntas> getByAsignatura(int idAsig){
        try {
            return dao.queryForEq(BDPreguntas.ASIGNATURA,idAsig);
        } catch (SQLException e) {
            //TODO GESTION DE ERRORES
            e.printStackTrace();
        }
        return null;}

}
