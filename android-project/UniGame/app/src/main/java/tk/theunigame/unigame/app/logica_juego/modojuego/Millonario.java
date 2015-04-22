package tk.theunigame.unigame.app.logica_juego.modojuego;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import juego.taes.domainmodel.Model.Cliente.Pregunta;
import tk.theunigame.unigame.app.logica_juego.interfaces.IModoJuego;


/**
 * Created by Paco on 22/04/2015.
 */
public abstract class Millonario implements IModoJuego {
    private HashMap<Pregunta, Integer> preguntas;
    private int numPreguntas;

    public Millonario()
    {
        numPreguntas = 20;
        preguntas = new HashMap<Pregunta, Integer>();

    }


    public Millonario(int n)
    {
        numPreguntas = n;
    }





    public void jugar()
    {

        throw new RuntimeException("Not implemented yet");
    }

    public void obtenerPreguntas()
    {
        //preguntas = ...
        throw new RuntimeException("Not implemented yet");
    }


    public void comprobarRespuestas()
    {

        Iterator it = preguntas.entrySet().iterator();
        while(it.hasNext())
        {
            Map.Entry e = (Map.Entry)it.next();
            comprobarRespuesta((Pregunta)e.getKey(), (Integer)e.getValue());
        }
    }

    public boolean comprobarRespuesta(Pregunta preg, Integer res)
    {
        throw new RuntimeException("Not implemented yet");

    }

    public boolean responderPregunta()
    {
        throw new RuntimeException("Not implemented yet");
    }

    abstract public void guardarResultado();



}
