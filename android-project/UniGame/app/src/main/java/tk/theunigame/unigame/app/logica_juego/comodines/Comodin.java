package tk.theunigame.unigame.app.logica_juego.comodines;

import java.util.List;

import juego.taes.domainmodel.Model.Cliente.Pregunta;

/**
 * Created by Paco on 22/04/2015.
 */
public abstract class Comodin {

    protected int cantidad;
    protected Pregunta p;


    public Comodin() {
        cantidad = 1;
    }


    public abstract Pregunta usarComodin() throws Exception;



    public void setPregunta(Pregunta pregunta)
    {
        p = pregunta;
    }

    public boolean quedanComodines()
    {
        return cantidad>0;

    }


    protected void consumirComodin()
    {
        --cantidad;
    }



    public void setCantidad(int cantidad)
    {
        if(cantidad<0) throw new RuntimeException("La cantidad debe ser mayor o igual que 9");
        this.cantidad = cantidad;
    }
}
