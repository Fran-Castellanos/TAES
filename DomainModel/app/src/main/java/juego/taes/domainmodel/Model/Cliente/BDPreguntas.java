package juego.taes.domainmodel.Model.Cliente;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

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
    @DatabaseField(columnName=ID, generatedId = true)
    private int id;

    @DatabaseField(columnName= ENSERVIDOR, canBeNull = false)
    private String enServidor;

    @DatabaseField(columnName= IDSINCRONIZACION, unique = true)
    private int idSincronizacion;

    @DatabaseField(columnName= FECHASINCRONIZACION)
    private String fechaSincronizacion;

    @DatabaseField(column)

    public BDPreguntas() {
        // ORMLite needs a no-arg constructor
    }

    public BDPreguntas(int id, String nombre) {
        this.id=id;
        this.nombre=nombre;
    }

    //Setters y getters

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
        this.nombre = nombre;
    }
}