package tk.theunigame.unigame.app.logica_juego.juego;

import tk.theunigame.unigame.app.logica_juego.comodines.ModoJuego;

/**
 * Created by Paco on 23/04/2015.
 */
public class JuegoFactory {
    private static JuegoFactory ourInstance = new JuegoFactory();

    public static JuegoFactory getInstance() {
        return ourInstance;
    }

    private JuegoFactory() {
    }


    public static Millonario getMillonario()
    {
        return new Millonario();
    }


    public static IModoJuego getJuego(ModoJuego modo) {
        switch (modo)
        {
            case MILLONARIO:
                return getMillonario();

            default:
                return null;

        }


    }






}
