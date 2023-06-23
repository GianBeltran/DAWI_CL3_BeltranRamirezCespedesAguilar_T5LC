package pe.com.cibertec.DAWI_CL3_BeltranRamirezCespedesAguilar_T5LC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	@GetMapping("/home")
	public String home() {
		return "home";
	}
}
