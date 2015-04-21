package juego.taes.domainmodel.Model.Servidor;

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
public class UsuarioServidor {

    //Nombres de las columnas
    public static final String ID="_id";
    public static final String NICK ="nick";
    public static final String PASS = "pass";
    public static final String NOMBRE ="nombre";
    public static final String APELLIDOS ="apellidos";
    public static final String FECHA_NACIMIENTO ="fecha_nacimiento";
    public static final String EMAIL = "email";
    public static final String FECHA_REGISTRO ="fecha_registro";
    public static final String ULTIMO_ACCESO ="ultimo_acceso";
    public static final String SEXO ="sexo";
    public static final String CUENTA_CERRADA ="cuenta_cerrada";

    //Atributos de la base de datos
    @DatabaseField(columnName=ID, generatedId = true)
    private int id;

    @DatabaseField(columnName= NICK, canBeNull = false, unique=true)
    private String nick;

    @DatabaseField(columnName= PASS, canBeNull = false)
    private String pass;

    @DatabaseField(columnName= NOMBRE, canBeNull = false)
    private String nombre;

    @DatabaseField(columnName= APELLIDOS, canBeNull = false)
    private String apellidos;

    @DatabaseField(columnName= FECHA_NACIMIENTO, canBeNull=false)
    private Date fechaNacimiento;

    @DatabaseField(columnName= EMAIL, canBeNull = false, unique=true)
    private String email;

    @DatabaseField(columnName= FECHA_REGISTRO, canBeNull = false)
    private Date fechaRegistro;

    @DatabaseField(columnName= ULTIMO_ACCESO)
    private Date ultimoAcceso;

    @DatabaseField(columnName= SEXO, unknownEnumName = "OTRO", canBeNull = false)
    private Sexo sexo;

    @DatabaseField(columnName= CUENTA_CERRADA, canBeNull = false)
    private boolean cuentaCerrada;

    public UsuarioServidor() {
        // ORMLite needs a no-arg constructor
    }

    public UsuarioServidor(String nick, String pass, String nombre, String apellidos,
                           Date fechaNacimiento, String email, Date fechaRegistro, Date ultimoAcceso,
                           Sexo sexo, boolean cuentaCerrada) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        this.nick = nick;
        setPass(pass);
        this.nombre=nombre;
        this.apellidos=apellidos;
        this.fechaNacimiento=fechaNacimiento;
        this.email=email;
        this.fechaRegistro=fechaRegistro;
        this.ultimoAcceso = ultimoAcceso;
        this.sexo=sexo;
        this.cuentaCerrada = cuentaCerrada;
    }

    //Setters y getters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNick()
    {
        return nick;
    }

    public void setNick(String nick)
    {
        this.nick=nick;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nick=nombre;
    }

    public String getPass()
    {
        return pass;
    }

    public void setPass(String password) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        this.pass = hashPassword(password);
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Date getUltimoAcceso() {
        return ultimoAcceso;
    }

    public void setUltimoAcceso(Date ultimoAcceso) {
        this.ultimoAcceso = ultimoAcceso;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public boolean isCuentaCerrada() {
        return cuentaCerrada;
    }

    public void setCuentaCerrada(boolean cuentaCerrada) {
        this.cuentaCerrada = cuentaCerrada;
    }

    public boolean isPasswordCorrect(String givenPassword) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        return TextUtils.equals(hashPassword(givenPassword), pass);
    }

    private String hashPassword(String password) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        return AeSimpleSHA1.SHA1(password);
    }

    //Enumerador para el sexo del usuario
    private enum Sexo
    {
        HOMBRE,
        MUJER,
        OTRO;
    }
}