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

    @Query(value = "SELECT * FROM cuentas_c WHERE id = :id", nativeQuery = true)
    CuentaConsumo darCuentaConsumo(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO cuentas_c (id, estado, checkin, checkout) VALUES (parranderos_sequence.nextval, :estado, :checkin, :checkout)", nativeQuery = true)
    void insertarCuentaConsumo(@Param("estado") Boolean estado, @Param("checkin") Timestamp checkin, @Param("checkout") Timestamp checkout);

    @Modifying
    @Transactional
    @Query(value = "UPDATE cuentas_c SET estado = :estado, checkin = :checkin, checkout = :checkout WHERE id = :id", nativeQuery = true)
    void actualizarCuentaConsumo(@Param("id") int id, @Param("estado") Boolean estado, @Param("checkin") Timestamp checkin, @Param("checkout") Timestamp checkout);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM cuentas_c WHERE id = :id", nativeQuery = true)
    void eliminarCuentaConsumo(@Param("id") int id);
}
