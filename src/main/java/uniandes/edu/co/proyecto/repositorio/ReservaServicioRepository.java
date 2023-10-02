package uniandes.edu.co.proyecto.repositorio;
import uniandes.edu.co.proyecto.modelo.ReservaServicio;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ReservaServicioRepository extends JpaRepository<ReservaServicio, Integer>{
        
        @Query(value = "SELECT * FROM reservas_s", nativeQuery = true)
        Collection<ReservaServicio> darReservasServicio();
    
        @Query(value = "SELECT * FROM reservas_s WHERE idReserva = :idReserva AND idServicio = :idServicio", nativeQuery = true)
        ReservaServicio darReservaServicio(@Param("idReserva") int idReserva, @Param("idServicio") int idServicio);
    
        @Modifying
        @Transactional
        @Query(value = "INSERT INTO reservas_s (idReserva, idServicio) VALUES (:idReserva, :idServicio)", nativeQuery = true)
        void insertarReservaServicio(@Param("idReserva") int idReserva, @Param("idServicio") int idServicio);
    
        @Modifying
        @Transactional
        @Query(value = "DELETE FROM reservas_s WHERE idReserva = :idReserva AND idServicio = :idServicio", nativeQuery = true)
        void eliminarReservaServicio(@Param("idReserva") int idReserva, @Param("idServicio") int idServicio);
    
}
