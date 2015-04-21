package tk.theunigame.unigame.app.presentacion.negocio.interfaces;

import java.util.List;

/**
 * Created by Paco on 21/04/2015.
 */
public interface IAsignatura {

    public List<IAsignatura> readAll();

    public List<IAsignatura> readFilter(int carID);


}
