package tk.theunigame.unigame.app.logica_juego.comodines;

/**
 * Created by Paco on 22/04/2015.
 */
public class Comodin50 extends Comodin {
    private final static String nombre = "Comodín del 50%";


    public Comodin50()
    {
        cantidad = 1;
    }


    @Override
    public void usarComodin() {
        --cantidad;
        throw new RuntimeException("Not implemented yet");
    }

}
