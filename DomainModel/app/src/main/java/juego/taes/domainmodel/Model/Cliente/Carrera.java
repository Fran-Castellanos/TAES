package juego.taes.domainmodel.Model.Cliente;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by alienware18 on 9-8-13.
 */

@DatabaseTable(tableName = "carrera")
public class Carrera {

    //Nombres de las columnas
    public static final String ID="_id";
    public static final String NOMBRE="nombre";

    //Atributos de la base de datos
    @DatabaseField(columnName=ID, id = true )
    private int id;

    @DatabaseField(columnName= NOMBRE, canBeNull = false)
    private String nombre;

    public Carrera() {
        // ORMLite needs a no-arg constructor
    }

    public Carrera(int id, String nombre) {
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