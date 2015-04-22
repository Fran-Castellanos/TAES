package tk.theunigame.unigame.app.presentacion.util;

/**
 * Created by John on 22/04/2015.
 */
public class Comunicador {
    private static Object object= null;

    public static Object getObject() {
        return object;
    }

    public static void setObject(Object obj) {
        object = obj;
    }
}
