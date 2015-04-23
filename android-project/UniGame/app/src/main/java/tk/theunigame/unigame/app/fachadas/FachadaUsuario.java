package tk.theunigame.unigame.app.fachadas;

import android.content.Context;

import juego.taes.domainmodel.Model.Cliente.Usuario;
import juego.taes.domainmodel.Repository.UsuarioRepository;

/**
 * Created by Paco on 23/04/2015.
 */
public class FachadaUsuario {



    public FachadaUsuario()
    {}


    public Usuario loguear(Context c, String nick, String pass)
    {
        UsuarioRepository usu_rep = new UsuarioRepository();
        Usuario usu = usu_rep.getByNick(nick);



        throw new RuntimeException("Not implemented yet");
    }



    public int registrarse(Context c, String nick, String nombre, String apellidos, Usuario.Sexo sexo) throws Exception {
        UsuarioRepository usu_rep = new UsuarioRepository();
        Usuario usu = new Usuario();
        usu.setNick(nick);
        usu.setNombre(nombre);
        usu.setApellidos(apellidos);
        usu.setSexo(sexo);

        try {
            return usu_rep.create(usu);
        }catch(Exception e)
        {
            throw new Exception("No se ha podido crear el usuario. " + e.getMessage());
        }

    }
}
