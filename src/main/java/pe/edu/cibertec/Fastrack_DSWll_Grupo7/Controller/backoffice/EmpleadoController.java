package pe.edu.cibertec.Fastrack_DSWll_Grupo7.Controller.backoffice;

import pe.edu.cibertec.Fastrack_DSWll_Grupo7.Exception.ResourceNotFoundException;
import pe.edu.cibertec.Fastrack_DSWll_Grupo7.Model.bd.Empleado;
import pe.edu.cibertec.Fastrack_DSWll_Grupo7.Service.EmpleadoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/empleado")
public class EmpleadoController {

    private final EmpleadoService empleadoService;

    @GetMapping("")
    public ResponseEntity<List<Empleado>> listaEmpleados() {
        List<Empleado> empleadoList = empleadoService.listaEmpleados();
        if (empleadoList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(empleadoList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empleado> obtenerEmpleadoPorId(@PathVariable("id") Integer id) {
        Empleado empleado = empleadoService.obtenerEmpleadoPorId(id)
                .orElseThrow(() -> new ResourceNotFoundException("El empleado con el ID " + id + " no existe"));
        return new ResponseEntity<>(empleado, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Empleado> registrarEmpleado(@RequestBody Empleado empleado) {
        Empleado nuevoEmpleado = empleadoService.registrarEmpleado(empleado);
        return new ResponseEntity<>(nuevoEmpleado, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Empleado> actualizarEmpleado(@PathVariable("id") Integer id, @RequestBody Empleado empleado) {
        Empleado oldEmpleado = empleadoService.obtenerEmpleadoPorId(id)
                .orElseThrow(() -> new ResourceNotFoundException("El empleado con el ID " +
                        id + " no existe"));
        oldEmpleado.setNombre(empleado.getNombre());
        oldEmpleado.setNumerotelefono(empleado.getNumerotelefono());
        oldEmpleado.setCorreoelectronico(empleado.getCorreoelectronico());
        oldEmpleado.setTiposempleados(empleado.getTiposempleados());
        empleadoService.registrarEmpleado(oldEmpleado);
        return new ResponseEntity<>(oldEmpleado, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEmpleado(@PathVariable("id") Integer id) {
        Empleado empleado = empleadoService.obtenerEmpleadoPorId(id)
                .orElseThrow(() -> new ResourceNotFoundException("El empleado con el ID " + id + " no existe"));
        empleadoService.eliminarEmpleado(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/pornombre")
    public ResponseEntity<List<Empleado>> obtenerEmpleadosPorNombre(@RequestParam String nombre) {
        List<Empleado> empleados = empleadoService.obtenerEmpleadosPorNombre(nombre);
        if (empleados.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(empleados, HttpStatus.OK);
    }
}