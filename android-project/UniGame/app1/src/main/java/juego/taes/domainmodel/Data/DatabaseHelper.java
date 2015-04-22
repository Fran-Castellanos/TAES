package juego.taes.domainmodel.Data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

import juego.taes.domainmodel.Data.Dao.*;
import juego.taes.domainmodel.Model.Cliente.*;
import juego.taes.domainmodel.Model.Example.Comment;

/**
 * Created by felix 22/04/2015.
 */
public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

    // name of the database file for your application -- change to something appropriate for your app
    private static final String DATABASE_NAME = "localdb.db";
    // any time you make changes to your database objects, you may have to increase the database version
    private static final int DATABASE_VERSION = 1;

    //Daos utilizados
    private IAsignaturaDao asignaturaDao = null;
    private IBDPreguntasDao bdPreguntasDao = null;
    private ICarreraDao carreraDao = null;
    private IPreguntaDao preguntaDao = null;
    private IRespuestaDao respuestaDao = null;
    private IUniversidadDao universidadDao = null;
    private IUsuarioDao usuarioDao = null;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * This is called when the database is first created. Usually you should call createTable statements here to create
     * the tables that will store your data.
     */
    @Override
    public void onCreate(SQLiteDatabase db, ConnectionSource connectionSource) {
        try {

            Log.i(DatabaseHelper.class.getName(), "onCreate");
            //Crear las tablas
            crearTablas();

        } catch (SQLException e) {
            Log.e(DatabaseHelper.class.getName(), "Can't create database", e);
            throw new RuntimeException(e);
        }

        inicializarDatos();

    }

    /**
     * This is called when your application is upgraded and it has a higher version number. This allows you to adjust
     * the various data to match the new version number.
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            Log.i(DatabaseHelper.class.getName(), "onUpgrade");
            // after we drop the old databases, we create the new ones
            borrarTablas();
            onCreate(db, connectionSource);
        } catch (SQLException e) {
            Log.e(DatabaseHelper.class.getName(), "Can't drop databases", e);
            throw new RuntimeException(e);
        }
    }

    //Crear las tablas en la bd
    private void crearTablas() throws SQLException {
        TableUtils.createTable(connectionSource, Comment.class);
    }

    //Borrar tablas de la bd
    private void borrarTablas() throws SQLException {
        TableUtils.dropTable(connectionSource, Comment.class, true);
    }

    //Insertar datos en la bd
    private void inicializarDatos()
    {

        // here we try inserting data in the on-create as a test

        Log.i(DatabaseHelper.class.getName(), "created new entries in onCreate");
    }

    /**
     * Returns the Database Access Object (DAO) for our SimpleData class. It will create it or just give the cached
     * value.
     */
    public IAsignaturaDao getIAsignaturaDao() throws SQLException
    {
        if(asignaturaDao == null)
        {
            asignaturaDao = getDao(Asignatura.class);
        }
        return asignaturaDao;
    }

    public IBDPreguntasDao getIBDPreguntasDao() throws SQLException
    {
        if(bdPreguntasDao == null)
        {
            bdPreguntasDao = getDao(BDPreguntas.class);
        }
        return bdPreguntasDao;
    }

    public ICarreraDao getCarreraDao() throws SQLException
    {
        if(carreraDao == null)
        {
            carreraDao = getDao(Carrera.class);
        }
        return carreraDao;
    }

    public IPreguntaDao getPreguntaDao() throws SQLException
    {
        if(preguntaDao == null)
        {
            preguntaDao = getDao(Pregunta.class);
        }
        return preguntaDao;
    }

    public IRespuestaDao getRespuestaDao() throws SQLException
    {
        if(respuestaDao == null)
        {
            respuestaDao = getDao(Respuesta.class);
        }
        return respuestaDao;
    }

    public IUniversidadDao getUniversidadDao() throws SQLException
    {
        if(universidadDao == null)
        {
            universidadDao = getDao(Universidad.class);
        }
        return universidadDao;
    }

    public IUsuarioDao getUsuarioDao() throws SQLException
    {
        if(usuarioDao == null)
        {
            usuarioDao = getDao(Usuario.class);
        }
        return usuarioDao;
    }

    /**
     * Close the database connections and clear any cached DAOs.
     */
    @Override
    public void close() {
        super.close();
        limpiarDaos();
    }

    //Poner a null los daos
    public void limpiarDaos()
    {
        asignaturaDao = null;
        bdPreguntasDao = null;
        carreraDao = null;
        preguntaDao = null;
        respuestaDao = null;
        universidadDao = null;
        usuarioDao = null;
    }

}
