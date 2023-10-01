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

    @Query(value="SELECT * FROM gimnasios WHERE idServicio = :idServicio", nativeQuery = true)
    Gimnasio darGimnasio(@Param("idServicio") Integer idServicio);

    @Modifying
    @Transactional
    @Query(value="INSERT INTO gimnasios (idServicio, numeroMaquinas, horaInicio, horaFin) VALUES(parranderos_sequence.nextval, :numeroMaquinas, :horaInicio, :horaFin", nativeQuery=true) 
    void insertarGimnasio(@Param("numeroMaquinas") Integer numeroMaquinas,@Param("horaInicio") Timestamp horaInicio,@Param("horaFin") Timestamp horaFin);

    @Modifying
    @Transactional
    @Query (value ="UPDATE gimnasios SET numeroMaquinas=:numeroMaquinas, horaInicio=:horaInicio, horaFin=:horaFin WHERE idServicio=:idServicio", nativeQuery = true)
    void actualizarGimnasio(@Param("idServicio") Integer idServicio,@Param("numeroMaquinas") Integer numeroMaquinas,@Param("horaInicio") Timestamp horaInicio,@Param("horaFin") Timestamp horaFin);

    @Modifying
    @Transactional
    @Query (value ="DELETE FROM gimrnasios WHERE idServicio=:idServicio", nativeQuery=true)
    void eliminarGimnasio(@Param("idServicio") Integer idServicio);
}
