package uniandes.edu.co.proyecto.repositorio;

import java.security.Timestamp;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Gimnasio;

public interface GimnasioRepository  extends JpaRepository<Gimnasio, Integer> {
    @Query(value="SELECT * FROM gimnasios", nativeQuery=true) 
    Collection<Gimnasio> darGimnasios();

    @Query(value="SELECT * FROM gimnasios WHERE id = :id", nativeQuery = true)
    Gimnasio darGimnasio(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value="INSERT INTO gimnasios (id, costoTotal, capacidad, numeroMaquinas, horaInicio, horaFin) VALUES(parranderos_sequence.nextval, :id, :costoTotal, :capacidad, :bandaAncha, :numeroMaquinas, :horaInicio, :horaFin", nativeQuery=true) 
    void insertarGimnasio(@Param("costoTotal") Integer costoTotal,@Param("capacidad") Integer capacidad,@Param("numeroMaquinas") Integer numeroMaquinas,@Param("horaInicio") Timestamp horaInicio,@Param("horaFin") Timestamp horaFin);

    @Modifying
    @Transactional
    @Query (value ="UPDATE gimnasios SET costoTotal=:costoTotal,capacidad= :capacidad, numeroMaquinas=:numeroMaquinas, horaInicio=:horaInicio, horaFin=:horaFin WHERE id=:id", nativeQuery = true)
    void actualizarGimnasio(@Param("id") Integer id,@Param("costoTotal") Integer costoTotal,@Param("capacidad") Integer capacidad,@Param("numeroMaquinas") Integer numeroMaquinas,@Param("horaInicio") Timestamp horaInicio,@Param("horaFin") Timestamp horaFin);

    @Modifying
    @Transactional
    @Query (value ="DELETE FROM gimrnasios WHERE id=:id", nativeQuery=true)
    void eliminarGimnasio(@Param("id") int id);
}
