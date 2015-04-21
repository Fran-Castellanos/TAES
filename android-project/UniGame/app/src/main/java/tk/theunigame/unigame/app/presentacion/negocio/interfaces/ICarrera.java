package tk.theunigame.unigame.app.presentacion.negocio.interfaces;

import java.util.List;

/**
 * Created by Paco on 21/04/2015.
 */
public interface ICarrera {

    public List<ICarrera> readAll();

    public List<ICarrera> readFilter(int uniID);


}
