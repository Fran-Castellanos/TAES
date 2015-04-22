package tk.theunigame.unigame.app.logica_juego.comodines;

/**
 * Created by Paco on 22/04/2015.
 */
public abstract class Comodin {

    protected int cantidad;


    public abstract void usarComodin();

    public boolean quedanComodines()
    {
        return cantidad>0;

    }

    public void setCantidad(int cantidad)
    {
        if(cantidad<0) throw new RuntimeException("La cantidad debe ser mayor o igual que 9");
        this.cantidad = cantidad;
    }
}
