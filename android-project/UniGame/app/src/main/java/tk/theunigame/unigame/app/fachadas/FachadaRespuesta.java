package tk.theunigame.unigame.app.fachadas;

/**
 * Created by Pedro on 21/04/2015.
 */
public class FachadaRespuesta {

    private String contenido;
    private boolean correcto;


    public FachadaRespuesta(String str){
        contenido=str;
        correcto=false;
    }

    public void setCorrecto(boolean nuevo){correcto=nuevo;}
}

