package uniandes.edu.co.proyecto.repositorio;
import uniandes.edu.co.proyecto.modelo.Habitacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import jakarta.transaction.Transactional;
import java.util.Collection;

public interface HabitacionRepository extends JpaRepository<Habitacion, Integer>{

    public interface RespuestaDineroRecolectado {
        
        int getID_HAB();
        int getDINERO_REC();

    }

    public interface RespuestaIndiceOcupacion {

        int getID_HAB();
        int getUSUARIOS_EN_HABITACION();
        float getINDICE_OCUPACION();

    }

    public interface RespuestaMayorDemanda {
        
        String getFechainicio();
        String getHabitaciones_ocupadas();

    }

    public interface RespuestaMasConsumido {
        
        int getMOST_OCCURRING();
        int getLEAST_OCCURRING();
        int getMOST_OCUPADO();
        int getLEAST_OCUPADO();

    }

    @Query(value = "SELECT * FROM habitaciones FETCH FIRST 30 ROWS ONLY", nativeQuery = true)
    Collection<Habitacion> darHabitaciones();

    @Query(value = "SELECT * FROM habitaciones WHERE idhabitacion = :idhabitacion", nativeQuery = true)
    Habitacion darHabitacion(@Param("idhabitacion") int idhabitacion);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO habitaciones (idhabitacion, capacidad, disponible, tipo, dotacion, precionoche,nombrehotel) VALUES (parranderos_sequence.nextval, :capacidad, :disponible, :tipo, :dotacion, :precionoche, :nombrehotel)", nativeQuery = true)
    void insertarHabitacion(@Param("capacidad") int capacidad, @Param("disponible") Boolean disponible, @Param("tipo") String tipo, @Param("dotacion") String dotacion, @Param("precionoche") int precionoche, @Param("nombrehotel") String nombrehotel);

    @Modifying
    @Transactional
    @Query(value = "UPDATE habitaciones SET capacidad = :capacidad, disponible = :disponible, tipo = :tipo, dotacion = :dotacion, precionoche = :precionoche WHERE idhabitacion = :idhabitacion", nativeQuery = true)
    void actualizarHabitacion(@Param("idhabitacion") int idHabitacion, @Param("capacidad") int capacidad, @Param("disponible") Boolean disponible, @Param("tipo") String tipo, @Param("dotacion") String dotacion, @Param("precionoche") int precioNoche);
    
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM habitaciones WHERE idhabitacion = :idhabitacion", nativeQuery = true)
    void eliminarHabitacion(@Param("idhabitacion") int idhabitacion);

    @Query(value = "SELECT rs.idhabitacion id_hab, SUM(s.costoTotal) AS dinero_rec "+//
                   "FROM reservas_servicios rs "+// 
                   "JOIN servicios s ON rs.idservicio = s.idservicio "+//
                   "WHERE rs.fechareserva BETWEEN TO_DATE('2023/01/01 12:00', 'yyyy/mm/dd hh24:mi') AND TO_DATE('2023/12/31 12:00', 'yyyy/mm/dd hh24:mi') " + //
                   "GROUP BY rs.idhabitacion", nativeQuery = true)
    Collection<RespuestaDineroRecolectado> darDineroRecolectadoPorHabitacion();
    
    @Query (value = "SELECT h.idhabitacion AS id_hab, " +//
                    "COUNT(DISTINCT u.idusuario) AS usuarios_en_habitacion, " +//
                    "ROUND((COUNT(DISTINCT u.idusuario) / 365) * 100, 2) AS indice_ocupacion " +//
                    "FROM habitaciones h " +//
                    "INNER JOIN reservas r ON h.idhabitacion = r.idhabitacion " +//
                    "AND r.fechainicio  BETWEEN TO_DATE('2023/01/01 12:00', 'yyyy/mm/dd hh24:mi') AND TO_DATE('2023/12/31 12:00', 'yyyy/mm/dd hh24:mi') " +//
                    "INNER JOIN usuarios u ON r.idusuario = u.idusuario " +//
                    "GROUP BY h.idhabitacion ", nativeQuery = true)
    Collection<RespuestaIndiceOcupacion> darIndiceOcupacion();


