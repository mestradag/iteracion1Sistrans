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

    @Query(value= "SELECT * FROM reservas WHERE idReserva= :idReserva", nativeQuery=true)
    Reserva darReserva(@Param("idReserva") Integer idReserva);

    @Modifying
    @Transactional
    @Query(value= "INSERT INTO reservas(idReserva, fechaInicio, fechaFin, duracion, numAcompanantes, idHabitacion, idUsuario, idPlanConsumo) VALUES (parranderos_sequence.nextval, :fechaInicio, :fechaFin, :duracion, :numAcompanantes, :idHabitacion, :idUsuario, idPlanConsumo)", nativeQuery=true)
    void insertarReserva(@Param("fechaInicio") Date fechaInicio, @Param("fechaFin") Date fechaFin, @Param("duracion") Integer duracion, @Param("numAcompanantes") Integer numAcompanantes, @Param("idHabitacion") Habitacion idHabitacion, @Param("idUsuario") Usuario idUsuario, @Param("idPlanConsumo") PlanConsumo idPlanConsumo);


    @Modifying
    @Transactional
    @Query(value ="UPDATE reservas SET fechaInicio= :fechaInicio, fechaFin= :fechaFin, duracion= :duracion, numAcompanantes= :numAcompanantes, idHabitacion= :idHabitacion, idUsuario= :idUsuario idPlanConsumo= :idPlanConsumo WHERE idReserva = :idReserva", nativeQuery = true)
    void actualizarReserva(@Param("idReserva") Integer idReserva, @Param("fechaInicio") Date fechaInicio, @Param("fechaFin") Date fechaFin, @Param("duracion") Integer duracion, @Param("numAcompanantes") Integer numAcompanantes, @Param("idHabitacion") Habitacion idHabitacion, @Param("idUsuario") Usuario idUsuario, @Param("idPlanConsumo") PlanConsumo idPlanConsumo);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM reservas  WHERE idRerserva= :idReserva", nativeQuery = true)
    void eliminarReserva(@Param("idReserva") Integer idReserva);
    
}
