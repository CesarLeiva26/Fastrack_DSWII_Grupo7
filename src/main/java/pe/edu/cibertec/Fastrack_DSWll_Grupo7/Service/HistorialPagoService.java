package pe.edu.cibertec.Fastrack_DSWll_Grupo7.Service;

import pe.edu.cibertec.Fastrack_DSWll_Grupo7.Model.bd.HistorialPago;
import pe.edu.cibertec.Fastrack_DSWll_Grupo7.Repository.HistorialPagoRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class HistorialPagoService {

    @Autowired
    private HistorialPagoRepository historialPagoRepository;

    @Transactional
    public HistorialPago guardarHistorialPago(HistorialPago historialPago) {
        return historialPagoRepository.save(historialPago);
    }

    public List<HistorialPago> listarPagos(){
        return historialPagoRepository.findAll();
    }
}