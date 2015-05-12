package juego.taes.domainmodel.Repository;

import android.content.Context;

import com.j256.ormlite.stmt.QueryBuilder;

import java.sql.SQLException;
import java.util.List;

import juego.taes.domainmodel.Data.Dao.IUsuarioDao;
import juego.taes.domainmodel.Data.Dao.UsuarioDao;
import juego.taes.domainmodel.Data.DatabaseHelper;
import juego.taes.domainmodel.Data.DatabaseManager;
import juego.taes.domainmodel.Model.Cliente.Usuario;

/**
 * Created by Pedro on 21/04/2015.
 */
public class UsuarioRepository {

    private DatabaseHelper db;
    private UsuarioDao dao;

    public UsuarioRepository(Context ctx)
    {
        try {
            DatabaseManager dbManager = new DatabaseManager();
            db = dbManager.getHelper(ctx);
            dao = db.getUsuarioDao();
        } catch (SQLException e) {
            // TODO: Exception Handling
            e.printStackTrace();
        }

    }

    public int create(Usuario usuario) throws SQLException {
        try {
            return dao.create(usuario);
        } catch (SQLException e) {
            //TODO GESTION DE ERRORES
            throw e;
        }
    }

    public int update(Usuario usuario)
    {
        try {
            return dao.update(usuario);
        } catch (SQLException e) {
            //TODO GESTION DE ERRORES
            e.printStackTrace();
        }
        return 0;
    }
    public int delete(Usuario usuario)
    {
        try {
            return dao.delete(usuario);
        } catch (SQLException e) {
            //TODO GESTION DE ERRORES
            e.printStackTrace();
        }
        return 0;
    }

    public int refresh(Usuario us)
    {
        try {
            return dao.refresh(us);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    public List<Usuario> getAll()
    {
        try {
            QueryBuilder<Usuario,Integer> builder = dao.queryBuilder();
            builder.orderBy(Usuario.NOMBRE,true);
            return builder.query();

        } catch (SQLException e) {
            //TODO GESTION DE ERRORES
            e.printStackTrace();
        }
        return null;
    }

    public Usuario getById(int id)
    {
        try {
            return dao.queryForId(id);
        } catch (SQLException e) {
            //TODO GESTION DE ERRORES
            e.printStackTrace();
        }
        return null;
    }

    public Usuario getByNick(String nick){
        try {
            List<Usuario> usuarios = dao.queryForEq(Usuario.NICK,nick);
            if(usuarios != null && usuarios.size() == 1)
                return usuarios.get(0);

        } catch (SQLException e) {
            //TODO GESTION DE ERRORES
            e.printStackTrace();
        }
        return null;
    }
}
