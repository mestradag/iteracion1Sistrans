package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Salon;
import uniandes.edu.co.proyecto.modelo.TipoSalon;

public interface SalonRespository extends JpaRepository<Salon, Integer>{
    @Query(value="SELECT * FROM salones", nativeQuery=true) 
    Collection<Salon> darSalones();

    @Query(value="SELECT * FROM salones WHERE idServicio = :idServicio", nativeQuery = true)
    Salon darInternet(@Param("idServicio") Integer idServicio);

    @Modifying
    @Transactional
    @Query(value="INSERT INTO salones (idServicio, tipo) VALUES(parranderos_sequence.nextval, :tipo", nativeQuery=true) 
    void insertarInternet(@Param("tipo") TipoSalon tipo);

    @Modifying
    @Transactional
    @Query (value ="UPDATE salones SET tipo=:tipo WHERE idServicio=:idServicio", nativeQuery = true)
    void actualizarInternet(@Param("idServicio") Integer idServicio,@Param("tipo") TipoSalon tipo);

    @Modifying
    @Transactional
    @Query (value ="DELETE FROM salones WHERE idServicio=:idServicio", nativeQuery=true)
    void eliminarInternet(@Param("idServicio") Integer idServicio);
}
