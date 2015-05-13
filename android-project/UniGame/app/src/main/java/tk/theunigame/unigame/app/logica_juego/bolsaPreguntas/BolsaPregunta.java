package tk.theunigame.unigame.app.logica_juego.bolsaPreguntas;
import android.content.Context;

import com.j256.ormlite.dao.ForeignCollection;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import juego.taes.domainmodel.Model.Cliente.BDPreguntas;
import juego.taes.domainmodel.Model.Cliente.Pregunta;
import juego.taes.domainmodel.Repository.BDPreguntasRepository;

public class BolsaPregunta {

    private ArrayList<Pregunta> preguntas_eliminadas;
    private ArrayList<Pregunta> preguntas_modificadas;
    private ArrayList<Pregunta> preguntas_creadas;
    private BDPreguntas pBDPreguntas;
    private ArrayList<Pregunta> pPreguntas;

    /**********************************************************************************************/
    private static BolsaPregunta sInstance = null;//Objeto session

    private BolsaPregunta()//Privado para el objeto session
    {
        preguntas_creadas = new ArrayList<Pregunta>();
        preguntas_eliminadas = new ArrayList<Pregunta>();
        preguntas_modificadas = new ArrayList<Pregunta>();
    }

    public static void init() {
        sInstance = new BolsaPregunta();
    }

    public static BolsaPregunta getInstance()
    {
        if(sInstance == null)//La primera vez que llamo a la clase inicializo la clase si es null
            init();
        return sInstance;
    }
    /**********************************************************************************************/
    public ArrayList<Pregunta> DevolverPreguntasEnBD()
    {
        return pPreguntas;
    }
    public ArrayList<Pregunta> DevolverPreguntasCreadas()
    {
        return preguntas_creadas;
    }
    public ArrayList<Pregunta> DevolverPreguntasModificadas()
    {
        return preguntas_modificadas;
    }
    public ArrayList<Pregunta> DevolverPreguntasBorradas()
    {
        return preguntas_eliminadas;
    }
    public ArrayList<Pregunta> DevolverListadoPreguntas()
    {
        ArrayList<Pregunta> pregts = new ArrayList<Pregunta>();
        pregts.addAll(pPreguntas);
        pregts.addAll(preguntas_creadas);
        return pregts;
    }

    public void SetBDPreguntas(BDPreguntas bd)
    {
        pBDPreguntas = bd;
        pPreguntas = new ArrayList<Pregunta>(bd.getPreguntas());
    }
    public BDPreguntas getBDPreguntas()
    {
        return pBDPreguntas;
    }

    public void InsertarPregunta(Pregunta pregunta)
    {
        pregunta.setBdPreguntas(pBDPreguntas);
        pregunta.setId((preguntas_creadas.size() + 1)*(-1));//Setteo su id a un valor negativo
        preguntas_creadas.add(pregunta);
    }

    public void EliminarPregunta(Pregunta pregunta)
    {
        if(pregunta.getBdPreguntas().getId() == pBDPreguntas.getId()) {
            if (preguntas_creadas.contains(pregunta)) {
                int pos = (pregunta.getId() * (-1)) - 1;
                preguntas_creadas.remove(pregunta);

                if (pos < preguntas_creadas.size()) { //Si la posicion borrada no es la última
                    //Cambiar todos los Ids
                    for (int i = pos; i < preguntas_creadas.size(); i++) {
                        preguntas_creadas.get(i).setId((i + 1) * (-1));//Setteo su id a un valor negativo
                    }
                }
            } else if (pPreguntas.contains(pregunta))
                preguntas_eliminadas.add(pregunta);
        }
    }

    public void ModificarPreguntaInsertada(Pregunta pregunta)
    {
        if(pregunta.getBdPreguntas().getId() == pBDPreguntas.getId()) {
            if (preguntas_creadas.contains(pregunta)) {
                preguntas_creadas.remove(pregunta);
                preguntas_creadas.add(pregunta);
            } else if (pPreguntas.contains(pregunta))
                preguntas_modificadas.add(pregunta);
        }
    }

    public void RegistrarCambios(Context cont) throws SQLException {
        //Repositorys
        BDPreguntasRepository bDRepository = new BDPreguntasRepository(cont);
        bDRepository.GuardarCambios(pBDPreguntas,preguntas_creadas,preguntas_modificadas,preguntas_eliminadas);

        //Vaciar el contenido de las listas una vez registrado en la BD
        preguntas_creadas.clear();
        preguntas_eliminadas.clear();
        preguntas_modificadas.clear();
    }

    public void VaciarBD(){
        //Vaciar el contenido de las listas una vez registrado en la BD
        preguntas_creadas.clear();
        preguntas_eliminadas.clear();
        preguntas_modificadas.clear();
    }

    public Boolean hayCambios()
    {
        if(preguntas_creadas.size()>0 || preguntas_eliminadas.size()>0 || preguntas_modificadas.size()>0)
        {
            return true;
        }
        return false;
    }

    public String getCambiosRealizados()
    {
        return "Creadas: "+preguntas_creadas.size()+
                "\nModificadas: "+preguntas_modificadas.size()+
                "\nEliminadas: "+preguntas_eliminadas.size();
    }
}
