package uniandes.edu.co.proyecto.repositorio;

import uniandes.edu.co.proyecto.modelo.ServiciosConsumidos;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ServiciosConsumidosRepository extends JpaRepository<ServiciosConsumidos, Integer> {
   
    @Query(value = "SELECT * FROM s_consumidos", nativeQuery = true) 
    Collection<ServiciosConsumidos> darServiciosConsumidos();

    @Query(value = "SELECT * FROM s_consumidos WHERE idCuenta = :idCuenta AND idServicio = :idServicio", nativeQuery = true)
    ServiciosConsumidos darServicioConsumido(@Param("idCuenta") int idCuenta, @Param("idServicio") int idServicio);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO s_consumidos (idCuenta, idServicio) VALUES (:idCuenta, :idServicio)", nativeQuery = true)
    void insertarServicioConsumido(@Param("idCuenta") int idCuenta, @Param("idServicio") int idServicio);

    @Modifying
    @Transactional
    @Query(value = "UPDATE s_consumidos SET idCuenta = :idCuenta, idServicio = :idServicio WHERE idCuenta = :idCuenta AND idServicio = :idServicio", nativeQuery = true)
    void actualizarServicioConsumido(@Param("idCuenta") int idCuenta, @Param("idServicio") int idServicio);
    
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM s_consumidos WHERE idCuenta = :idCuenta AND idServicio = :idServicio", nativeQuery = true)
    void eliminarServicioConsumido(@Param("idCuenta") int idCuenta, @Param("idServicio") int idServicio);
    
    
}
