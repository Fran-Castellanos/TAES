package tk.theunigame.unigame.app.logica_juego.modojuego;

import android.content.Context;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import juego.taes.domainmodel.Model.Cliente.BDPreguntas;
import juego.taes.domainmodel.Model.Cliente.Pregunta;
import juego.taes.domainmodel.Model.Cliente.Respuesta;
import juego.taes.domainmodel.Repository.PreguntaRepository;
import tk.theunigame.unigame.app.logica_juego.interfaces.IModoJuego;


/**
 * Created by Paco on 22/04/2015.
 */
public abstract class Millonario implements IModoJuego {
    private HashMap<Pregunta, Integer> preguntas;
    private int numPreguntas;
    private int numComodines;

    public Millonario()
    {
        numPreguntas = 20;
        preguntas = new HashMap<Pregunta, Integer>();
        numComodines=3;

    }


    public Millonario(int n)
    {
        numPreguntas = n;
    }


    public void setNumPreguntas(int n)
    {
        if(n>0)
            numPreguntas = n;
    }



    public abstract void jugar(List<Pregunta> preguntas);



    public List<Pregunta> obtenerPreguntas(Context c , List<BDPreguntas> bolsas,int numPreguntas)
    {
        setNumPreguntas(numPreguntas);
        return obtenerPreguntas(c, bolsas);
    }



    @Override
    public List<Pregunta> obtenerPreguntas(Context c, List<BDPreguntas> bolsas) {
        List<Integer> numPreguntasBolsa = new ArrayList<Integer>();
        List<Double> ranks;
        PreguntaRepository pregunta = new PreguntaRepository(c);
        List<Pregunta> preguntas = new ArrayList<Pregunta>();

        for (BDPreguntas bolsa : bolsas) {
            numPreguntasBolsa.add(bolsa.getPreguntas().size());
        }

        ranks = calcularRangos(numPreguntasBolsa);
        int n = 0;
        while (n<numPreguntas+1)
        {
            double random = Math.random();
            int indice=0;
            for (Double d : ranks) {
                indice = ranks.indexOf(d);
                if(random<=d)
                    break;
            }

            Pregunta p = pregunta.getRandomByBolsa(bolsas.get(indice).getId());
            if(!preguntas.contains(p))
            {
                preguntas.add(p);
                ++n;
            }

        }


        return preguntas;

    }




    private List<Double> calcularRangos(List<Integer> numPreguntasBolsa) {
        int total = 0;
        List<Double> result = new ArrayList<Double>();
        for(Integer i: numPreguntasBolsa)
            total += i;

        if(total < numPreguntas)
            setNumPreguntas(total);

        double aux=0;
        for(Integer i: numPreguntasBolsa) {
            aux += (double) i / total;
            result.add(aux);

        }

        return result;

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

    public boolean comprobarRespuesta(Pregunta preg, int res)
    {
        Respuesta r = preg.getRespuestaCorrecta();
        return r.getId()==res;
    }

    public boolean responderPregunta()
    {
        throw new RuntimeException("Not implemented yet");
    }



    abstract public void guardarResultado();



}
