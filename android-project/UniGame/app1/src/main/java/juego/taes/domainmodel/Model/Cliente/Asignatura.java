package juego.taes.domainmodel.Model.Cliente;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import juego.taes.domainmodel.Data.Dao.AsignaturaDao;

/**
 * Created by felix on 22-4-2015.
 */

@DatabaseTable(tableName = Asignatura.TABLA, daoClass = AsignaturaDao.class)
public class Asignatura {

    //Nombre de la tabla
    public static final String TABLA = "asignatura";

    //Nombres de las columnas
    public static final String ID="_id";
    public static final String NOMBRE="nombre";

    //Atributos de la base de datos
    @DatabaseField(columnName=ID, id = true, useGetSet = true )
    private int id;

    @DatabaseField(columnName= NOMBRE, canBeNull = false, useGetSet = true)
    private String nombre;

    //Relaciones

    @ForeignCollectionField(eager = false, foreignFieldName = BDPreguntas.ASIGNATURA_CAMPO)
    private ForeignCollection<BDPreguntas> bds;

    public Asignatura() {
        // ORMLite needs a no-arg constructor
    }

    public Asignatura(String nombre) {
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

    public ForeignCollection<BDPreguntas> getBds() {
        return bds;
    }

    public void setBds(ForeignCollection<BDPreguntas> bds) {
        this.bds = bds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Asignatura)) return false;

        Asignatura that = (Asignatura) o;

        if (id != that.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }
}