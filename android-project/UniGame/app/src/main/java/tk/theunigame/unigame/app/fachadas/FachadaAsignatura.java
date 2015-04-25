package tk.theunigame.unigame.app.fachadas;

import java.util.ArrayList;

import juego.taes.domainmodel.Model.Cliente.Asignatura;
import juego.taes.domainmodel.Model.Cliente.Carrera;
import juego.taes.domainmodel.Model.Cliente.Universidad;


/**
 * Created by John on 22/04/2015.
 */
public class FachadaAsignatura {


    //Devuelve las asignaturas de una carrera en una universidad
    public ArrayList<Asignatura> obtenerAsignaturas(Universidad universidad, Carrera carrera){

        ArrayList<Asignatura> respuestas= new ArrayList<>();
        //
        Asignatura u1 = new Asignatura("Matemáticas Discretas");
        u1.setId(1);
        u1.setNombre("Matemáticas Discretas");
        respuestas.add(u1);
        u1= new Asignatura("Física");
        u1.setId(2);
        u1.setNombre("Física");
        respuestas.add(u1);
        u1 = new Asignatura("Lenguajes y paradigmas de programación");
        u1.setId(3);
        u1.setNombre("Lenguajes y paradigmas de programación");
        respuestas.add(u1);
        return respuestas;
    }

}
