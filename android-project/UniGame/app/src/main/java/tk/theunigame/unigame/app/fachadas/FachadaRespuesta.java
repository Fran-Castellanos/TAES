package tk.theunigame.unigame.app.fachadas;

import android.content.Context;

import com.j256.ormlite.dao.BaseForeignCollection;
import com.j256.ormlite.dao.ForeignCollection;

import java.sql.SQLException;
import java.util.ArrayList;

import juego.taes.domainmodel.Model.Cliente.Pregunta;
import juego.taes.domainmodel.Model.Cliente.Respuesta;
import juego.taes.domainmodel.Repository.RespuestaRepository;

/**
 * Created by Pedro on 21/04/2015.
 */
public class FachadaRespuesta {


    public ArrayList<Respuesta> crearRespuestas(Pregunta pregunta,ArrayList<String> contenido){

        ArrayList<Respuesta> respuestas = new ArrayList<>();

        for(int i=0; i<contenido.size(); ++i)
        {
            Respuesta respuesta = new Respuesta(contenido.get(i),false,false);
            respuesta.setPregunta(pregunta);
            respuestas.add(respuesta);
        }
        return respuestas;
    }

    public Respuesta recuperarRespuesta(Context c, int id) throws SQLException {
        RespuestaRepository respuesta = new RespuestaRepository(c);
        return respuesta.getById(id);
    }

}
