package pe.edu.cibertec.Fastrack_DSWll_Grupo7.Controller;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.Fastrack_DSWll_Grupo7.Exception.ResourceNotFoundException;
import pe.edu.cibertec.Fastrack_DSWll_Grupo7.Model.bd.Locales;
import pe.edu.cibertec.Fastrack_DSWll_Grupo7.Service.LocalesService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/locales")
public class LocalesController {

    private final LocalesService localesService;

    @GetMapping("")
    public ResponseEntity<List<Locales>> listaLocales() {
        List<Locales> localesList = localesService.listaLocales();
        if (localesList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(localesList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Locales> obtenerLocalPorId(@PathVariable("id") Integer id) {
        Locales local = localesService.obtenerLocalPorId(id)
                .orElseThrow(() -> new ResourceNotFoundException("El local con el ID " + id + " no existe"));
        return new ResponseEntity<>(local, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Locales> registrarLocal(@RequestBody Locales local) {
        Locales nuevoLocal = localesService.registrarLocal(local);
        return new ResponseEntity<>(nuevoLocal, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Locales> actualizarLocal(@PathVariable("id") Integer id, @RequestBody Locales local) {
        Locales oldLocal = localesService.obtenerLocalPorId(id)
                .orElseThrow(() -> new ResourceNotFoundException("El local con el ID " +
                        id + " no existe"));
        oldLocal.setNombrelocal(local.getNombrelocal());
        oldLocal.setDireccionlocal(local.getDireccionlocal());
        oldLocal.setCiudadlocal(local.getCiudadlocal());
        oldLocal.setCodigopostal(local.getCodigopostal());
        oldLocal.setTelefonolocal(local.getTelefonolocal());
        localesService.registrarLocal(oldLocal);
        return new ResponseEntity<>(oldLocal, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarLocal(@PathVariable("id") Integer id) {
        Locales local = localesService.obtenerLocalPorId(id)
                .orElseThrow(() -> new ResourceNotFoundException("El local con el ID " + id + " no existe"));
        localesService.eliminarLocal(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/pornombre")
    public ResponseEntity<List<Locales>> buscarLocalesPorNombreLocal(@RequestParam String nombrelocal) {
        List<Locales> locales = localesService.buscarLocalesPorNombreLocal(nombrelocal);
        if (locales.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(locales, HttpStatus.OK);
    }
}