    @Query (value = "SELECT r.fechainicio fechainicio, COUNT(DISTINCT r.idhabitacion) AS habitaciones_ocupadas " + //
            "FROM reservas r " + //
            "INNER JOIN cuentas_c c ON r.idcuenta = c.idcuenta " + //
            "GROUP BY r.fechainicio " + //
            "ORDER BY habitaciones_ocupadas DESC " + //
            "FETCH FIRST 1 ROWS ONLY ", nativeQuery = true)
    Collection<RespuestaMayorDemanda> darMayorDemanda();


    @Query (value = 
            "SELECT " + //
            "    MIN(LEAST_SERVICE.IDSERVICIO) AS MOST_OCCURRING, " + //
            "    MAX(MOST_SERVICE.IDSERVICIO) AS LEAST_OCCURRING, " + //
            "    MAX(MOST_ROOM.IDHABITACION) AS MOST_OCUPADO, " + //
            "    MIN(LEAST_ROOM.IDHABITACION) AS LEAST_OCUPADO " + //
            "FROM ( " + //
            "    SELECT IDSERVICIO, COUNT(IDSERVICIO) AS SERVICE_COUNT " + //
            "    FROM S_CONSUMIDOS " + //
            "    GROUP BY IDSERVICIO " + //
            ") MOST_SERVICE " + //
            "JOIN ( " + //
            "    SELECT IDSERVICIO, COUNT(IDSERVICIO) AS SERVICE_COUNT " + //
            "    FROM S_CONSUMIDOS " + //
            "    GROUP BY IDSERVICIO " + //
            ") LEAST_SERVICE ON MOST_SERVICE.SERVICE_COUNT = ( " + //
            "    SELECT MAX(SERVICE_COUNT) FROM ( " + //
            "        SELECT COUNT(IDSERVICIO) AS SERVICE_COUNT " + //
            "        FROM S_CONSUMIDOS " + //
            "        GROUP BY IDSERVICIO " + //
            "    ) " + //
            ") OR LEAST_SERVICE.SERVICE_COUNT = ( " + //
            "    SELECT MIN(SERVICE_COUNT) FROM ( " + //
            "        SELECT COUNT(IDSERVICIO) AS SERVICE_COUNT " + //
            "        FROM S_CONSUMIDOS " + //
            "        GROUP BY IDSERVICIO " + //
            "    ) " + //
            ") " + //
            "JOIN ( " + //
            "    SELECT IDHABITACION, COUNT(IDHABITACION) AS ROOM_COUNT " + //
            "    FROM HABITACIONES " + //
            "    GROUP BY IDHABITACION " + //
            ") MOST_ROOM ON MOST_ROOM.ROOM_COUNT = ( " + //
            "    SELECT MAX(ROOM_COUNT) FROM ( " + //
            "        SELECT COUNT(IDHABITACION) AS ROOM_COUNT " + //
            "        FROM HABITACIONES " + //
            "        GROUP BY IDHABITACION " + //
            "    ) " + //
            ") " + //
            "JOIN ( " + //
            "    SELECT IDHABITACION, COUNT(IDHABITACION) AS ROOM_COUNT " + //
            "    FROM HABITACIONES " + //
            "    GROUP BY IDHABITACION " + //
            ") LEAST_ROOM ON LEAST_ROOM.ROOM_COUNT = ( " + //
            "    SELECT MIN(ROOM_COUNT) FROM ( " + //
            "        SELECT COUNT(IDHABITACION) AS ROOM_COUNT " + //
            "        FROM HABITACIONES " + //
            "        GROUP BY IDHABITACION " + //
            "    ) " + //
            ") ", nativeQuery = true)
    Collection<RespuestaMasConsumido> darMasConsumido();
    
}

