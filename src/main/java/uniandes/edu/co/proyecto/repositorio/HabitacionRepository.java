package uniandes.edu.co.proyecto.repositorio;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;

import uniandes.edu.co.proyecto.modelo.Habitacion;

import java.util.List;

public interface HabitacionRepository extends MongoRepository<Habitacion, String> {

    public class RespuestaDineroRecolectado{
        String idhabitacion;
        int total;
        public RespuestaDineroRecolectado(String idhabitacion, int total) {
            this.idhabitacion = idhabitacion;
            this.total = total;
        }
        public void setIdhabitacion(String idhabitacion) {
             this.idhabitacion = idhabitacion;
        }
        public void setTotal(int total) {
            this.total = total;
        }
        public String getIdhabitacion() {
            return idhabitacion;
        }
        public int getTotal() {
            return total;
        }
    }

    public class RespuestaIndiceOcupacion{
        String idhabitacion;
        Double ocupacion;
        public RespuestaIndiceOcupacion(String idhabitacion, Double ocupacion) {
            this.idhabitacion = idhabitacion;
            this.ocupacion = ocupacion;
        }
        public void setIdhabitacion(String idhabitacion) {
            this.idhabitacion = idhabitacion;
        }
        public void setOcupacion(Double ocupacion) {
            this.ocupacion = ocupacion;
        }
        public String getIdhabitacion() {
            return idhabitacion;
        }
        public Double getOcupacion() {
            return ocupacion;
        }
    }

    // RF1 Actualizar tipo de habitacion
    @Query("{_id: ?0}")
    @Update("{$set:{tipo:{tipoH:?3}}}")
    void actualizarTipoHabitacion(String id_hotel, String tipoH);

    @Query(value="{_id: ?0}", delete = true)
    void eliminarHabitacion(String idhabitacion);

    // RFC1 - MOSTRAR EL DINERO RECOLECTADO POR SERVICIOS EN CADA HABITACIÓN EN EL ÚLTIMO AÑO CORRIDO.
    @Aggregation({
        "{$match: { 'reservasservicios.fechareserva': { $gte: ISODate('2023-01-01'), $lt: ISODate('2023-12-31') } } }",
        "{$unwind: '$reservasservicios'}",
        "{$lookup: { from: 'servicios', localField: 'reservasservicios.idservicio', foreignField: '_id', as: 'servicio'}}",
        "{$unwind: '$servicio'}",
        "{$group: {_id: '$_id', total: {$sum: '$servicio.costototal'}}}",
        "{$project: {idhabitacion: '$_id.', total: 1, _id: 0}}"})
    List<RespuestaDineroRecolectado> dineroRecolectado();

    // RFC2 - MOSTRAR EL ÍNDICE DE OCUPACIÓN DE CADA UNA DE LAS HABITACIONES DEL HOTEL EN EL ÚLTIMO AÑO CORRIDO
    @Aggregation(pipeline = {
        "{$unwind: '$reservasservicios'}",
        "{$match: { 'reservasservicios.fechareserva': { $gte: ISODate('2023-01-01'), $lt: ISODate('2023-12-31') } }}",
        "{$group: { _id: '$_id', ocupacion: { $sum: 1 } }}",
        "{$project: { idhabitacion: '$_id', ocupacion: 1, _id: 0 }}"
    })
    List<RespuestaIndiceOcupacion> indiceOcupacioPorHabitacion();
    
}
