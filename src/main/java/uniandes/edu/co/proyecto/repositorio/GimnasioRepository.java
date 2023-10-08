package uniandes.edu.co.proyecto.repositorio;

import java.sql.Timestamp;
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

    @Query(value="SELECT * FROM gimnasios WHERE idservicio = :idservicio", nativeQuery = true)
    Gimnasio darGimnasio(@Param("idservicio") Integer idservicio);

    @Modifying
    @Transactional
    @Query(value="INSERT INTO gimnasios (idservicio, numeroMaquinas, horaInicio, horaFin) VALUES(parranderos_sequence.nextval, :numeroMaquinas, :horaInicio, :horaFin", nativeQuery=true) 
    void insertarGimnasio(@Param("numeroMaquinas") Integer numeroMaquinas,@Param("horaInicio") Timestamp horaInicio,@Param("horaFin") Timestamp horaFin);

    @Modifying
    @Transactional
    @Query (value ="UPDATE gimnasios SET numeroMaquinas=:numeroMaquinas, horaInicio=:horaInicio, horaFin=:horaFin WHERE idservicio=:idservicio", nativeQuery = true)
    void actualizarGimnasio(@Param("idservicio") Integer idservicio,@Param("numeroMaquinas") Integer numeroMaquinas,@Param("horaInicio") Timestamp horaInicio,@Param("horaFin") Timestamp horaFin);

    @Modifying
    @Transactional
    @Query (value ="DELETE FROM gimrnasios WHERE idservicio=:idservicio", nativeQuery=true)
    void eliminarGimnasio(@Param("idservicio") Integer idservicio);
}
