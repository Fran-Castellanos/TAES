package juego.taes.domainmodel.Repository;

import android.content.Context;

import com.j256.ormlite.stmt.QueryBuilder;

import java.sql.SQLException;
import java.util.List;

import juego.taes.domainmodel.Data.Dao.CarreraDao;
import juego.taes.domainmodel.Data.Dao.CarreraUniversidadDao;
import juego.taes.domainmodel.Data.Dao.ICarreraDao;
import juego.taes.domainmodel.Data.Dao.ICarreraUniversidadDao;
import juego.taes.domainmodel.Data.DatabaseHelper;
import juego.taes.domainmodel.Data.DatabaseManager;
import juego.taes.domainmodel.Model.Cliente.Carrera;
import juego.taes.domainmodel.Model.Cliente.CarreraUniversidad;

/**
 * Created by Pedro on 21/04/2015.
 */
public class CarreraRepository {

    private DatabaseHelper db;
    private CarreraDao dao;
    private CarreraUniversidadDao carreraUniversidadDao;

    public CarreraRepository(Context ctx) throws SQLException {
        try {
            DatabaseManager dbManager = new DatabaseManager();
            db = dbManager.getHelper(ctx);
            dao = db.getCarreraDao();
            carreraUniversidadDao = db.getCarreraUniversidadDao();

        } catch (SQLException e) {
            // TODO: Exception Handling
            throw e;
        }

    }

    public int create(Carrera carrera) throws SQLException {
        try {
            return dao.create(carrera);
        } catch (SQLException e) {
            //TODO GESTION DE ERRORES
            throw e;
        }
    }

    public int update(Carrera carrera) throws SQLException {
        try {
            return dao.update(carrera);
        } catch (SQLException e) {
            //TODO GESTION DE ERRORES
            throw e;
        }
    }
    public int delete(Carrera carrera) throws SQLException {
        try {
            return dao.delete(carrera);
        } catch (SQLException e) {
            //TODO GESTION DE ERRORES
            throw e;
        }
    }

    public int refresh(Carrera carrera) throws SQLException {
        try {
            return dao.refresh(carrera);
        } catch (SQLException e) {
            throw e;
        }
    }

    public List<Carrera> getAll() throws SQLException {
        try {

            QueryBuilder<Carrera,Integer> builder = dao.queryBuilder();
            builder.orderBy(Carrera.NOMBRE,true);
            return builder.query();

        } catch (SQLException e) {
            //TODO GESTION DE ERRORES
            throw e;
        }
    }

    public Carrera getById(int id) throws SQLException {
        try {
            return dao.queryForId(id);
        } catch (SQLException e) {
            //TODO GESTION DE ERRORES
            throw e;
        }
    }

    public List<Carrera> getByUniversidad(int id) throws SQLException {
        try {

            QueryBuilder<CarreraUniversidad,Integer> builder = carreraUniversidadDao.queryBuilder();
            QueryBuilder<Carrera, Integer> builderC = dao.queryBuilder();
            builder.where().eq(CarreraUniversidad.UNIVERSIDAD,id);
            builderC.join(builder);
            builderC.orderBy(Carrera.NOMBRE,true);

            return builderC.query();

        } catch (SQLException e) {
            //TODO GESTION DE ERRORES
            throw e;
        }
    }
}
