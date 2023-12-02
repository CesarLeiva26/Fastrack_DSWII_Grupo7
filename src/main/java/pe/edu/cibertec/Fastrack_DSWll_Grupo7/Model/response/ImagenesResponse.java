package pe.edu.cibertec.Fastrack_DSWll_Grupo7.Model.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ImagenesResponse {
    private String message;
    public ImagenesResponse(String message) {
        this.message = message;
    }
}
