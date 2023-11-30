package pe.edu.cibertec.Fastrack_DSWll_Grupo7.Exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message){
        super(message);
    }
}