package tk.theunigame.unigame.app.logica_juego.juego;

/**
 * Created by Gio on 28/04/2015.
 */
public class Estadisticas {
    //Preguntas acertadas
    private int acertadas;
    //Preguntas falladas;
    private int falladas;
    //Comodines usados
    private int comodines;

    public Estadisticas()
    {
        acertadas=0;
        falladas=0;
        comodines=0;
    }

    public void sumarAcertadas()
    {
        ++acertadas;
    }

    public void sumarFalladas()
    {
        ++falladas;
    }

    public int getAcertadas()
    {
        return acertadas;
    }

    public int getFalladas()
    {
        return falladas;
    }

    public void sumarComodinesUsados()
    {
        ++comodines;
    }
    public int getComodinesUsados(){
        return comodines;
    }


}
