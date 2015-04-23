package tk.theunigame.unigame.app.logica_juego.comodines;

import java.util.List;

import juego.taes.domainmodel.Model.Cliente.Pregunta;

/**
 * Created by Paco on 22/04/2015.
 */
public abstract class Comodin {

    protected int cantidad;


    public Comodin()
    {
        cantidad=0;
    }
    public abstract Pregunta usarComodin(List<Pregunta> preguntas,Pregunta p) throws Exception;

    public boolean quedanComodines()
    {
        return cantidad>0;

    }
    public abstract boolean comodinDisponible();

    public void setCantidad(int cantidad)
    {
        if(cantidad<0) throw new RuntimeException("La cantidad debe ser mayor o igual que 9");
        this.cantidad = cantidad;
    }
}
