package tk.theunigame.unigame.app.fachadas;

import android.content.Context;

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
    public ArrayList<Carrera> obtenerCarreras(Universidad universidad){

        ArrayList<Carrera> respuestas= new ArrayList<>();
        //
        Carrera u1 = new Carrera("Ingeniería informática");
        u1.setId(1);
        u1.setNombre("Ingeniería informática");
        respuestas.add(u1);
        u1= new Carrera("Magisterio");
        u1.setId(2);
        u1.setNombre("Magisterio");
        respuestas.add(u1);
        return respuestas;
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
