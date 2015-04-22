package jacv050.com.tiemposasincronos;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by John on 21/04/2015.
 */
public class TiempoAsyncTask extends TextView implements OnTiempoListener{
    //Listener para interactuar con el tiempo
    private MyAsyncTask mytask;
    public TiempoAsyncTask(Context context){
        super(context);
        setText("0");
        mytask= new MyAsyncTask(this);
    }

    public TiempoAsyncTask(Context context, AttributeSet attr, int defStyle){
        super(context, attr, defStyle);
        setText("0");
        mytask= new MyAsyncTask(this);
    }

    public TiempoAsyncTask(Context context, AttributeSet attr){
        super(context, attr);
        setText("0");
        mytask= new MyAsyncTask(this);
    }


    @Override
    public void onParar() {
        mytask.cancel(true);
    }

    @Override
    public void onContinuar() {
        if(mytask.isCancelled()) {
            mytask.cancel(false);
            mytask.execute();
        }
    }

    @Override
    public void onReiniciar() {
        this.setText(0);
    }


}
