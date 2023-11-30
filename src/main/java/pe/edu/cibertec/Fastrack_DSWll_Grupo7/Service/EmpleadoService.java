package pe.edu.cibertec.Fastrack_DSWll_Grupo7.Service;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.Fastrack_DSWll_Grupo7.Model.bd.Empleado;
import pe.edu.cibertec.Fastrack_DSWll_Grupo7.Repository.EmpleadoRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmpleadoService {

    private final EmpleadoRepository empleadoRepository;

    public List<Empleado> listaEmpleados() {
        return empleadoRepository.findAll();
    }

    public Empleado registrarEmpleado(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    public Optional<Empleado> obtenerEmpleadoPorId(Integer id) {
        return empleadoRepository.findById(id);
    }

    public void eliminarEmpleado(Integer id) {
        empleadoRepository.deleteById(id);
    }
    public List<Empleado> obtenerEmpleadosPorNombre(String nombre) {
        return empleadoRepository.findByNombreContaining(nombre);
    }
}
