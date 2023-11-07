package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Hotel;

public interface HotelRepository extends JpaRepository <Hotel, String> {
    
    @Query(value = "SELECT * FROM hoteles", nativeQuery=true)
    Collection<Hotel> darHoteles();

    @Query(value= "SELECT * FROM hoteles WHERE nombre= :nombre", nativeQuery=true)
    Hotel darHotel(@Param("nombre") String nombre);


    //@Param("nombre") String nombre
    @Modifying
    @Transactional
    @Query(value= "INSERT INTO hoteles(nombre, ciudad) VALUES (:nombre, :ciudad)", nativeQuery=true)
    void insertarHotel(@Param("ciudad") String ciudad);

    @Modifying
    @Transactional
    @Query(value ="UPDATE hoteles SET ciudad= :ciudad WHERE nombre = :nombre", nativeQuery = true)
    void actualizarHotel(@Param("nombre") String nombre, @Param("ciudad") String ciudad);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM hoteles WHERE nombre= :nombre", nativeQuery = true)
    void eliminarHotel(@Param("nombre") String nombre);

}


