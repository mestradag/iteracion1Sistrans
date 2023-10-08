package uniandes.edu.co.proyecto.repositorio;

import uniandes.edu.co.proyecto.modelo.CuentaConsumo;

import java.sql.Timestamp;
import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;



public interface CuentaConsumoRepository extends JpaRepository<CuentaConsumo, Integer> {
    

    @Query(value = "SELECT * FROM CUENTAS_C", nativeQuery = true) 
    Collection<CuentaConsumo> darCuentasConsumo();

    @Query(value = "SELECT * FROM cuentas_c WHERE idcuenta = :idcuenta", nativeQuery = true)
    CuentaConsumo darCuentaConsumo(@Param("idcuenta") int idcuenta);
    /*Change the code below if necessary because CuentaConsumo recieves two more atributes: idReserva and idHabitacion */

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO cuentas_c (idcuenta, estado, checkin, checkout,idreserva,idhabitacion) VALUES (parranderos_sequence.nextval, :estado, :checkin, :checkout, :idreserva, :idhabitacion)", nativeQuery = true)
    void insertarCuentaConsumo(@Param("estado") Boolean estado, @Param("checkin") Timestamp checkin, @Param("checkout") Timestamp checkout, @Param("idreserva") int idreserva, @Param("idhabitacion") int idhabitacion);

    @Modifying
    @Transactional
    @Query(value = "UPDATE cuentas_c SET estado = :estado, checkin = :checkin, checkout = :checkout,idreserva = :idreserva,idhabitacion = :idhabitacion, WHERE idcuenta = :idcuenta", nativeQuery = true)
    void actualizarCuentaConsumo(@Param("idcuenta") int idcuenta, @Param("estado") Boolean estado, @Param("checkin") Timestamp checkin, @Param("checkout") Timestamp checkout , @Param("idreserva") int idreserva, @Param("idhabitacion") int idhabitacion);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM cuentas_c WHERE idcuenta = :idcuenta", nativeQuery = true)
    void eliminarCuentaConsumo(@Param("idcuenta") int idcuenta);
}
