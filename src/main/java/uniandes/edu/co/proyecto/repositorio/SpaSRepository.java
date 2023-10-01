package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.SpaS;

public interface SpaSRepository extends JpaRepository<SpaS,String>{
    @Query(value="SELECT * FROM servicios_spa", nativeQuery=true) 
    Collection<SpaS> darSpaS();

    @Query(value="SELECT * FROM servicios_spa WHERE id = :id", nativeQuery = true)
    SpaS darSpaS(@Param("nombre") String nombre);

    @Modifying
    @Transactional
    @Query(value="INSERT INTO servicios_spa (nombre,duracion,costo) VALUES(parranderos_sequence.nextval, :id, :costoTotal, :capacidad, :bandaAncha", nativeQuery=true) 
    void insertarSpaS(@Param("costoTotal") String costoTotal,@Param("capacidad") Integer capacidad,@Param("bandaAncha") Integer bandaAncha);

    @Modifying
    @Transactional
    @Query (value ="UPDATE servicios_spa SET duracion=:duracion,costo= :costo", nativeQuery = true)
    void actualizarSpaS(@Param("nombre") String nombre,@Param("duracion") Integer duracion,@Param("costo") Integer costo);

    @Modifying
    @Transactional
    @Query (value ="DELETE FROM internet WHERE id=:id", nativeQuery=true)
    void eliminarSpaS(@Param("nombre") String nombr);
    
}
