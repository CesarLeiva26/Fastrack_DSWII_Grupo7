package pe.edu.cibertec.Fastrack_DSWll_Grupo7.Service;

import pe.edu.cibertec.Fastrack_DSWll_Grupo7.Exception.ResourceNotFoundException;
import pe.edu.cibertec.Fastrack_DSWll_Grupo7.Model.bd.Cliente;
import pe.edu.cibertec.Fastrack_DSWll_Grupo7.Repository.ClienteRepository;
import pe.edu.cibertec.Fastrack_DSWll_Grupo7.Repository.HistorialPagoRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;
private final HistorialPagoRepository historialPagoRepository;
    public List<Cliente> listaClientes() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> obtenerClientePorId(Integer id) {
        return clienteRepository.findById(id);
    }

    public List<Cliente> obtenerEmpleadosPorNombre(String nombre){
        return clienteRepository.findByNombreContaining(nombre);
    }

    @Transactional
    public Cliente guardarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Transactional
    public void eliminarClienteConHistorial(Integer id) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("El cliente con el ID " + id + " no existe"));
        historialPagoRepository.deleteByClienteId(id);
        clienteRepository.delete(cliente);
    }

}