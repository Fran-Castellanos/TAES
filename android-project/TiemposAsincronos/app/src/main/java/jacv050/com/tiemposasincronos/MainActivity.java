package jacv050.com.tiemposasincronos;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {

    Tiempo tiempo;

    Button btn_iniciar;
    Button btn_pausar;
    Button btn_reiniciar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tiempo = (Tiempo) findViewById(R.id.tiempo);

        btn_iniciar= (Button) findViewById(R.id.btn_iniciar);
        btn_iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tiempo.onContinuar();
            }
        });

        btn_pausar= (Button) findViewById(R.id.btn_pausar);
        btn_pausar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tiempo.onParar();
            }
        });

        btn_reiniciar = (Button) findViewById(R.id.btn_reiniciar);
        btn_reiniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tiempo.onReiniciar();
            }
        });
        //tiempoTask.onContinuar();
        //setCont
        //addContentView(tiempo, null);

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
