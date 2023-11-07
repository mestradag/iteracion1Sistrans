package uniandes.edu.co.proyecto.repositorio;

import java.sql.Date;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.CuentaConsumo;
import uniandes.edu.co.proyecto.modelo.Habitacion;
import uniandes.edu.co.proyecto.modelo.PlanConsumo;
import uniandes.edu.co.proyecto.modelo.Reserva;
import uniandes.edu.co.proyecto.modelo.Usuario;

public interface ReservaRepository extends JpaRepository <Reserva, Integer> {

    @Query(value = "SELECT * FROM reservas FETCH FIRST 30 ROWS ONLY", nativeQuery=true)
    Collection<Reserva> darReservas();

    @Query(value= "SELECT * FROM reservas WHERE idreserva= :idreserva", nativeQuery=true)
    Reserva darReserva(@Param("idreserva") Integer idreserva);

    @Modifying
    @Transactional
    @Query(value= "INSERT INTO reservas(idreserva, fechainicio, fechafin, duracion, numacompanantes, idhabitacion, idusuario, idplanconsumo, idcuenta) VALUES (parranderos_sequence.nextval, :fechainicio, :fechafin, :duracion, :numacompanantes, :idhabitacion, :idusuario, :idplanconsumo, :idcuenta)", nativeQuery=true)
    void insertarReserva(@Param("fechainicio") Date fechainicio, @Param("fechafin") Date fechafin, @Param("duracion") Integer duracion, @Param("numacompanantes") Integer numacompanantes, @Param("idhabitacion") Integer idhabitacion, @Param("idusuario") Integer idusuario, @Param("idplanconsumo") Integer idplanconsumo, @Param("idcuenta") Integer idcuenta);


    @Modifying
    @Transactional
    @Query(value ="UPDATE reservas SET fechainicio= :fechainicio, fechafin= :fechafin, duracion= :duracion, numacompanantes= :numacompanantes WHERE idreserva = :idreserva", nativeQuery = true)
    void actualizarReserva(@Param("idreserva") Integer idreserva, @Param("fechainicio") Date fechainicio, @Param("fechafin") Date fechafin, @Param("duracion") Integer duracion, @Param("numacompanantes") Integer numacompanantes);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM reservas  WHERE idreserva= :idreserva", nativeQuery = true)
    void eliminarReserva(@Param("idreserva") Integer idreserva);
    
}
