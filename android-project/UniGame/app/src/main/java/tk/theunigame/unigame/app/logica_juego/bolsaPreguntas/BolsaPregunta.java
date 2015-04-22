package tk.theunigame.unigame.app.logica_juego.bolsaPreguntas;

import com.j256.ormlite.dao.ForeignCollection;


import juego.taes.domainmodel.Model.Cliente.BDPreguntas;
import juego.taes.domainmodel.Model.Cliente.Pregunta;

/**
 * Created by Pedro on 22/04/2015.
 */
public class BolsaPregunta {

    private ForeignCollection<Pregunta> preguntas_eliminadas;
    private ForeignCollection<Pregunta> preguntas_modificadas;
    private ForeignCollection<Pregunta> preguntas_creadas;
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

    }
    public void actualizarBorradas()
    {

    }
    public void actualizarModificadas()
    {

    }
}
