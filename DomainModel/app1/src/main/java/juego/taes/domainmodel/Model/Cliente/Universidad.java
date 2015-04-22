package juego.taes.domainmodel.Model.Cliente;

import android.text.TextUtils;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

import juego.taes.domainmodel.Utilities.AeSimpleSHA1;

/**
 * Created by alienware18 on 9-8-13.
 */

@DatabaseTable(tableName = "universidad")
public class Universidad {

    //Nombres de las columnas
    public static final String ID="_id";
    public static final String NOMBRE="nombre";
    public static final String SIGLAS="siglas";

    //Atributos de la base de datos
    @DatabaseField(columnName=ID, id = true )
    private int id;

    @DatabaseField(columnName= NOMBRE, canBeNull = false)
    private String nombre;

    @DatabaseField(columnName= SIGLAS, canBeNull = false)
    private String siglas;

    public Universidad() {
        // ORMLite needs a no-arg constructor
    }

    public Universidad(int id, String nombre, String siglas) {
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