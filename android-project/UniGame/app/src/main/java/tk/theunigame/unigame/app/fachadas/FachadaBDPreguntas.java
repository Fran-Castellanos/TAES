package tk.theunigame.unigame.app.fachadas;
import android.content.Context;

import com.j256.ormlite.dao.ForeignCollection;

import java.util.ArrayList;

import juego.taes.domainmodel.Model.Cliente.Asignatura;
import juego.taes.domainmodel.Model.Cliente.BDPreguntas;
import juego.taes.domainmodel.Model.Cliente.Carrera;
import juego.taes.domainmodel.Model.Cliente.Pregunta;
import juego.taes.domainmodel.Model.Cliente.Universidad;
import juego.taes.domainmodel.Repository.BDPreguntasRepository;

/**
 * Created by Pedro on 21/04/2015.
 */
public class FachadaBDPreguntas {

    BDPreguntasRepository bd;
    public BDPreguntas recuperarBDPreguntas(Context c, int id)
    {
        bd = new BDPreguntasRepository(c);
        return bd.getById(id);
    }

    public ForeignCollection<Pregunta> obtenerPreguntas(int carreraID, int asignaturaID, boolean buscarEnTodaBD)
    {
        throw new RuntimeException("Not implemented yet");
    }

    public void crearBaseDatos(String nombre,Context c){
        bd = new BDPreguntasRepository(c);
        bd.create((new BDPreguntas(nombre,false)));
    }

    //Devuelve las asignaturas de una carrera en una universidad
    public ArrayList<BDPreguntas> obtenerBasesDatos(Universidad universidad, Carrera carrera, ArrayList<Asignatura> asignaturas){

        ArrayList<BDPreguntas> respuestas= new ArrayList<>();
        //
        BDPreguntas u1 = new BDPreguntas("BD de Jaimito",false);
        u1.setId(1);
        u1.setNombre("BD de Jaimito");
        respuestas.add(u1);
        u1= new BDPreguntas("BD de Juan",false);
        u1.setId(2);
        u1.setNombre("BD de Juan");
        respuestas.add(u1);
        u1 = new BDPreguntas("BD de RITO",false);
        u1.setId(3);
        u1.setNombre("BD de RITO");
        respuestas.add(u1);
        return respuestas;
    }
}
