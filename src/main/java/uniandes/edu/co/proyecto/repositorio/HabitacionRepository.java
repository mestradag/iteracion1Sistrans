package uniandes.edu.co.proyecto.repositorio;
import uniandes.edu.co.proyecto.modelo.Habitacion;

import org.springframework.data.mongodb.repository.DeleteQuery;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HabitacionRepository extends MongoRepository<Habitacion, Integer>{

    public class RespuestadarTipodeHabitacion{
        
        String tipo;

        public RespuestadarTipodeHabitacion(Integer capacidad, Boolean disponible, String tipo, String dotacion, Integer precionoches) {
             this.tipo = tipo;
        }
        public String getTipo() {
            return tipo;
        }
        public void setTipo(String tipo) {
            this.tipo = tipo;
        }
    }

    @Query("")
    List<Habitacion> darHabitaciones();

    //RF2 Consultar habitacion
    @Query("{_id: ?0}")
    Habitacion darHabitacion(int id);

    @Query("{_id: ?0}")
    @Update("{$push:{capacidad:?1, disponible:?2, tipo:?3, dotacion:?4, precioNoche?5}}")
    void actualizarHabitacion(int idHabitacion, int capacidad, Boolean disponible, String tipo, String dotacion, int precioNoche);

    //RF1 Actualizar tipo de habitacion
    @Query("{_id: ?0}")
    @Update("{$set:{tipo:{tipoH:?3}}}")
    void actualizarTipoHabitacion(String id_hotel, String tipoH);

    //RF1 Consultar tipo de habitacion  
    @Query("{_id: ?0},{tipo:1}")
    List<RespuestadarTipodeHabitacion> darTipodeHabitacion();

    @DeleteQuery("{_id: ?0}")
    void eliminarHabitacion(int idhabitacion);
}

