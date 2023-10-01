package uniandes.edu.co.proyecto.repositorio;

import uniandes.edu.co.proyecto.modelo.Habitacion;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;


public interface HabitacionRepository extends JpaRepository<Habitacion, Integer>{
    @Query(value = "SELECT * FROM habitaciones", nativeQuery = true)
    Collection<Habitacion> darHabitacion();

    @Query(value = "SELECT * FROM habitaciones WHERE idHabitacion = :idHabitacion", nativeQuery = true)
    Habitacion darHabitacion(@Param("idHabitacion") int idHabitacion);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO habitaciones (idHabitacion, capacidad, disponible, tipo, dotacion, precioNoche,idhotel,idUsuario,idPlanConsumo) VALUES (parranderos_sequence.nextval, :cantidad, :disponible, :tipo, :dotacion, :precioNoche, :idhotel, :idUsuario, :idPlanConsumo)", nativeQuery = true)
    void insertarHabitacion(@Param("capacidad") int capacidad, @Param("disponible") Boolean disponible, @Param("tipo") String tipo, @Param("dotacion") String dotacion, @Param("precioNoche") int precioNoche, @Param("idhotel") String idhotel, @Param("idUsuario") int idUsuario, @Param("idPlanConsumo") int idPlanConsumo);

    @Modifying
    @Transactional
    @Query(value = "UPDATE habitaciones SET capacidad = :capacidad, disponible = :disponible, tipo = :tipo, dotacion = :dotacion, precioNoche = :precioNoche, idhotel = :idhotel, idUsuario = :idUsuario, idPlanConsumo = :idPlanConsumo WHERE idHabitacion = :idHabitacion", nativeQuery = true)
    void actualizarHabitacion(@Param("idHabitacion") int idHabitacion, @Param("capacidad") int capacidad, @Param("disponible") Boolean disponible, @Param("tipo") String tipo, @Param("dotacion") String dotacion, @Param("precioNoche") int precioNoche, @Param("idhotel") String idhotel, @Param("idUsuario") int idUsuario, @Param("idPlanConsumo") int idPlanConsumo);
    
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM habitaciones WHERE idHabitacion = :idHabitacion", nativeQuery = true)
    void eliminarHabitacion(@Param("idHabitacion") int idHabitacion);
    
}
