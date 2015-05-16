package tk.theunigame.unigame.app.fachadas;

import android.content.Context;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import juego.taes.domainmodel.Model.Cliente.Asignatura;
import juego.taes.domainmodel.Model.Cliente.Carrera;
import juego.taes.domainmodel.Model.Cliente.Universidad;
import juego.taes.domainmodel.Repository.AsignaturaRepository;
import juego.taes.domainmodel.Repository.CarreraRepository;


/**
 * Created by John on 22/04/2015.
 */
public class FachadaCarrera {

    //Devolverá las carreras que oferte la universidad pasada por parámetro
    public ArrayList<Carrera> obtenerCarreras(Context context, Universidad universidad) throws SQLException {

        return (ArrayList<Carrera>)getCarreras(context, universidad.getId(),true);
    }

    public FachadaCarrera()
    {}


    /**
     * Devuelve una lista de todas las carreras dentro de una universidad.
     * @param c Objeto Context
     * @param idUniversidad ID de la Universidad.
     * @return Lista de carreras de la Universidad.
     * @throws Exception
     */
    public List<Carrera> getCarreras(Context c, int idUniversidad, boolean mostrarTodos) throws SQLException {
        List<Carrera> carreras;

        try{

            CarreraRepository car= new CarreraRepository(c);
            carreras = car.getByUniversidad(idUniversidad);


            FachadaAsignatura fachadaAsignatura = new FachadaAsignatura();
            AsignaturaRepository asig = new AsignaturaRepository(c);

            ArrayList<Integer> aBorrar = new ArrayList<Integer>();
            int i = 0;
            List<Asignatura> listaAsignaturas = null;
            for(Carrera carrera : carreras)
            {
                if(mostrarTodos)
                    listaAsignaturas = asig.getByCarrera(carrera.getId());
                else
                    listaAsignaturas = fachadaAsignatura.getAsignaturas(c,carrera.getId(),mostrarTodos);
                
                if(listaAsignaturas.size() == 0)
                {
                    aBorrar.add(i);
                }
                ++i;
            }

            i = aBorrar.size()-1;

            while(i>=0)
            {
                carreras.remove((int)aBorrar.get(i));
                --i;
            }


        }catch(SQLException e){
            throw  new SQLException("No se han obtenido carreras para la Universidad"+e.getMessage());
        }
        return  carreras;
    }



    //Devolverá las carreras que oferte la universidad pasada por parámetro
    public ArrayList<Carrera> obtenerCarrerasNoVacias(Context context, Universidad universidad) throws SQLException {

        return (ArrayList<Carrera>)getCarreras(context, universidad.getId(),false);
    }


}
