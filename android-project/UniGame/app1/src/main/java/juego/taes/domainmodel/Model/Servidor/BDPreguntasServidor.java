package juego.taes.domainmodel.Model.Servidor;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

/**
 * Created by felix on 22-4-2015.
 */

@DatabaseTable(tableName = "bd_preguntas")
public class BDPreguntasServidor {

    //Nombres de las columnas
    public static final String ID="_id";
    public static final String FECHAMODIFICADOSERVIDOR="fecha_modificado_servidor";

    //Atributos de la base de datos
    @DatabaseField(columnName=ID, generatedId = true, useGetSet = true)
    private int id;

    @DatabaseField(columnName= FECHAMODIFICADOSERVIDOR, canBeNull = false, useGetSet = true)
    private Date fechaModificadoServidor;

    public BDPreguntasServidor() {
        // ORMLite needs a no-arg constructor
    }

    public BDPreguntasServidor(Date fechaModificadoServidor) {
        this.fechaModificadoServidor = fechaModificadoServidor;
    }

//Setters y getters


    public Date getFechaModificadoServidor() {
        return fechaModificadoServidor;
    }

    public void setFechaModificadoServidor(Date fechaModificadoServidor) {
        this.fechaModificadoServidor = fechaModificadoServidor;
    }
}