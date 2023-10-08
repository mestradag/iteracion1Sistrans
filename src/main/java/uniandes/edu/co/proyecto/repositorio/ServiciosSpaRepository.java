package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.ServiciosSpa;

public interface ServiciosSpaRepository extends JpaRepository<ServiciosSpa,String>{
    @Query(value="SELECT * FROM servicios_spa", nativeQuery=true) 
    Collection<ServiciosSpa> darServiciosSpas();

    @Query(value="SELECT * FROM servicios_spa WHERE nombre = :nombre", nativeQuery = true)
    ServiciosSpa darServiciosSpa(@Param("nombre") String nombre);

    @Modifying
    @Transactional
    @Query(value="INSERT INTO servicios_spa (nombre,duracion,costo, idservicio) VALUES( :nombre, :costoTotal, :capacidad, :idservicio", nativeQuery=true) 
    void insertarServiciosSpa(@Param("duracion") Integer duracion,@Param("costo") Integer costo,@Param("idservicio") Integer idservicio);

    @Modifying
    @Transactional
    @Query (value ="UPDATE servicios_spa SET duracion=:duracion,costo= :costo , idservicio:=idservicio WHERE nombre=:nombre", nativeQuery = true)
    void actualizarServiciosSpa(@Param("nombre") String nombre,@Param("duracion") Integer duracion,@Param("costo") Integer costo,@Param("idservicio") Integer idservicio);

    @Modifying
    @Transactional
    @Query (value ="DELETE FROM internet WHERE nombre=:nombre", nativeQuery=true)
    void eliminarServiciosSpa(@Param("nombre") String nombre);
    
}
