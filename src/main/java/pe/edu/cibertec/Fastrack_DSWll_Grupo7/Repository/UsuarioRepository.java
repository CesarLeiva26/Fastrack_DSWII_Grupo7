package pe.edu.cibertec.Fastrack_DSWll_Grupo7.Repository;

import pe.edu.cibertec.Fastrack_DSWll_Grupo7.Model.bd.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends
        JpaRepository<Usuario, Integer> {

   Usuario findByNomusuario(String nomusuario);
}
