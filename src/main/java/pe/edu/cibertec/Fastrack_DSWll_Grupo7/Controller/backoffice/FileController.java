package pe.edu.cibertec.Fastrack_DSWll_Grupo7.Controller.backoffice;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import pe.edu.cibertec.Fastrack_DSWll_Grupo7.Model.response.ImagenesResponse;
import pe.edu.cibertec.Fastrack_DSWll_Grupo7.Model.response.ResponseFile;
import pe.edu.cibertec.Fastrack_DSWll_Grupo7.Service.FileService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/file")
public class FileController {

    private final FileService fileService;

    @PostMapping("/filesimages")
    public ResponseEntity<ImagenesResponse> subirArchivosImages(
            @RequestParam("files") List<MultipartFile> files) {
        try {
            fileService.guardarArchivosImages(files);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ImagenesResponse("Las imágenes fueron cargadas correctamente"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ImagenesResponse("Error al cargar las imágenes: " + e.getMessage()));
        }
    }

    @PostMapping("/filesexcel")
    public ResponseEntity<ImagenesResponse> subirArchivosExcel(
            @RequestParam("files") List<MultipartFile> files) {
        try {
            fileService.guardarArchivosDocumentos(files);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ImagenesResponse("Los archivos Excel fueron cargados correctamente"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ImagenesResponse("Error al cargar los archivos Excel: " + e.getMessage()));
        }
    }
}
