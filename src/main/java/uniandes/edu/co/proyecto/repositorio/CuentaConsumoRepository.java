package uniandes.edu.co.proyecto.repositorio;
import uniandes.edu.co.proyecto.modelo.CuentaConsumo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CuentaConsumoRepository extends MongoRepository<CuentaConsumo, String> {
    

}

