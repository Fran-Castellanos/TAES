package tk.theunigame.unigame.app.logica_juego.juego;

import android.content.Context;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import juego.taes.domainmodel.Model.Cliente.BDPreguntas;
import juego.taes.domainmodel.Model.Cliente.Pregunta;
import juego.taes.domainmodel.Model.Cliente.Respuesta;
import juego.taes.domainmodel.Repository.PreguntaRepository;
import tk.theunigame.unigame.app.logica_juego.comodines.Comodin;
import tk.theunigame.unigame.app.logica_juego.comodines.IModoComodin;
import tk.theunigame.unigame.app.logica_juego.comodines.ModoJuego;
import tk.theunigame.unigame.app.logica_juego.temporizador.ITemporizador;

/**
 * Created by Paco on 23/04/2015.
 */
public class Juego {
    private static Juego ourInstance;

    protected IModoComodin modoComodin;
    protected ITemporizador cronometro;
    protected List<Comodin> comodines;

    protected List<Pregunta> preguntas;
    protected int turno;
    protected double tiempo_pregunta;
    protected int numPreguntas;
    protected IModoJuego juego;


    public Pregunta usarComodin(Comodin comodin) throws Exception {
        return modoComodin.usarComodin(comodin, preguntas.get(turno));
    }




    public void init()
    {
        preguntas = new ArrayList<Pregunta>();
        comodines = new ArrayList<Comodin>();
        tiempo_pregunta = 30;
        numPreguntas = 20;
        turno = 0;
    }



    public void setJuego(ModoJuego modo)
    {
        juego = JuegoFactory.getJuego(modo);
    }




    public void setNumPreguntas(int n)
    {
        if(n>0)
            numPreguntas = n;
    }


    public void addComodin(Comodin c)
    {
        comodines.add(c);
    }


    public List<Pregunta> obtenerPreguntas(Context c , List<BDPreguntas> bolsas,int numPreguntas)
    {
        setNumPreguntas(numPreguntas);
        return obtenerPreguntas(c,bolsas);
    }


    public List<Pregunta> obtenerPreguntas(Context c, List<BDPreguntas> bolsas)
    {
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




    public boolean comprobarRespuesta(int res)
    {
        Pregunta p = preguntas.get(turno);
        boolean result = false;
        List<Respuesta> respuestasList = new ArrayList<Respuesta>();

        Collection<Respuesta> respuestasCol = p.getRespuestas();
        int i=0;
        for(Respuesta r : respuestasCol)
        {
            if(i==turno) {
                result = r.getId() == res;
                break;
            }
            ++i;
        }

       return false;

    }


    public Pregunta siguientePregunta() {
        ++turno;
        return preguntas.get(turno);
    }
}







