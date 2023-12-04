package uniandes.edu.co.proyecto.repositorio;
import uniandes.edu.co.proyecto.modelo.CuentaConsumo;

import java.util.Date;
import java.util.List;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;
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
    // void insertarCuentaConsumo(@Param("estado") Boolean estado, @Param("checkin") Date checkin, @Param("checkout") Date checkout, @Param("idhabitacion") Integer idhabitacion);

    @Query("{_id: ?0}")
    @Update("{$push:{estado:?1, checkin:?2, checkout:?3}}")
    void actualizarCuentaConsumo(int idcuenta,Boolean estado, Date checkin, Date checkout);

    //TOCA REVISAR NO SÉ SI ES ASI
    @Query(value="{_id: ?0}", delete = true)
    void eliminarCuentaConsumo(Integer idcuenta);
}

