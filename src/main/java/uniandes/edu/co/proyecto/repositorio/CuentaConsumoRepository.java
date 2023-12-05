package uniandes.edu.co.proyecto.repositorio;
import uniandes.edu.co.proyecto.modelo.CuentaConsumo;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CuentaConsumoRepository extends MongoRepository<CuentaConsumo, String> {

    //RFC3 -  MOSTRAR EL CONSUMO EN HOTELANDES POR UN CLIENTE, EN UN RANGO DE FECHAS INDICADO. 
    //Recuerde que un cliente puede alojarse en el hotel cuantas veces quiera.

    @Aggregation(pipeline = {
        "{$match: {'reservas.cuenta_c.checkin': { $gte: { $dateFromString: { dateString: ':?0', format: '%Y-%m-%dT%H:%M:%S.%LZ' } }, $lte: { $dateFromString: { dateString: ':?1', format: '%Y-%m-%dT%H:%M:%S.%LZ' } } } }}",
        "{$match: {rol:'cliente'}}",
        "{$lookup: {from: 'servicios', localField: 'reservas.cuenta_c.serviciosconsumidos.idservicio', foreignField: '_id', as: 'servicio'}}",
        "{$unwind: '$servicio'}",
        "{$group: {_id: {idcuenta: '$idcuenta', nombreCliente: '$nombre'}, totalConsumo: {$sum: '$servicio.costototal'}}}",
        "{$project: {idcuenta: '$_id.idcuenta', nombreCliente: '$_id.nombreCliente', totalConsumo: 1, rol:1, _id: 0}}"
    })
    List<CuentaConsumo> consumoCliente(String fechaInicio, String fechaFin);
}

