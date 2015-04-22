package tk.theunigame.unigame.app.fachadas;


import java.util.ArrayList;
import java.util.List;

import juego.taes.domainmodel.Model.Cliente.Asignatura;
import juego.taes.domainmodel.Model.Cliente.BDPreguntas;
import juego.taes.domainmodel.Model.Cliente.Carrera;
import juego.taes.domainmodel.Model.Cliente.Universidad;
import juego.taes.domainmodel.Repository.AsignaturaRepository;
import juego.taes.domainmodel.Repository.BDPreguntasRepository;
import juego.taes.domainmodel.Repository.CarreraRepository;
import juego.taes.domainmodel.Repository.UniversidadRepository;
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

     throw new Exception("Not implemented yet");

    }




}
