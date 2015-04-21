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
        throw new RuntimeException("Not implemented yet");
    }
    public int update (Universidad universidad)
    {
        throw new RuntimeException("Not implemented yet");
    }
    public int delete(Universidad universidad)
    {
        throw new RuntimeException("Not implemented yet");
    }

    public List<Universidad> getAll()
    {
        throw new RuntimeException("Not implemented yet");
    }

    public Universidad getById(int id)
    {
        throw new RuntimeException("Not implemented yet");
    }
}
