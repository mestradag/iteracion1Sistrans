package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Lavado;

public interface LavadoRepository extends JpaRepository<Lavado, Integer> {
    @Query(value="SELECT * FROM lavado", nativeQuery=true) 
    Collection<Lavado> darLavados();

    @Query(value="SELECT * FROM lavados WHERE id = :id", nativeQuery = true)
    Lavado darLavado(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value="INSERT INTO lavados (id, costoTotal, capacidad, numeroPrendas, paresZapatos) VALUES(parranderos_sequence.nextval, :id, :costoTotal, :capacidad, :numeroPrendas, :paresZapatos", nativeQuery=true) 
    void insertarLavado(@Param("costoTotal") String costoTotal,@Param("capacidad") Integer capacidad,@Param("numeroPrendas") Integer numeroPrendas,@Param("paresZapatos") Integer paresZapatos);

    @Modifying
    @Transactional
    @Query (value ="UPDATE lavados SET costoTotal=:costoTotal,capacidad= :capacidad, numeroPrendas=:numeroPrendas, paresZapatos=:paresZapatos ", nativeQuery = true)
    void actualizarLavado(@Param("id") Integer id,@Param("costoTotal") Integer costoTotal,@Param("capacidad") Integer capacidad,@Param("numeroPrendas") Integer numeroPrendas,@Param("paresZapatos") Integer paresZapatos);

    @Modifying
    @Transactional
    @Query (value ="DELETE FROM lavados WHERE id=:id", nativeQuery=true)
    void eliminarLavado(@Param("id") int id);
}
