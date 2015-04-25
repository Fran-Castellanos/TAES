package tk.theunigame.unigame.app.fachadas;


import android.content.Context;

import java.util.List;

import juego.taes.domainmodel.Model.Cliente.Asignatura;
import juego.taes.domainmodel.Model.Cliente.BDPreguntas;
import juego.taes.domainmodel.Model.Cliente.Carrera;
import juego.taes.domainmodel.Model.Cliente.Pregunta;
import juego.taes.domainmodel.Model.Cliente.Universidad;
import juego.taes.domainmodel.Repository.AsignaturaRepository;
import juego.taes.domainmodel.Repository.BDPreguntasRepository;
import juego.taes.domainmodel.Repository.CarreraRepository;
import juego.taes.domainmodel.Repository.PreguntaRepository;
import juego.taes.domainmodel.Repository.UniversidadRepository;
import tk.theunigame.unigame.app.logica_juego.juego.Juego;
import tk.theunigame.unigame.app.logica_juego.comodines.Comodin;
import tk.theunigame.unigame.app.logica_juego.temporizador.TemporizadorTimerTask;


/**
 * Created by Paco on 21/04/2015.
 */
public class FachadaPartida {

    /**
     * Constructor por defecto de la fachadaPartida
     */
    public FachadaPartida()
    {
    }

    /**
     * Comprueba si la respuesta del usuario respecto de una pregunta es correcta o no.
     * @param c Objeto Context
     * @param juego Contiene la información de la partida.
     * @param respuestaId Respuesta del usuario.
     * @return True si la respuesta es correcta, false, si es incorrecta.
     */
    public boolean comprobarPregunta(Context c, Juego juego, int respuestaId)
    {
        PreguntaRepository preg = new PreguntaRepository(c);
        return juego.comprobarRespuesta(respuestaId);

    }


    /**
     * Devuelve la lista de preguntas que se usarán en la partida.
     * @param c Objeto Context
     * @param juego Contiene la información de la partida.
     * @param bolsas Lista de bolsas de preguntas de donde se obtienen las preguntas.
     * @return
     */
    public List<Pregunta> getPreguntasPartida(Context c, Juego juego, List<BDPreguntas> bolsas)
    {
        BDPreguntasRepository bdrep = new BDPreguntasRepository(c);
        return juego.obtenerPreguntas(c, bolsas);

    }

    /**
     * Devulve una nueva pregunta resultado de aplicar el comodin
     * @param c Objeto Context
     * @param  comodin Comodin que vamos a usar
     * @return
     */
    public Pregunta usarComodin(Context c, Juego juego, Comodin comodin) throws Exception
    {
        return juego.usarComodin(comodin);
    }


    /**
     * Devuelve la siguiente pregunta de la partida.
     * @param c Objeto Context
     * @param juego Contiene la información de la partida.
     * @return
     */
    public Pregunta siguientePregunta(Context c, Juego juego)
    {

        return juego.siguientePregunta();
    }



    public void PararCronometro(TemporizadorTimerTask cronometro) {
        cronometro.Parar();
    }

    //Continua la cuenta
    public void ContinuarCronometro(TemporizadorTimerTask cronometro) {
       cronometro.Continuar();
    }

    //Reinicia la cuenta
    public void ReiniciarCronometro(TemporizadorTimerTask cronometro, int tiempoMax) {
        cronometro.setTiempo(tiempoMax);
        cronometro.Reiniciar();
    }




}
