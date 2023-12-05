package uniandes.edu.co.proyecto.repositorio;
import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import uniandes.edu.co.proyecto.modelo.Usuario;

public interface UsuarioRepository extends MongoRepository<Usuario, String>{

    public class RespuestaClientesExcelentes{
        String idcliente;
        String nombre;
        public RespuestaClientesExcelentes(String idcliente, String nombre) {
            this.idcliente = idcliente;
            this.nombre = nombre;
        }
        public void setIdcliente(String idcliente) {
            this.idcliente = idcliente;
        }
        public void setNombre(String nombre) {
            this.nombre = nombre;
        }
        public String getIdcliente() {
            return idcliente;
        }
        public String getNombre() {
            return nombre;
        }
    }
    
    //RFC7 -  CONSULTAR LOS CLIENTES EXCELENTES
    /*Los clientes excelentes son de tres tipos: aquellos que realizan estancias (las estancias están delimitadas por un check in y 
    su respectivo check out) en HotelAndes al menos una vez por trimestre. Esta consulta retorna toda la información de dichos clientes.*/

    @Aggregation(pipeline = {
        "{$match: { 'reservas.cuenta_c.checkin': { $gte: ISODate('2023-01-01T14:00:00.000+00:00'), $lte: ISODate('2023-01-01T14:00:00.000+00:00') }}}",
        "{$group: {_id: { idcliente: '$_id', nombre: '$nombre' }}}",
        "{$project: {idcliente: '$_id.idcliente', nombre: '$_id.nombre', _id: 0}}"
    })
    List<RespuestaClientesExcelentes> clientesExcelentes();
    
}

