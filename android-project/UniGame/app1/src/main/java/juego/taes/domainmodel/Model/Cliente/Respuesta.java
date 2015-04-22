package juego.taes.domainmodel.Model.Cliente;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

import juego.taes.domainmodel.Data.Dao.RespuestaDao;

/**
 * Created by felix on 22-4-2015.
 */

@DatabaseTable(tableName = "respuesta", daoClass = RespuestaDao.class)
public class Respuesta {

    //Nombres de las columnas
    public static final String ID="_id";
    public static final String CONTENIDO="contenido";
    public static final String ENSERVIDOR="en_servidor";
    public static final String IDSINCRONIZACION="id_sincronizacion";
    public static final String FECHASINCRONIZACION="fecha_sincronizacion";
    public static final String MODIFICADODESDEULTIMASINCRONIZACION="modificado";

    //Relaciones
    public static final String PREGUNTA="fk_pregunta";

    //Atributos de la base de datos
    @DatabaseField(columnName=ID, generatedId = true, useGetSet = true)
    private int id;

    @DatabaseField(columnName=CONTENIDO, canBeNull=false, useGetSet = true)
    private String contenido;

    @DatabaseField(columnName= ENSERVIDOR, canBeNull = false, defaultValue="false", useGetSet = true)
    private boolean enServidor;

    @DatabaseField(columnName= IDSINCRONIZACION, unique = true, useGetSet = true)
    private int idSincronizacion;

    @DatabaseField(columnName= FECHASINCRONIZACION, useGetSet = true)
    private Date fechaSincronizacion;

    @DatabaseField(columnName = MODIFICADODESDEULTIMASINCRONIZACION, useGetSet = true)
    private boolean modificadoDesdeUltimaSincronizacion;

    //Relaciones
    @DatabaseField(columnName = PREGUNTA, useGetSet = true, foreign = true, canBeNull = false)
    private Pregunta pregunta;

    public Respuesta() {
        // ORMLite needs a no-arg constructor
    }

    public Respuesta(String contenido, boolean enServidor) {
        this.contenido = contenido;
        this.enServidor = enServidor;
    }

    //Setters y getters


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public boolean isEnServidor() {
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

    public boolean isModificadoDesdeUltimaSincronizacion() {
        return modificadoDesdeUltimaSincronizacion;
    }

    public void setModificadoDesdeUltimaSincronizacion(boolean modificadoDesdeUltimaSincronizacion) {
        this.modificadoDesdeUltimaSincronizacion = modificadoDesdeUltimaSincronizacion;
    }

    public Pregunta getPregunta() {
        return pregunta;
    }

    public void setPregunta(Pregunta pregunta) {
        this.pregunta = pregunta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Respuesta)) return false;

        Respuesta respuesta = (Respuesta) o;

        if (id != respuesta.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }
}