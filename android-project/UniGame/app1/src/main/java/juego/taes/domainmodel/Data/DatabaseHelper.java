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

    private static final int DATABASE_VERSION = 23;


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
        universidad4.setNombre("Universidad Politecnica de Valencia");
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
        carrera2.setNombre("Ingeniería Informática");
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
        carrera4.setNombre("Ingeniería Industrial");
        carrera4.setId(4);
        carreraDao.create(carrera4);

        carreraUniversidad.setId(0);
        carreraUniversidad.setCarrera(carrera4);
        carreraUniversidad.setUniversidad(universidad1);
        carreraUniversidadDao.create(carreraUniversidad);

        Carrera carrera5 = new Carrera();
        carrera5.setNombre("Ingeniería Química");
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
        carrera8.setNombre("Traducción e Interpretación");
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
        carrera12.setNombre("Ingenería Aeronáutica");
        carrera12.setId(12);
        carreraDao.create(carrera12);

        carreraUniversidad.setId(0);
        carreraUniversidad.setCarrera(carrera12);
        carreraUniversidad.setUniversidad(universidad1);
        carreraUniversidadDao.create(carreraUniversidad);

        /**********************************************************/

        Carrera carrera13 = new Carrera();
        carrera13.setNombre("Farmacia");
        carrera13.setId(13);
        carreraDao.create(carrera13);

        carreraUniversidad.setId(0);
        carreraUniversidad.setCarrera(carrera13);
        carreraUniversidad.setUniversidad(universidad3);
        carreraUniversidadDao.create(carreraUniversidad);

        Carrera carrera14 = new Carrera();
        carrera14.setNombre("Medicina");
        carrera14.setId(14);
        carreraDao.create(carrera14);

        carreraUniversidad.setId(0);
        carreraUniversidad.setCarrera(carrera14);
        carreraUniversidad.setUniversidad(universidad2);
        carreraUniversidadDao.create(carreraUniversidad);

        Carrera carrera15 = new Carrera();
        carrera15.setNombre("Ingenieria Civil");
        carrera15.setId(15);
        carreraDao.create(carrera15);

        carreraUniversidad.setId(0);
        carreraUniversidad.setCarrera(carrera15);
        carreraUniversidad.setUniversidad(universidad4);
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
        asignatura4.setNombre("STI");
        asignatura4.setId(4);
        asignaturaDao.create(asignatura4);

        asignaturaCarrera.setId(0);
        asignaturaCarrera.setCarrera(carrera2);
        asignaturaCarrera.setAsignatura(asignatura4);
        asignaturaCarreraDao.create(asignaturaCarrera);
