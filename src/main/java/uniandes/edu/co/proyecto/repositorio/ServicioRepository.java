package uniandes.edu.co.proyecto.repositorio;
import org.springframework.data.mongodb.repository.MongoRepository;
import uniandes.edu.co.proyecto.modelo.Servicio;

public interface ServicioRepository extends MongoRepository<Servicio,String>{

  
}



