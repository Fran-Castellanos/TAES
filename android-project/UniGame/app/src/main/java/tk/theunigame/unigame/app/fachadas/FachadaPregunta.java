package tk.theunigame.unigame.app.fachadas;

import android.content.Context;

import com.j256.ormlite.dao.ForeignCollection;

import java.util.ArrayList;
import java.util.Collection;

import juego.taes.domainmodel.Model.Cliente.Pregunta;
import juego.taes.domainmodel.Model.Cliente.Respuesta;

/**
 * Created by Pedro on 21/04/2015.
 */
public class FachadaPregunta {

    public Pregunta crearPregunta(String contenido){

        return new Pregunta(contenido,false);
    }

    public void indicarRespuestas(Pregunta pregunta, ArrayList<Respuesta> respuestas) {

        pregunta.setRespuestas((ForeignCollection<Respuesta>)respuestas);
    }



    public void RespuestaCorrecta(Context c, Pregunta pregunta, int IDrespuestaCorrecta,FachadaRespuesta respuestaFachada){

        Collection<Respuesta> respuestas = pregunta.getRespuestas();

        for(Respuesta r : respuestas)
        {
            if(r.getId() == IDrespuestaCorrecta)
                r.setEsCorrecta(true);
            else
                r.setEsCorrecta(false);
        }


    }
}
