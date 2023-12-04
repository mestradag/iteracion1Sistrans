package uniandes.edu.co.proyecto.repositorio;
import org.springframework.data.mongodb.repository.MongoRepository;
import uniandes.edu.co.proyecto.modelo.Reserva;

public interface ReservaRepository extends MongoRepository<Reserva, String> {


}
