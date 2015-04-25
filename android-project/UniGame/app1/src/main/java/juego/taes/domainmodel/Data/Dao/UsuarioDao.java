package juego.taes.domainmodel.Data.Dao;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;

import juego.taes.domainmodel.Model.Cliente.Usuario;


/**
 * Created by felix on 22/04/15.
 */

//Dao de asignatura
public class UsuarioDao extends BaseDaoImpl<Usuario,Integer> implements IUsuarioDao
{
    // Constructor
    public UsuarioDao(ConnectionSource connectionSource)
            throws SQLException {
        super(connectionSource, Usuario.class);
    }
}
