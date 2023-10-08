package uniandes.edu.co.proyecto.repositorio;

import java.sql.Date;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Habitacion;
import uniandes.edu.co.proyecto.modelo.PlanConsumo;
import uniandes.edu.co.proyecto.modelo.Reserva;
import uniandes.edu.co.proyecto.modelo.Usuario;

public interface ReservaRepository extends JpaRepository <Reserva, Integer> {

    @Query(value = "SELECT * FROM reservas", nativeQuery=true)
    Collection<Reserva> darReservas();

    @Query(value= "SELECT * FROM reservas WHERE idreserva= :idreserva", nativeQuery=true)
    Reserva darReserva(@Param("idreserva") Integer idreserva);

    @Modifying
    @Transactional
    @Query(value= "INSERT INTO reservas(idreserva, fechaInicio, fechaFin, duracion, numAcompanantes, idhabitacion, idusuario, idplanconsumo) VALUES (parranderos_sequence.nextval, :fechaInicio, :fechaFin, :duracion, :numAcompanantes, :idhabitacion, :idusuario, idplanconsumo)", nativeQuery=true)
    void insertarReserva(@Param("fechaInicio") Date fechaInicio, @Param("fechaFin") Date fechaFin, @Param("duracion") Integer duracion, @Param("numAcompanantes") Integer numAcompanantes, @Param("idhabitacion") Habitacion idhabitacion, @Param("idusuario") Usuario idusuario, @Param("idplanconsumo") PlanConsumo idplanconsumo);


    @Modifying
    @Transactional
    @Query(value ="UPDATE reservas SET fechaInicio= :fechaInicio, fechaFin= :fechaFin, duracion= :duracion, numAcompanantes= :numAcompanantes, idhabitacion= :idhabitacion, idusuario= :idusuario idplanconsumo= :idplanconsumo WHERE idreserva = :idreserva", nativeQuery = true)
    void actualizarReserva(@Param("idreserva") Integer idreserva, @Param("fechaInicio") Date fechaInicio, @Param("fechaFin") Date fechaFin, @Param("duracion") Integer duracion, @Param("numAcompanantes") Integer numAcompanantes, @Param("idhabitacion") Habitacion idhabitacion, @Param("idusuario") Usuario idusuario, @Param("idplanconsumo") PlanConsumo idplanconsumo);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM reservas  WHERE idreserva= :idreserva", nativeQuery = true)
    void eliminarReserva(@Param("idreserva") Integer idreserva);
    
}
