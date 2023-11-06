package uniandes.edu.co.proyecto.repositorio;

import uniandes.edu.co.proyecto.modelo.CuentaConsumo;

import java.sql.Timestamp;
import java.util.Collection;

import org.antlr.v4.runtime.atn.SemanticContext.AND;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import oracle.net.aso.h;



public interface CuentaConsumoRepository extends JpaRepository<CuentaConsumo, Integer> {
    

    @Query(value = "SELECT * FROM cuentas_c", nativeQuery = true) 
    Collection<CuentaConsumo> darCuentasConsumo();

    @Query(value = "SELECT * FROM cuentas_c WHERE idcuenta = :idcuenta", nativeQuery = true)
    CuentaConsumo darCuentaConsumo(@Param("idcuenta") int idcuenta);
    /*Change the code below if necessary because CuentaConsumo recieves one more atributes: idhabitacion */

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO cuentas_c (idcuenta, estado, checkin, checkout,idhabitacion) VALUES (parranderos_sequence.nextval, :estado, :checkin, :checkout, :idhabitacion)", nativeQuery = true)
    void insertarCuentaConsumo(@Param("estado") Boolean estado, @Param("checkin") Timestamp checkin, @Param("checkout") Timestamp checkout, @Param("idhabitacion") Integer idhabitacion);

    @Modifying
    @Transactional
    @Query(value = "UPDATE cuentas_c SET estado = :estado, checkin = :checkin, checkout = :checkout WHERE idcuenta = :idcuenta", nativeQuery = true)
    void actualizarCuentaConsumo(@Param("idcuenta") int idcuenta, @Param("estado") Boolean estado, @Param("checkin") Timestamp checkin, @Param("checkout") Timestamp checkout);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM cuentas_c WHERE idcuenta = :idcuenta", nativeQuery = true)
    void eliminarCuentaConsumo(@Param("idcuenta") int idcuenta);

    @Query(value = "SELECT cu.* "+//
                   "FROM CUENTAS_C cu "+// 
                   "INNER JOIN HABITACIONES h ON cu.idhabitacion=h.idhabitacion "+//
                   "INNER JOIN RESERVAS r ON h.idhabitacion= r.idhabitacion "+//
                   "INNER JOIN USUARIOS u ON r.idusuario= u.idusuario "+//
                   "WHERE u.nombre = :nombreusuario AND CHECKIN BETWEEN :fechainicio and :fechafin", nativeQuery = true)
    Collection<CuentaConsumo> darConsumoPorUsuarioEnRango(@Param("nombreusuario") String nombreusuario, @Param("fechainicio") String fechainicio, @Param("fechafin") String fechafin);
}

