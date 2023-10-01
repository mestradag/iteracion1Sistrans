package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Internet;

public interface InternetRepository extends JpaRepository<Internet, Integer> {
    @Query(value="SELECT * FROM internet", nativeQuery=true) 
    Collection<Internet> darInternets();

    @Query(value="SELECT * FROM internet WHERE id = :id", nativeQuery = true)
    Internet darInternet(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value="INSERT INTO internet (id, costoTotal, capacidad, bandaAncha) VALUES(parranderos_sequence.nextval, :id, :costoTotal, :capacidad, :bandaAncha", nativeQuery=true) 
    void insertarInternet(@Param("costoTotal") String costoTotal,@Param("capacidad") Integer capacidad,@Param("bandaAncha") Integer bandaAncha);

    @Modifying
    @Transactional
    @Query (value ="UPDATE internet SET costoTotal=:costoTotal,capacidad= :capacidad, bandaAncha=:bandaAncha", nativeQuery = true)
    void actualizarInternet(@Param("id") Integer id,@Param("costoTotal") Integer costoTotal,@Param("capacidad") Integer capacidad,@Param("bandaAncha") Integer bandaAncha);

    @Modifying
    @Transactional
    @Query (value ="DELETE FROM internet WHERE id=:id", nativeQuery=true)
    void eliminarInternet(@Param("id") int id);
}
