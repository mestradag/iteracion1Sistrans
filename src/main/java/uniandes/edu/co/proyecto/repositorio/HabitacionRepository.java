package uniandes.edu.co.proyecto.repositorio;
import uniandes.edu.co.proyecto.modelo.CuentaConsumo;
import uniandes.edu.co.proyecto.modelo.Habitacion;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.DeleteQuery;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;

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

    public interface RespuestaDineroRecolectado {
        
        int getID_HAB();
        int getDINERO_REC();

    }

    public interface RespuestaIndiceOcupacion {

        int getID_HAB();
        int getUSUARIOS_EN_HABITACION();
        float getINDICE_OCUPACION();

    }

    @Query("{}")
    List<Habitacion> darHabitaciones();

    //RF2 Consultar habitacion
    @Query("{_id: ?0}")
    Habitacion darHabitacion(int id);

    @Query("{_id: ?0}")
    @Update("{$push:{capacidad:?1, disponible:?2, tipo:?3, dotacion:?4, precioNoche:?5}}")
    void actualizarHabitacion(int idhabitacion, int capacidad, Boolean disponible, String tipo, String dotacion, int precioNoche);

    //RF1 Actualizar tipo de habitacion
    @Query("{_id: ?0}")
    @Update("{$set:{tipo:{tipoH:?3}}}")
    void actualizarTipoHabitacion(String id_hotel, String tipoH);

    //RF1 Consultar tipo de habitacion  
    @Query("{_id: ?0},{tipo:1}")
    List<RespuestadarTipodeHabitacion> darTipodeHabitacion();

    @Query(value="{_id: ?0}", delete = true)
    void eliminarHabitacion(int idhabitacion);

    //RFC1 -  MOSTRAR EL DINERO RECOLECTADO POR SERVICIOS EN CADA HABITACIÓN EN EL ÚLTIMO AÑO CORRIDO. 
    @Aggregation({
        "{ $match: { 'fechareserva': { $gte: ISODate('2023-01-01T12:00:00Z'), $lte: ISODate('2023-12-31T12:00:00Z') } } }",
        "{ $lookup: { from: 'servicios', localField: 'idservicio', foreignField: 'idservicio', as: 'servicio' } }",
        "{ $unwind: '$servicio' }",
        "{ $group: { _id: '$idhabitacion', dinero_rec: { $sum: '$servicio.costoTotal' } } }",
        "{ $project: { _id: 0, id_hab: '$_id', dinero_rec: 1 } }"
    })
    List<RespuestaDineroRecolectado> darDineroRecolectadoPorServicios();

    //RFC2 -  MOSTRAR EL ÍNDICE DE OCUPACIÓN DE CADA UNA DE LAS HABITACIONES DEL HOTEL EN EL ÚLTIMO AÑO CORRIDO (Se debe mostrar el % de ocupación de cada habitación en el último año (2023)).
    @Aggregation({
        "{ $match: { 'reservas.fechainicio': { $gte: ISODate('2023-01-01T12:00:00Z'), $lte: ISODate('2023-12-31T12:00:00Z') } } }",
        "{ $unwind: '$reservas' }",
        "{ $lookup: { from: 'usuarios', localField: 'reservas.idusuario', foreignField: 'idusuario', as: 'usuario' } }",
        "{ $unwind: '$usuario' }",
        "{ $group: { _id: '$_id', id_hab: { $first: '$idhabitacion' }, usuarios_en_habitacion: { $addToSet: '$usuario.idusuario' } } }",
        "{ $project: { _id: 0, id_hab: 1, usuarios_en_habitacion: { $size: '$usuarios_en_habitacion' }, indice_ocupacion: { $multiply: [ { $divide: [ { $size: '$usuarios_en_habitacion' }, 365 ] }, 100 ] } } }"
    })
    List<RespuestaIndiceOcupacion> darIndiceOcupacion();

    //RFC3 -  MOSTRAR EL CONSUMO EN HOTELANDES POR UN CLIENTE, EN UN RANGO DE FECHAS INDICADO. 
    @Aggregation({
            "{ $match: { 'reservas.usuarios.nombre': ?0, 'reservas.checkin': { $gte: ISODate(?1), $lte: ISODate(?2) } } }",
            "{ $project: { _id: 0, cu: '$$ROOT' } }"
    })
    List<CuentaConsumo> darConsumoPorUsuarioEnRango(String nombreusuario, String fechainicio, String fechafin);



}

