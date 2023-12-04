package uniandes.edu.co.proyecto.repositorio;
import java.util.Collection;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.DeleteQuery;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Update;

import uniandes.edu.co.proyecto.modelo.Usuario;

public interface UsuarioRepository extends MongoRepository<Usuario, String>{

    
}

