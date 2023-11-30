package pe.edu.cibertec.Fastrack_DSWll_Grupo7.Repository;

import pe.edu.cibertec.Fastrack_DSWll_Grupo7.Model.bd.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado,Integer> {
    List<Empleado> findByNombreContaining(String nombre);

}
