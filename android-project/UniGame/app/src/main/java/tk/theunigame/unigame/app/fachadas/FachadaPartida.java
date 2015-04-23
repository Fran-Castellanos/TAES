package tk.theunigame.unigame.app.fachadas;


import android.content.Context;
import android.content.pm.PermissionGroupInfo;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

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
import tk.theunigame.unigame.app.logica_juego.comodines.Comodin;
import tk.theunigame.unigame.app.logica_juego.interfaces.IModoJuego;
import tk.theunigame.unigame.app.logica_juego.modojuego.JuegoSimple;
import tk.theunigame.unigame.app.logica_juego.modojuego.JuegoTorneo;
import tk.theunigame.unigame.app.logica_juego.modojuego.Millonario;


/**
 * Created by Paco on 21/04/2015.
 */
public class FachadaPartida {


    private IModoJuego juego;


    /**
     * Constructor de la fachada a partir de un modo de juego.
     * @param modo Modo de juego.
     */
    public FachadaPartida(IModoJuego modo)
    {
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
    public List<Universidad> verUniversidades(Context c) throws Exception {

        List<Universidad> universidades;
        try {
            UniversidadRepository uni= new UniversidadRepository(c);
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
    public List<Carrera> verCarreras(Context c, int idUniversidad) throws Exception {
        List<Carrera> carreras;

        try{

            CarreraRepository car= new CarreraRepository(c);
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
    public List<Asignatura> verAsignaturas(Context c, int idCarrera) throws Exception {
        List<Asignatura> asignaturas;

        try {

            AsignaturaRepository asig = new AsignaturaRepository(c);
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
    public List<BDPreguntas> verBDPreguntasTodasUnis(Context c, int idAsig) throws Exception {
        List<BDPreguntas> bases;

        try {

            BDPreguntasRepository base= new BDPreguntasRepository(c);
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
    public  List<BDPreguntas> verBDPreguntasUnaUni(Context c, int idAsig ,int idUni) throws Exception {
        List<BDPreguntas> bases;

        try {

            BDPreguntasRepository base= new BDPreguntasRepository(c);
            bases = base.getByAsignaturaYUniversidad(idAsig, idUni);

        }catch(Exception e){
            throw  new Exception("No se han obtenido asignaturas para la carrera"+e.getMessage());
        }
        return bases;

    }




    /**
     * Comprueba si la respuesta del usuario respecto de una pregunta es correcta o no.
     * @param preguntaId Pregunta que contesta el usuario.
     * @param respuestaId Respuesta del usuario.
     * @return True si la respuesta es correcta, false, si es incorrecta.
     */
    public boolean comprobarPregunta(Context c, int preguntaId, int respuestaId)
    {
        PreguntaRepository preg = new PreguntaRepository(c);
        Pregunta p = preg.getById(preguntaId);
        return juego.comprobarRespuesta(p, respuestaId);

    }


    /**
     * Devuelve la lista de preguntas que se usarán en la partida.
     * @param bolsas Lista de bolsas de preguntas de donde se obtienen las preguntas.
     * @return
     */
    public List<Pregunta> getPreguntasPartida(Context c, List<BDPreguntas> bolsas)
    {
        BDPreguntasRepository bdrep = new BDPreguntasRepository(c);


        return juego.obtenerPreguntas(c, bolsas);

    }

    /**
     * Devulve una nueva pregunta resultado de aplicar el comodin
     * @param preguntas Lista de preguntas de la partida
     * @param preguntaId Id de la pregunta en la que usaremos el comodin.
     * @param  comodin Comodin que vamos a usar
     * @return
     */
    public Pregunta usarComodin(Context c, List<Pregunta> preguntas,int preguntaId, Comodin comodin) throws Exception {
        Pregunta p=null;
        try{
            PreguntaRepository preg= new PreguntaRepository(c);
            p=preg.getById(preguntaId);
        }catch(Exception ex){
            throw ex;
        }
        return comodin.usarComodin(preguntas,p);
    }





}
