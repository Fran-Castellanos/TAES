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
    private IAsignaturaCarreraDao asignaturaCarreraDao = null;
    private ICarreraUniversidadDao carreraUniversidadDao = null;

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
        TableUtils.createTable(connectionSource, AsignaturaCarrera.class);
        TableUtils.createTable(connectionSource, CarreraUniversidad.class);

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
        TableUtils.dropTable(connectionSource, AsignaturaCarrera.class,true);
        TableUtils.dropTable(connectionSource, CarreraUniversidad.class,true);
    }

    //Insertar datos en la bd
    private void inicializarDatos() throws SQLException {

        // here we try inserting data in the on-create as a test

        //Crear usuario

        Usuario user = new Usuario();


        user.setNick("Paco");
        user.setNombre("Paco");
        user.setApellidos("Apellidos");
        user.setSexo(Sexo.HOMBRE);
        user.setLoginOffline(true);
        user.setId(1);

        int usuario1 = usuarioDao.create(user);

        user.setNick("Torretas");
        user.setNombre("Ivan");
        user.setApellidos("Fantasma Casper");
        user.setSexo(Sexo.HOMBRE);
        user.setLoginOffline(true);
        user.setId(2);
        int usuario2 = usuarioDao.create(user);

        user.setNick("Javier");
        user.setNombre("Javier");
        user.setApellidos("Ortega");
        user.setSexo(Sexo.HOMBRE);
        user.setLoginOffline(true);
        user.setId(3);
        int usuario3 = usuarioDao.create(user);

        user.setNick("Felix");
        user.setNombre("Felix");
        user.setApellidos("Escalona");
        user.setSexo(Sexo.HOMBRE);
        user.setLoginOffline(true);
        user.setId(4);
        int usuario4 = usuarioDao.create(user);


        user.setNick("Pedro");
        user.setNombre("Pedro");
        user.setApellidos("Martinez");
        user.setSexo(Sexo.HOMBRE);
        user.setLoginOffline(true);
        user.setId(5);
        int usuario5 = usuarioDao.create(user);

        user.setNick("Gio");
        user.setNombre("Giovani");
        user.setApellidos("Gallego");
        user.setSexo(Sexo.HOMBRE);
        user.setLoginOffline(true);
        user.setId(6);
        int usuario6 = usuarioDao.create(user);


        user.setNick("Fran");
        user.setNombre("Fran");
        user.setApellidos("Garcia");
        user.setSexo(Sexo.HOMBRE);
        user.setLoginOffline(true);
        user.setId(7);
        int usuario7 = usuarioDao.create(user);


        user.setNick("Martica");
        user.setNombre("Marta");
        user.setApellidos("Castillo");
        user.setSexo(Sexo.HOMBRE);
        user.setLoginOffline(true);
        user.setId(8);
        int usuario8 = usuarioDao.create(user);

        user.setNick("BobEsponja");
        user.setNombre("Bob");
        user.setApellidos("Mateu");
        user.setSexo(Sexo.HOMBRE);
        user.setLoginOffline(true);
        user.setId(9);
        int usuario9 = usuarioDao.create(user);


        user.setNick("SR.Burns");
        user.setNombre("Burnsito");
        user.setApellidos("Tejados Porta");
        user.setSexo(Sexo.HOMBRE);
        user.setLoginOffline(true);
        user.setId(10);
        int usuario10 = usuarioDao.create(user);




        /////////////////////////////////////////////////////////////////////////
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


        universidad.setNombre("Universidad Miguel Hernandez");
        universidad.setSiglas("UMH");
        universidad.setId(3);
        int universidad3 = universidadDao.create(universidad);


        universidad.setNombre("Universidad Publica de Valencia");
        universidad.setSiglas("UPV");
        universidad.setId(4);
        int universidad4 = universidadDao.create(universidad);


        universidad.setNombre("Universidad San jorge");
        universidad.setSiglas("USJ");
        universidad.setId(5);
        int universidad5 = universidadDao.create(universidad);


        universidad.setNombre("Universidad de Granada");
        universidad.setSiglas("UG");
        universidad.setId(6);

        int universidad6 = universidadDao.create(universidad);


        universidad.setNombre("Universidad Sevilla");
        universidad.setSiglas("US");
        universidad.setId(7);

        int universidad7 = universidadDao.create(universidad);


        universidad.setNombre("Universidad de Zaragoza");
        universidad.setSiglas("UZIZAR");
        universidad.setId(8);

        int universidad8 = universidadDao.create(universidad);


        universidad.setNombre("Universidad de Almeria");
        universidad.setSiglas("UMH");
        universidad.setId(9);

        int universidad9 = universidadDao.create(universidad);


        universidad.setNombre("Universidad Murcia");
        universidad.setSiglas("UM");
        universidad.setId(10);

        int universidad10 = universidadDao.create(universidad);


        universidad.setNombre("Universidad Extremadura");
        universidad.setSiglas("UNEX");
        universidad.setId(11);

        int universidad11 = universidadDao.create(universidad);


        universidad.setNombre("Universidad de Burgos");
        universidad.setSiglas("UBU");
        universidad.setId(12);

        int universidad12 = universidadDao.create(universidad);


        universidad.setNombre("Universidad de madrid");
        universidad.setSiglas("UAM");
        universidad.setId(13);

        int universidad13 = universidadDao.create(universidad);

        universidad.setNombre("Universidad Complutense de Madrid");
        universidad.setSiglas("UCM");
        universidad.setId(14);

        int universidad14 = universidadDao.create(universidad);

        universidad.setNombre("Universidad de Leon");
        universidad.setSiglas("UNILEON");
        universidad.setId(15);

        int universidad15 = universidadDao.create(universidad);




        ////////////////////////////////////////////////////////////////////////

        //Facultad

        Carrera carrera = new Carrera();
        carrera.setNombre("Derecho");
        carrera.setId(1);
        int carrera1 = carreraDao.create(carrera);

        carrera.setNombre("Ingenieria Informatica");
        carrera.setId(2);
        universidad.setId(universidad1);
        int carrera2 = carreraDao.create(carrera);

        carrera.setNombre("Medicina");
        carrera.setId(3);
        universidad.setId(universidad1);
        int carrera3 = carreraDao.create(carrera);

        carrera.setNombre("Ingenieria Industrial");
        carrera.setId(4);
        universidad.setId(universidad1);
        int carrera4 = carreraDao.create(carrera);

        carrera.setNombre("Ingenieria Quimica");
        carrera.setId(5);
        universidad.setId(universidad1);
        int carrera5 = carreraDao.create(carrera);  //Ingenieria


        carrera.setNombre("ADE");
        carrera.setId(6);
        universidad.setId(universidad1);
        int carrera6 = carreraDao.create(carrera);


        carrera.setNombre("Turismo");
        carrera.setId(7);
        universidad.setId(universidad1);
        int carrera7 = carreraDao.create(carrera);

        carrera.setNombre("Traduccion e Interpretacion");
        carrera.setId(8);
        universidad.setId(universidad1);
        int carrera8 = carreraDao.create(carrera);

        carrera.setNombre("Arquitectura");
        carrera.setId(9);
        universidad.setId(universidad1);
        int carrera9 = carreraDao.create(carrera);

        carrera.setNombre("Magisterio Infantil");
        carrera.setId(10);
        universidad.setId(universidad1);
        int carrera10 = carreraDao.create(carrera);

        carrera.setNombre("Periodismo");
        carrera.setId(11);
        universidad.setId(universidad1);
        int carrera11 = carreraDao.create(carrera);

        carrera.setNombre("Ingeneria Aeronautica");
        carrera.setId(12);
        universidad.setId(universidad1);
        int carrera12 = carreraDao.create(carrera);

        /////////////////////////////////////////////////////////////////////

        //Asignaturas

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

        asignatura.setNombre("LPP");
        asignatura.setId(3);
        carrera.setId(carrera2);
        asignatura.setCarrera(carrera);
        int asignatura3 = asignaturaDao.create(asignatura);


        asignatura.setNombre("MacroEconomia");
        asignatura.setId(4);
        carrera.setId(carrera2);
        asignatura.setCarrera(carrera);
        int asignatura4 = asignaturaDao.create(asignatura);


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

    public IAsignaturaCarreraDao getIAsignaturaCarreraDao() throws SQLException
    {
        if(asignaturaCarreraDao == null)
        {
            asignaturaCarreraDao = getDao(AsignaturaCarrera.class);
        }
        return asignaturaCarreraDao;
    }

    public ICarreraUniversidadDao getICarreraUniversidadDao() throws SQLException
    {
        if(carreraUniversidadDao == null)
        {
            carreraUniversidadDao = getDao(CarreraUniversidad.class);
        }
        return carreraUniversidadDao;
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
        asignaturaCarreraDao = null;
        carreraUniversidadDao = null;
    }

}
