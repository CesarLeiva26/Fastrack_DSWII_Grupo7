package pe.edu.cibertec.Fastrack_DSWll_Grupo7.Model.dto;

import lombok.Data;

@Data
public class LocalesDto implements DtoEntity {

    private Integer idlocal;
    private String nombrelocal;
    private String direccionlocal;
    private String ciudadlocal;
    private EmpleadoDto empleado;
}
