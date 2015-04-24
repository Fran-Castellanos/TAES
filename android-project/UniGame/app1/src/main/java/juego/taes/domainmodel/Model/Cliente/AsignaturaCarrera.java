package juego.taes.domainmodel.Model.Cliente;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import juego.taes.domainmodel.Data.Dao.AsignaturaCarreraDao;
import juego.taes.domainmodel.Data.Dao.CarreraUniversidadDao;

/**
 * Created by felix on 23/04/15.
 */

@DatabaseTable(tableName = "asignatura_carrera", daoClass = AsignaturaCarreraDao.class)
public class AsignaturaCarrera
{
    //Relaciones
    public static final String ID = "_id";
    public static final String ASIGNATURA = "fk_asignatura";
    public static final String CARRERA = "fk_carrera";

    @DatabaseField(columnName = ID, generatedId = true, useGetSet = true)
    private int id;

    @DatabaseField(columnName = CARRERA, foreign=true, canBeNull = false, useGetSet = true, uniqueCombo = true)
    private Carrera carrera;

    @DatabaseField(columnName = ASIGNATURA, foreign=true, canBeNull = false, useGetSet = true, uniqueCombo = true)
    private Asignatura asignatura;

    public AsignaturaCarrera()
    {
        //Constructor para ormlite
    }

    public AsignaturaCarrera(Asignatura asignatura, Carrera carrera) {
        this.asignatura = asignatura;
        this.carrera = carrera;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }
}
