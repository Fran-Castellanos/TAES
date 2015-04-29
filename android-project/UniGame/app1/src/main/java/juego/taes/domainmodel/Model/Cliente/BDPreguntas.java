package juego.taes.domainmodel.Model.Cliente;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

import juego.taes.domainmodel.Data.Dao.AsignaturaDao;
import juego.taes.domainmodel.Data.Dao.BDPreguntasDao;

/**
 * Created by felix on 22-4-2015.
 */

@DatabaseTable(tableName = BDPreguntas.TABLA, daoClass = BDPreguntasDao.class)
public class BDPreguntas {

    //Nombre de la tabla
    public static final String TABLA = "bd_preguntas";

    //Nombres de las columnas
    public static final String ID="_id";
    public static final String NOMBRE ="nombre"; // ejemplo : Examen1: primer parcial
    public static final String ENSERVIDOR="en_servidor";
    public static final String IDSINCRONIZACION="id_sincronizacion";
    public static final String FECHASINCRONIZACION="fecha_sincronizacion";
    public static final String MODIFICADODESDEULTIMASINCRONIZACION="modificado";

    //Columnas foreign key
    public static final String ASIGNATURA="fk_asignatura"; // ejemplo  PED
    public static final String USUARIO="fk_usuario";
    public static final String UNIVERSIDAD="fk_universidad";

    //Nombre de campos
    public static final String ASIGNATURA_CAMPO="asignatura";
    public static final String USUARIO_CAMPO="usuario";
    public static final String UNIVERSIDAD_CAMPO="universidad";

    //Atributos de la base de datos
    @DatabaseField(columnName=ID, generatedId = true, useGetSet = true)
    private int id;

    @DatabaseField(columnName=NOMBRE, useGetSet = true, canBeNull = false)
    private String nombre;

    @DatabaseField(columnName= ENSERVIDOR, canBeNull = false, defaultValue="false", useGetSet = true)
    private boolean enServidor;

    @DatabaseField(columnName= IDSINCRONIZACION, unique = true, useGetSet = true)
    private int idSincronizacion;

    @DatabaseField(columnName= FECHASINCRONIZACION, useGetSet = true)
    private Date fechaSincronizacion;

    @DatabaseField(columnName = MODIFICADODESDEULTIMASINCRONIZACION, useGetSet = true)
    private boolean modificadoDesdeUltimaSincronizacion;

    //Relaciones
    @DatabaseField(columnName = ASIGNATURA, foreign = true, canBeNull = false, useGetSet = true)
    private Asignatura asignatura;

    @DatabaseField(columnName=USUARIO, foreign = true, canBeNull = false, useGetSet = true)
    private Usuario usuario;

    @DatabaseField(columnName = UNIVERSIDAD, foreign = true, canBeNull = false, useGetSet = true)
    private Universidad universidad;

    @ForeignCollectionField(eager=false, foreignFieldName = Pregunta.BD_CAMPO)
    private ForeignCollection<Pregunta> preguntas;

    public BDPreguntas() {
        // ORMLite needs a no-arg constructor
    }

    public BDPreguntas(String nombre, boolean enServidor, Universidad universidad, Asignatura asignatura) {
        this.nombre = nombre;
        this.enServidor = enServidor;
        this.universidad = universidad;
        this.asignatura = asignatura;
    }

    public BDPreguntas(String nombre, boolean enServidor, Universidad universidad, Asignatura asignatura,ForeignCollection<Pregunta> preguntas) {
        this.nombre = nombre;
        this.enServidor = enServidor;
        this.universidad = universidad;
        this.asignatura = asignatura;
        this.preguntas = preguntas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        nombre = nombre;
    }

    public boolean getEnServidor() {
        return enServidor;
    }

    public void setEnServidor(boolean enServidor) {
        this.enServidor = enServidor;
    }

    public int getIdSincronizacion() {
        return idSincronizacion;
    }

    public void setIdSincronizacion(int idSincronizacion) {
        this.idSincronizacion = idSincronizacion;
    }

    public Date getFechaSincronizacion() {
        return fechaSincronizacion;
    }

    public void setFechaSincronizacion(Date fechaSincronizacion) {
        this.fechaSincronizacion = fechaSincronizacion;
    }

    public boolean getModificadoDesdeUltimaSincronizacion() {
        return modificadoDesdeUltimaSincronizacion;
    }

    public void setModificadoDesdeUltimaSincronizacion(boolean modificadoDesdeUltimaSincronizacion) {
        this.modificadoDesdeUltimaSincronizacion = modificadoDesdeUltimaSincronizacion;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Universidad getUniversidad() {
        return universidad;
    }

    public void setUniversidad(Universidad universidad) {
        this.universidad = universidad;
    }

    public ForeignCollection<Pregunta> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(ForeignCollection<Pregunta> preguntas) {
        this.preguntas = preguntas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BDPreguntas)) return false;

        BDPreguntas that = (BDPreguntas) o;

        if (id != that.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }
}