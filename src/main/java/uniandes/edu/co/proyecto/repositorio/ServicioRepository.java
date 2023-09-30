package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.CuentaConsumo;
import uniandes.edu.co.proyecto.modelo.Hotel;
import uniandes.edu.co.proyecto.modelo.PlanConsumo;
import uniandes.edu.co.proyecto.modelo.Servicio;

public interface ServicioRepository extends JpaRepository<Servicio,Integer>{
    @Query(value="SELECT * FROM servicios", nativeQuery=true) 
    Collection<Servicio> darServicios();

    @Query(value="SELECT * FROM servicios WHERE id = :id", nativeQuery = true)
    Servicio darServicio(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value="INSERT INTO servicios (id, costoTotal,capacidad,cuentaC,planC, hotel) VALUES(parranderos_sequence.nextval, :costoTotal, :capacidad, :cuentaC, :planC, :hotel", nativeQuery = true) 
    void insertarServicio(@Param("costoTotal") String costoTotal, @Param("capacidad") Integer capacidad, @Param("cuentaC") CuentaConsumo cuentaC, @Param("planC") PlanConsumo planC, @Param("hotel") Hotel hotel);

    @Modifying
    @Transactional
    @Query (value ="UPDATE servicios SET costoTotal=:costoTotal,capacidad= :capacidad, cuentaC=:cuentaC,planC= :planC, hotel=:hotel WHERE id=:id", nativeQuery = true)
    void actualizarServicio(@Param("id") Integer id,@Param("costoTotal") String costoTotal, @Param("capacidad") Integer capacidad, @Param("cuentaC") CuentaConsumo cuentaC, @Param("planC") PlanConsumo planC, @Param("hotel") Hotel hotel);

    @Modifying
    @Transactional
    @Query (value ="DELETE FROM servicios WHERE id=:id", nativeQuery=true)
    void eliminarServicio(@Param("id") int id);
}
