package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.antlr.v4.runtime.atn.SemanticContext.AND;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Usuario;

public interface UsuarioRepository extends JpaRepository <Usuario, Integer>{
    
    public interface RespuestaBuenosClientes {
        String getNombre();
        Integer getTotalcost();
    }

    public interface RespuestaConsumoHotel {
        String getIdusuario();
        String getNombre_cliente();
        String getNombre_servicio();
        String getVeces_consumido();
    }

    public interface RespuestaClientesExcelentes{
        String getNombre();
        String getCorreo();


    }
    @Query(value = "SELECT * FROM usuarios FETCH FIRST 30 ROWS ONLY ", nativeQuery = true)
    Collection<Usuario> darUsuarios();

    @Query(value = "SELECT * FROM usuarios WHERE idusuario= :idusuario", nativeQuery = true)
    Usuario darUsuario(@Param("idusuario") Integer idusuario);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO usuarios(idusuario, nombre, correo, rol, nombrehotel) VALUES (parranderos_sequence.nextval, :nombre, :correo, :rol, :nombrehotel)", nativeQuery = true)
    void insertarUsuario(@Param("nombre") String nombre, @Param("correo") String correo, @Param("rol") String rol, @Param("nombrehotel") String nombrehotel);

    @Modifying
    @Transactional
    @Query(value ="UPDATE usuarios SET nombre= :nombre, correo= :correo, rol= :rol WHERE idusuario = :idusuario", nativeQuery = true)
    void actualizarUsuario(@Param("idusuario") Integer idusuario, @Param("nombre") String nombre, @Param("correo") String correo, @Param("rol") String rol);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM usuarios WHERE idusuario= :idusuario", nativeQuery = true)
    void eliminarUsuario(@Param("idusuario") Integer idusuario);



    @Query(value = "SELECT * FROM usuarios  ",nativeQuery=true)
    Collection<Usuario> darBuenosClientes(@Param("idusuario") Integer idusuario);
    
    @Query(value = "SELECT U.NOMBRE AS nombre, SUM(S.COSTOTOTAL) AS totalcost " +
            "FROM USUARIOS U, RESERVAS R, CUENTAS_C C, S_CONSUMIDOS SC, SERVICIOS S " +
            "WHERE U.IDUSUARIO = R.IDUSUARIO " +
            "AND R.IDCUENTA = C.IDCUENTA " +
            "AND C.IDCUENTA = SC.IDCUENTA " +
            "AND SC.IDSERVICIO = S.IDSERVICIO " +
            "AND U.ROL='cliente' " +
            "AND (C.CHECKOUT - C.CHECKIN) >= INTERVAL '14' DAY " +
            "GROUP BY U.NOMBRE " +
            "HAVING SUM(S.COSTOTOTAL) > 15000000 "+
            "FETCH FIRST 30 ROWS ONLY ", nativeQuery = true)
    Collection<RespuestaBuenosClientes> darBuenosClientes();


    @Query(value ="SELECT u.idusuario idusuario, u.nombre AS nombre_cliente, s.nombre AS nombre_servicio, COUNT(rc.idservicio) AS veces_consumido " +
        "FROM usuarios u " +
        "JOIN reservas r ON u.idusuario = r.idusuario " +
        "JOIN reservas_servicios rs ON r.idhabitacion = rs.idhabitacion " +
        "JOIN servicios s ON rs.idservicio = s.idservicio " +
        "JOIN s_consumidos rc ON rc.idcuenta = r.idcuenta AND rc.idservicio = s.idservicio " +
        "WHERE rs.fechareserva BETWEEN TO_DATE(:fechainicio, 'YYYY-MM-DD') AND TO_DATE(:fechafin, 'YYYY-MM-DD') " +
        "GROUP BY u.idusuario, u.nombre, s.nombre " +
        "HAVING COUNT(rc.idservicio) >= 1 " +
        "ORDER BY CASE WHEN :orden = 'ASC' THEN u.idusuario END ASC, " +
        "         CASE WHEN :orden = 'DESC' THEN u.idusuario END DESC, " +
        "         CASE WHEN :orden = 'ASC' THEN s.nombre END ASC, " +
        "         CASE WHEN :orden = 'DESC' THEN s.nombre END DESC", nativeQuery = true)
    Collection<RespuestaConsumoHotel> darConsumoHotel(@Param("fechainicio") String fechainicio, @Param("fechafin") String fechafin, @Param("orden") String orden);

