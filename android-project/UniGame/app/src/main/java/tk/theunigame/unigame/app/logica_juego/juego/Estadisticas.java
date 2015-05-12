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

    private int numPreguntas;

    private double nota;

    public Estadisticas()
    {
        acertadas=0;
        falladas=0;
        comodines=0;
        numPreguntas=0;
    }

    public void sumarAcertadas()
    {
        ++acertadas; ++numPreguntas;
        calcularNota();
    }

    public void sumarFalladas()
    {
        ++falladas;++numPreguntas;
        calcularNota();
    }

    public int getAcertadas()
    {
        return acertadas;
    }

    public int getFalladas()
    {
        return falladas;
    }

    public int getNumPreguntas()
    {
        return numPreguntas;
    }

    public void sumarComodinesUsados()
    {
        ++comodines;
    }
    public int getComodinesUsados(){
        return comodines;
    }


    public void calcularNota()
    {
        nota = ((double)acertadas/numPreguntas) * 10.0;

    }

    public double getNota() {
        double n = Math.round(nota * 100);
        n = n/100;
        return n;
    }

}