/***************************************************************************************/
        Asignatura asignatura5 = new Asignatura();
        asignatura5.setNombre("Anatomia");
        asignatura5.setId(5);
        getAsignaturaDao().create(asignatura5);

        asignaturaCarrera.setId(0);
        asignaturaCarrera.setCarrera(carrera14);
        asignaturaCarrera.setAsignatura(asignatura5);
        getAsignaturaCarreraDao().create(asignaturaCarrera);

        Asignatura asignatura6 = new Asignatura();
        asignatura6.setNombre("Formulación 1");
        asignatura6.setId(6);
        getAsignaturaDao().create(asignatura6);

        asignaturaCarrera.setId(0);
        asignaturaCarrera.setCarrera(carrera13);
        asignaturaCarrera.setAsignatura(asignatura6);
        getAsignaturaCarreraDao().create(asignaturaCarrera);

        Asignatura asignatura7 = new Asignatura();
        asignatura7.setNombre("Diseño Gráfico 1");
        asignatura7.setId(7);
        getAsignaturaDao(). create(asignatura7);

        asignaturaCarrera.setId(0);
        asignaturaCarrera.setCarrera(carrera15);
        asignaturaCarrera.setAsignatura(asignatura7);
        getAsignaturaCarreraDao().create(asignaturaCarrera);


        Asignatura asignatura8 = new Asignatura();
        asignatura8.setNombre("Filosofía del derecho");
        asignatura8.setId(8);
        getAsignaturaDao(). create(asignatura8);

        asignaturaCarrera.setId(0);
        asignaturaCarrera.setCarrera(carrera1);
        asignaturaCarrera.setAsignatura(asignatura8);
        getAsignaturaCarreraDao().create(asignaturaCarrera);



        Asignatura asignatura9 = new Asignatura();
        asignatura9.setNombre("Intr. Macroeconomía");
        asignatura9.setId(9);
        getAsignaturaDao(). create(asignatura9);

        asignaturaCarrera.setId(0);
        asignaturaCarrera.setCarrera(carrera6);
        asignaturaCarrera.setAsignatura(asignatura9);
        getAsignaturaCarreraDao().create(asignaturaCarrera);


        Asignatura asignatura10 = new Asignatura();
        asignatura10.setNombre("Economía Mundial");
        asignatura10.setId(10);
        getAsignaturaDao(). create(asignatura10);

        asignaturaCarrera.setId(0);
        asignaturaCarrera.setCarrera(carrera6);
        asignaturaCarrera.setAsignatura(asignatura10);
        getAsignaturaCarreraDao().create(asignaturaCarrera);

//////////////////////////////////////////////////////////////////////////////////
        //Crear bases de preguntas

        BDPreguntas preguntas1 = new BDPreguntas("Primer parcial",false,universidad1,asignatura1);
        preguntas1.setUsuario(user4);
        getBDPreguntasDao().assignEmptyForeignCollection(preguntas1, BDPreguntas.PREGUNTAS_CAMPO);
        getBDPreguntasDao().create(preguntas1);



        BDPreguntas preguntasFilosofiaDerecho = new BDPreguntas("Simulación control",false,universidad1,asignatura8);
        preguntasFilosofiaDerecho.setUsuario(user4);
        getBDPreguntasDao().assignEmptyForeignCollection(preguntasFilosofiaDerecho, BDPreguntas.PREGUNTAS_CAMPO);
        getBDPreguntasDao().create(preguntasFilosofiaDerecho);


        BDPreguntas preguntasMacroeconomia = new BDPreguntas("Preguntas",false,universidad1,asignatura9);
        preguntasMacroeconomia.setUsuario(user4);
        getBDPreguntasDao().assignEmptyForeignCollection(preguntasMacroeconomia, BDPreguntas.PREGUNTAS_CAMPO);
        getBDPreguntasDao().create(preguntasMacroeconomia);


        BDPreguntas preguntasEconomiaMundial = new BDPreguntas("testEconomiaMundial",false,universidad1,asignatura10);
        preguntasEconomiaMundial.setUsuario(user4);
        getBDPreguntasDao().assignEmptyForeignCollection(preguntasEconomiaMundial, BDPreguntas.PREGUNTAS_CAMPO);
        getBDPreguntasDao().create(preguntasEconomiaMundial);


        BDPreguntas preguntasEconomiaMundial2 = new BDPreguntas("más tests",false,universidad1,asignatura10);
        preguntasEconomiaMundial2.setUsuario(user4);
        getBDPreguntasDao().assignEmptyForeignCollection(preguntasEconomiaMundial2, BDPreguntas.PREGUNTAS_CAMPO);
        getBDPreguntasDao().create(preguntasEconomiaMundial2);


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





