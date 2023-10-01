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

    @Query(value="SELECT * FROM salones WHERE id = :id", nativeQuery = true)
    Salon darInternet(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value="INSERT INTO salones (id, costoTotal, capacidad, tipo) VALUES(parranderos_sequence.nextval, :id, :costoTotal, :capacidad, :tipo", nativeQuery=true) 
    void insertarInternet(@Param("costoTotal") String costoTotal,@Param("capacidad") Integer capacidad,@Param("tipo") TipoSalon tipo);

    @Modifying
    @Transactional
    @Query (value ="UPDATE salones SET costoTotal=:costoTotal,capacidad= :capacidad, tipo=:tipo", nativeQuery = true)
    void actualizarInternet(@Param("id") Integer id,@Param("costoTotal") Integer costoTotal,@Param("capacidad") Integer capacidad,@Param("tipo") TipoSalon tipo);

    @Modifying
    @Transactional
    @Query (value ="DELETE FROM salones WHERE id=:id", nativeQuery=true)
    void eliminarInternet(@Param("id") int id);
}
