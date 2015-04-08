package tk.theunigame.unigame.app.presentacion.controlador.impl;

import tk.theunigame.unigame.R;
import tk.theunigame.unigame.util.SystemUiHider;

import android.app.Activity;
import android.os.Bundle;


/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 *
 * @see SystemUiHider
 */
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_crear_db);
        //findViewById(R.id.dummy_button).setOnTouchListener(mDelayHideTouchListener);
    }


}
