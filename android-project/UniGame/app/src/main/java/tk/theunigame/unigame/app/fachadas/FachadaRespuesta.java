package tk.theunigame.unigame.app.fachadas;

import com.j256.ormlite.dao.BaseForeignCollection;
import com.j256.ormlite.dao.ForeignCollection;

import java.util.ArrayList;

import juego.taes.domainmodel.Model.Cliente.Pregunta;
import juego.taes.domainmodel.Model.Cliente.Respuesta;

/**
 * Created by Pedro on 21/04/2015.
 */
public class FachadaRespuesta {


    public ArrayList<Respuesta> obtenerRespuestas(ArrayList<String> contenido){

        ForeignCollection<Respuesta> respuestas= new BaseForeignCollection<>();
        for(int i=0; i<contenido.size(); ++i){
            respuestas.add(new Respuesta(contenido.get(i),false));
        }
        return respuestas;
    }

    public void indicarRespuestas(Pregunta pregunta, ArrayList<Respuesta> respuestas){

    }

}
