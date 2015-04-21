package juego.taes.domainmodel.Repository;

import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;

import juego.taes.domainmodel.Data.Example.DatabaseHelper;
import juego.taes.domainmodel.Model.Cliente.Universidad;

/**
 * Created by Pedro on 21/04/2015.
 */
public class UniversidadRepository {

    private DatabaseHelper db;

    public int create()
    {
        return 0;
    }
    public int update (Universidad universidad)
    {
        return 0;
    }
    public int delete(Universidad universidad)
    {
        return 0;
    }

    public List<Universidad> getAll()
    {
        return null;
    }
}
