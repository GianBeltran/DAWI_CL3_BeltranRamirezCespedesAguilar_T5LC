package pe.com.cibertec.DAWI_CL3_BeltranRamirezCespedesAguilar_T5LC.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.com.cibertec.DAWI_CL3_BeltranRamirezCespedesAguilar_T5LC.model.Usuario;
import pe.com.cibertec.DAWI_CL3_BeltranRamirezCespedesAguilar_T5LC.service.UsuarioService;


@Controller
@RequestMapping("/sesion")
public class SesionController {
	@Autowired
	private UsuarioService usuarioService;
	@GetMapping("/login")
	public String login() {
		return "sesion/frmLogin";
	}
	@GetMapping("/registrar")
	public String registrar() {
		return "sesiob/frmRegistro";
	}
	@PostMapping("/guardarUsuario")
	public String guardarUsuario(@ModelAttribute Usuario usuario, Model model) {
		usuarioService.guardarUsuario(usuario);
		model.addAttribute("registroCorrecto", true);
		return "sesion/frmRegistro";
	}
}
