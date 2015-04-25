package tk.theunigame.unigame.app.fachadas;

import java.util.ArrayList;
import java.util.Objects;

import juego.taes.domainmodel.Model.Cliente.Asignatura;
import juego.taes.domainmodel.Model.Cliente.Carrera;
import juego.taes.domainmodel.Model.Cliente.Universidad;
import tk.theunigame.unigame.app.presentacion.util.Comunicador;

/**
 * Created by John on 25/04/2015.
 *
 * El envío de objetos se realizará dentro de un vector de Objetc.
 */
public class FachadaComunicador {

    //Prepara una universidad para ser recibida por otra activity
    public void ComunicarUniversidad(Universidad u){
        Comunicador.setObject(new Object[]{u});
    }

    //Prepara universidad y carrera para ser recibida por otra activity
    public void ComunicarUniversidadCarrera(Universidad u, Carrera c){
        Comunicador.setObject(new Object[]{u, c});
    }

    //Prepara una universidad, carrera y asignatura para ser recibida por otra activity
    public void ComunicarUniversidadCarreraAsignatura(Universidad u, Carrera c, Asignatura a){
        Comunicador.setObject(new Object[]{u, c, a});
    }

    //Prepara una universidad, carrera y asignaturas para ser recibida por otra activity
    public void ComunicarUniversidadCarreraAsignaturas(Universidad u, Carrera c, ArrayList<Asignatura> a){
        Comunicador.setObject(new Object[]{u, c, a});
    }

    //Recupera una universidad enviada en la posición 0
    public Universidad RecibirUniversidadPosicion0(){
        return (Universidad)((Object[])Comunicador.getObject())[0];
    }

    //Recupera una carrera enviada en la posición 1
    public Carrera RecibirCarreraPosicion1(){
        return (Carrera)((Object[])Comunicador.getObject())[1];
    }

    //Recupera una asignatura enviada en la posición 2
    public Asignatura RecibirAsignaturaPosicion2(){
        return (Asignatura)((Object[])Comunicador.getObject())[2];
    }

    //Recupera un aray de asignaturas enviada en la posición 2
    public ArrayList<Asignatura> RecibirAsignaturasPosicion2(){
        return (ArrayList<Asignatura>)((Object[])Comunicador.getObject())[2];
    }
}
