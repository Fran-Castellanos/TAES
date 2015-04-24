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

        Usuario user1 = new Usuario();

        user1.setNick("Paco");
        user1.setNombre("Paco");
        user1.setApellidos("Apellidos");
        user1.setSexo(Sexo.HOMBRE);
        user1.setLoginOffline(true);
        user1.setId(1);

        usuarioDao.create(user1);

        Usuario user2 = new Usuario();

        user2.setNick("Torretas");
        user2.setNombre("Ivan");
        user2.setApellidos("Fantasma Casper");
        user2.setSexo(Sexo.HOMBRE);
        user2.setLoginOffline(true);
        user2.setId(2);
        usuarioDao.create(user2);

        Usuario user3 = new Usuario();

        user3.setNick("Javier");
        user3.setNombre("Javier");
        user3.setApellidos("Ortega");
        user3.setSexo(Sexo.HOMBRE);
        user3.setLoginOffline(true);
        user3.setId(3);
        int usuario3 = usuarioDao.create(user3);

        Usuario user4 = new Usuario();
        user4.setNick("Felix");
        user4.setNombre("Felix");
        user4.setApellidos("Escalona");
        user4.setSexo(Sexo.HOMBRE);
        user4.setLoginOffline(true);
        user4.setId(4);
        usuarioDao.create(user4);

        Usuario user5 = new Usuario();
        user5.setNick("Pedro");
        user5.setNombre("Pedro");
        user5.setApellidos("Martinez");
        user5.setSexo(Sexo.HOMBRE);
        user5.setLoginOffline(true);
        user5.setId(5);
        usuarioDao.create(user5);

        Usuario user6 = new Usuario();
        user6.setNick("Gio");
        user6.setNombre("Giovani");
        user6.setApellidos("Gallego");
        user6.setSexo(Sexo.HOMBRE);
        user6.setLoginOffline(true);
        user6.setId(6);
        usuarioDao.create(user6);

        Usuario user7 = new Usuario();
        user7.setNick("Fran");
        user7.setNombre("Fran");
        user7.setApellidos("Garcia");
        user7.setSexo(Sexo.HOMBRE);
        user7.setLoginOffline(true);
        user7.setId(7);
        usuarioDao.create(user7);

        Usuario user8 = new Usuario();
        user8.setNick("Martica");
        user8.setNombre("Marta");
        user8.setApellidos("Castillo");
        user8.setSexo(Sexo.HOMBRE);
        user8.setLoginOffline(true);
        user8.setId(8);
        usuarioDao.create(user8);

        /////////////////////////////////////////////////////////////////////////
        //Crear universidades

        Universidad universidad1 = new Universidad();
        universidad1.setNombre("Universidad de Alicante");
        universidad1.setSiglas("UA");
        universidad1.setId(1);
        universidadDao.create(universidad1);

        Universidad universidad2 = new Universidad();
        universidad2.setNombre("Universidad de la Vida");
        universidad2.setSiglas("UDLV");
        universidad2.setId(2);
        universidadDao.create(universidad2);

        Universidad universidad3 = new Universidad();
        universidad3.setNombre("Universidad Miguel Hernandez");
        universidad3.setSiglas("UMH");
        universidad3.setId(3);
        universidadDao.create(universidad3);

        Universidad universidad4 = new Universidad();
        universidad4.setNombre("Universidad Publica de Valencia");
        universidad4.setSiglas("UPV");
        universidad4.setId(4);
        universidadDao.create(universidad4);

        Universidad universidad5 = new Universidad();
        universidad5.setNombre("Universidad San jorge");
        universidad5.setSiglas("USJ");
        universidad5.setId(5);
        universidadDao.create(universidad5);

        Universidad universidad6 = new Universidad();
        universidad6.setNombre("Universidad de Granada");
        universidad6.setSiglas("UG");
        universidad6.setId(6);
        universidadDao.create(universidad6);

        Universidad universidad7 = new Universidad();
        universidad7.setNombre("Universidad Sevilla");
        universidad7.setSiglas("US");
        universidad7.setId(7);

        universidadDao.create(universidad7);

        Universidad universidad8 = new Universidad();
        universidad8.setNombre("Universidad de Zaragoza");
        universidad8.setSiglas("UZIZAR");
        universidad8.setId(8);

        universidadDao.create(universidad8);

        Universidad universidad9 = new Universidad();
        universidad9.setNombre("Universidad de Almeria");
        universidad9.setSiglas("UMH");
        universidad9.setId(9);

        universidadDao.create(universidad9);

        Universidad universidad10 = new Universidad();
        universidad10.setNombre("Universidad Murcia");
        universidad10.setSiglas("UM");
        universidad10.setId(10);

        universidadDao.create(universidad10);

        Universidad universidad11 = new Universidad();
        universidad11.setNombre("Universidad Extremadura");
        universidad11.setSiglas("UNEX");
        universidad11.setId(11);

        universidadDao.create(universidad11);

        Universidad universidad12 = new Universidad();
        universidad12.setNombre("Universidad de Burgos");
        universidad12.setSiglas("UBU");
        universidad12.setId(12);

        universidadDao.create(universidad12);

        Universidad universidad13 = new Universidad();
        universidad13.setNombre("Universidad de madrid");
        universidad13.setSiglas("UAM");
        universidad13.setId(13);

        universidadDao.create(universidad13);

        Universidad universidad14 = new Universidad();
        universidad14.setNombre("Universidad Complutense de Madrid");
        universidad14.setSiglas("UCM");
        universidad14.setId(14);

        universidadDao.create(universidad14);

        Universidad universidad15 = new Universidad();
        universidad15.setNombre("Universidad de Leon");
        universidad15.setSiglas("UNILEON");
        universidad15.setId(15);

        universidadDao.create(universidad15);




        ////////////////////////////////////////////////////////////////////////

        //Facultad

        CarreraUniversidad carreraUniversidad = new CarreraUniversidad();
        Carrera carrera1 = new Carrera();
        carrera1.setNombre("Derecho");
        carrera1.setId(1);
        carreraDao.create(carrera1);

        carreraUniversidad.setId(0);
        carreraUniversidad.setCarrera(carrera1);
        carreraUniversidad.setUniversidad(universidad1);
        carreraUniversidadDao.create(carreraUniversidad);

        Carrera carrera2 = new Carrera();
        carrera2.setNombre("Ingenieria Informatica");
        carrera2.setId(2);
        carreraDao.create(carrera2);

        carreraUniversidad.setId(0);
        carreraUniversidad.setCarrera(carrera2);
        carreraUniversidad.setUniversidad(universidad1);
        carreraUniversidadDao.create(carreraUniversidad);

        Carrera carrera3 = new Carrera();
        carrera3.setNombre("Medicina");
        carrera3.setId(3);
        carreraDao.create(carrera3);

        carreraUniversidad.setId(0);
        carreraUniversidad.setCarrera(carrera3);
        carreraUniversidad.setUniversidad(universidad1);
        carreraUniversidadDao.create(carreraUniversidad);

        Carrera carrera4 = new Carrera();
        carrera4.setNombre("Ingenieria Industrial");
        carrera4.setId(4);
        carreraDao.create(carrera4);

        carreraUniversidad.setId(0);
        carreraUniversidad.setCarrera(carrera4);
        carreraUniversidad.setUniversidad(universidad1);
        carreraUniversidadDao.create(carreraUniversidad);

        Carrera carrera5 = new Carrera();
        carrera5.setNombre("Ingenieria Quimica");
        carrera5.setId(5);
        carreraDao.create(carrera5);  //Ingenieria

        carreraUniversidad.setId(0);
        carreraUniversidad.setCarrera(carrera5);
        carreraUniversidad.setUniversidad(universidad1);
        carreraUniversidadDao.create(carreraUniversidad);

        Carrera carrera6 = new Carrera();
        carrera6.setNombre("ADE");
        carrera6.setId(6);
        carreraDao.create(carrera6);

        carreraUniversidad.setId(0);
        carreraUniversidad.setCarrera(carrera6);
        carreraUniversidad.setUniversidad(universidad1);
        carreraUniversidadDao.create(carreraUniversidad);

        Carrera carrera7 = new Carrera();
        carrera7.setNombre("Turismo");
        carrera7.setId(7);
        carreraDao.create(carrera7);

        carreraUniversidad.setId(0);
        carreraUniversidad.setCarrera(carrera7);
        carreraUniversidad.setUniversidad(universidad1);
        carreraUniversidadDao.create(carreraUniversidad);

        Carrera carrera8 = new Carrera();
        carrera8.setNombre("Traduccion e Interpretacion");
        carrera8.setId(8);
        carreraDao.create(carrera8);

        carreraUniversidad.setId(0);
        carreraUniversidad.setCarrera(carrera8);
        carreraUniversidad.setUniversidad(universidad1);
        carreraUniversidadDao.create(carreraUniversidad);

        Carrera carrera9 = new Carrera();
        carrera9.setNombre("Arquitectura");
        carrera9.setId(9);
        carreraDao.create(carrera9);

        carreraUniversidad.setId(0);
        carreraUniversidad.setCarrera(carrera9);
        carreraUniversidad.setUniversidad(universidad1);
        carreraUniversidadDao.create(carreraUniversidad);

        Carrera carrera10 = new Carrera();
        carrera10.setNombre("Magisterio Infantil");
        carrera10.setId(10);
        carreraDao.create(carrera10);

        carreraUniversidad.setId(0);
        carreraUniversidad.setCarrera(carrera10);
        carreraUniversidad.setUniversidad(universidad1);
        carreraUniversidadDao.create(carreraUniversidad);

        Carrera carrera11 = new Carrera();
        carrera11.setNombre("Periodismo");
        carrera11.setId(11);
        carreraDao.create(carrera11);

        carreraUniversidad.setId(0);
        carreraUniversidad.setCarrera(carrera11);
        carreraUniversidad.setUniversidad(universidad1);
        carreraUniversidadDao.create(carreraUniversidad);

        Carrera carrera12 = new Carrera();
        carrera12.setNombre("Ingeneria Aeronautica");
        carrera12.setId(12);
        carreraDao.create(carrera12);

        carreraUniversidad.setId(0);
        carreraUniversidad.setCarrera(carrera12);
        carreraUniversidad.setUniversidad(universidad1);
        carreraUniversidadDao.create(carreraUniversidad);

        /////////////////////////////////////////////////////////////////////

        //Asignaturas

        Asignatura asignatura1 = new Asignatura();
        asignatura1.setNombre("PED");
        asignatura1.setId(1);
        asignaturaDao.create(asignatura1);

        AsignaturaCarrera asignaturaCarrera = new AsignaturaCarrera();
        asignaturaCarrera.setId(0);
        asignaturaCarrera.setCarrera(carrera2);
        asignaturaCarrera.setAsignatura(asignatura1);
        asignaturaCarreraDao.create(asignaturaCarrera);

        Asignatura asignatura2 = new Asignatura();
        asignatura2.setNombre("Programación 3");
        asignatura2.setId(2);
        asignaturaDao.create(asignatura2);

        asignaturaCarrera.setId(0);
        asignaturaCarrera.setCarrera(carrera2);
        asignaturaCarrera.setAsignatura(asignatura2);
        asignaturaCarreraDao.create(asignaturaCarrera);

        Asignatura asignatura3 = new Asignatura();
        asignatura3.setNombre("LPP");
        asignatura3.setId(3);
        asignaturaDao.create(asignatura3);

        asignaturaCarrera.setId(0);
        asignaturaCarrera.setCarrera(carrera2);
        asignaturaCarrera.setAsignatura(asignatura3);
        asignaturaCarreraDao.create(asignaturaCarrera);

        Asignatura asignatura4 = new Asignatura();
        asignatura4.setNombre("MacroEconomia");
        asignatura4.setId(4);
        asignaturaDao.create(asignatura4);

        asignaturaCarrera.setId(0);
        asignaturaCarrera.setCarrera(carrera2);
        asignaturaCarrera.setAsignatura(asignatura4);
        asignaturaCarreraDao.create(asignaturaCarrera);


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
