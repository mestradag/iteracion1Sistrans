package uniandes.edu.co.proyecto.repositorio;
import java.util.Collection;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.DeleteQuery;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Update;

import uniandes.edu.co.proyecto.modelo.Usuario;

public interface UsuarioRepository extends MongoRepository<Usuario, Integer>{
    
    
    @Query("{}")
    Collection<Usuario> darUsuarios();

    @Query("{_id: ?0}")
    Usuario darUsuario(Integer idusuario);

 
    @Query("{_id: ?0}")
    @Update("{$push:{correo:?1, rol:?2, nombrehotel:?3}}")
    void actualizarUsuario(Integer idusuario, String nombre, String correo, String rol);

    // @Modifying
    // @Transactional
    // @Query(value = "DELETE FROM usuarios WHERE idusuario= :idusuario", nativeQuery = true)
    // void eliminarUsuario(@Param("idusuario") Integer idusuario);

    @DeleteQuery("{_id: ?0}")
    void eliminarUsuario(Integer idusuairio);
}

