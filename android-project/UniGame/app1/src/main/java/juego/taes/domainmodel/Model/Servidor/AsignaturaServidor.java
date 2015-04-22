package juego.taes.domainmodel.Model.Servidor;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by felix on 22-4-2015.
 */

@DatabaseTable(tableName = "asignatura")
public class AsignaturaServidor {

    //Nombres de las columnas
    public static final String ID="_id";
    public static final String NOMBRE="nombre";

    //Atributos de la base de datos
    @DatabaseField(columnName=ID, generatedId = true, useGetSet = true)
    private int id;

    @DatabaseField(columnName= NOMBRE, canBeNull = false, useGetSet = true)
    private String nombre;

    public AsignaturaServidor() {
        // ORMLite needs a no-arg constructor
    }

    public AsignaturaServidor(String nombre) {
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