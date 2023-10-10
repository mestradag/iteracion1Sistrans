package uniandes.edu.co.proyecto.repositorio;

import java.sql.Date;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.PlanConsumo;

public interface PlanConsumoRepository extends JpaRepository <PlanConsumo, Integer>{

    @Query(value = "SELECT * FROM planes_c", nativeQuery=true)
    Collection<PlanConsumo> darPlanConsumos();

    @Query(value= "SELECT * FROM planes_c WHERE idplanconsumo= :idplanconsumo", nativeQuery=true)
    PlanConsumo darPlanConsumo(@Param("idplanconsumo") Integer idplanconsumo);

    @Modifying
    @Transactional
    @Query(value= "INSERT INTO planes_c(idplanconsumo, nombre, descuentoalojamiento, descuentobar, descuentorestaurante, descuentoservicio, costofijo, fechainicial, durancion, valorfinal, valido) VALUES (parranderos_sequence.nextval, :nombre, :descuentoalojamiento, :descuentobar, :descuentorestaurante, :descuentoservicio, :costofijo, :fechainicial, :durancion, :valorfinal, :valido)", nativeQuery=true)
    void insertarPlanConsumo(@Param("nombre") String nombre, @Param("descuentoalojamiento") Double descuentoalojamiento, @Param("descuentobar") Double descuentobar, @Param("descuentorestaurante") Double descuentorestaurante, @Param("descuentoservicio") Double descuentoservicio, @Param("costofijo") Integer costofijo, @Param("fechainicial") Date fechainicial, @Param("durancion") Integer durancion, @Param("valorfinal") Double valorfinal, @Param("valido") Boolean valido);

    @Modifying
    @Transactional
    @Query(value ="UPDATE planes_c SET nombre= :nombre, descuentoalojamiento= :descuentoalojamiento, descuentobar= :descuentobar, descuentorestaurante= :descuentorestaurante, descuentoservicio= :descuentoservicio, costofijo= :costofijo, fechainicial= :fechainicial, durancion= :durancion, valorfinal= :valorfinal, valido= :valido WHERE idplanconsumo = :idplanconsumo", nativeQuery = true)
    void actualizarPlanConsumo(@Param("idplanconsumo") Integer idplanconsumo, @Param("nombre") String nombre, @Param("descuentoalojamiento") Double descuentoalojamiento, @Param("descuentobar") Double descuentobar, @Param("descuentorestaurante") Double descuentorestaurante, @Param("descuentoservicio") Double descuentoservicio, @Param("costofijo") Integer costofijo, @Param("fechainicial") Date fechainicial, @Param("durancion") Integer durancion, @Param("valorfinal") Double valorfinal, @Param("valido") Boolean valido);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM planes_c WHERE idplanconsumo= :idplanconsumo", nativeQuery = true)
    void eliminarPlanConsumo(@Param("idplanconsumo") Integer idplanconsumo);
}