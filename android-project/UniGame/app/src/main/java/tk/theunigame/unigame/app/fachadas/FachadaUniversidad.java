package tk.theunigame.unigame.app.fachadas;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import juego.taes.domainmodel.Model.Cliente.Universidad;
import juego.taes.domainmodel.Repository.UniversidadRepository;


/**
 * Created by John on 22/04/2015.
 */
public class FachadaUniversidad {


    public List<Universidad> obtenerUniversidades(Context context){

        /*ArrayList<Universidad> respuestas= new ArrayList<>();
        //
        Universidad u1 = new Universidad("Universidad alicante", "UA");
        u1.setId(1);
        u1.setNombre("Universidad Alicante");
        respuestas.add(u1);
        u1= new Universidad("Miguel Hernández", "MH");
        u1.setId(2);
        u1.setNombre("Miguel Hernández");
        respuestas.add(u1);
        return respuestas;*/
        UniversidadRepository repository = new UniversidadRepository(context);
        return  repository.getAll();
    }


    /**
     * Devuelve lista de todas las universidades.
     * @param c Objeto Context
     * @return Lista de todas las universidades.
     * @throws Exception
     */
    public List<Universidad> getUniversidades(Context c) throws Exception {

        List<Universidad> universidades;
        try {
            UniversidadRepository uni= new UniversidadRepository(c);
            universidades = uni.getAll();

        }catch(Exception e){
            throw  new Exception("No se han obtenido universidades"+e.getMessage());
        }
        return  universidades;
    }

}
