package uniandes.edu.co.proyecto.repositorio;

import java.sql.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.DeleteQuery;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Update;

import uniandes.edu.co.proyecto.modelo.Reserva;

public interface ReservaRepository extends MongoRepository<Reserva, Integer> {

    @Query("{}")
    List<Reserva> darReservas();

    @Query("{_id: ?0}")
    Reserva darReserva(Integer idreserva);

    @Query("{_id: ?0}")
    @Update("{$push:{fechainicio:?1, fechafin:?2, duracion:?3, idhabitacion:?4, cuenta_c:?5, plan_c:?6}}")
    void actualizarReserva(Integer idreserva, Date fechainicio, Date fechafin, Integer duracion, Integer numacompanantes);

    @DeleteQuery("{_id: ?0}")
    void eliminarReserva(Integer idreserva);
}