//////////////////////////////////////////////////////////////////////////////////
        //Crear preguntas y añadirlas a la base de preguntas


        String p1 = "¿Qué es un árbol binario?";
        String[] resp1 = {"Un árbol compuesto por 0s y 1s",
                "Una estructura jerárquica compuesta por una raíz y como mucho dos hijos",
                "Un árbol representado en formato digital",
                "Una estructura de datos simple"};

        Boolean [] sol1 = {false, true, false, false};
        generarPregunta(preguntas1, p1, resp1, sol1);


        String p2 = "¿Qué es un ABB?";
        String[] resp2 = {"Es una estructura de datos abstracta ordenada de izquierda a derecha",
                "Es una estructura de datos abstracta muy ineficiente",
                "Es un concepto que no existe",
                "Es un tipo de datos predefinido por el sistema en los lenguajes de alto nivel"};

        Boolean [] sol2 = {true, false, false, false};

        generarPregunta(preguntas1, p2, resp2, sol2);



        String p3 = "¿Qué estructura de datos abstracta es más eficiente para las inserciones?";
        String[] resp3 = {"Un vector",
                "Un árbol binario",
                "Una lista enlazada simple",
                "Cualquier estructura de datos"};

        Boolean [] sol3 = {false, false, true, false};
        generarPregunta(preguntas1, p3, resp3, sol3);


        String p4 = "¿Cuál fue la principal aportacion de Von Neuman a la computación?";
        String[] resp4 = {"El programa almacenado en memoria",
                "Memoria principal en los computadores",
                "Computadores con mayor memoria secundaria",
                "Paralelización de cómputo de procesos"};

        Boolean [] sol4 = {true, false, false, false};
        generarPregunta(preguntas1, p4, resp4, sol4);


        String p5 = "¿Cuál es el principal problema de la recursión?";
        String[] resp5 = {"Problemas largos compuestos por muchas instrucciones",
                "Inversión grande en tiempo para diseñar el algoritmo",
                "Muchas llamadas se quedan en espera",
                "No existe ningún inconveniente en la recursión"};

        Boolean [] sol5 = {false, false, true, false};
        generarPregunta(preguntas1, p5, resp5,sol5);




        String p6 = "¿Qué significa el término layering?";
        String[] resp6 = {"Herencia de atributos y métodos",
                "Ese término no existe en programación",
                "Es copiar valores por referencia",
                "Sirve para destruir objetos en lenguajes de alto nivel"};

        Boolean [] sol6 = {true, false, false, false};
        generarPregunta(preguntas1, p6, resp6,sol6);



        String p7 = "¿Cuál es el paradigma de programación que más se usa hoy en día?";
        String[] resp7 = {"Programación imperativa",
                "Programación recursiva",
                "Programación lógica",
                "Programación orientada a objetos"};

        Boolean [] sol7 = {false, false, false, true};
        generarPregunta(preguntas1, p7, resp7, sol7);




        //******************** FILOSOFIA DEL DERECHO**************************

        String p1FD = "Señale la modalidad correlativa del concepto de libertad.";
        String[] resp1FD = {"No-derecho",
                "Sujeción",
                "Incompetencia",
                "Inmunidad"};

        Boolean [] sol1FD = {true, false, false, false};
        generarPregunta(preguntasFilosofiaDerecho, p1FD, resp1FD, sol1FD);


        String p2FD = "La modalidad correlativa del concepto de poder...";
        String[] resp2FD = {"Es sujeción",
                "Es incompetencia",
                "Es inmunidad",
                "Es no-derecho"};

        Boolean [] sol2FD = {true, false, false, false};

        generarPregunta(preguntasFilosofiaDerecho, p2FD, resp2FD, sol2FD);



        String p3FD = "La modalidad correlativa del concepto de inmunidad...";
        String[] resp3FD = {"Es incompetencia",
                "Es no-derecho",
                "Es derecho en sentido fuerte",
                "Es sujeción"};

        Boolean [] sol3FD = {true, false, false, false};

        generarPregunta(preguntasFilosofiaDerecho, p3FD, resp3FD, sol3FD);


        String p4FD = "¿A qué sentido de responsabilidad hace referencia la siguente frase? Los neuro-deterministas afirman que los seres humanos no son responsables de sus actos.";
        String[] resp4FD = {"Responsabilidad como reprochabilidad moral o jurídica",
                "Resposabilidad como factor causal",
                "Responsabilidad como ajuste entre principios y reglas",
                "Responsabilidad como conjunto de deberes derivados de rol o cargo"};

        Boolean [] sol4FD = {true, false, false, false};

        generarPregunta(preguntasFilosofiaDerecho, p4FD, resp4FD, sol4FD);



        String p5FD = "¿Cuál de las siguientes fuentes de derecho son fuentes-acto?";
        String[] resp5FD = {"La ley y los pactos internacionales",
                "La costumbre jurídica",
                "La doctrina",
                "Ninguna de las anteriores"};

        Boolean [] sol5FD = {true, false, false, false};

        generarPregunta(preguntasFilosofiaDerecho, p5FD, resp5FD, sol5FD);



        String p6FD = "Quien es parte de un proceso, se encuentra en una situación de...";
        String[] resp6FD = {"Sujeción",
                "Poder",
                "Inmunidad",
                "Libertad"};

        Boolean [] sol6FD = {true, false, false, false};

        generarPregunta(preguntasFilosofiaDerecho, p6FD, resp6FD, sol6FD);



        String p7FD = "Completa la falacia de la afirmación del consecuente:\n si 'p->q', si se da 'q'...";
        String[] resp7FD = {"Entonces p",
                "Entonces z",
                "Entonces ¬p",
                "Entonces ¬q"};

        Boolean [] sol7FD = {true, false, false, false};

        generarPregunta(preguntasFilosofiaDerecho, p7FD, resp7FD, sol7FD);



        String p8FD = "¿Qué caracteriza a la sanción civil?";
        String[] resp8FD = {"Beneficio al demandante",
                "Se ingresa en el erario publico",
                "Se reclama de oficio",
                "Beneficio al demandado"};

        Boolean [] sol8FD = {true, false, false, false};

        generarPregunta(preguntasFilosofiaDerecho, p8FD, resp8FD, sol8FD);


        //****************** INTRODUCCION A MACROECONOMIA*******************************

        String p1IM = "El supuesto 'ceteris paribus' NO significa...";
        String[] resp1IM = {"Que siempre hay pares de variables que se muevan a la vez",
                "El resto permanece constante",
                "Dado todo lo demás",
                "Que se puede analizar el efecto cuando cambia una sóla variable"};

        Boolean [] sol1IM = {true, false, false, false};

        generarPregunta(preguntasMacroeconomia, p1IM, resp1IM, sol1IM);




        String p2IM = "Indica la afirmación falsa respecto a la Frontera de Posibilidades de Producción (FPP)";
        String[] resp2IM = {"Para aumentar la produccion de un bien tenemos que renunciar a parte del otro bien",
                "Todas asignaciones eficientes son factibles",
                "Las asignaciones eficientes se encuentran sobre la FPP",
                "Las asignaciones factibles se encuentran sobre o por debajo de la FPP"};

        Boolean [] sol2IM = {true, false, false, false};

        generarPregunta(preguntasMacroeconomia, p2IM, resp2IM, sol2IM);



        String p3IM = "¿Qué factores no favorecen al crecimiento a largo plazo?";
        String[] resp3IM = {"Una tasa de fertilidad muy elevada",
                "La difusión de nuevas tecnologías",
                "La acumulación del capital humano",
                "Todos los anteriores favorecen el crecimiento a largo plazo"};

        Boolean [] sol3IM = {true, false, false, false};

        generarPregunta(preguntasMacroeconomia, p3IM, resp3IM, sol3IM);





        String p4IM = "La identidad ahorro-inversión en economía abierta implica que...";
        String[] resp4IM = {"El ahorro nacional más las entradas netas de capital siempre es igual a la inversión de la economía",
                "Las entradas netas de capitales siempre son iguales a cero",
                "El ahorro nacional siempre es igual a la inversión de la economía",
                "El déficit del presupuesto público es igual a las entradas netas de capital del extranjero"};

        Boolean [] sol4IM = {true, false, false, false};

        generarPregunta(preguntasMacroeconomia, p4IM, resp4IM, sol4IM);




        String p5IM = "¿Cuáles de las siguientes organizaciones no es un intermediario financiero?";
        String[] resp5IM = {"Una agencia de viajes",
                "Un banco",
                "Una compañía de seguros",
                "Un fondo de inversión"};

        Boolean [] sol5IM = {true, false, false, false};

        generarPregunta(preguntasMacroeconomia, p5IM, resp5IM, sol5IM);




        String p6IM = "El Banco Central puede incrementar el nivel de precios realizando en el mercado abierto operaciones de...";
        String[] resp6IM = {"Compra y reduciendo la tasa de descuento",
                "Venta y elevando la tasa de descuento",
                "Venta y reduciendo la tasa de descuento",
                "Compra y elevando la tasa de descuento"};

        Boolean [] sol6IM = {true, false, false, false};

        generarPregunta(preguntasMacroeconomia, p6IM, resp6IM, sol6IM);



        String p7IM = "¿Qué causa de desempleo NO está asociada con una tasa de salarios por encima del salario de equilibrio?";
        String[] resp7IM = {"La búsqueda de empleo",
                "Los sindicatos",
                "Los salarios de eficiencia",
                "Las leyes de salario mínimo"};

        Boolean [] sol7IM = {true, false, false, false};

        generarPregunta(preguntasMacroeconomia, p7IM, resp7IM, sol7IM);



        String p8IM = "Si el tipo de cambio real de Estados Unidos se aprecia, las exportaciones de Estados Unidos...";
        String[] resp8IM = {"Se reducen y sus importaciones aumentan",
                "Aumentan y sus importaciones se reducen",
                "Y las importaciones aumentan",
                "Y las importaciones se reducen"};

        Boolean [] sol8IM = {true, false, false, false};

        generarPregunta(preguntasMacroeconomia, p8IM, resp8IM, sol8IM);



        //************ECONOMIA MUNDIAL************************************************

        String p1EM = "Un aumento del tipo de cambio del dólar frente al euro se corresponde con...";
        String[] resp1EM = {"Una apreciación del dólar o del euro, depende",
                "Una apreciación del dólar",
                "Una apreciación del euro",
                "Ninguna de las anteriores"};

        Boolean [] sol1EM = {true, false, false, false};

        generarPregunta(preguntasEconomiaMundial, p1EM, resp1EM, sol1EM);



        String p2EM = "Para realizar pronósticos sobre la evolución del tipo de cambio de mercado de una moneda, se suele utilizar...";
        String[] resp2EM = {"El valor de su tipo de cambio con paridad de poder adquisitivo frente al dólar",
                "El valor de su tipo de cambio efectivo real frente al dólar",
                "El valor de su tipo de cambio nominal frente al dólar",
                "El valor de su tipo de cambio efectivo nominal frente al dólar"};

        Boolean [] sol2EM = {true, false, false, false};

        generarPregunta(preguntasEconomiaMundial, p2EM, resp2EM, sol2EM);



        String p3EM = "El coeficiente de apertura externa de una economía se define como:";
        String[] resp3EM = {"La suma de exportaciones e importaciones como porcentaje del PIB",
                "El saldo comercial de un país como porcentaje del PIB",
                "La inversa de la recaudación arancelaria de un país como porcentaje del PIB",
                "Los aranceles promedio de un país"};

        Boolean [] sol3EM = {true, false, false, false};

        generarPregunta(preguntasEconomiaMundial, p3EM, resp3EM, sol3EM);



        String p4EM = "Entre los siguientes factores, no suele dar lugar a una depreciación de la moneda de una economía...";
        String[] resp4EM = {"La venta de divisas extranjeras por parte del banco central",
                "Un repunte significativo de la inflación",
                "Un débil crecimiento económico",
                "Una reducción de los tipos de interés oficiales"};

        Boolean [] sol4EM = {true, false, false, false};

        generarPregunta(preguntasEconomiaMundial, p4EM, resp4EM, sol4EM);



        String p5EM = "Una mejora de la posición de inversión internacional neta de un país en un año indica que en dicho año...";
        String[] resp5EM = {"Sus activos externos aumentaron más que sus pasivos externos",
                "Sus pasivos externos aumentaron más que sus activos externos",
                "El valor de sus pasivos externos excedía al de sus activos externos",
                "El valor de sus activos externos excedía al de sus pasivos externos"};

        Boolean [] sol5EM = {true, false, false, false};

        generarPregunta(preguntasEconomiaMundial, p5EM, resp5EM, sol5EM);



        String p1EM2 = "La apreciación de la moneda de una economía suele implicar ceteris paribus:";
        String[] resp1EM2 = {"Una caída de la inflación",
                "Una mejora del saldo público",
                "Un empeoramiento del saldo público",
                "Una mejora o empeoramiento del saldo público, en función de la elasticidad-precio que presenten exportaciones e importaciones"};

        Boolean [] sol1EM2 = {true, false, false, false};

        generarPregunta(preguntasEconomiaMundial2, p1EM2, resp1EM2, sol1EM2);


        String p2EM2 = "¿Cuál de estas circunstancias no es compatible con un aumento de la competitividad-precio de un país?";
        String[] resp2EM2 = {"Una depreciación efectiva nominal menor que el aumento de los precios relativos",
                "Una depreciación efectiva nominal mayor que el aumento de los precios relativos",
                "Una depreciación efectiva nominal menor que el descenso de los precios relativos",
                "Una depreciación efectiva nominal mayor que el descenso de los precios relativos"};

        Boolean [] sol2EM2 = {true, false, false, false};

        generarPregunta(preguntasEconomiaMundial2, p2EM2, resp2EM2, sol2EM2);



        String p3EM2 = "Son circunstancias que dan lugar a variaciones en el tipo de cambio efectivo nominal de una moneda...";
        String[] resp3EM2 = {"Las modificaciones en los tipos de cambio bilaterales nominales de la moneda",
                "Las modificaciones en los precios relativos de la economía",
                "Tanto las modificaciones en los tipos de cambio bilaterales nominales de la moneda como en los precios relativos de la economía ",
                "Ninguno de los anteriores"};

        Boolean [] sol3EM2 = {true, false, false, false};

        generarPregunta(preguntasEconomiaMundial2, p3EM2, resp3EM2, sol3EM2);


        String p4EM2 = "Si durante un año la magnitud del ahorro interno ha superado la de la inversión productiva en un país, ello se reflejará en:";
        String[] resp4EM2 = {"Una disminución de la posición deudora o un aumento de la posición acredora, depende",
                "Una disminución de la posición deudora exclusivamente",
                "Un aumento de la posición acreedora exclusivamente",
                "Este hecho no altera la posición dudora o acreedora de un país, que es una magnitud tipo stock"};

        Boolean [] sol4EM2 = {true, false, false, false};

        generarPregunta(preguntasEconomiaMundial2, p4EM2, resp4EM2, sol4EM2);


    }



    public void generarPregunta(BDPreguntas bd, String preg, String[] respuestas, Boolean [] sol) throws SQLException {
        Pregunta pregunta = new Pregunta(preg,false);
        pregunta.setBdPreguntas(bd);

        getPreguntaDao().assignEmptyForeignCollection(pregunta, Pregunta.RESPUESTAS_CAMPO);
        getPreguntaDao().create(pregunta);

        int i = 0;
        for(String r : respuestas)
        {
            Respuesta respuesta = new Respuesta(r,sol[i++],false);
            respuesta.setPregunta(pregunta);
            getRespuestaDao().create(respuesta);
        }

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
