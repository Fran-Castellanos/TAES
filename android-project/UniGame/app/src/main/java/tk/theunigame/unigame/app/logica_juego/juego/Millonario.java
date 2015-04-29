package tk.theunigame.unigame.app.logica_juego.juego;

import android.content.Context;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import juego.taes.domainmodel.Model.Cliente.BDPreguntas;
import juego.taes.domainmodel.Model.Cliente.Pregunta;
import juego.taes.domainmodel.Model.Cliente.Respuesta;
import juego.taes.domainmodel.Repository.PreguntaRepository;
import tk.theunigame.unigame.app.logica_juego.comodines.Comodin;
import tk.theunigame.unigame.app.logica_juego.comodines.Comodin50;
import tk.theunigame.unigame.app.logica_juego.comodines.ComodinCambiarPregunta;
import tk.theunigame.unigame.app.logica_juego.comodines.ComodinPasar;
import tk.theunigame.unigame.app.presentacion.util.Listener.OnJuegoListener;


/**
 * Created by Paco on 22/04/2015.
 */
public class Millonario extends JuegoSimple {


    List<Comodin> comodines;
    OnJuegoListener listener;


    public Millonario()
    {
        comodines = new ArrayList<Comodin>();
        listener = null;
    }


    @Override
    public void initComodines()
    {
        comodines.add(Comodin50.getInstance());
        comodines.add(ComodinPasar.getInstance());
        comodines.add(ComodinCambiarPregunta.getInstance());
    }


    @Override
    public Pregunta usarComodin(Comodin comodin) throws Exception {
        Juego j = Juego.getInstance();
        j.sumarComodinUsado();
        if(listener != null)
            listener.onComodinUsado(comodin.usarComodin(), comodin.getNombre());
        else
            throw new Exception("No se ha podido enviar evento en usarComodin");

        return comodin.usarComodin();
    }


}
