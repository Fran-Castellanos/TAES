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
            //Inicializar los datos
            inicializarDatos();

        } catch (SQLException e) {
            Log.e(DatabaseHelper.class.getName(), "Can't create database", e);
            throw new RuntimeException(e);
        }


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

        //Crear las tablas en la bd
        TableUtils.createTable(connectionSource, Asignatura.class);
        TableUtils.createTable(connectionSource, BDPreguntas.class);
        TableUtils.createTable(connectionSource, Carrera.class);
        TableUtils.createTable(connectionSource, Pregunta.class);
        TableUtils.createTable(connectionSource, Respuesta.class);
        TableUtils.createTable(connectionSource, Universidad.class);
        TableUtils.createTable(connectionSource, Usuario.class);

    }

    //Borrar tablas de la bd
    private void borrarTablas() throws SQLException {

        //Borrar las tablas de la bd
        TableUtils.dropTable(connectionSource, Asignatura.class, true);
        TableUtils.dropTable(connectionSource, BDPreguntas.class, true);
        TableUtils.dropTable(connectionSource, Carrera.class, true);
        TableUtils.dropTable(connectionSource, Pregunta.class, true);
        TableUtils.dropTable(connectionSource, Respuesta.class, true);
        TableUtils.dropTable(connectionSource, Universidad.class, true);
        TableUtils.dropTable(connectionSource, Usuario.class, true);
    }

    //Insertar datos en la bd
    private void inicializarDatos() throws SQLException {

        // here we try inserting data in the on-create as a test

        //Crear usuario
        Usuario user = new Usuario();
        user.setNick("paco");
        user.setNombre("Paco");
        user.setApellidos("Apellidos");
        user.setSexo(Sexo.HOMBRE);
        user.setLoginOffline(true);
        user.setId(1);

        int usuario1 = usuarioDao.create(user);

        //Crear universidades
        Universidad universidad = new Universidad();
        universidad.setNombre("Universidad de Alicante");
        universidad.setSiglas("UA");
        universidad.setId(1);
        int universidad1 = universidadDao.create(universidad);

        universidad.setNombre("Universidad de la Vida");
        universidad.setSiglas("UDLV");
        universidad.setId(2);
        int universidad2 = universidadDao.create(universidad);

        //Crear carreras
        Carrera carrera = new Carrera();
        carrera.setNombre("Derecho");
        carrera.setId(1);
        int carrera1 = carreraDao.create(carrera);

        carrera.setNombre("Informatica");
        carrera.setId(2);
        universidad.setId(universidad1);
        int carrera2 = carreraDao.create(carrera);

        //Crear asignaturas
        Asignatura asignatura = new Asignatura();
        asignatura.setNombre("PED");
        asignatura.setId(1);
        asignatura.setCarrera(carrera);
        int asignatura1 = asignaturaDao.create(asignatura);

        asignatura.setNombre("Programación 3");
        asignatura.setId(2);
        carrera.setId(carrera2);
        asignatura.setCarrera(carrera);
        int asignatura2 = asignaturaDao.create(asignatura);

        //Crear bases de preguntas


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

    public ICarreraDao getICarreraDao() throws SQLException
    {
        if(carreraDao == null)
        {
            carreraDao = getDao(Carrera.class);
        }
        return carreraDao;
    }

    public IPreguntaDao getIPreguntaDao() throws SQLException
    {
        if(preguntaDao == null)
        {
            preguntaDao = getDao(Pregunta.class);
        }
        return preguntaDao;
    }

    public IRespuestaDao getIRespuestaDao() throws SQLException
    {
        if(respuestaDao == null)
        {
            respuestaDao = getDao(Respuesta.class);
        }
        return respuestaDao;
    }

    public IUniversidadDao getIUniversidadDao() throws SQLException
    {
        if(universidadDao == null)
        {
            universidadDao = getDao(Universidad.class);
        }
        return universidadDao;
    }

    public IUsuarioDao getIUsuarioDao() throws SQLException
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
