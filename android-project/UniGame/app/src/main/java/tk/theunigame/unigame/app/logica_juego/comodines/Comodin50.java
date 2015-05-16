package tk.theunigame.unigame.app.logica_juego.comodines;

import com.j256.ormlite.dao.ForeignCollection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import juego.taes.domainmodel.Model.Cliente.Pregunta;
import juego.taes.domainmodel.Model.Cliente.Respuesta;
import tk.theunigame.unigame.app.logica_juego.juego.Juego;

/**
 * Created by Paco on 22/04/2015.
 */
public class Comodin50 extends Comodin {

    private static Comodin50 ourInstance = new Comodin50();

    public static Comodin50 getInstance() {
        return ourInstance;
    }


    private Comodin50() {
        super();
        nombre = "Ha usado el comodín del 50%";
    }



    @Override
    public Pregunta usarComodin() throws Exception {

        Juego j= Juego.getInstance();
        p = j.getPreguntaActual();
        Pregunta result=new Pregunta(p.getContenido(),false);
        try{

            List<Respuesta> respuestasCollection = p.getRespuestas();

            int eliminadas=0;
            List<Respuesta> resp50= new ArrayList<Respuesta>();
            int numEliminadas = (int)Math.round(respuestasCollection.size()/2);

            Random r = new Random();
            ArrayList<Integer> aleatorios = new ArrayList<Integer>();
            int a;
            while(eliminadas < numEliminadas)
            {
                a = r.nextInt(respuestasCollection.size());  // Entre 0 y num de respuestasCollection
                if(!aleatorios.contains(a) && !esCorrecta(respuestasCollection,a)) {
                    aleatorios.add(a);
                    ++eliminadas;
                }

        }

        int i=0;
        for(Respuesta res : respuestasCollection){
            if(aleatorios.contains(i))
            {
                    res.setContenido("");
            }
            ++i;
        }
        result.setRespuestas(respuestasCollection);

        consumirComodin();


        }catch (Exception ex){
            throw new Exception("No se pudo usar comodin 50%"+ex.getMessage());
        }

        j.getPreguntaActual().setRespuestas(result.getRespuestas());

        return result;
    }

    @Override
    public String getNombre() {
        return nombre;
    }


    private boolean esCorrecta(Collection<Respuesta> respuestas, int pos) {

        Iterator<Respuesta> it = respuestas.iterator();
        int i=0;
        while(it.hasNext())
        {
            Respuesta r = it.next();
            if(i==pos)
            {
                if(r.getEsCorrecta())
                    return true;
                else
                    return false;
            }

            ++i;
        }

        return false;
    }



}
