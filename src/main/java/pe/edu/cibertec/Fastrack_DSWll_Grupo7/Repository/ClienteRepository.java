package pe.edu.cibertec.Fastrack_DSWll_Grupo7.Repository;

import pe.edu.cibertec.Fastrack_DSWll_Grupo7.Model.bd.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
 List<Cliente> findByNombreContaining(String nombre);

}
