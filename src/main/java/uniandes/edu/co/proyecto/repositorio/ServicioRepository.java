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

    public interface Respuesta20Servicios {
        
        int getNOMBRE_SERVICIO();
        int getVECES_CONSUMIDO();

    }

    @Query(value="SELECT * FROM servicios", nativeQuery=true) 
    Collection<Servicio> darServicios();

    @Query(value="SELECT * FROM servicios WHERE idservicio= :idservicio", nativeQuery = true)
    Servicio darServicio(@Param("idservicio") Integer idservicio);

    @Modifying
    @Transactional
    @Query(value="INSERT INTO servicios(idservicio,nombre,descripcion,idplanconsumo, nombrehotel) VALUES (parranderos_sequence.nextval, :nombre, :descripcion, :idplanconsumo, :nombrehotel)", nativeQuery = true) 
    void insertarServicio(@Param("nombre") String nombre,@Param("descripcion") String descripcion,@Param("idplanconsumo") Integer idplanconsumo, @Param("nombrehotel") String nombrehotel);

    @Modifying
    @Transactional
    @Query (value ="UPDATE servicios SET nombre= :nombre, descripcion= :descripcion WHERE idservicio= :idservicio", nativeQuery = true)
    void actualizarServicio(@Param("idservicio") Integer idservicio, @Param("nombre") String nombre,@Param("descripcion") String descripcion);

    @Modifying
    @Transactional
    @Query (value ="DELETE FROM servicios WHERE idservicio= :idservicio", nativeQuery=true)
    void eliminarServicio(@Param("idservicio") Integer idservicio);

    @Query (value = "SELECT s.nombre AS nombre_servicio, " +//
                    "COUNT(*) AS veces_consumido " +//
                    "FROM servicios s " +//
                    "JOIN s_consumidos sc on s.idservicio = sc.idservicio "+//
                    "WHERE sc.idcuenta IN (SELECT idcuenta FROM cuentas_c WHERE checkout BETWEEN TO_TIMESTAMP(:fechainicio, 'DD-MM-YYYY HH24:MI:SS') AND TO_TIMESTAMP(:fechafin, 'DD-MM-YYYY HH24:MI:SS'))" +//
                    "GROUP BY s.nombre " +//
                    "ORDER BY veces_consumido DESC " +//
                    "FETCH FIRST 20 ROWS ONLY", nativeQuery = true)
    Collection<Respuesta20Servicios> dar20serviciosPopulares (@Param("fechainicio") String fechainicio, @Param("fechafin") String fechafin); //'11-11-2023 00:00:00'
}
