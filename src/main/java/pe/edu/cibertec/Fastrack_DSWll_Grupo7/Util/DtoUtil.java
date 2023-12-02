package pe.edu.cibertec.Fastrack_DSWll_Grupo7.Util;


import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import pe.edu.cibertec.Fastrack_DSWll_Grupo7.Model.dto.DtoEntity;

@Component
public class DtoUtil {

    public DtoEntity convertirADto(Object obj, DtoEntity mapper){
        return new ModelMapper().map(obj, mapper.getClass());
    }

    public Object convertirAEntidad(Object obj, DtoEntity mapper){
        return new ModelMapper().map(mapper, obj.getClass());
    }

}
