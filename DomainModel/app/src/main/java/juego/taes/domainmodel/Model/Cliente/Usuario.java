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

@DatabaseTable(tableName = "usuario")
public class Usuario {

    //Nombres de las columnas
    public static final String ID="_id";
    public static final String NICK ="nick";
    public static final String NOMBRE ="nombre";
    public static final String APELLIDOS ="apellidos";
    public static final String SEXO ="sexo";
    public static final String LOGINOFFLINE="login_offline";

    //Atributos de la base de datos
    @DatabaseField(columnName=ID, id=true)
    private int id;

    @DatabaseField(columnName= NICK, canBeNull = false, unique=true)
    private String nick;

    @DatabaseField(columnName= NOMBRE, canBeNull = false)
    private String nombre;

    @DatabaseField(columnName= APELLIDOS, canBeNull = false)
    private String apellidos;

    @DatabaseField(columnName= SEXO, unknownEnumName = "OTRO", canBeNull = false)
    private Sexo sexo;

    @DatabaseField(columnName=LOGINOFFLINE)
    private boolean loginOffline;

    public Usuario() {
        // ORMLite needs a no-arg constructor
    }

    public Usuario(int id, String nick, String nombre, String apellidos, Sexo sexo, boolean loginOffline) {
        this.id = id;
        this.nick = nick;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.sexo = sexo;
        this.loginOffline = loginOffline;
    }

    //Setters y getters


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public boolean isLoginOffline() {
        return loginOffline;
    }

    public void setLoginOffline(boolean loginOffline) {
        this.loginOffline = loginOffline;
    }

    //Enumerador para el sexo del usuario
    private enum Sexo
    {
        HOMBRE,
        MUJER,
        OTRO;
    }
}