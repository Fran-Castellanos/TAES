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


/**
 * Created by Paco on 22/04/2015.
 */
public class Millonario extends JuegoSimple {


    List<Comodin> comodines;



    public Millonario()
    {
        comodines = new ArrayList<Comodin>();

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
        return comodin.usarComodin();
    }


}
