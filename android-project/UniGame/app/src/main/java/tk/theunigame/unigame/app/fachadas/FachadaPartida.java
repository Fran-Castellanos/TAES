package tk.theunigame.unigame.app.fachadas;


import java.util.HashMap;
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
import tk.theunigame.unigame.app.logica_juego.interfaces.IModoJuego;
import tk.theunigame.unigame.app.logica_juego.modojuego.JuegoSimple;
import tk.theunigame.unigame.app.logica_juego.modojuego.JuegoTorneo;
import tk.theunigame.unigame.app.logica_juego.modojuego.Millonario;


/**
 * Created by Paco on 21/04/2015.
 */
public class FachadaPartida {

    private int uniId;
    private UniversidadRepository uni;
    private CarreraRepository car;
    private AsignaturaRepository asig;
    private BDPreguntasRepository base;


    private HashMap<Pregunta,Integer> listaPreguntas;
    private IModoJuego juego;


    /**
     * Constructor de la fachada a partir de un modo de juego.
     * @param modo Modo de juego.
     */
    public FachadaPartida(IModoJuego modo)
    {
        uni = new UniversidadRepository();
        car = new CarreraRepository();
        asig = new AsignaturaRepository();
        listaPreguntas = new HashMap<Pregunta, Integer>();
        juego = modo;
    }

    /**
     * Asigna modo de juego simple
     */
    public void setJuegoSimple()
    {
        juego = new JuegoSimple();
    }


    /**
     * Asigna modo de juego torneo
     */
    public void setJuegoTorneo()
    {
        juego = new JuegoTorneo();
    }


    /**
     * Devuelve lista de todas las universidades.
     * @return Lista de todas las universidades.
     * @throws Exception
     */
    public List<Universidad> verUniversidades() throws Exception {

        List<Universidad> universidades;
        try {

            universidades = uni.getAll();

        }catch(Exception e){
            throw  new Exception("No se han obtenido universidades"+e.getMessage());
        }
        return  universidades;
    }


    /**
     * Devuelve una lista de todas las carreras dentro de una universidad.
     * @param idUniversidad ID de la Universidad.
     * @return Lista de carreras de la Universidad.
     * @throws Exception
     */
    public List<Carrera> verCarreras(int idUniversidad) throws Exception {
        List<Carrera> carreras;

        try{

            carreras = car.getByUniversidad(idUniversidad);

        }catch(Exception e){
            throw  new Exception("No se han obtenido carreras para la Universidad"+e.getMessage());
        }
        return  carreras;
    }


    /**
     * Devuelve una lista de asignaturas de una carrera concreta.
     * @param idCarrera ID de la carrera.
     * @return Lista de asignaturas de una carrera.
     * @throws Exception
     */
    public List<Asignatura> verAsignaturas(int idCarrera) throws Exception {
        List<Asignatura> asignaturas;

        try {

            asignaturas = asig.getByCarrera(idCarrera);

        }catch(Exception e){
            throw  new Exception("No se han obtenido asignaturas para la carrera"+e.getMessage());
        }
        return  asignaturas;
    }


    /**
     * Devuelve la lista de bolsas de preguntas relacionadas con una asignatura y con
     * cualquier Universidad.
     * @param idAsig ID de la asignatura.
     * @return Lista de bolsas de preguntas.
     * @throws Exception
     */
    public List<BDPreguntas> verBDPreguntasTodasUnis(int idAsig) throws Exception {
        List<BDPreguntas> bases;

        try {

            bases = base.getByAsignatura(idAsig);

        }catch(Exception e){
            throw  new Exception("No se han obtenido asignaturas para la carrera"+e.getMessage());
        }
        return  bases;
    }


    /**
     * Devuelve la lista de bolsas de preguntas de una asignatura concreta impartida
     * en una Universidad concreta.
     * @param idAsig ID de la asignatura.
     * @param idUni ID de la Universidad.
     * @return Lista de bolsas de preguntas.
     * @throws Exception
     */
    public  List<BDPreguntas> verBDPreguntasUnaUni(int idAsig ,int idUni) throws Exception {
        List<BDPreguntas> bases;

        try {

            bases = base.getByAsignaturaYUniversidad(idAsig, idUni);

        }catch(Exception e){
            throw  new Exception("No se han obtenido asignaturas para la carrera"+e.getMessage());
        }
        return bases;

    }


    /**
     *
     * @param p
     * @throws Exception
     */
    public void jugarPartida(Millonario p) throws Exception {
        BDPreguntasRepository bdpreg = new BDPreguntasRepository();



        throw new Exception("Not implemented yet");


    }


    /**
     * Comprueba si la respuesta del usuario respecto de una pregunta es correcta o no.
     * @param pregunta Pregunta que contesta el usuario.
     * @param respuesta Respuesta del usuario.
     * @return True si la respuesta es correcta, false, si es incorrecta.
     */
    public boolean comprobarPregunta(int pregunta, int respuesta)
    {
        PreguntaRepository preg = new PreguntaRepository();
        Pregunta p = preg.getById(pregunta);
        return juego.comprobarRespuesta(p, respuesta);

    }


    /**
     * Devuelve la lista de preguntas que se usarán en la partida.
     * @param bolsas Lista de bolsas de preguntas de donde se obtienen las preguntas.
     * @return
     */
    public List<Pregunta> getPreguntasPartida(List<BDPreguntas> bolsas)
    {
        BDPreguntasRepository bdrep = new BDPreguntasRepository();


        return juego.obtenerPreguntas(bolsas);

    }





}
