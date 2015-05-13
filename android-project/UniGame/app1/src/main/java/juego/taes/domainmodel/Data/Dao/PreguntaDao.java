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
    public int create(Pregunta preg) throws SQLException
    {
        this.assignEmptyForeignCollection(preg,Pregunta.RESPUESTAS_CAMPO);
        int resultado = super.create(preg);

        for(Respuesta resp :  preg.getRespuestas()) {
            resp.setPregunta(preg);
            respuestaDao.create(resp);
        }

        return resultado;

    }

    @Override
    public int update(Pregunta preg) throws SQLException
    {
        int resultado = super.update(preg);

        for(Respuesta resp : preg.getRespuestas())
        {
            resp.setPregunta(preg);
            respuestaDao.update(resp);
        }

        return resultado;

    }

    @Override
    public int delete(Pregunta preg) throws SQLException
    {
        for(Respuesta resp :  preg.getRespuestas())
            respuestaDao.delete(resp);

        return super.delete(preg);
    }
}
