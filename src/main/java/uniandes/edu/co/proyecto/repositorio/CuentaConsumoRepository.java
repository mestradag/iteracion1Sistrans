package uniandes.edu.co.proyecto.repositorio;
import uniandes.edu.co.proyecto.modelo.CuentaConsumo;

import java.sql.Timestamp;
import java.util.List;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;
import org.springframework.data.mongodb.repository.DeleteQuery;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CuentaConsumoRepository extends MongoRepository<CuentaConsumo, Integer> {
    
    public class Respuesta{

    }

    @Query("{}")
    List<CuentaConsumo> darCuentasConsumo();

    @Query("{_id: ?0}")
    CuentaConsumo darCuentaConsumo(Integer idcuenta);

    // @Modifying
    // @Transactional
    // @Query(value = "INSERT INTO cuentas_c (idcuenta, estado, checkin, checkout,idhabitacion) VALUES (parranderos_sequence.nextval, :estado, :checkin, :checkout, :idhabitacion)", nativeQuery = true)
    // void insertarCuentaConsumo(@Param("estado") Boolean estado, @Param("checkin") Timestamp checkin, @Param("checkout") Timestamp checkout, @Param("idhabitacion") Integer idhabitacion);

    @Query("{_id: ?0}")
    @Update("{$push:{estado:?1, checkin:?2, checkout:?3}}")
    void actualizarCuentaConsumo(int idcuenta,Boolean estado, Timestamp checkin, Timestamp checkout);

    //TOCA REVISAR NO SÉ SI ES ASI
    @DeleteQuery("{_id: ?0}")
    void eliminarCuentaConsumo(Integer idcuenta);
}

