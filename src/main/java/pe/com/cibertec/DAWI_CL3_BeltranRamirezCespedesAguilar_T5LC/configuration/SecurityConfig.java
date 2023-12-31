package pe.com.cibertec.DAWI_CL3_BeltranRamirezCespedesAguilar_T5LC.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import pe.com.cibertec.DAWI_CL3_BeltranRamirezCespedesAguilar_T5LC.service.UsuarioDetalleService;
import lombok.RequiredArgsConstructor;


@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
	
	@Autowired
	private final UsuarioDetalleService
		usuarioDetalleService;
	
	@Bean
	public SecurityFilterChain configure(HttpSecurity http) throws Exception{
		http
			.authorizeHttpRequests()
			.antMatchers("/sesion/login",
					"/sesion/registrar",
					"/sesion/guardarUsuario",
					"/resources/**",
					"/static/**",
					"/css/**",
					"/js/**")
			.permitAll()
			.anyRequest()
			.authenticated()
			.and()
			.formLogin().loginPage("/sesion/login")
			.usernameParameter("txtusuario")
			.passwordParameter("txtpassword")
			.defaultSuccessUrl("/home")
			.failureUrl("/sesion/login?error=true")
			.and()
			.logout()
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
			.logoutSuccessUrl("/sesion/login").and()
			.exceptionHandling()
			.accessDeniedPage("/access-denied")
			.and()
			.authenticationProvider(
					authenticationProvider());
		return http.build();
		
	}
	
	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(usuarioDetalleService);
		authenticationProvider.setPasswordEncoder(new BCryptPasswordEncoder());
		return authenticationProvider;
	}	
}
