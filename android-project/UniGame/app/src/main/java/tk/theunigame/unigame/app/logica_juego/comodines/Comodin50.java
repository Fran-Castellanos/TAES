package tk.theunigame.unigame.app.logica_juego.comodines;

import com.j256.ormlite.dao.ForeignCollection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
        for(Respuesta r : respuestas){
            if(r != p.getRespuestaCorrecta())
            {
                eliminadas++;
                if(eliminadas>2){
                    resp50.add(r);
                }
            }else
                resp50.add(r);
        }
        result.setRespuestas(resp50);
        result.setRespuestaCorrecta(p.getRespuestaCorrecta());
        cantidad--;
        disponible=false;

        }catch (Exception ex){
            throw new Exception("No se pudo usar comodin 50%"+ex.getMessage());
        }
        return result;
    }

    @Override
    public boolean comodinDisponible() {

        return disponible;

    }

}
