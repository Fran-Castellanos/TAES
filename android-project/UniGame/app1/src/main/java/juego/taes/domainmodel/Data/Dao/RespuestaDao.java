package juego.taes.domainmodel.Data.Dao;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;

import juego.taes.domainmodel.Model.Cliente.Pregunta;
import juego.taes.domainmodel.Model.Cliente.Respuesta;

/**
 * Created by felix on 22/04/15.
 */

//Dao de asignatura
public class RespuestaDao extends BaseDaoImpl<Respuesta,Integer> implements IRespuestaDao
{
    // Constructor
    public RespuestaDao(ConnectionSource connectionSource)
            throws SQLException {
        super(connectionSource, Respuesta.class);
    }
}
