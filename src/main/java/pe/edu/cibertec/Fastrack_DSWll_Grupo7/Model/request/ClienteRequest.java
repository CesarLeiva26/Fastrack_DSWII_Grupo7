package pe.edu.cibertec.Fastrack_DSWll_Grupo7.Model.request;

import pe.edu.cibertec.Fastrack_DSWll_Grupo7.Model.bd.Cliente;
import pe.edu.cibertec.Fastrack_DSWll_Grupo7.Model.bd.HistorialPago;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteRequest {

    private Cliente cliente;
    private HistorialPago historialPago;

}
