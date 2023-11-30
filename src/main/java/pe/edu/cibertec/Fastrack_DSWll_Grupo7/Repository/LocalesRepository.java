package pe.edu.cibertec.Fastrack_DSWll_Grupo7.Repository;

import pe.edu.cibertec.Fastrack_DSWll_Grupo7.Model.bd.Locales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface LocalesRepository extends JpaRepository<Locales,Integer>{
    List<Locales> findByNombrelocalContaining(String nombrelocal);

}

