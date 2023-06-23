package pe.com.cibertec.DAWI_CL3_BeltranRamirezCespedesAguilar_T5LC.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import pe.com.cibertec.DAWI_CL3_BeltranRamirezCespedesAguilar_T5LC.model.Usuario;

@Service
public class UsuarioDetalleService 
	implements UserDetailsService {
	
	@Autowired
	private UsuarioService usuarioService;
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = 
				usuarioService
				.buscarUsuarioPorNomusuario(username);		
		return usuarioPorAutenticacion(usuario);
	}
	

}
