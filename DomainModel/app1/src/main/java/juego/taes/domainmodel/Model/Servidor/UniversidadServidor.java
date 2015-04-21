package juego.taes.domainmodel.Model.Servidor;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by alienware18 on 9-8-13.
 */

@DatabaseTable(tableName = "universidad")
public class UniversidadServidor {

    //Nombres de las columnas
    public static final String ID="_id";
    public static final String NOMBRE="nombre";
    public static final String SIGLAS="siglas";

    //Atributos de la base de datos
    @DatabaseField(columnName=ID, generatedId = true)
    private int id;

    @DatabaseField(columnName= NOMBRE, canBeNull = false)
    private String nombre;

    @DatabaseField(columnName= SIGLAS, canBeNull = false)
    private String siglas;

    public UniversidadServidor() {
        // ORMLite needs a no-arg constructor
    }

    public UniversidadServidor(int id, String nombre, String siglas) {
        this.id = id;
        this.nombre=nombre;
        this.siglas=siglas;
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

    public String getSiglas() {
        return siglas;
    }

    public void setSiglas(String siglas) {
        this.siglas = siglas;
    }
}