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

    @Query(value="SELECT * FROM internet WHERE idservicio = :idservicio", nativeQuery = true)
    Internet darInternet(@Param("idservicio") Integer idservicio);

    @Modifying
    @Transactional
    @Query(value="INSERT INTO internet (idservicio, bandaAncha) VALUES(parranderos_sequence.nextval, :bandaAncha", nativeQuery=true) 
    void insertarInternet(@Param("bandaAncha") Double bandaAncha);

    @Modifying
    @Transactional
    @Query (value ="UPDATE internet SET bandaAncha=:bandaAncha WHERE idservicio=:idservicio", nativeQuery = true)
    void actualizarInternet(@Param("idservicio") Integer idservicio,@Param("bandaAncha") Double bandaAncha);

    @Modifying
    @Transactional
    @Query (value ="DELETE FROM internet WHERE idservicio=:idservicio", nativeQuery=true)
    void eliminarInternet(@Param("idservicio") Integer idservicio);
}
