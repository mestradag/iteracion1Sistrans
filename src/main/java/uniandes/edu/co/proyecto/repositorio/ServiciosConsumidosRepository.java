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

    @Query(value = "SELECT * FROM s_consumidos WHERE idcuenta = :idcuenta AND idservicio = :idservicio", nativeQuery = true)
    ServiciosConsumidos darServicioConsumido(@Param("idcuenta") int idcuenta, @Param("idservicio") int idservicio);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO s_consumidos (idcuenta, idservicio) VALUES (:idcuenta, :idservicio)", nativeQuery = true)
    void insertarServicioConsumido(@Param("idcuenta") int idcuenta, @Param("idservicio") int idservicio);

    @Modifying
    @Transactional
    @Query(value = "UPDATE s_consumidos SET idcuenta = :idcuenta, idservicio = :idservicio WHERE idcuenta = :idcuenta AND idservicio = :idservicio", nativeQuery = true)
    void actualizarServicioConsumido(@Param("idcuenta") int idcuenta, @Param("idservicio") int idservicio);
    
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM s_consumidos WHERE idcuenta = :idcuenta AND idservicio = :idservicio", nativeQuery = true)
    void eliminarServicioConsumido(@Param("idcuenta") int idcuenta, @Param("idservicio") int idservicio);
    
    
}
