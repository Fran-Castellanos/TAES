package tk.theunigame.unigame.app.fachadas;


import juego.taes.domainmodel.Model.Cliente.Pregunta;
import tk.theunigame.unigame.app.logica_juego.comodines.Comodin;
import tk.theunigame.unigame.app.logica_juego.juego.IModoJuego;
import tk.theunigame.unigame.app.logica_juego.juego.Juego;
import tk.theunigame.unigame.app.presentacion.util.Listener.OnJuegoListener;


/**
 * Created by Paco on 21/04/2015.
 */
public class FachadaPartida {

    /**
     * Constructor por defecto de la fachadaPartida
     */
    public FachadaPartida() {
        inicializarPartida();
    }

    /**
     * Inicializa el juego
     */
    public void inicializarPartida() {
        Juego j = Juego.getInstance();
        j.init();
    }


    /**
     * Comprueba si la respuesta del usuario respecto de una pregunta es correcta o no.
     *
     * @param respuestaId Respuesta del usuario.
     * @return True si la respuesta es correcta, false, si es incorrecta.
     */
    public boolean comprobarPregunta(int respuestaId) {
        Juego j = Juego.getInstance();
        j.pararCronometro();
        return j.comprobarRespuesta(respuestaId);


    }


    /**
     * Devulve una nueva pregunta resultado de aplicar el comodin
     *
     * @param comodin Comodin que vamos a usar
     * @return
     */
    public Pregunta usarComodin(Comodin comodin) throws Exception {
        Juego juego = Juego.getInstance();
        juego.reiniciarCronometro();
        IModoJuego modo = juego.getModoJuego();
        return modo.usarComodin(comodin);
    }


    /**
     * Devuelve la siguiente pregunta de la partida.
     *
     * @return Siguiente pregunta
     */
    public Pregunta siguientePregunta() {

        Juego juego = Juego.getInstance();
        juego.reiniciarCronometro();
        return juego.siguientePregunta();
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
}
