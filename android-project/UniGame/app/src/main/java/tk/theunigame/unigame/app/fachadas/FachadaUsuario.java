package tk.theunigame.unigame.app.fachadas;

import juego.taes.domainmodel.Model.Cliente.Sexo;
import android.content.Context;

import java.sql.SQLException;

import juego.taes.domainmodel.Model.Cliente.Usuario;
import juego.taes.domainmodel.Repository.UsuarioRepository;

/**
 * Created by Paco on 23/04/2015.
 */
public class FachadaUsuario {



    public FachadaUsuario()
    {}


    public Usuario loguear(Context c, String nick, String pass) throws SQLException {
        UsuarioRepository usu_rep = new UsuarioRepository(c);
        Usuario usu = usu_rep.getByNick(nick);

        if(usu == null)
            return null;


        if(usu.getLoginOffline())
            return usu;
        else
            return null;

    }


    public int registrarse(Context c, String nick, String nombre, String apellidos, Sexo sexo) throws Exception {
        if(nick.isEmpty() || nombre.isEmpty() || apellidos.isEmpty()) throw new Exception("Error en el registro");


        UsuarioRepository usu_rep = new UsuarioRepository(c);
        Usuario usu = new Usuario();
        usu.setNick(nick);
        usu.setNombre(nombre);
        usu.setApellidos(apellidos);
        usu.setSexo(sexo);
        usu.setLoginOffline(true);

        try {
            return usu_rep.create(usu);
        }catch(Exception e)
        {
            throw new Exception("No se ha podido crear el usuario. " + e.getMessage());
        }

    }
}
