package tk.theunigame.unigame.app.presentacion.controlador.impl;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import juego.taes.domainmodel.Data.DatabaseManager;
import juego.taes.domainmodel.Model.Cliente.Sexo;
import juego.taes.domainmodel.Model.Cliente.Usuario;
import tk.theunigame.unigame.R;
import tk.theunigame.unigame.app.fachadas.FachadaUsuario;


/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 *
 * @see tk.theunigame.unigame.util.SystemUiHider
 */
public class Registry extends Activity {

    private Button btn_registry;
    private Button btn_cancel;
    private FachadaUsuario fachadaUsuario;
    private EditText et_username, et_password, et_nombre, et_apellidos;
    private Spinner sp_sexo;
    private Sexo s;
    private Context c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_registry);

        DatabaseManager manager = new DatabaseManager();
        manager.getHelper(this).getWritableDatabase();

        c = this;
        fachadaUsuario = new FachadaUsuario();

        btn_registry = (Button) findViewById(R.id.btn_registry);
        btn_cancel = (Button) findViewById(R.id.btn_cancel);

        et_username = (EditText) findViewById(R.id.username);
        et_password = (EditText) findViewById(R.id.password);
        et_nombre = (EditText) findViewById(R.id.nombre);
        et_apellidos = (EditText) findViewById(R.id.apellidos);
        sp_sexo = (Spinner) findViewById(R.id.sexo);

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.sexo, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        sp_sexo.setAdapter(adapter);



        btn_registry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sp_sexo.getSelectedItemId() == 0)
                    s = Sexo.MUJER;
                else
                    s = Sexo.HOMBRE;


                String nick = et_username.getText().toString();
                String nombre = et_nombre.getText().toString();
                String apellidos = et_apellidos.getText().toString();
                ProgressDialog dialog = ProgressDialog.show(Registry.this, "",
                        "Registrando usuario...", true);




                 AlertDialog.Builder builder = new AlertDialog.Builder(c);
                boolean correcto = true;
                try {
                   fachadaUsuario.registrarse(c,nick,nombre,apellidos,s);
                }catch (Exception e) {
                    correcto = false;
                }
                if(!correcto) {
                    builder.setMessage("No se ha podido crear la cuenta de usuario").
                            setTitle("Registro de usuario denegado").setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });

                    builder.create().show();
                }
                else
                {

                    builder.setMessage("¡Se ha creado la cuenta de usuario!").
                        setTitle("Usuario registrado").setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                        Intent intent = new Intent(Registry.this, LoginMain.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                        startActivity(intent);
                    }
                });
                    builder.create().show();

                }
                dialog.cancel();

            }

        });

        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }


    @Override
    public void onBackPressed() {


        super.onBackPressed();
    }

}
