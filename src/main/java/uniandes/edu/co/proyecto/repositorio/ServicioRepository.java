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

    @Query(value="SELECT * FROM servicios WHERE idservicio = :idservicio", nativeQuery = true)
    Servicio darServicio(@Param("idservicio") Integer idservicio);

    @Modifying
    @Transactional
    @Query(value="INSERT INTO servicios(idservicio,cuentaC,planC, nombrehotel) VALUES(parranderos_sequence.nextval, :cuentaC, :planC, :nombrehotel", nativeQuery = true) 
    void insertarServicio(@Param("cuentaC") CuentaConsumo cuentaC, @Param("planC") PlanConsumo planC, @Param("nombrehotel") Hotel nombrehotel);

    @Modifying
    @Transactional
    @Query (value ="UPDATE servicios SET cuentaC=:cuentaC,planC=:planC, nombrehotel=:nombrehotel WHERE idservicio=:idservicio", nativeQuery = true)
    void actualizarServicio(@Param("idservicio") Integer idservicio, @Param("cuentaC") CuentaConsumo cuentaC, @Param("planC") PlanConsumo planC, @Param("nombrehotel") Hotel nombrehotel);

    @Modifying
    @Transactional
    @Query (value ="DELETE FROM servicios WHERE idservicio=:idservicio", nativeQuery=true)
    void eliminarServicio(@Param("idservicio") Integer idservicio);
}
