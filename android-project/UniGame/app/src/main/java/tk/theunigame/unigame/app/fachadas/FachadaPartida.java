package tk.theunigame.unigame.app.fachadas;


import java.util.ArrayList;
import java.util.List;

import juego.taes.domainmodel.Model.Cliente.Asignatura;
import juego.taes.domainmodel.Model.Cliente.Carrera;
import juego.taes.domainmodel.Model.Cliente.Universidad;
import juego.taes.domainmodel.Repository.AsignaturaRepository;
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

    public List<String> verUniversidades() throws Exception {
        List<Universidad> universidades;
        List<String> nombres;
        try {
            nombres= new ArrayList<String>();
            universidades = uni.getAll();
            for(Universidad u : universidades)
                nombres.add(u.getNombre());


        }catch(Exception e){
            throw  new Exception("No se han obtenido universidades"+e.getMessage());
        }
        return  nombres;
    }


    public List<String> verCarreras(int idUniversidad) throws Exception {
        List<Carrera> carreras;
        List<String> nombres;
        try {
            nombres= new ArrayList<String>();
            carreras = car.getByUniversidad(idUniversidad);
            for(Carrera c : carreras)
                nombres.add(c.getNombre());


        }catch(Exception e){
            throw  new Exception("No se han obtenido carreras para la Universidad"+e.getMessage());
        }
        return  nombres;
    }


    public List<String> verAsignaturas(int idCarrera) throws Exception {
        List<Asignatura> asignaturas;
        List<String> nombres;
        try {
            nombres= new ArrayList<String>();
            asignaturas = asig.getByCarrera(idCarrera);
            for(Asignatura c : asignaturas)
                nombres.add(c.getNombre());


        }catch(Exception e){
            throw  new Exception("No se han obtenido asignaturas para la carrera"+e.getMessage());
        }
        return  nombres;
    }



    public void jugarPartida(Millonario p)
    {

    }



}
