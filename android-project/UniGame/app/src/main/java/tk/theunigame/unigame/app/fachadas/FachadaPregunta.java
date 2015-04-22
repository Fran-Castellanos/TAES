package tk.theunigame.unigame.app.fachadas;

import java.util.ArrayList;

/**
 * Created by Pedro on 21/04/2015.
 */
public class FachadaPregunta {
    private String contenido;
    private ArrayList<FachadaRespuesta> respuestas;

    public FachadaPregunta(String str, FachadaRespuesta a, FachadaRespuesta b, FachadaRespuesta c,FachadaRespuesta d){
        contenido=str;
        //queda hacer las comprobaciones
        respuestas.add(a); respuestas.add(b); respuestas.add(c); respuestas.add(d);

    }

}
