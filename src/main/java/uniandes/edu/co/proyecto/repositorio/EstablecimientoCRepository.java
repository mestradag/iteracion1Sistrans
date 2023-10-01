package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.EstablecimientoC;

public interface EstablecimientoCRepository extends JpaRepository<EstablecimientoC, Integer> {
    @Query(value="SELECT * FROM establecimientos_c", nativeQuery=true) 
    Collection<EstablecimientoC> darEstablecimientosC();

    @Query(value="SELECT * FROM establecimientos_c WHERE idServicio = :idServicio", nativeQuery = true)
    EstablecimientoC darEstablecimientoC(@Param("idServicio") Integer idServicio);

    @Modifying
    @Transactional
    @Query(value="INSERT INTO establecimientos_c (idServicio, nombre,tipo) VALUES(parranderos_sequence.nextval, :nombre,:tipo", nativeQuery=true) 
    void insertarEstablecimientoC(@Param("nombre") String nombre,@Param("tipo") String tipo);

    @Modifying
    @Transactional
    @Query (value ="UPDATE establecimientos_c SET nombre=:nombre,tipo=:tipo WHERE idServicio=:idServicio", nativeQuery = true)
    void actualizarEstablecimientoC(@Param("idServicio") Integer idServicio,@Param("nombre") String nombre,@Param("tipo") String tipo);

    @Modifying
    @Transactional
    @Query (value ="DELETE FROM establecimientos_c WHERE idServicio=:idServicio", nativeQuery=true)
    void eliminarEstablecimientoC(@Param("idServicio") Integer idServicio);
}
