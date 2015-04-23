package tk.theunigame.unigame.app.logica_juego.comodines;

import com.j256.ormlite.dao.ForeignCollection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import juego.taes.domainmodel.Model.Cliente.Pregunta;
import juego.taes.domainmodel.Model.Cliente.Respuesta;

/**
 * Created by Paco on 22/04/2015.
 */
public class Comodin50 extends Comodin {

    private final static String nombre = "Comodín del 50%";

    private boolean disponible;


    public Comodin50()
    {
        disponible=true;
        cantidad++;
    }



    @Override
    public Pregunta usarComodin(List<Pregunta>preguntas,Pregunta p) throws Exception {

        Pregunta result=new Pregunta(p.getContenido(),false);
        try{
        ForeignCollection<Respuesta> respuestas = p.getRespuestas();
        int eliminadas=0;
        ForeignCollection<Respuesta> resp50= (ForeignCollection<Respuesta>) new ArrayList<Respuesta>();
        int numEliminadas = (int)Math.floor(resp50.size()/2);

        Random r = new Random();
        ArrayList<Integer> aleatorios = new ArrayList<Integer>();
        int a;
        while(eliminadas < numEliminadas)
        {
            a = r.nextInt(resp50.size());  // Entre 0 y num de respuestas
            if(!aleatorios.contains(a) && !esCorrecta(respuestas,a,p.getRespuestaCorrecta())) {
                aleatorios.add(a);
                ++eliminadas;
            }

        }

        int i=0;
        for(Respuesta res : respuestas){
            if(aleatorios.contains(i))
            {
                    res.setContenido("");
            }
            ++i;
        }
        result.setRespuestas(respuestas);
        result.setRespuestaCorrecta(p.getRespuestaCorrecta());
        cantidad--;
        disponible=false;

        }catch (Exception ex){
            throw new Exception("No se pudo usar comodin 50%"+ex.getMessage());
        }
        return result;
    }



    private boolean esCorrecta(Collection<Respuesta> respuestas, int pos, Respuesta correcta) {

        Iterator<Respuesta> it = respuestas.iterator();
        int i=0;
        while(it.hasNext())
        {
            Respuesta r = it.next();
            if(i==pos && r.equals(correcta))
            {
                return true;
            }

            ++i;
        }

        return false;
    }

    @Override
    public boolean comodinDisponible() {

        return disponible;

    }

}
