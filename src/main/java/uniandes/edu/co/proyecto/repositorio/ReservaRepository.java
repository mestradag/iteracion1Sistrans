package uniandes.edu.co.proyecto.repositorio;

import java.sql.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.DeleteQuery;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Update;

import uniandes.edu.co.proyecto.modelo.CuentaConsumo;
import uniandes.edu.co.proyecto.modelo.Reserva;

public interface ReservaRepository extends MongoRepository<Reserva, Integer> {

    @Query("")
    List<Reserva> darReservas();

    @Query("{_id: ?0}")
    Reserva darReserva(Integer idreserva);

    // @Modifying
    // @Transactional
    // @Query(value= "INSERT INTO reservas(idreserva, fechainicio, fechafin, duracion, numacompanantes, idhabitacion, idusuario, idplanconsumo, idcuenta) VALUES (parranderos_sequence.nextval, :fechainicio, :fechafin, :duracion, :numacompanantes, :idhabitacion, :idusuario, :idplanconsumo, :idcuenta)", nativeQuery=true)
    // void insertarReserva(@Param("fechainicio") Date fechainicio, @Param("fechafin") Date fechafin, @Param("duracion") Integer duracion, @Param("numacompanantes") Integer numacompanantes, @Param("idhabitacion") Integer idhabitacion, @Param("idusuario") Integer idusuario, @Param("idplanconsumo") Integer idplanconsumo, @Param("idcuenta") Integer idcuenta);


    @Query("{_id: ?0}")
    @Update("{$push:{fechainicio:?1, fechafin:?2, duracion:?3, numacompanantes:?4}}")
    void actualizarReserva(Integer idreserva, Date fechainicio, Date fechafin, Integer duracion, Integer numacompanantes);

    @DeleteQuery("{_id: ?0}")
    void eliminarReserva(Integer idreserva);
}
