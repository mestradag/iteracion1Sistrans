package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;
import uniandes.edu.co.proyecto.modelo.PlanConsumo;

public interface PlanConsumoRepository extends MongoRepository<PlanConsumo, String>{


}