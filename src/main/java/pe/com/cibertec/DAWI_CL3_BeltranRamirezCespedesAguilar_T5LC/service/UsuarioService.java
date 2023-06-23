package pe.com.cibertec.DAWI_CL3_BeltranRamirezCespedesAguilar_T5LC.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import pe.com.cibertec.DAWI_CL3_BeltranRamirezCespedesAguilar_T5LC.model.Usuario;
import pe.com.cibertec.DAWI_CL3_BeltranRamirezCespedesAguilar_T5LC.repository.UsuarioRepository;

@Service
public class UsuarioService {
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	private BCryptPasswordEncoder 
		bCryptPasswordEncoder = 
			new BCryptPasswordEncoder();
	
	public Usuario buscarUsuarioPorNomusuario
		(String nomUsuario) {
		return usuarioRepository
				.findByNomusuario(nomUsuario);
	}
	
	public Usuario guardarUsuario(
			Usuario usuario) {
		usuario.setPassword(
				bCryptPasswordEncoder
					.encode(usuario.getPassword()));
		usuario.setActivo(true);
		return usuarioRepository.save(usuario);
	}

}
