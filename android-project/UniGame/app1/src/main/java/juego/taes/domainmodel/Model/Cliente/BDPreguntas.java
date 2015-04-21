package juego.taes.domainmodel.Model.Cliente;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

/**
 * Created by alienware18 on 9-8-13.
 */

@DatabaseTable(tableName = "bd_preguntas")
public class BDPreguntas {

    //Nombres de las columnas
    public static final String ID="_id";
    public static final String ENSERVIDOR="en_servidor";
    public static final String IDSINCRONIZACION="id_sincronizacion";
    public static final String FECHASINCRONIZACION="fecha_sincronizacion";
    public static final String MODIFICADODESDEULTIMASINCRONIZACION="modificado";

    //Atributos de la base de datos
    @DatabaseField(columnName=ID, generatedId = true, useGetSet = true)
    private int id;

    @DatabaseField(columnName= ENSERVIDOR, canBeNull = false, defaultValue="false", useGetSet = true)
    private boolean enServidor;

    @DatabaseField(columnName= IDSINCRONIZACION, unique = true, useGetSet = true)
    private int idSincronizacion;

    @DatabaseField(columnName= FECHASINCRONIZACION, useGetSet = true)
    private Date fechaSincronizacion;

    @DatabaseField(columnName = MODIFICADODESDEULTIMASINCRONIZACION, useGetSet = true)
    private boolean modificadoDesdeUltimaSincronizacion;

    public BDPreguntas() {
        // ORMLite needs a no-arg constructor
    }

    public BDPreguntas(boolean enServidor, int idSincronizacion, Date fechaSincronizacion, boolean modificadoDesdeUltimaSincronizacion) {
        this.enServidor = enServidor;
        this.idSincronizacion = idSincronizacion;
        this.fechaSincronizacion = fechaSincronizacion;
        this.modificadoDesdeUltimaSincronizacion = modificadoDesdeUltimaSincronizacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}