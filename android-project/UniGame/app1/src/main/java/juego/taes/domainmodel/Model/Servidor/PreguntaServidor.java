package juego.taes.domainmodel.Model.Servidor;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

/**
 * Created by alienware18 on 9-8-13.
 */

@DatabaseTable(tableName = "pregunta")
public class PreguntaServidor {

    //Nombres de las columnas
    public static final String ID="_id";
    public static final String CONTENIDO="contenido";
    public static final String FECHAMODIFICADOSERVIDOR="fecha_modificado_servidor";

    //Atributos de la base de datos
    @DatabaseField(columnName=ID, generatedId = true, useGetSet = true)
    private int id;

    @DatabaseField(columnName=CONTENIDO, canBeNull=false, useGetSet = true)
    private String contenido;

    @DatabaseField(columnName= FECHAMODIFICADOSERVIDOR, canBeNull = false, useGetSet = true)
    private Date fechaModificadoServidor;


    public PreguntaServidor() {
        // ORMLite needs a no-arg constructor
    }

    public PreguntaServidor(String contenido, Date fechaModificadoServidor) {
        this.contenido = contenido;
        this.fechaModificadoServidor = fechaModificadoServidor;
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

    public Date getFechaModificadoServidor() {
        return fechaModificadoServidor;
    }

    public void setFechaModificadoServidor(Date fechaModificadoServidor) {
        this.fechaModificadoServidor = fechaModificadoServidor;
    }
}