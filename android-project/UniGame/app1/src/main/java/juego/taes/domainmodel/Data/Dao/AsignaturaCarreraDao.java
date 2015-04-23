package juego.taes.domainmodel.Data.Dao;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;

import juego.taes.domainmodel.Model.Cliente.AsignaturaCarrera;
import juego.taes.domainmodel.Model.Cliente.CarreraUniversidad;

/**
 * Created by felix on 22/04/15.
 */

//Dao de asignatura
public class AsignaturaCarreraDao extends BaseDaoImpl<AsignaturaCarrera,Integer> implements IAsignaturaCarreraDao
{
    // Constructor
    public AsignaturaCarreraDao(ConnectionSource connectionSource)
            throws SQLException {
        super(connectionSource, AsignaturaCarrera.class);
    }
}
