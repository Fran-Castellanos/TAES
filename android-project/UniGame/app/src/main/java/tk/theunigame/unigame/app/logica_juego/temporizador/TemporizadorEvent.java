package tk.theunigame.unigame.app.logica_juego.temporizador;

import java.util.EventObject;

/**
 * Created by Paco on 24/04/2015.
 */
public class TemporizadorEvent extends EventObject {

    String id;

    /**
     * Constructs a new instance of this class.
     *
     * @param source the object which fired the event.
     */
    public TemporizadorEvent(Object source, String id) {
        super(source);
        this.id = id;
    }


    public String getEventoID()
    {
        return id;
    }


}


