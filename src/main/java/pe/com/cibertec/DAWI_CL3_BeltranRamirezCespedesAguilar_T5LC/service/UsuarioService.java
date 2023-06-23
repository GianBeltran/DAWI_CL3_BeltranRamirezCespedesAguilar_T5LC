package com.pe.cibertec.DAWI_CL3_BeltranRamirezCespedesAguilar_T5LC.service;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.pe.cibertec.DAWI_CL3_BeltranRamirezCespedesAguilar_T5LC.modelo.bd.Rol;
import com.pe.cibertec.DAWI_CL3_BeltranRamirezCespedesAguilar_T5LC.modelo.bd.Usuario;
import com.pe.cibertec.DAWI_CL3_BeltranRamirezCespedesAguilar_T5LC.repository.RolRepository;
import com.pe.cibertec.DAWI_CL3_BeltranRamirezCespedesAguilar_T5LC.repository.UsuarioRepository;

@Service
public class UsuarioService {
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private RolRepository rolRepository;
	
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
		Rol rol = rolRepository
				.findByNomrol("ADMIN");
		usuario.setRoles(new HashSet<Rol>(
				Arrays.asList(rol)));
		return usuarioRepository.save(usuario);
	}

}
