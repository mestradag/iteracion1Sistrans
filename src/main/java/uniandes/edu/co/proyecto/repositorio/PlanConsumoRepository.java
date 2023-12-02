package uniandes.edu.co.proyecto.repositorio;

import java.sql.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.DeleteQuery;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Update;

import uniandes.edu.co.proyecto.modelo.Hotel;
import uniandes.edu.co.proyecto.modelo.PlanConsumo;

public interface PlanConsumoRepository extends MongoRepository<PlanConsumo, Integer>{


    @Query("{_id: ?0}")
    PlanConsumo darPlanConsumo(Integer id);

    @Query("")
    List<PlanConsumo> darPlanConsumos();

    // @Modifying
    // @Transactional
    // @Query(value= "INSERT INTO planes_c(idplanconsumo, nombre, descuentoalojamiento, descuentobar, descuentorestaurante, descuentoservicio, costofijo, fechainicial, durancion, valorfinal, valido) VALUES (parranderos_sequence.nextval, :nombre, :descuentoalojamiento, :descuentobar, :descuentorestaurante, :descuentoservicio, :costofijo, :fechainicial, :durancion, :valorfinal, :valido)", nativeQuery=true)
    // void insertarPlanConsumo(@Param("nombre") String nombre, @Param("descuentoalojamiento") Double descuentoalojamiento, @Param("descuentobar") Double descuentobar, @Param("descuentorestaurante") Double descuentorestaurante, @Param("descuentoservicio") Double descuentoservicio, @Param("costofijo") Integer costofijo, @Param("fechainicial") Date fechainicial, @Param("durancion") Integer durancion, @Param("valorfinal") Double valorfinal, @Param("valido") Boolean valido);

    @Query("{_id: ?0}")
    @Update("{$push:{nombre:?1, descuentoalojamiento:?2, descuentobar:?3, descuentorestaurante:?4, descuentoservicio:?5, costofijo:?6, fechainicial:?7, duracion:?8, valorfinal:?9, valido:?10}}")
    void actualizarPlanConsumo(Integer idplanconsumo, String nombre, Double descuentoalojamiento, Double descuentobar, Double descuentorestaurante, Double descuentoservicio, Integer costofijo, Date fechainicial, Integer durancion,  Double valorfinal, Boolean valido);

    @DeleteQuery("{_id: ?0}")
    void eliminarPlanConsumo(Integer idplanconsumo);}