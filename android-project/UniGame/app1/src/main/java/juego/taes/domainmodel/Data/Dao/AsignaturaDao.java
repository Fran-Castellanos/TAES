package juego.taes.domainmodel.Data.Dao;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;

import juego.taes.domainmodel.Model.Cliente.Asignatura;

/**
 * Created by felix on 22/04/15.
 */

//Dao de asignatura
public class AsignaturaDao extends BaseDaoImpl<Asignatura,Integer> implements IAsignaturaDao
{
    // Constructor
    public AsignaturaDao(ConnectionSource connectionSource)
            throws SQLException {
        super(connectionSource, Asignatura.class);
    }
}
