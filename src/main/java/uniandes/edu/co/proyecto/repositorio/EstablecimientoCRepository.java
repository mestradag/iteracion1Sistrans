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

    @Query(value="SELECT * FROM establecimientos_c WHERE id = :id", nativeQuery = true)
    EstablecimientoC darEstablecimientoC(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value="INSERT INTO establecimientos_c (id, costoTotal, capacidad, nombre,tipo) VALUES(parranderos_sequence.nextval, :id, :costoTotal, :capacidad, :nombre,:tipo", nativeQuery=true) 
    void insertarEstablecimientoC(@Param("costoTotal") String costoTotal,@Param("capacidad") Integer capacidad,@Param("nombre") String nombre,@Param("tipo") String tipo);

    @Modifying
    @Transactional
    @Query (value ="UPDATE establecimientos_c SET costoTotal=:costoTotal,capacidad= :capacidad, estilo=:estilo,tipo=:tipo", nativeQuery = true)
    void actualizarEstablecimientoC(@Param("id") Integer id,@Param("costoTotal") Integer costoTotal,@Param("capacidad") Integer capacidad,@Param("nombre") String nombre,@Param("tipo") String tipo);

    @Modifying
    @Transactional
    @Query (value ="DELETE FROM establecimientos_c WHERE id=:id", nativeQuery=true)
    void eliminarEstablecimientoC(@Param("id") int id);
}
