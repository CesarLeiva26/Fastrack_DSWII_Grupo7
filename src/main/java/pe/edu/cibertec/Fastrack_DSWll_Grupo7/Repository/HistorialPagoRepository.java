package pe.edu.cibertec.Fastrack_DSWll_Grupo7.Repository;

import pe.edu.cibertec.Fastrack_DSWll_Grupo7.Model.bd.HistorialPago;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface HistorialPagoRepository extends JpaRepository<HistorialPago,Integer>{
    @Transactional
    @Modifying
    @Query(value = "DELETE FROM historialpagos WHERE idcliente = :idcliente", nativeQuery = true)
    void deleteByClienteId(@Param("idcliente") Integer id);
}
