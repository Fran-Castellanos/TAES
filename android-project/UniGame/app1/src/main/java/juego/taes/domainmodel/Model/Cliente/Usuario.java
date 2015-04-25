package juego.taes.domainmodel.Model.Cliente;

import android.text.TextUtils;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

import juego.taes.domainmodel.Data.Dao.UsuarioDao;
import juego.taes.domainmodel.Utilities.AeSimpleSHA1;

/**
 * Created by felix on 22-4-2015.
 */

@DatabaseTable(tableName = "usuario", daoClass = UsuarioDao.class)
public class Usuario {

    //Nombres de las columnas
    public static final String ID="_id";
    public static final String NICK ="nick";
    public static final String NOMBRE ="nombre";
    public static final String APELLIDOS ="apellidos";
    public static final String SEXO ="sexo";
    public static final String LOGINOFFLINE="login_offline";

    //Atributos de la base de datos
    @DatabaseField(columnName=ID, id=true, useGetSet = true)
    private int id;

    @DatabaseField(columnName= NICK, canBeNull = false, unique=true, useGetSet = true)
    private String nick;

    @DatabaseField(columnName= NOMBRE, canBeNull = false, useGetSet = true)
    private String nombre;

    @DatabaseField(columnName= APELLIDOS, canBeNull = false, useGetSet = true)
    private String apellidos;

    @DatabaseField(columnName= SEXO, unknownEnumName = "OTRO", canBeNull = false, useGetSet = true)
    private Sexo sexo;

    @DatabaseField(columnName=LOGINOFFLINE, useGetSet = true)
    private boolean loginOffline;

    //Relaciones
    @ForeignCollectionField(eager=false, foreignFieldName = BDPreguntas.USUARIO_CAMPO)
    private ForeignCollection<BDPreguntas> bds;

    public Usuario() {
        // ORMLite needs a no-arg constructor
    }

    public Usuario(String nick, String nombre, String apellidos, Sexo sexo, boolean loginOffline) {
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

    public boolean getLoginOffline() {
        return loginOffline;
    }

    public void setLoginOffline(boolean loginOffline) {
        this.loginOffline = loginOffline;
    }

    public ForeignCollection<BDPreguntas> getBds() {
        return bds;
    }

    public void setBds(ForeignCollection<BDPreguntas> bds) {
        this.bds = bds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuario)) return false;

        Usuario usuario = (Usuario) o;

        if (id != usuario.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }
}