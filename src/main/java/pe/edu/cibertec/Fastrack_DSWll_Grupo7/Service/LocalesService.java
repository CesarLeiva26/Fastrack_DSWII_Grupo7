package pe.edu.cibertec.Fastrack_DSWll_Grupo7.Service;

import pe.edu.cibertec.Fastrack_DSWll_Grupo7.Model.bd.Locales;
import pe.edu.cibertec.Fastrack_DSWll_Grupo7.Repository.LocalesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class LocalesService {

    private final LocalesRepository localesRepository;

    public List<Locales> listaLocales() {
        return localesRepository.findAll();
    }

    public Locales registrarLocal(Locales local) {
        return localesRepository.save(local);
    }

    public Optional<Locales> obtenerLocalPorId(Integer id) {
        return localesRepository.findById(id);
    }

    public void eliminarLocal(Integer id) {
        localesRepository.deleteById(id);
    }

    public List<Locales> buscarLocalesPorNombreLocal(String nombrelocal) {
        return localesRepository.findByNombrelocalContaining(nombrelocal);
    }
}