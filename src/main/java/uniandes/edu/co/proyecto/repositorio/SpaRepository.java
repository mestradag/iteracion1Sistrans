package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Spa;

public interface SpaRepository extends JpaRepository<Spa, Integer> {
    @Query(value="SELECT * FROM spas", nativeQuery=true) 
    Collection<Spa> darSpas();

    @Query(value="SELECT * FROM spas WHERE idservicio = :idservicio", nativeQuery = true)
    Spa darSpa(@Param("idservicio") Integer idservicio);

    @Modifying
    @Transactional
    @Query(value="INSERT INTO spas (idservicio, nombre", nativeQuery=true) 
    void insertarSpa(@Param("nombre") String nombre);

    @Modifying
    @Transactional
    @Query (value ="UPDATE spas SET nombre=:nombre", nativeQuery = true)
    void actualizarSpa(@Param("idservicio") Integer idservicio,@Param("nombre") String nombre);

    @Modifying
    @Transactional
    @Query (value ="DELETE FROM spas WHERE idservicio=:idservicio", nativeQuery=true)
    void eliminarSpa(@Param("idservicio") Integer idservicio);
    
}
