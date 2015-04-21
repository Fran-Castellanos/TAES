package juego.taes.domainmodel.Model.Cliente;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

/**
 * Created by alienware18 on 9-8-13.
 */

@DatabaseTable(tableName = "pregunta")
public class Pregunta {

    //Nombres de las columnas
    public static final String ID="_id";
    public static final String CONTENIDO="contenido";
    public static final String ENSERVIDOR="en_servidor";
    public static final String IDSINCRONIZACION="id_sincronizacion";
    public static final String FECHASINCRONIZACION="fecha_sincronizacion";
    public static final String MODIFICADODESDEULTIMASINCRONIZACION="modificado";

    //Atributos de la base de datos
    @DatabaseField(columnName=ID, generatedId = true)
    private int id;

    @DatabaseField(columnName=CONTENIDO, canBeNull=false)
    private String contenido;

    @DatabaseField(columnName= ENSERVIDOR, canBeNull = false)
    private boolean enServidor;

    @DatabaseField(columnName= IDSINCRONIZACION, unique = true)
    private int idSincronizacion;

    @DatabaseField(columnName= FECHASINCRONIZACION)
    private Date fechaSincronizacion;

    @DatabaseField(columnName = MODIFICADODESDEULTIMASINCRONIZACION)
    private boolean modificadoDesdeUltimaSincronizacion;

    public Pregunta() {
        // ORMLite needs a no-arg constructor
    }

    public Pregunta(String contenido, boolean enServidor, int idSincronizacion, Date fechaSincronizacion, boolean modificadoDesdeUltimaSincronizacion) {
        this.contenido = contenido;
        this.enServidor = enServidor;
        this.idSincronizacion = idSincronizacion;
        this.fechaSincronizacion = fechaSincronizacion;
        this.modificadoDesdeUltimaSincronizacion = modificadoDesdeUltimaSincronizacion;
    }

    public boolean isModificadoDesdeUltimaSincronizacion() {
        return modificadoDesdeUltimaSincronizacion;
    }

    public void setModificadoDesdeUltimaSincronizacion(boolean modificadoDesdeUltimaSincronizacion) {
        this.modificadoDesdeUltimaSincronizacion = modificadoDesdeUltimaSincronizacion;
    }

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
}