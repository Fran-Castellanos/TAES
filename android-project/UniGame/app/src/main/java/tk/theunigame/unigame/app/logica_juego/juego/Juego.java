package tk.theunigame.unigame.app.logica_juego.juego;

import android.content.Context;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import juego.taes.domainmodel.Model.Cliente.BDPreguntas;
import juego.taes.domainmodel.Model.Cliente.Pregunta;
import juego.taes.domainmodel.Model.Cliente.Respuesta;
import juego.taes.domainmodel.Repository.PreguntaRepository;
import tk.theunigame.unigame.app.logica_juego.comodines.ModoJuego;
import tk.theunigame.unigame.app.logica_juego.temporizador.TemporizadorTimerTask;
import tk.theunigame.unigame.app.presentacion.util.Listener.OnJuegoListener;
import tk.theunigame.unigame.app.presentacion.util.Listener.OnTiempoListener;

/**
 * Created by Paco on 23/04/2015.
 */
public class Juego implements OnTiempoListener {
    private static Juego ourInstance = null;
    TemporizadorTimerTask cronometro;
    private List<Pregunta> preguntas;
    private int turno;
    private double tiempo_pregunta;
    private int numPreguntas;
    private OnJuegoListener listener;
    private OnTiempoListener listenerTiempo;
    private Estadisticas estadisticas;
    private IModoJuego modojuego;


    private Juego() {
        turno = 0;
        tiempo_pregunta = 30;
        numPreguntas = 20;
        cronometro = new TemporizadorTimerTask();
        cronometro.setOnTiempoListener(this);
        estadisticas = new Estadisticas();
        listenerTiempo = null;
        listener = null;


    }

    public static Juego getInstance() {
        return ourInstance;
    }

    public void setTiempoMax(int tiempo) throws Exception {

        if (tiempo > 0) {
            cronometro.setTiempo(tiempo);
            tiempo_pregunta = tiempo;
        } else
            throw new Exception("El tiempo del cronómetro es negativo");
    }

    public void pararCronometro() {
        cronometro.Parar();
    }

    public void reiniciarCronometro() {
        cronometro.Reiniciar();
    }


    public IModoJuego getModoJuego() {
        return modojuego;
    }

    public void initComodines() throws Exception {
        modojuego.initComodines();
    }

    public int getNumPreguntas() {
        return numPreguntas;
    }

    public void setNumPreguntas(int n) {
        if (n > 0)
            numPreguntas = n;
    }

    public List<Pregunta> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(List<Pregunta> pr) {
        preguntas = pr;
    }

    public void init() {
        preguntas = new ArrayList<Pregunta>();
        tiempo_pregunta = 30;
        numPreguntas = 20;
        turno = 0;
    }

    public void setModojuego(ModoJuego modo) {
        modojuego = JuegoFactory.getJuego(modo);
    }

    public boolean comprobarRespuesta(int res) {
        Pregunta p = preguntas.get(turno);
        boolean result = false;
        List<Respuesta> respuestasList = new ArrayList<Respuesta>();

        Collection<Respuesta> respuestasCol = p.getRespuestas();
        int i = 0;
        for (Respuesta r : respuestasCol) {
            if (i == turno) {
                result = r.getId() == res;
                break;
            }
            ++i;
        }
        if (result)
            estadisticas.sumarAcertadas();
        else
            estadisticas.sumarFalladas();
        return result;

    }

    public Pregunta siguientePregunta() {

        if (++turno >= numPreguntas) {
            if (listener != null)
                listener.onJuegoHaAcabado(estadisticas.getAcertadas(), estadisticas.getFalladas(), estadisticas.getComodinesUsados());
        }

        return preguntas.get(turno);
    }

    public Pregunta getPreguntaActual() {
        return preguntas.get(turno);
    }

    public void setOnJuegoListener(OnJuegoListener listener) {
        this.listener = listener;
    }

    @Override
    public void onTiempoFinalizado(TemporizadorTimerTask object) {
        listener.onTiempoFinalizado("¡Tiempo agotado!");
    }

    @Override
    public void onTiempoHaCambiado(TemporizadorTimerTask object) {
        listener.onTiempoHaCambiado(cronometro.getTiempo());
    }

    @Override
    public void onParar(TemporizadorTimerTask object) {

    }

    @Override
    public void onContinuar(TemporizadorTimerTask object) {

    }

    @Override
    public void onReiniciar(TemporizadorTimerTask object) {
        reiniciarCronometro();
        listenerTiempo.onReiniciar(cronometro);
    }

    public void sumarComodinUsado() {
        estadisticas.sumarComodinesUsados();
    }
}







