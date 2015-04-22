package tk.theunigame.unigame.app.presentacion.negocio.comodines;

import tk.theunigame.unigame.app.presentacion.negocio.interfaces.IComodin;

/**
 * Created by Paco on 22/04/2015.
 */
public class ComodinPublico implements IComodin {
    private final static String nombre = "Comodín del público";

    private int cantidad;


    @Override
    public void usarComodin() {
        throw new RuntimeException("Not implemented yet");
    }

    @Override
    public boolean quedanComodines() {
        throw new RuntimeException("Not implemented yet");

    }
}
