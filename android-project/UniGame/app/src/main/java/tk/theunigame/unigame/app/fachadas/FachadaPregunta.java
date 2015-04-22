package tk.theunigame.unigame.app.fachadas;

import java.util.ArrayList;

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

        //setRespuestas recibe un foregincollection
        //pregunta.setRespuestas(respuestas);
    }

    public void RespuestaCorrecta(Pregunta pregunta, int IDrespuestaCorrecta,FachadaRespuesta respuestaFachada){

        pregunta.setRespuestaCorrecta(respuestaFachada.recuperarRespuesta(IDrespuestaCorrecta));
    }
}
