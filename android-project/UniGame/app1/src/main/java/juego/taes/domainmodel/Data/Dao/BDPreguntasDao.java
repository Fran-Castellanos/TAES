package juego.taes.domainmodel.Data.Dao;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;

import juego.taes.domainmodel.Model.Cliente.Asignatura;
import juego.taes.domainmodel.Model.Cliente.BDPreguntas;

/**
 * Created by felix on 22/04/15.
 */

//Dao de asignatura
public class BDPreguntasDao extends BaseDaoImpl<BDPreguntas,Integer> implements IBDPreguntasDao
{
    // Constructor
    public BDPreguntasDao(ConnectionSource connectionSource)
            throws SQLException {
        super(connectionSource, BDPreguntas.class);
    }
}
