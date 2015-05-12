package juego.taes.domainmodel.Data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

import juego.taes.domainmodel.Data.Dao.*;
import juego.taes.domainmodel.Model.Cliente.*;

/**
 * Created by felix 22/04/2015.
 */
public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

    // name of the database file for your application -- change to something appropriate for your app
    private static final String DATABASE_NAME = "localdb.db";
    // any time you make changes to your database objects, you may have to increase the database version
    private static final int DATABASE_VERSION = 9;

    //Daos utilizados
    private AsignaturaDao asignaturaDao = null;
    private BDPreguntasDao bdPreguntasDao = null;
    private CarreraDao carreraDao = null;
    private PreguntaDao preguntaDao = null;
    private RespuestaDao respuestaDao = null;
    private UniversidadDao universidadDao = null;
    private UsuarioDao usuarioDao = null;
    private AsignaturaCarreraDao asignaturaCarreraDao = null;
    private CarreraUniversidadDao carreraUniversidadDao = null;

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

        getUsuarioDao().create(user1);

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
        getUniversidadDao().create(universidad1);

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
        getCarreraDao().create(carrera1);

        carreraUniversidad.setId(0);
        carreraUniversidad.setCarrera(carrera1);
        carreraUniversidad.setUniversidad(universidad1);
        getCarreraUniversidadDao().create(carreraUniversidad);

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
        getAsignaturaDao().create(asignatura1);

        AsignaturaCarrera asignaturaCarrera = new AsignaturaCarrera();
        asignaturaCarrera.setId(0);
        asignaturaCarrera.setCarrera(carrera2);
        asignaturaCarrera.setAsignatura(asignatura1);
        getAsignaturaCarreraDao().create(asignaturaCarrera);

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

