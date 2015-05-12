package tk.theunigame.unigame.app.fachadas;

import android.content.Context;

import com.j256.ormlite.dao.ForeignCollection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import juego.taes.domainmodel.Model.Cliente.BDPreguntas;
import juego.taes.domainmodel.Model.Cliente.Pregunta;
import juego.taes.domainmodel.Model.Cliente.Respuesta;
import juego.taes.domainmodel.Repository.BDPreguntasRepository;
import juego.taes.domainmodel.Repository.PreguntaRepository;
import tk.theunigame.unigame.app.logica_juego.juego.Juego;

/**
 * Created by Pedro on 21/04/2015.
 */
public class FachadaPregunta {

    public Pregunta crearPregunta(String contenido)
    {
        return new Pregunta(contenido,false);
    }

    public void indicarRespuestas(Pregunta pregunta, ArrayList<Respuesta> respuestas)
    {
        pregunta.setRespuestas(respuestas);
    }

    public void respuestaCorrecta(Pregunta pregunta, int IDrespuestaCorrecta)
    {
        ArrayList<Respuesta> respuestas = (ArrayList<Respuesta>) pregunta.getRespuestas();

        for(Respuesta r : respuestas)
        {
            if(r.getId() == IDrespuestaCorrecta)
                r.setEsCorrecta(true);
            else
                r.setEsCorrecta(false);
        }
    }



    /**
     * Devuelve la lista de preguntas que se usarán en la partida.
     * @return
     */
    public List<Pregunta> getPreguntasPartida()
    {
        Juego j = Juego.getInstance();
        return j.getPreguntas();

    }




    public void cargarPreguntas(Context c, List<BDPreguntas> bolsas)
    {
        Juego j = Juego.getInstance();
        List<Integer> numPreguntasBolsa = new ArrayList<Integer>();
        List<Double> ranks;
        PreguntaRepository pregunta = new PreguntaRepository(c);
        List<Pregunta> preguntas = new ArrayList<Pregunta>();

        for (BDPreguntas bolsa : bolsas) {
            numPreguntasBolsa.add(bolsa.getPreguntas().size());
        }

        ranks = calcularRangos(numPreguntasBolsa);
        int n = 0;
        while (n<j.getNumPreguntas())
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
        j.setPreguntas(preguntas);

    }




    private List<Double> calcularRangos(List<Integer> numPreguntasBolsa) {
        Juego j = Juego.getInstance();
        int total = 0;
        List<Double> result = new ArrayList<Double>();
        for(Integer i: numPreguntasBolsa)
            total += i;

        if(total < j.getNumPreguntas())
            if(total>1)
                j.setNumPreguntas(total-1);
            else
                j.setNumPreguntas(total);

        double aux=0;
        for(Integer i: numPreguntasBolsa) {
            aux += (double) i / total;
            result.add(aux);

        }

        return result;

    }

}
