package pe.edu.cibertec.Fastrack_DSWll_Grupo7.Controller;

import pe.edu.cibertec.Fastrack_DSWll_Grupo7.Exception.ResourceNotFoundException;
import pe.edu.cibertec.Fastrack_DSWll_Grupo7.Model.bd.TipoEmpleado;
import pe.edu.cibertec.Fastrack_DSWll_Grupo7.Service.TipoEmpleadoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/tipoempleado")
public class TipoEmpleadoController {

    private final TipoEmpleadoService tipoEmpleadoService;

    @GetMapping("")
    public ResponseEntity<List<TipoEmpleado>> listaTiposEmpleados() {
        List<TipoEmpleado> tiposEmpleadosList = tipoEmpleadoService.listaTiposEmpleados();
        if (tiposEmpleadosList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(tiposEmpleadosList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoEmpleado> obtenerTipoEmpleadoPorId(@PathVariable("id") Integer id) {
        TipoEmpleado tipoEmpleado = tipoEmpleadoService.obtenerTipoEmpleadoPorId(id)
                .orElseThrow(() -> new ResourceNotFoundException("El tipo de empleado con el ID " + id + " no existe"));
        return new ResponseEntity<>(tipoEmpleado, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<TipoEmpleado> registrarTipoEmpleado(@RequestBody TipoEmpleado tipoEmpleado) {
        TipoEmpleado nuevoTipoEmpleado = tipoEmpleadoService.registrarTipoEmpleado(tipoEmpleado);
        return new ResponseEntity<>(nuevoTipoEmpleado, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoEmpleado> actualizarTipoEmpleado(@PathVariable("id") Integer id, @RequestBody TipoEmpleado tipoEmpleado) {
        TipoEmpleado oldTipoEmpleado = tipoEmpleadoService.obtenerTipoEmpleadoPorId(id)
                .orElseThrow(() -> new ResourceNotFoundException("El tipo de empleado con el ID " +
                        id + " no existe"));
        oldTipoEmpleado.setNombretipoempleado(tipoEmpleado.getNombretipoempleado());
        tipoEmpleadoService.registrarTipoEmpleado(oldTipoEmpleado);
        return new ResponseEntity<>(oldTipoEmpleado, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTipoEmpleado(@PathVariable("id") Integer id) {
        TipoEmpleado tipoEmpleado = tipoEmpleadoService.obtenerTipoEmpleadoPorId(id)
                .orElseThrow(() -> new ResourceNotFoundException("El tipo de empleado con el ID " + id + " no existe"));
        tipoEmpleadoService.eliminarTipoEmpleado(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
