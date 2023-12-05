package uniandes.edu.co.proyecto.repositorio;
import uniandes.edu.co.proyecto.modelo.CuentaConsumo;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CuentaConsumoRepository extends MongoRepository<CuentaConsumo, String> {

    /*
    @Aggregation(pipeline = {
        "{$match: { 'reservas.cuentas_c.checkout': { $gte: ISODate('?0'), $lt: ISODate('?1') } }}",
        "{$unwind: '$reservas.cuentas_c.serviciosconsumidos'}",
        "{$lookup: { from: 'servicios', localField: 'reservas.reservas.serviciosconsumidos.idservicio', foreignField: '_id', as: 'servicio'}}",
        "{$unwind: '$servicio'}",
        "{$group: {_id: { idcuenta: '$idcuenta', nombreCliente: '$nombre' }, totalConsumo: {$sum: '$servicio.costototal'}}}",
        "{$project: {idcuenta: '$_id.idcuenta', nombreCliente: '$_id.nombreCliente', totalConsumo: 1, _id: 0}}"
    })
    List<CuentaConsumo> consumoPorClienteEnRango(Date fechaInicio, Date fechaFin);
    */
}

