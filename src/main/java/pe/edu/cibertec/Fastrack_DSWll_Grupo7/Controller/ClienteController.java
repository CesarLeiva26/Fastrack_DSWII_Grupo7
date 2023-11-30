package pe.edu.cibertec.Fastrack_DSWll_Grupo7.Controller;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.Fastrack_DSWll_Grupo7.Exception.ResourceNotFoundException;
import pe.edu.cibertec.Fastrack_DSWll_Grupo7.Model.bd.Cliente;
import pe.edu.cibertec.Fastrack_DSWll_Grupo7.Model.bd.HistorialPago;
import pe.edu.cibertec.Fastrack_DSWll_Grupo7.Model.request.ClienteRequest;
import pe.edu.cibertec.Fastrack_DSWll_Grupo7.Service.ClienteService;
import pe.edu.cibertec.Fastrack_DSWll_Grupo7.Service.HistorialPagoService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/cliente")
public class ClienteController {

    private ClienteService clienteService;
    private HistorialPagoService historialPagoService;


    @GetMapping("")
    public ResponseEntity<List<Cliente>> listaClientes() {
        List<Cliente> clientesList = clienteService.listaClientes();
        if (clientesList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(clientesList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> obtenerClientePorId(@PathVariable("id") Integer id) {
        Cliente cliente = clienteService.obtenerClientePorId(id)
                .orElseThrow(() -> new ResourceNotFoundException("El cliente con el ID " + id + " no existe"));
        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCliente(@PathVariable("idcliente") Integer id) {
        try {
            clienteService.eliminarClienteConHistorial(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/pornombre")
    public ResponseEntity<List<Cliente>> obtenerClientePorNombre(@RequestParam String nombre) {
        List<Cliente> clientes = clienteService.obtenerEmpleadosPorNombre(nombre);
        if (clientes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> actualizarCliente(@PathVariable("id") Integer id, @RequestBody Cliente cliente) {
        Cliente oldCliente = clienteService.obtenerClientePorId(id)
                .orElseThrow(() -> new ResourceNotFoundException("El cliente con el ID " +
                        id + " no existe"));
        oldCliente.setNombre(cliente.getNombre());
        oldCliente.setDireccion(cliente.getDireccion());
        oldCliente.setNumerotelefono(cliente.getNumerotelefono());
        oldCliente.setCorreoelectronico(cliente.getCorreoelectronico());
        clienteService.guardarCliente(oldCliente);
        return new ResponseEntity<>(oldCliente, HttpStatus.OK);
    }
    @PostMapping("/registrar")
    public ResponseEntity<String> registrarTransaccion(@RequestBody ClienteRequest request) {
        try {
            Cliente cliente = request.getCliente();
            Cliente clienteGuardado = clienteService.guardarCliente(cliente);
            HistorialPago historialPago = request.getHistorialPago();
            historialPago.setCliente(clienteGuardado);
            historialPagoService.guardarHistorialPago(historialPago);
            return ResponseEntity.ok("Transacción exitosa");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error en la transacción: " + e.getMessage());
        }
    }

}
