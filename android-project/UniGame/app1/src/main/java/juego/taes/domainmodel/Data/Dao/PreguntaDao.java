package juego.taes.domainmodel.Data.Dao;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;

import juego.taes.domainmodel.Model.Cliente.BDPreguntas;
import juego.taes.domainmodel.Model.Cliente.Pregunta;
import juego.taes.domainmodel.Model.Cliente.Respuesta;

/**
 * Created by felix on 22/04/15.
 */

//Dao de asignatura
public class PreguntaDao extends BaseDaoImpl<Pregunta,Integer> implements IPreguntaDao
{
    IRespuestaDao respuestaDao;

    // Constructor
    public PreguntaDao(ConnectionSource connectionSource)
            throws SQLException {
        super(connectionSource, Pregunta.class);

        respuestaDao = new RespuestaDao(connectionSource);
    }

    @Override
    public int delete(Pregunta preg) throws SQLException
    {
        for(Respuesta resp : respuestaDao)
            respuestaDao.delete(resp);

        return super.delete(preg);
    }
}
