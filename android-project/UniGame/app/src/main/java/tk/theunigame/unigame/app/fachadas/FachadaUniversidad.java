package tk.theunigame.unigame.app.fachadas;

import java.util.ArrayList;

import juego.taes.domainmodel.Model.Cliente.Universidad;


/**
 * Created by John on 22/04/2015.
 */
public class FachadaUniversidad {


    public ArrayList<Universidad> obtenerUniversidades(){

        ArrayList<Universidad> respuestas= new ArrayList<>();
        //
        Universidad u1 = new Universidad("Universidad alicante", "UA");
        u1.setId(1);
        u1.setNombre("Universidad Alicante");
        respuestas.add(u1);
        u1= new Universidad("Miguel Hernández", "MH");
        u1.setId(2);
        u1.setNombre("Miguel Hernández");
        respuestas.add(u1);
        return respuestas;
    }

}
