package uniandes.edu.co.proyecto.repositorio;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.DeleteQuery;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Update;
import uniandes.edu.co.proyecto.modelo.PlanConsumo;

public interface PlanConsumoRepository extends MongoRepository<PlanConsumo, Integer>{


    @Query("{_id: ?0}")
    PlanConsumo darPlanConsumo(Integer id);

    @Query("{}")
    List<PlanConsumo> darPlanConsumos();

    @Query("{_id: ?0}")
    @Update("{$push:{nombre:?1, descuentoalojamiento:?2, descuentobar:?3, descuentorestaurante:?4, descuentoservicio:?5, costofijo:?6, fechainicial:?7, duracion:?8, valorfinal:?9, valido:?10}}")
    void actualizarPlanConsumo(Integer idplanconsumo, String nombre, Double descuentoalojamiento, Double descuentobar, Double descuentorestaurante, Double descuentoservicio, Integer costofijo, Date fechainicial, Integer durancion,  Double valorfinal, Boolean valido);

    @Query(value="{_id: ?0}", delete = true)
    void eliminarPlanConsumo(Integer idplanconsumo);}