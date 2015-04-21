package tk.theunigame.unigame.app.presentacion.negocio;


import java.util.List;

import juego.taes.domainmodel.Repository.*;

/**
 * Created by Paco on 21/04/2015.
 */
public class FiltrarBD {

    private int uniId;
    private UniversidadRepository uni;
    private CarreraRepository car;
    private AsignaturaRepository asig;

    public List<String> verUniversidades()
    {
        try
        {
            uni.getAll();
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
