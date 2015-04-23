package juego.taes.domainmodel.Model.Cliente;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import juego.taes.domainmodel.Data.Dao.UniversidadDao;

/**
 * Created by felix on 23/04/15.
 */

@DatabaseTable(tableName = "carrera_universidad", daoClass = UniversidadDao.class)
public class CarreraUniversidad
{
    //Relaciones
    public static final String ID = "_id";
    public static final String CARRERA = "fk_carrera";
    public static final String UNIVERSIDAD = "fk_universidad";

    @DatabaseField(columnName = ID, id = true, useGetSet = true)
    private int id;

    @DatabaseField(columnName = CARRERA, foreign=true, useGetSet = true)
    private Carrera carrera;

    @DatabaseField(columnName = UNIVERSIDAD, foreign=true, useGetSet = true)
    private Universidad universidad;

    public CarreraUniversidad()
    {
        //Constructor para ormlite
    }

    public CarreraUniversidad(Carrera carrera, Universidad universidad) {
        this.carrera = carrera;
        this.universidad = universidad;
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

    public Universidad getUniversidad() {
        return universidad;
    }

    public void setUniversidad(Universidad universidad) {
        this.universidad = universidad;
    }
}