    @Query(value ="SELECT u.idusuario,u.nombre AS nombre_cliente,s.nombre AS nombre_servicio,COUNT(rc.idservicio) AS veces_consumido " + //
        "FROM usuarios u " + //
        "JOIN reservas r ON u.idusuario = r.idusuario " + //
        "JOIN reservas_servicios rs ON r.idhabitacion = rs.idhabitacion " + //
        "JOIN servicios s ON rs.idservicio = s.idservicio " + //
        "LEFT JOIN s_consumidos rc ON rc.idcuenta = r.idcuenta AND rc.idservicio = s.idservicio " + //
        "WHERE rs.fechareserva BETWEEN TO_DATE(:fechainicioo, 'YYYY-MM-DD') " + //
        "AND TO_DATE(:fechafino, 'YYYY-MM-DD') " + //
        "AND rc.idservicio IS NULL " + //
        "GROUP BY u.idusuario, u.nombre, s.nombre " + //
        "ORDER BY CASE WHEN :ordeno = 'ASC' THEN u.idusuario END ASC, " +
        "         CASE WHEN :ordeno = 'DESC' THEN u.idusuario END DESC, " +
        "         CASE WHEN :ordeno = 'ASC' THEN s.nombre END ASC, " +
        "         CASE WHEN :ordeno = 'DESC' THEN s.nombre END DESC", nativeQuery = true)
    Collection<RespuestaConsumoHotel> darNoConsumoHotel(@Param("fechainicioo") String fechainicioo, @Param("fechafino") String fechafino, @Param("ordeno") String ordeno);


    @Query(value ="SELECT Distinct c1.nombre AS nombre, c1.correo AS correo\r\n" + //
            "FROM (SELECT U.idusuario,u.nombre,u.correo,C.CHECKIN,R.IDHABITACION\r\n" + //
            "        FROM CUENTAS_C C\r\n" + //
            "        INNER JOIN RESERVAS R ON R.IDCUENTA=C.IDCUENTA\r\n" + //
            "        INNER JOIN USUARIOS U ON U.IDUSUARIO=R.IDUSUARIO) C1\r\n" + //
            "JOIN (SELECT U.idusuario,u.nombre,u.correo,C.CHECKIN,R.IDHABITACION\r\n" + //
            "        FROM CUENTAS_C C\r\n" + //
            "        INNER JOIN RESERVAS R ON R.IDCUENTA=C.IDCUENTA\r\n" + //
            "        INNER JOIN USUARIOS U ON U.IDUSUARIO=R.IDUSUARIO) C2\r\n" + //
            "ON C1.IDUSUARIO=C2.IDUSUARIO\r\n" + //
            "INNER JOIN HABITACIONES H ON C1.IDHABITACION=H.IDHABITACION\r\n" + //
            "INNER JOIN RESERVAS_SERVICIOS RS ON H.IDHABITACION = RS.IDHABITACION\r\n" + //
            "INNER JOIN SERVICIOS S ON S.IDSERVICIO=RS.IDSERVICIO\r\n" + //
            "WHERE  C1.CHECKIN - C2.CHECKIN >= INTERVAL '90' DAY\r\n" + //
            "AND s.costototal > 300000\r\n" + //
            "FETCH FIRST 5 ROWS ONLY  ", nativeQuery = true)
    Collection<RespuestaClientesExcelentes> darClientesExcelentes();

}

