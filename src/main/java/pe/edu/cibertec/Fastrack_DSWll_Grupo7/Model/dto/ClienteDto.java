package pe.edu.cibertec.Fastrack_DSWll_Grupo7.Model.dto;

import lombok.Data;

@Data
public class ClienteDto implements DtoEntity{
    private Integer idcliente;
    private String nombre;
    private String numerotelefono;
}
