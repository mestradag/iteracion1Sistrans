package uniandes.edu.co.proyecto.repositorio;
import org.springframework.data.mongodb.repository.MongoRepository;
import uniandes.edu.co.proyecto.modelo.Usuario;

public interface UsuarioRepository extends MongoRepository<Usuario, String>{

    
}

