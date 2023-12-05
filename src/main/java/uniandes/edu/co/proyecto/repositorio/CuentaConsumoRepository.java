package uniandes.edu.co.proyecto.repositorio;
import uniandes.edu.co.proyecto.modelo.CuentaConsumo;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

public interface CuentaConsumoRepository extends MongoRepository<CuentaConsumo, String> {

    //RFC3 -  MOSTRAR EL CONSUMO EN HOTELANDES POR UN CLIENTE, EN UN RANGO DE FECHAS INDICADO. 
    //Recuerde que un cliente puede alojarse en el hotel cuantas veces quiera.
    @Aggregation(pipeline = {
        "{$match: {'reservas.cuenta_c.checkin': { $gte: ?0, $lte: ?1 } }}",
        "{$match: {rol: 'cliente'}}",
        "{$lookup: {from: 'servicios', localField: 'reservas.cuenta_c.serviciosconsumidos.idservicio', foreignField: '_id', as: 'servicio'}}",
        "{$unwind: '$servicio'}",
        "{$group: {_id: {idcuenta: '$idcuenta', nombreCliente: '$nombre'}, totalConsumo: {$sum: '$servicio.costototal'}}}"
    })
    List<CuentaConsumo> consumoCliente(@Param("0") Date fechainicio,  @Param("1") Date fechafin);
}

