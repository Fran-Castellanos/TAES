package tk.theunigame.unigame.app.logica_juego.comodines;

import java.util.List;

import juego.taes.domainmodel.Model.Cliente.Pregunta;

/**
 * Created by Paco on 22/04/2015.
 */
public class ComodinCambiarPregunta extends Comodin {

    private final static String nombre = "Comodín del público";

    private boolean disponible;

    public ComodinCambiarPregunta(){

        disponible=true;
        cantidad++;
    }

    @Override
    public Pregunta usarComodin(List<Pregunta>preguntas,Pregunta p)throws Exception{
        Pregunta resp;
        try {
            resp=preguntas.get(preguntas.size()-1);
            cantidad--;
            disponible=false;
        }catch (Exception ex){
            throw new Exception("No se pudo usar cambiar pregunta"+ex.getMessage());
        }
        return resp;
    }

    @Override
    public boolean quedanComodines() {

        return cantidad>0;

    }

    @Override
    public boolean comodinDisponible() {
        return disponible;
    }
}
