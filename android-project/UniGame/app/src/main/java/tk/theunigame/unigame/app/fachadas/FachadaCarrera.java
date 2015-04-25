package tk.theunigame.unigame.app.fachadas;

import java.util.ArrayList;

import juego.taes.domainmodel.Model.Cliente.Carrera;
import juego.taes.domainmodel.Model.Cliente.Universidad;


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

}
