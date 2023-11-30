package pe.edu.cibertec.Fastrack_DSWll_Grupo7.Service;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.Fastrack_DSWll_Grupo7.Model.bd.TipoEmpleado;
import pe.edu.cibertec.Fastrack_DSWll_Grupo7.Repository.TipoEmpleadoRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TipoEmpleadoService {

    private final TipoEmpleadoRepository tipoEmpleadoRepository;

    public List<TipoEmpleado> listaTiposEmpleados() {
        return tipoEmpleadoRepository.findAll();
    }

    public TipoEmpleado registrarTipoEmpleado(TipoEmpleado tipoEmpleado) {
        return tipoEmpleadoRepository.save(tipoEmpleado);
    }

    public Optional<TipoEmpleado> obtenerTipoEmpleadoPorId(Integer id) {
        return tipoEmpleadoRepository.findById(id);
    }

    public void eliminarTipoEmpleado(Integer id) {
        tipoEmpleadoRepository.deleteById(id);
    }
}
