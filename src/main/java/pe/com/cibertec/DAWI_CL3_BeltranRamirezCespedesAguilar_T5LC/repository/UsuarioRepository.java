package pe.com.cibertec.DAWI_CL3_BeltranRamirezCespedesAguilar_T5LC.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.com.cibertec.DAWI_CL3_BeltranRamirezCespedesAguilar_T5LC.model.Usuario;

@Repository
public interface UsuarioRepository extends
 JpaRepository<Usuario, Integer>{
	
	Usuario findByEmail(String email);
	
	Usuario findByNomusuario(String username);

}
