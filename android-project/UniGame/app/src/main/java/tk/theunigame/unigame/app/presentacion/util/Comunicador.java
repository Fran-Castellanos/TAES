package tk.theunigame.unigame.app.presentacion.util;

import java.util.ArrayList;
import java.util.List;

import juego.taes.domainmodel.Model.Cliente.Usuario;

/**
 * Created by John on 22/04/2015.
 */
public class Comunicador {
    private static Object object= null;
    private static Usuario usuario = null;
    private static List<Object> listaComunicadores = new ArrayList<Object>();
    public static Object getObject() {
        return object;
    }

    public static void setObject(Object obj) {
        object = obj;
        listaComunicadores.add(obj);
    }

    public static Usuario getUsuario()
    {
        return usuario;
    }

    public static void setUsuario(Usuario usu)
    {
        usuario = usu;
    }

    public static void limpiarHistoria()
    {
        listaComunicadores.clear();
        object = null;
    }
    public static Object getObjectAnterior()
    {
        int L = listaComunicadores.size()-1;
        if(L>0)
            listaComunicadores.remove(listaComunicadores.get(L));
        L = listaComunicadores.size()-1;
        if(L>0)
            object = listaComunicadores.get(L);
        else
            object = null;

        return object;
    }


}
