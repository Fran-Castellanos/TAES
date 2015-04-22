package tk.theunigame.unigame.app.logica_juego.bolsaPreguntas;

import com.j256.ormlite.dao.ForeignCollection;

import java.util.ArrayList;
import java.util.List;

import juego.taes.domainmodel.Model.Cliente.BDPreguntas;
import juego.taes.domainmodel.Model.Cliente.Pregunta;
import juego.taes.domainmodel.Repository.BDPreguntasRepository;
import juego.taes.domainmodel.Repository.PreguntaRepository;

/**
 * Created by Pedro on 22/04/2015.
 */
public class BolsaPregunta {

    private List<Pregunta> preguntas_eliminadas;
    private List<Pregunta> preguntas_modificadas;
    private List<Pregunta> preguntas_creadas;
    private BDPreguntas bolsa;
    private ForeignCollection<Pregunta> registradas;

    private PreguntaRepository preguntaRepository = new PreguntaRepository();
    private BDPreguntasRepository bDRepository = new BDPreguntasRepository();

    public BolsaPregunta(BDPreguntas bd)
    {
        bolsa = bd;
        registradas = bd.getPreguntas();
        preguntas_creadas = new ArrayList<Pregunta>();
        preguntas_eliminadas = new ArrayList<Pregunta>();
        preguntas_modificadas = new ArrayList<Pregunta>();
    }

    public void CrearPregunta(Pregunta pregunta)
    {
        pregunta.setBdPreguntas(bolsa);
        pregunta.setId((preguntas_creadas.size() + 1)*(-1));//Setteo su id a un valor negativo
        preguntas_creadas.add(pregunta);
    }

    public void EliminarPregunta(Pregunta pregunta)
    {
        if(preguntas_creadas.contains(pregunta))
        {
            int pos = (pregunta.getId()*(-1)) - 1;
            preguntas_creadas.remove(pregunta);

            if(pos<preguntas_creadas.size()) { //Si la posicion borrada no es la última
                //Cambiar todos los Ids
                for (int i = pos; i < preguntas_creadas.size(); i++) {
                    preguntas_creadas.get(i).setId((i + 1) * (-1));//Setteo su id a un valor negativo
                }
            }
        }
        else if(registradas.contains(pregunta))
            preguntas_eliminadas.add(pregunta);
    }

    public void ModificarPregunta(Pregunta pregunta)
    {
        if(preguntas_creadas.contains(pregunta))
        {
            preguntas_creadas.remove(pregunta);
            preguntas_creadas.add(pregunta);
        }
        else if(registradas.contains(pregunta))
            preguntas_modificadas.add(pregunta);
    }

    public void actualizarCreadas()
    {
        for(Pregunta x : preguntas_creadas)
        {
            preguntaRepository.create(x);
        }
    }
    public void actualizarBorradas()
    {
        for(Pregunta x : preguntas_eliminadas)
        {
            preguntaRepository.delete(x);
        }
    }
    public void actualizarModificadas()
    {
        for(Pregunta x : preguntas_modificadas)
        {
            preguntaRepository.update(x);
        }
    }
}
