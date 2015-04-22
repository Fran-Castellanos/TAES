package tk.theunigame.unigame.app.logica_juego.bolsaPreguntas;

import java.util.List;

import juego.taes.domainmodel.Model.Cliente.BDPreguntas;
import juego.taes.domainmodel.Model.Cliente.Pregunta;

/**
 * Created by Pedro on 22/04/2015.
 */
public class BolsaPregunta {

    private List<Pregunta> preguntas_eliminadas;
    private List<Pregunta> preguntas_modificadas;
    private List<Pregunta> preguntas_creadas;
    private BDPreguntas bolsa;

    public BolsaPregunta(BDPreguntas bd)
    {
        bolsa = bd;
        preguntas_creadas = null;
        preguntas_eliminadas = null;
        preguntas_modificadas = null;
    }

    public void CrearPregunta(Pregunta pregunta)
    {
        pregunta.setBdPreguntas(bolsa);
        preguntas_creadas.add(pregunta);
    }

    public void EliminarPregunta(Pregunta pregunta)
    {
        preguntas_eliminadas.add(pregunta);
    }

    public void ModificarPregunta(Pregunta pregunta)
    {
        preguntas_modificadas.add(pregunta);
    }

    public void actualizarCreadas()
    {
        for(Pregunta x : preguntas_creadas)
        {

        }
    }
    public void actualizarBorradas()
    {

    }
    public void actualizarModificadas()
    {

    }
}
