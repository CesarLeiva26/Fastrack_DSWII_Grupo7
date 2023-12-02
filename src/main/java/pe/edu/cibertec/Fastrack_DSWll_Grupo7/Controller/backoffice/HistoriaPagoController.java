package pe.edu.cibertec.Fastrack_DSWll_Grupo7.Controller.backoffice;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.cibertec.Fastrack_DSWll_Grupo7.Model.dto.ClienteDto;
import pe.edu.cibertec.Fastrack_DSWll_Grupo7.Model.dto.DtoEntity;
import pe.edu.cibertec.Fastrack_DSWll_Grupo7.Model.dto.HistoriaPagoDto;
import pe.edu.cibertec.Fastrack_DSWll_Grupo7.Service.HistorialPagoService;
import pe.edu.cibertec.Fastrack_DSWll_Grupo7.Util.DtoUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/historiapago")
public class HistoriaPagoController {

    private HistorialPagoService historialPagoService;

    @GetMapping("/cliente")
    public ResponseEntity<List<DtoEntity>> listarHistoria(){
        List<DtoEntity> clienteList = new ArrayList<>();
        clienteList = historialPagoService.listarPagos()
                .stream()
                .map(historia -> new DtoUtil().convertirADto(historia, new HistoriaPagoDto()))
                .collect(Collectors.toList());
        if(clienteList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return  new ResponseEntity<>(clienteList, HttpStatus.OK);
    }
}
