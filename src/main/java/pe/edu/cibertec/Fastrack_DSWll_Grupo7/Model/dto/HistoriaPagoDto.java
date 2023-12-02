package pe.edu.cibertec.Fastrack_DSWll_Grupo7.Model.dto;

import lombok.Data;
import java.util.Date;

@Data
public class HistoriaPagoDto implements DtoEntity{

    private Integer idpago;
    private Date fechapago;
    private Double montopagado;
    private String estadopago;
    private ClienteDto cliente;
}
