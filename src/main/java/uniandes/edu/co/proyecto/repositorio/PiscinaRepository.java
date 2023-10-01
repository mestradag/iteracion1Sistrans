package uniandes.edu.co.proyecto.repositorio;

import java.sql.Timestamp;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Piscina;

public interface PiscinaRepository extends JpaRepository<Piscina, Integer> {
    @Query(value="SELECT * FROM piscinas", nativeQuery=true) 
    Collection<Piscina> darPiscinas();

    @Query(value="SELECT * FROM piscinas WHERE idServicio = :idServicio", nativeQuery = true)
    Piscina darPiscina(@Param("idServicio") Integer idServicio);

    @Modifying
    @Transactional
    @Query(value="INSERT INTO piscinas (idServicio, profundidad, horaInicio, horaFin) VALUES(parranderos_sequence.nextval, :profundidad, :horaInicio,:horaFin", nativeQuery=true) 
    void insertarPiscina(@Param("profundidad") Integer profunidad, @Param("horaInicio") Timestamp horaInicio, @Param("horaFin") Timestamp horaFin);

    @Modifying
    @Transactional
    @Query (value ="UPDATE piscinas SET profundidad=:profundidad, horaInicio=:horaInicio, horaFin=:horaFin WHERE idServicio=:idServicio", nativeQuery = true)
    void actualizarPiscina(@Param("idServicio") Integer idServicio,@Param("profundidad") Integer profunidad, @Param("horaInicio") Timestamp horaInicio, @Param("horaFin") Timestamp horaFin);

    @Modifying
    @Transactional
    @Query (value ="DELETE FROM piscinas WHERE idServicio=:idServicio", nativeQuery=true)
    void eliminarPiscina(@Param("idServicio") Integer idServicio);
}
