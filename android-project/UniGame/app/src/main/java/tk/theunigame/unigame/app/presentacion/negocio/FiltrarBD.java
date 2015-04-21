package tk.theunigame.unigame.app.presentacion.negocio;

import java.util.List;

import tk.theunigame.unigame.app.presentacion.negocio.interfaces.IAsignatura;
import tk.theunigame.unigame.app.presentacion.negocio.interfaces.ICarrera;
import tk.theunigame.unigame.app.presentacion.negocio.interfaces.IUniversidad;

/**
 * Created by Paco on 21/04/2015.
 */
public class FiltrarBD {

    private int uniId;
    private IUniversidad uni;
    private ICarrera car;
    private IAsignatura asig;

    public List<String> verUniversidades()
    {
        try
        {
            uni.readAll();
        }catch(Exception e) {

        }
        throw new RuntimeException("Not implemented yet");
    }


    public List<String> verCarreras(int idUniversidad)
    {
        throw new RuntimeException("Not implemented yet");
    }


    public List<String> verAsignaturas(int idCarrera)
    {
        throw new RuntimeException("Not implemented yet");
    }





}
