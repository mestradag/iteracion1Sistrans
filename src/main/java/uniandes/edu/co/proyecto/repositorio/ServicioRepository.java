package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.antlr.v4.runtime.atn.SemanticContext.AND;
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
        
        String getNOMBRE_SERVICIO();
        int getVECES_CONSUMIDO();

    }

    public interface RespuestaServiciosCaracteristicas {

        int getID_SERV();
        String getNOMBRE();
        int getCOSTO_TOTAL();

    }

    public interface RespuestaServiciosNoMuchaDemanda {

        String getNOMBRE_SERVICIO();
        int getVECES_SOLICITADO();
    }

    @Query(value="SELECT * FROM servicios", nativeQuery=true) 
    Collection<Servicio> darServicios();

    @Query(value="SELECT * FROM servicios WHERE idservicio= :idservicio", nativeQuery = true)
    Servicio darServicio(@Param("idservicio") Integer idservicio);

    @Modifying
    @Transactional
    @Query(value="INSERT INTO servicios(idservicio,nombre,descripcion,costototal,idplanconsumo, nombrehotel,costototal) VALUES (parranderos_sequence.nextval, :nombre, :descripcion, :idplanconsumo, :nombrehotel, :costototal)", nativeQuery = true) 
    void insertarServicio(@Param("nombre") String nombre,@Param("descripcion") String descripcion,@Param("idplanconsumo") Integer idplanconsumo, @Param("nombrehotel") String nombrehotel,@Param("costototal") Integer costototal);

    @Modifying
    @Transactional
    @Query (value ="UPDATE servicios SET nombre= :nombre, descripcion= :descripcion , costototal= :costototal WHERE idservicio= :idservicio", nativeQuery = true)
    void actualizarServicio(@Param("idservicio") Integer idservicio, @Param("nombre") String nombre,@Param("descripcion") String descripcion,@Param("costototal") Integer costototal);

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

    @Query (value = "SELECT s.idservicio AS ID_SERV, s.nombre AS NOMBRE, s.costototal AS COSTO_TOTAL\r\n" + //
            "FROM servicios s, usuarios u, reservas r\r\n" + //
            "WHERE s.nombre = 'Piscina'\r\n" + //
            "AND s.costoTotal BETWEEN CONVERT(INT, :precioinicio) AND CONVERT(INT, :preciofin)\r\n" + //
            "AND u.rol = 'empleado'\r\n" + //
            "AND u.nombre = :nombre\r\n" + //
            "AND r.idusuario = u.idusuario\r\n" + //
            "AND r.fechainicio >= TO_DATE(:fechainicioo, 'YYYY-MM-DD')\r\n" + //
            "AND r.fechafin <= TO_DATE(:fechafino, 'YYYY-MM-DD')", nativeQuery = true)
    Collection<RespuestaServiciosCaracteristicas> darServiciosCaracteristicas(@Param("precioinicio") String precioinicio, @Param("preciofin") String preciofin, @Param("nombre") String nombre, @Param("fechainicioo") String fechainicioo, @Param("fechafino") String fechafino);

    @Query (value = "SELECT s.nombre AS nombre_servicio, COUNT(rs.idservicio) AS veces_solicitado " +//
                    "FROM servicios s " +//
                    "INNER JOIN reservas_servicios rs ON s.idservicio = rs.idservicio " +//
                    "WHERE rs.fechareserva BETWEEN TO_DATE('2023/01/01 12:00', 'yyyy/mm/dd hh24:mi') AND TO_DATE('2023/12/31 12:00', 'yyyy/mm/dd hh24:mi') " +//
                    "GROUP BY s.idservicio, s.nombre " +//
                    "HAVING COUNT(rs.idservicio) < 3", nativeQuery = true)
    Collection<RespuestaServiciosNoMuchaDemanda> darServiciosNoMuchaDemanda();

}



