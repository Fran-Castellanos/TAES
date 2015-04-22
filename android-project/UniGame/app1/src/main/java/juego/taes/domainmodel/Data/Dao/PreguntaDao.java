package juego.taes.domainmodel.Data.Dao;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;

import juego.taes.domainmodel.Model.Cliente.BDPreguntas;
import juego.taes.domainmodel.Model.Cliente.Pregunta;

/**
 * Created by felix on 22/04/15.
 */

//Dao de asignatura
public class PreguntaDao extends BaseDaoImpl<Pregunta,Integer> implements IPreguntaDao
{
    // Constructor
    public PreguntaDao(ConnectionSource connectionSource)
            throws SQLException {
        super(connectionSource, Pregunta.class);
    }
}
