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

    @Query(value= "SELECT * FROM planes_c WHERE idPlanConsumo= :idPlanConsumo", nativeQuery=true)
    PlanConsumo darPlanConsumo(@Param("idPlanConsumo") Integer idPlanConsumo);

    @Modifying
    @Transactional
    @Query(value= "INSERT INTO planes_c(idPlanConsumo, nombre, descuentoAlojamiento, descuentoBar, descuentoRestaurante, descuentoServicios, costoFijo, fechaInicial, duracion, valorFinal, valido) VALUES (parranderos_sequence.nextval, :nombre, :descuentoAlojamiento, :descuentoBar, :descuentoRestaurante, :descuentoServicios, :costoFijo, :fechaInicial, :duracion, :valorFinal, :valido)", nativeQuery=true)
    void insertarPlanConsumo(@Param("nombre") String nombre, @Param("descuentoAljamiento") Double descuentoAlojamiento, @Param("descuentoBar") Double descuentoBar, @Param("descuentoRestaurante") Double descuentoRestaurante, @Param("descuentoServicios") Double descuentoServicios, @Param("costoFijo") Integer costoFijo, @Param("fechaInicial") Date fechaInicial, @Param("duracion") Integer duracion, @Param("valorFinal") Double valorFinal, @Param("valido") Boolean valido);

    @Modifying
    @Transactional
    @Query(value ="UPDATE planes_c SET nombre= :nombre, descuentoAlojamiento= :descuentoAlojamiento, descuentoBar= :descuentoBar, descuentoRestaurante= :descuentoRestaurante, descuentoServicios= :descuentoServicios, costoFijo= :costoFijo, fechaInicial= :fechaInicial, duracion= :duracion, valorFinal= :valorFinal, valido= :valido WHERE idPlanConsumo = :idPlanConsumo", nativeQuery = true)
    void actualizarPlanConsumo(@Param("idPlanConsumo") Integer idPlanConsumo, @Param("nombre") String nombre, @Param("descuentoAljamiento") Double descuentoAlojamiento, @Param("descuentoBar") Double descuentoBar, @Param("descuentoRestaurante") Double descuentoRestaurante, @Param("descuentoServicios") Double descuentoServicios, @Param("costoFijo") Integer costoFijo, @Param("fechaInicial") Date fechaInicial, @Param("duracion") Integer duracion, @Param("valorFinal") Double valorFinal, @Param("valido") Boolean valido);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM planes_c WHERE idPlanConsumo= :idPlanConsumo", nativeQuery = true)
    void eliminarPlanConsumo(@Param("idPlanConsumo") Integer idPlanConsumo);
}
    

