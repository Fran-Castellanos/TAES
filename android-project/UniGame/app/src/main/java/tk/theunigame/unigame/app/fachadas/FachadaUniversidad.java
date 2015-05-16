package tk.theunigame.unigame.app.fachadas;

import android.content.Context;

import java.lang.reflect.Array;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import juego.taes.domainmodel.Model.Cliente.Carrera;
import juego.taes.domainmodel.Model.Cliente.Universidad;
import juego.taes.domainmodel.Repository.CarreraRepository;
import juego.taes.domainmodel.Repository.UniversidadRepository;


/**
 * Created by John on 22/04/2015.
 */
public class FachadaUniversidad {


    public List<Universidad> obtenerUniversidades(Context context) throws SQLException {

        return  getUniversidades(context, true);
    }


    public List<Universidad> obtenerUniversidadesNoVacios(Context context) throws SQLException {

        return  getUniversidades(context, false);
    }

    /**
     * Devuelve lista de todas las universidades.
     * @param c Objeto Context
     * @return Lista de todas las universidades.
     * @throws Exception
     */
    public List<Universidad> getUniversidades(Context c, boolean mostrarTodos) throws SQLException {

        List<Universidad> universidades;
        UniversidadRepository uni= new UniversidadRepository(c);
        universidades = uni.getAll();

        try {


            ArrayList<Integer> aBorrar = new ArrayList<Integer>();

            FachadaCarrera car = new FachadaCarrera();
            CarreraRepository carreraR = new CarreraRepository(c);
            List<Carrera> carreras = null;
            int i = 0;
            for(Universidad univ : universidades)
            {
                if(mostrarTodos)
                    carreras = carreraR.getByUniversidad(univ.getId());
                else
                    carreras = car.getCarreras(c,univ.getId(),mostrarTodos);
                if(carreras.size() == 0)
                {
                    aBorrar.add(i);
                }
                ++i;
            }

            i = aBorrar.size()-1;

            while(i>=0)
            {
                universidades.remove((int)aBorrar.get(i));
                --i;
            }


        }catch(SQLException e){
            throw  e;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  universidades;
    }

}
