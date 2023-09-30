package uniandes.edu.co.proyecto.repositorio;

import java.sql.Date;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Reserva;

public interface ReservaRepository extends JpaRepository <Reserva, Integer> {

    @Query(value = "SELECT * FROM reservas", nativeQuery=true)
    Collection<Reserva> darReserva();

    @Query(value= "SELECT * FROM reservas WHERE id= :id", nativeQuery=true)
    Reserva darReserva(@Param("id") long id);

    @Modifying
    @Transactional
    @Query(value= "INSERT INTO reservas(idReserva, fechaInicio, fechaFin, duracion, numAcompanantes) VALUES (parranderos_sequence.nextval, :idReserva, :fechaInicio, :fechaFin, :duracion, :numAcompanantes)", nativeQuery=true)
    void insertarReserva(@Param("idReserva") int idReserva, @Param("fechaInicio") Date fechaInicio, @Param("fechaFin") Date fechaFin, @Param("duracion") Integer duracion, @Param("numAcompanantes") Integer numAcompanantes);

    //idReserva
    @Modifying
    @Transactional
    @Query(value ="UPDATE reservas SET id= :id, idReserva= :idReserva, fechaInicio= :fechaInicio, fechaFin= :fechaFin, duracion= :duracion, numAcompanantes= :numAcompanantes WHERE id = :id", nativeQuery = true)
    void updateReserva(@Param("id") int id, @Param("idReserva") int idReserva, @Param("fechaInicio") Date fechaInicio, @Param("fechaFin") Date fechaFin, @Param("duracion") Integer duracion, @Param("numAcompanantes") Integer numAcompanantes);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM reservas  WHERE id= :id", nativeQuery = true)
    void eliminarReserva(@Param("id") int id);
    
}
