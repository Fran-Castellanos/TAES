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

    public UsuarioRepository(Context ctx) throws SQLException {
        try {
            DatabaseManager dbManager = new DatabaseManager();
            db = dbManager.getHelper(ctx);
            dao = db.getUsuarioDao();
        } catch (SQLException e) {
            // TODO: Exception Handling
            throw e;
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

    public int update(Usuario usuario) throws SQLException {
        try {
            return dao.update(usuario);
        } catch (SQLException e) {
            //TODO GESTION DE ERRORES
            throw e;
        }
    }
    public int delete(Usuario usuario) throws SQLException {
        try {
            return dao.delete(usuario);
        } catch (SQLException e) {
            //TODO GESTION DE ERRORES
            throw e;
        }
    }

    public int refresh(Usuario us) throws SQLException {
        try {
            return dao.refresh(us);
        } catch (SQLException e) {
            throw e;
        }
    }

    public List<Usuario> getAll() throws SQLException {
        try {
            QueryBuilder<Usuario,Integer> builder = dao.queryBuilder();
            builder.orderBy(Usuario.NOMBRE,true);
            return builder.query();

        } catch (SQLException e) {
            //TODO GESTION DE ERRORES
            throw e;
        }
    }

    public Usuario getById(int id) throws SQLException {
        try {
            return dao.queryForId(id);
        } catch (SQLException e) {
            //TODO GESTION DE ERRORES
            throw e;
        }
    }

    public Usuario getByNick(String nick) throws SQLException {
        try {
            List<Usuario> usuarios = dao.queryForEq(Usuario.NICK,nick);
            if(usuarios != null && usuarios.size() == 1)
                return usuarios.get(0);

        } catch (SQLException e) {
            //TODO GESTION DE ERRORES
            throw e;
        }
        return null;
    }
}
