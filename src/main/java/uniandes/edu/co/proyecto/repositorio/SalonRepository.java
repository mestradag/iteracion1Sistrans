package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Salon;
import uniandes.edu.co.proyecto.modelo.TipoSalon;

public interface SalonRepository extends JpaRepository<Salon, Integer>{
    @Query(value="SELECT * FROM salones", nativeQuery=true) 
    Collection<Salon> darSalones();

    @Query(value="SELECT * FROM salones WHERE idservicio = :idservicio", nativeQuery = true)
    Salon darSalon(@Param("idservicio") Integer idservicio);

    @Modifying
    @Transactional
    @Query(value="INSERT INTO salones (idservicio, tipo) VALUES(parranderos_sequence.nextval, :tipo", nativeQuery=true) 
    void insertarSalon(@Param("tipo") TipoSalon tipo);

    @Modifying
    @Transactional
    @Query (value ="UPDATE salones SET tipo=:tipo WHERE idservicio=:idservicio", nativeQuery = true)
    void actualizarSalon(@Param("idservicio") Integer idservicio,@Param("tipo") TipoSalon tipo);

    @Modifying
    @Transactional
    @Query (value ="DELETE FROM salones WHERE idservicio=:idservicio", nativeQuery=true)
    void eliminarSalon(@Param("idservicio") Integer idservicio);
}
