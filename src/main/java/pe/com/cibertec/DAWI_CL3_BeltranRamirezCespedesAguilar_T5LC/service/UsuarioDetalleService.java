package pe.com.cibertec.DAWI_CL3_BeltranRamirezCespedesAguilar_T5LC.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import pe.com.cibertec.DAWI_CL3_BeltranRamirezCespedesAguilar_T5LC.model.Usuario;

@Service
public class UsuarioDetalleService implements UserDetailsService {

    @Autowired
    private UsuarioService usuarioService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioService.buscarUsuarioPorNomusuario(username);
        return usuarioPorAutenticacion(usuario);
    }

    private UserDetails usuarioPorAutenticacion(Usuario usuario) {
        return new User(usuario.getNomusuario(), usuario.getPassword(), usuario.getActivo(), true, true, true,
                Collections.emptyList());
    }
}
