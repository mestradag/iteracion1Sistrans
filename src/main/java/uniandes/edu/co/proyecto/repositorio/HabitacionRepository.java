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
    
}

