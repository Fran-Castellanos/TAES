package tk.theunigame.unigame.app.fachadas;

import android.content.Context;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import juego.taes.domainmodel.Model.Cliente.Carrera;
import juego.taes.domainmodel.Model.Cliente.Universidad;
import juego.taes.domainmodel.Repository.CarreraRepository;


/**
 * Created by John on 22/04/2015.
 */
public class FachadaCarrera {

    //Devolverá las carreras que oferte la universidad pasada por parámetro
    public ArrayList<Carrera> obtenerCarreras(Context context, Universidad universidad) throws SQLException {
        CarreraRepository repository = new CarreraRepository(context);
        return (ArrayList<Carrera>)repository.getByUniversidad(universidad.getId());
    }


    /**
     * Devuelve una lista de todas las carreras dentro de una universidad.
     * @param c Objeto Context
     * @param idUniversidad ID de la Universidad.
     * @return Lista de carreras de la Universidad.
     * @throws Exception
     */
    public List<Carrera> getCarreras(Context c, int idUniversidad) throws Exception {
        List<Carrera> carreras;

        try{

            CarreraRepository car= new CarreraRepository(c);
            carreras = car.getByUniversidad(idUniversidad);

        }catch(Exception e){
            throw  new Exception("No se han obtenido carreras para la Universidad"+e.getMessage());
        }
        return  carreras;
    }

}
