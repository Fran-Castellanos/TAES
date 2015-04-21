package juego.taes.domainmodel.Repository;

import java.util.List;

import juego.taes.domainmodel.Data.Example.DatabaseHelper;
import juego.taes.domainmodel.Model.Cliente.Usuario;

/**
 * Created by Pedro on 21/04/2015.
 */
public class UsuarioRepository {
    private DatabaseHelper db;

    public int create(Usuario usuario)
    {
        throw new RuntimeException("Not implemented yet");
    }
    public int update(Usuario usuario)
    {
        throw new RuntimeException("Not implemented yet");
    }
    public int delete(Usuario usuario)
    {
        throw new RuntimeException("Not implemented yet");
    }

    public List<Usuario> getAll()
    {
        throw new RuntimeException("Not implemented yet");
    }

    public Usuario getById(int id)
    {
        throw new RuntimeException("Not implemented yet");
    }
}
