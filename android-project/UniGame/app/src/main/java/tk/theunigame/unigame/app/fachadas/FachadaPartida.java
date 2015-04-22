package tk.theunigame.unigame.app.fachadas;


import android.content.pm.PermissionGroupInfo;

import java.util.ArrayList;
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



    public FachadaPartida(IModoJuego modo)
    {
        uni = new UniversidadRepository();
        car = new CarreraRepository();
        asig = new AsignaturaRepository();
        listaPreguntas = new HashMap<Pregunta, Integer>();
        juego = modo;
    }

    public void setJuegoSimple()
    {
        juego = new JuegoSimple();
    }

    public void setJuegoTorneo()
    {
        juego = new JuegoTorneo();
    }



    public List<Universidad> verUniversidades() throws Exception {

        List<Universidad> universidades;
        try {

            universidades = uni.getAll();

        }catch(Exception e){
            throw  new Exception("No se han obtenido universidades"+e.getMessage());
        }
        return  universidades;
    }


    public List<Carrera> verCarreras(int idUniversidad) throws Exception {
        List<Carrera> carreras;

        try{

            carreras = car.getByUniversidad(idUniversidad);

        }catch(Exception e){
            throw  new Exception("No se han obtenido carreras para la Universidad"+e.getMessage());
        }
        return  carreras;
    }


    public List<Asignatura> verAsignaturas(int idCarrera) throws Exception {
        List<Asignatura> asignaturas;

        try {

            asignaturas = asig.getByCarrera(idCarrera);

        }catch(Exception e){
            throw  new Exception("No se han obtenido asignaturas para la carrera"+e.getMessage());
        }
        return  asignaturas;
    }
    public List<BDPreguntas> verBDPreguntasTodasUnis(int idAsig) throws Exception {
        List<BDPreguntas> bases;

        try {

            bases = base.getByAsignatura(idAsig);

        }catch(Exception e){
            throw  new Exception("No se han obtenido asignaturas para la carrera"+e.getMessage());
        }
        return  bases;
    }
    public  List<BDPreguntas> verBDPreguntasUnaUni(int idAsig ,int idUni) throws Exception {
        List<BDPreguntas> bases;

        try {

            bases = base.getByUniversidad(idAsig, idUni);

        }catch(Exception e){
            throw  new Exception("No se han obtenido asignaturas para la carrera"+e.getMessage());
        }
        return bases;

    }



    public void jugarPartida(Millonario p) throws Exception {
        BDPreguntasRepository bdpreg = new BDPreguntasRepository();



        throw new Exception("Not implemented yet");


    }


    public boolean comprobarPregunta(int pregunta, int respuesta)
    {
        PreguntaRepository preg = new PreguntaRepository();
        Pregunta p = preg.getById(pregunta);
        return juego.comprobarRespuesta(p, respuesta);

    }


    public List<Pregunta> getPreguntas(List<BDPreguntas> bolsas)
    {
        BDPreguntasRepository bdrep = new BDPreguntasRepository();


        return juego.obtenerPreguntas(bolsas);

    }





}