//////////////////////////////////////////////////////////////////////////////////
        //Crear bases de preguntas

        BDPreguntas preguntas1 = new BDPreguntas("Primer parcial",false,universidad1,asignatura1);
        preguntas1.setUsuario(user4);
        getBDPreguntasDao().assignEmptyForeignCollection(preguntas1, BDPreguntas.PREGUNTAS_CAMPO);
        getBDPreguntasDao().create(preguntas1);

        /*BDPreguntas preguntas2 = new BDPreguntas("Segundo parcial",false,universidad1,asignatura3);
        preguntas2.setUsuario(user4);
        getBDPreguntasDao().assignEmptyForeignCollection(preguntas2, BDPreguntas.PREGUNTAS_CAMPO);
        getBDPreguntasDao().create(preguntas2);

        BDPreguntas preguntas3 = new BDPreguntas("Examen final",false,universidad1,asignatura2);
        preguntas3.setUsuario(user4);
        getBDPreguntasDao().assignEmptyForeignCollection(preguntas3, BDPreguntas.PREGUNTAS_CAMPO);
        getBDPreguntasDao().create(preguntas3);

        BDPreguntas preguntas4 = new BDPreguntas("Primer parcial",false,universidad7,asignatura2);
        preguntas4.setUsuario(user1);
        getBDPreguntasDao().assignEmptyForeignCollection(preguntas4, BDPreguntas.PREGUNTAS_CAMPO);
        getBDPreguntasDao().create(preguntas4);*/

        Pregunta pregunta1 = new Pregunta("¿Que es un arbol binario?",false);
        pregunta1.setBdPreguntas(preguntas1);
        getPreguntaDao().assignEmptyForeignCollection(pregunta1, Pregunta.RESPUESTAS_CAMPO);
        getPreguntaDao().create(pregunta1);


        Respuesta respuesta1 = new Respuesta("a) un arbol compuesto por 0s y 1s",false,false);
        respuesta1.setPregunta(pregunta1);
        getRespuestaDao().create(respuesta1);
        Respuesta respuesta2 = new Respuesta("b) una estructura jerarquica compuesta por una raiz y como mucho dos hijos",true,false);
        respuesta2.setPregunta(pregunta1);
        getRespuestaDao().create(respuesta2);
        Respuesta respuesta3 = new Respuesta("c) un arbol representado en formato digital",false,false);
        respuesta3.setPregunta(pregunta1);
        getRespuestaDao().create(respuesta3);
        Respuesta respuesta4 = new Respuesta("d) una estructura de datos simple",false,false);
        respuesta4.setPregunta(pregunta1);
        getRespuestaDao().create(respuesta4);





        /*Pregunta pregunta2 = new Pregunta("¿que es un ABB?",false);
        pregunta2.setBdPreguntas(preguntas1);
        Respuesta respuesta5 = new Respuesta("a) es una estructura de datos abstracta ordenada de izquierda a derecha",true,false);
        respuesta5.setPregunta(pregunta2);
        Respuesta respuesta6 = new Respuesta("b) esas siglas componen un concepto que no existe",false,false);
        respuesta6.setPregunta(pregunta2);
        Respuesta respuesta7 = new Respuesta("c) es una estructura de datos abstracta muy ineficiente",false,false);
        respuesta7.setPregunta(pregunta2);
        Respuesta respuesta8 = new Respuesta("d) es un tipo de datos predefinido por el sistema en los lenguajes de alto nivel",false,false);
        respuesta8.setPregunta(pregunta2);

        Pregunta pregunta3 = new Pregunta("¿Que estructura de datos abstracta es mas eficiente para las inserciones?",false);
        pregunta3.setBdPreguntas(preguntas1);
        Respuesta respuesta9 = new Respuesta("a) un vector",false,false);
        respuesta9.setPregunta(pregunta3);
        Respuesta respuesta10 = new Respuesta("b) un arbol binario",false,false);
        respuesta10.setPregunta(pregunta3);
        Respuesta respuesta11 = new Respuesta("c) un lista enlazada simple",true,false);
        respuesta11.setPregunta(pregunta3);
        Respuesta respuesta12 = new Respuesta("d) cualquier estructur de datos",false,false);
        respuesta12.setPregunta(pregunta3);


        Pregunta pregunta4 = new Pregunta("¿Cual fue la principal aprtacion de Von Neuman a la computacion?",false);
        pregunta4.setBdPreguntas(preguntas2);
        Respuesta respuesta13 = new Respuesta("a) el programa almacenado en memoria",true,false);
        respuesta13.setPregunta(pregunta4);
        Respuesta respuesta14 = new Respuesta("b) memoria principal en los computadores",false,false);
        respuesta14.setPregunta(pregunta4);
        Respuesta respuesta15 = new Respuesta("c) computadores con mayor memoria secundaria",true,false);
        respuesta15.setPregunta(pregunta4);
        Respuesta respuesta16 = new Respuesta("d) paralelizacion de computo de procesos",false,false);
        respuesta16.setPregunta(pregunta4);


        Pregunta pregunta5 = new Pregunta("¿Cual es el principal problema de la recursion?",false);
        pregunta5.setBdPreguntas(preguntas2);
        Respuesta respuesta17 = new Respuesta("a) problemas largos compuestos por muchas instrucciones",false,false);
        respuesta17.setPregunta(pregunta5);
        Respuesta respuesta18 = new Respuesta("b) inverision grande en timepo para diseñar el algoritmo",false,false);
        respuesta18.setPregunta(pregunta5);
        Respuesta respuesta19 = new Respuesta("c) Muchas llamdas se quedan en espera",true,false);
        respuesta19.setPregunta(pregunta5);
        Respuesta respuesta20 = new Respuesta("d) No existe ningun inconveniente en la recursion",false,false);
        respuesta20.setPregunta(pregunta5);




        Pregunta pregunta6 = new Pregunta("¿Cual es el paradigma de programacion que mas se usa hoy en dia?",false);
        pregunta6.setBdPreguntas(preguntas3);
        Respuesta respuesta21 = new Respuesta("a) Programacion imperativa",false,false);
        respuesta21.setPregunta(pregunta6);
        Respuesta respuesta22 = new Respuesta("b) Programacion recursiva",false,false);
        respuesta22.setPregunta(pregunta6);
        Respuesta respuesta23 = new Respuesta("c) Programacion logica",false,false);
        respuesta23.setPregunta(pregunta6);
        Respuesta respuesta24 = new Respuesta("d) Programacion orientada a objetos",true,false);
        respuesta24.setPregunta(pregunta6);


        Pregunta pregunta7 = new Pregunta("¿Que significa el termino layering?",false);
        pregunta7.setBdPreguntas(preguntas4);
        Respuesta respuesta25 = new Respuesta("a) Herencia de atributos y metodos",true,false);
        respuesta25.setPregunta(pregunta7);
        Respuesta respuesta26 = new Respuesta("b) ese termino no existe en programacion",false,false);
        respuesta26.setPregunta(pregunta7);
        Respuesta respuesta27 = new Respuesta("c) es copir valores por referencia",false,false);
        respuesta27.setPregunta(pregunta7);
        Respuesta respuesta28 = new Respuesta("d) sirve para destruir objetos en lenguajes de alto nivel",false,false);
        respuesta28.setPregunta(pregunta7);*/





    }

    /**
     * Returns the Database Access Object (DAO) for our SimpleData class. It will create it or just give the cached
     * value.
     */
    public AsignaturaDao getAsignaturaDao() throws SQLException
    {
        if(asignaturaDao == null)
        {
            asignaturaDao = getDao(Asignatura.class);
        }
        return asignaturaDao;
    }

    public BDPreguntasDao getBDPreguntasDao() throws SQLException
    {
        if(bdPreguntasDao == null)
        {
            bdPreguntasDao = getDao(BDPreguntas.class);
        }
        return bdPreguntasDao;
    }

    public CarreraDao getCarreraDao() throws SQLException
    {
        if(carreraDao == null)
        {
            carreraDao = getDao(Carrera.class);
        }
        return carreraDao;
    }

    public PreguntaDao getPreguntaDao() throws SQLException
    {
        if(preguntaDao == null)
        {
            preguntaDao = getDao(Pregunta.class);
        }
        return preguntaDao;
    }

    public RespuestaDao getRespuestaDao() throws SQLException
    {
        if(respuestaDao == null)
        {
            respuestaDao = getDao(Respuesta.class);
        }
        return respuestaDao;
    }

    public UniversidadDao getUniversidadDao() throws SQLException
    {
        if(universidadDao == null)
        {
            universidadDao = getDao(Universidad.class);
        }
        return universidadDao;
    }

    public UsuarioDao getUsuarioDao() throws SQLException
    {
        if(usuarioDao == null)
        {
            usuarioDao = getDao(Usuario.class);
        }
        return usuarioDao;
    }

    public AsignaturaCarreraDao getAsignaturaCarreraDao() throws SQLException
    {
        if(asignaturaCarreraDao == null)
        {
            asignaturaCarreraDao = getDao(AsignaturaCarrera.class);
        }
        return asignaturaCarreraDao;
    }

    public CarreraUniversidadDao getCarreraUniversidadDao() throws SQLException
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
