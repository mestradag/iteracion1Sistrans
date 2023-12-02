package uniandes.edu.co.proyecto.repositorio;

import java.util.List;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.DeleteQuery;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Update;



import uniandes.edu.co.proyecto.modelo.Servicio;

public interface ServicioRepository extends MongoRepository<Servicio,Integer>{

    @Query("{}")
    List<Servicio> darServicios();

    @Query("{_id: ?0}")
    Servicio darServicio(Integer idservicio);

    // @Modifying
    // @Transactional
    // @Query(value="INSERT INTO servicios(idservicio,nombre,descripcion,costototal,idplanconsumo, nombrehotel,costototal) VALUES (parranderos_sequence.nextval, :nombre, :descripcion, :idplanconsumo, :nombrehotel, :costototal)", nativeQuery = true) 
    // void insertarServicio(@Param("nombre") String nombre,@Param("descripcion") String descripcion,@Param("idplanconsumo") Integer idplanconsumo, @Param("nombrehotel") String nombrehotel,@Param("costototal") Integer costototal);

    @Query("{_id: ?0}")
    @Update("{$push:{nombre:?1, descripcion:?2, costototal:?3}}")
    void actualizarServicio(Integer idservicio, String nombre, String descripcion, Integer costototal);


    @DeleteQuery("{_id: ?0}")
    void eliminarCuentaConsumo(Integer idservicio);
}



