package tk.theunigame.unigame.app.fachadas;


import java.util.ArrayList;
import java.util.Collection;

import juego.taes.domainmodel.Model.Cliente.Pregunta;
import tk.theunigame.unigame.app.logica_juego.comodines.Comodin;
import tk.theunigame.unigame.app.logica_juego.comodines.ModoJuego;
import tk.theunigame.unigame.app.logica_juego.juego.IModoJuego;
import tk.theunigame.unigame.app.logica_juego.juego.Juego;
import tk.theunigame.unigame.app.logica_juego.juego.JuegoFactory;
import tk.theunigame.unigame.app.logica_juego.juego.JuegoSimple;
import tk.theunigame.unigame.app.logica_juego.juego.Millonario;
import tk.theunigame.unigame.app.presentacion.util.Listener.OnJuegoListener;



/**
 * Created by Paco on 21/04/2015.
 */
public class FachadaPartida {

    /**
     * Constructor por defecto de la fachadaPartida
     */
    public FachadaPartida() {

    }

    /**
     * Inicializa el juego
     */
    public void inicializarPartida() {
        Juego j = Juego.getInstance();
        j.reiniciarPartida();
        try {
            j.initComodines();
        } catch (Exception e) {
            e.printStackTrace();
        }
        j.setModojuego(ModoJuego.MILLONARIO);
    }





    public int getTurno()
    {
        Juego j = Juego.getInstance();
        return j.getTurno();
    }

    public int getNumPreguntas()
    {
        Juego j = Juego.getInstance();
        return j.getNumPreguntas();
    }

    /**
     * Comprueba si la respuesta del usuario respecto de una pregunta es correcta o no.
     *
     * @param respuestaPos Respuesta del usuario.
     * @return True si la respuesta es correcta, false, si es incorrecta.
     */
    public void comprobarPregunta(int respuestaPos) {
        Juego j = Juego.getInstance();
        j.pararCronometro();

        int respuestaId = j.getPreguntaActual().getRespuestas().get(respuestaPos).getId();
        j.comprobarRespuesta(respuestaId);


    }


    /**
     * Devulve una nueva pregunta resultado de aplicar el comodin
     *
     * @param comodin Comodin que vamos a usar
     * @return
     */
    public void usarComodin(Comodin comodin) throws Exception {
        Juego juego = Juego.getInstance();
        juego.reiniciarCronometro();
        IModoJuego modo = juego.getModoJuego();
        modo.usarComodin(comodin);
    }


    /**
     * Devuelve la siguiente pregunta de la partida.
     */
    public void siguientePregunta() {

        Juego juego = Juego.getInstance();
        juego.siguientePregunta();

    }


    public void setTiempoCronometro(int tiempo) throws Exception {
        Juego j = Juego.getInstance();
        try {
            j.setTiempoMax(tiempo);
        } catch (Exception e) {
            throw e;
        }
    }


    public void setOnJuegoListenerToJuego(OnJuegoListener listener){
        Juego.getInstance().setOnJuegoListener(listener);
    }

    public void apagarCronometro() {
        Juego j = Juego.getInstance();
        j.pararCronometro();
    }
}
