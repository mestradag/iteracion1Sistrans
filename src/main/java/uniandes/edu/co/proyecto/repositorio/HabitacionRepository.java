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
    Collection<Habitacion> darHabitaciones();

    @Query(value = "SELECT * FROM habitaciones WHERE idhabitacion = :idhabitacion", nativeQuery = true)
    Habitacion darHabitacion(@Param("idhabitacion") int idhabitacion);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO habitaciones (idhabitacion, capacidad, disponible, tipo, dotacion, precioNoche,nombreHotel,idusuario,idplanconsumo) VALUES (parranderos_sequence.nextval, :cantidad, :disponible, :tipo, :dotacion, :precioNoche, :nombrehotel, :idusuario, :idplanconsumo)", nativeQuery = true)
    void insertarHabitacion(@Param("capacidad") int capacidad, @Param("disponible") Boolean disponible, @Param("tipo") String tipo, @Param("dotacion") String dotacion, @Param("precioNoche") int precioNoche, @Param("nombreHotel") String nombreHotel, @Param("idusuario") int idusuario, @Param("idplanconsumo") int idplanconsumo);

    @Modifying
    @Transactional
    @Query(value = "UPDATE habitaciones SET capacidad = :capacidad, disponible = :disponible, tipo = :tipo, dotacion = :dotacion, precioNoche = :precioNoche, nombreHotel = :nombreHotel, idusuario = :idusuario, idplanconsumo = :idplanconsumo WHERE idhabitacion = :idhabitacion", nativeQuery = true)
    void actualizarHabitacion(@Param("idhabitacion") int idhabitacion, @Param("capacidad") int capacidad, @Param("disponible") Boolean disponible, @Param("tipo") String tipo, @Param("dotacion") String dotacion, @Param("precioNoche") int precioNoche, @Param("nombrehotel") String nombreHotel, @Param("idusuario") int idusuario, @Param("idplanconsumo") int idplanconsumo);
    
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM habitaciones WHERE idhabitacion = :idhabitacion", nativeQuery = true)
    void eliminarHabitacion(@Param("idhabitacion") int idhabitacion);
    
}
