package juego.taes.domainmodel.Model.Cliente;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import juego.taes.domainmodel.Data.Dao.BDPreguntasDao;
import juego.taes.domainmodel.Data.Dao.CarreraDao;

/**
 * Created by felix on 22-4-2015.
 */

@DatabaseTable(tableName = "carrera", daoClass = CarreraDao.class)
public class Carrera {

    //Nombres de las columnas
    public static final String ID="_id";
    public static final String NOMBRE="nombre";

    //Relaciones
    public static final String ASIGNATURAS="fk_asignaturas";

    //Atributos de la base de datos
    @DatabaseField(columnName=ID, id = true, useGetSet = true )
    private int id;

    @DatabaseField(columnName= NOMBRE, canBeNull = false, useGetSet = true)
    private String nombre;

    //Relaciones

    @ForeignCollectionField(eager=false, columnName = ASIGNATURAS, foreignFieldName = "asignaturas")
    private ForeignCollection<Asignatura> asignaturas;

    public Carrera() {
        // ORMLite needs a no-arg constructor
    }

    public Carrera(String nombre) {
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

    public ForeignCollection<Asignatura> getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(ForeignCollection<Asignatura> asignaturas) {
        this.asignaturas = asignaturas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Carrera)) return false;

        Carrera carrera = (Carrera) o;

        if (id != carrera.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }
}