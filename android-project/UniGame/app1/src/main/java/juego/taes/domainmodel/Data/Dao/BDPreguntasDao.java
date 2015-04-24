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
public class BDPreguntasDao extends BaseDaoImpl<BDPreguntas,Integer> implements IBDPreguntasDao
{
    //Dao de preguntas
    IPreguntaDao preguntaDao;

    // Constructor
    public BDPreguntasDao(ConnectionSource connectionSource)
            throws SQLException {
        super(connectionSource, BDPreguntas.class);

        preguntaDao = new PreguntaDao(connectionSource);
    }

    //Método de borrado
    public int delete(BDPreguntas bd) throws SQLException {

        for(Pregunta preg : bd.getPreguntas())
            preguntaDao.delete(preg);

        return super.delete(bd);
    }
}
