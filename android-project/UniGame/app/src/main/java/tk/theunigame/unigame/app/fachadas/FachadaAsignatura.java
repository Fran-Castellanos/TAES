package tk.theunigame.unigame.app.fachadas;

import android.content.Context;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import juego.taes.domainmodel.Model.Cliente.Asignatura;
import juego.taes.domainmodel.Model.Cliente.Carrera;
import juego.taes.domainmodel.Model.Cliente.Universidad;
import juego.taes.domainmodel.Repository.AsignaturaRepository;


/**
 * Created by John on 22/04/2015.
 */
public class FachadaAsignatura {

    //Devuelve las asignaturas de una carrera en una universidad
    public ArrayList<Asignatura> obtenerAsignaturas(Context context, Universidad universidad, Carrera carrera) throws SQLException {
        return (ArrayList<Asignatura>)getAsignaturas(context, carrera.getId());
    }

    /**
     * Devuelve una lista de asignaturas de una carrera concreta.
     * @param c Objeto Context
     * @param idCarrera ID de la carrera.
     * @return Lista de asignaturas de una carrera.
     * @throws Exception
     */
    public List<Asignatura> getAsignaturas(Context c, int idCarrera) throws SQLException {
        List<Asignatura> asignaturas;
        AsignaturaRepository asig = new AsignaturaRepository(c);
        asignaturas = asig.getByCarrera(idCarrera);
        try {



            FachadaBDPreguntas bd = new FachadaBDPreguntas();
            ArrayList<Integer> aBorrar = new ArrayList<Integer>();

            /*
            int i = 0;
            for(Asignatura asignatura : asignaturas)
            {

                if( bd.getBDPreguntasTodasUnis(c, asignatura.getId()).size() == 0)
                {
                    aBorrar.add(i);
                }
                ++i;
            }

            i = aBorrar.size()-1;

            while(i>=0)
            {
                asignaturas.remove((int)aBorrar.get(i));
                --i;
            }


        }catch(SQLException e){
            throw  new SQLException("No se han obtenido asignaturas para la carrera"+e.getMessage());

            */
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  asignaturas;
    }

}
