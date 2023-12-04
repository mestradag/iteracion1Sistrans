package uniandes.edu.co.proyecto.repositorio;
import uniandes.edu.co.proyecto.modelo.Producto;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductoRepository extends MongoRepository<Producto, String>{
        
}
