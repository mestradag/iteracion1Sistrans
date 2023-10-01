package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Equipo;
import uniandes.edu.co.proyecto.modelo.TipoEquipo;

public interface EquipoRepository extends JpaRepository<Equipo, Integer> {
    @Query(value="SELECT * FROM equipos", nativeQuery=true) 
    Collection<Equipo> darEquipos();

    @Query(value="SELECT * FROM equipos WHERE id = :id", nativeQuery = true)
    Equipo darEquipo(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value="INSERT INTO equipos (id, tipo, costo) VALUES(parranderos_sequence.nextval, :tipo, :costo", nativeQuery=true) 
    void insertarEquipo(@Param("tipo") TipoEquipo tipo,@Param("costo") Integer costo);

    @Modifying
    @Transactional
    @Query (value ="UPDATE equipos SET tipo=:tipo,costo= :costo", nativeQuery = true)
    void actualizarEquipo(@Param("id") Integer id,@Param("tipo") TipoEquipo tipo,@Param("costo") Integer costo);

    @Modifying
    @Transactional
    @Query (value ="DELETE FROM equipos WHERE id=:id", nativeQuery=true)
    void eliminarEquipo(@Param("id") int id);
}
