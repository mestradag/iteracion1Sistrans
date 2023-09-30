package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Hotel;

public interface HotelRepository extends JpaRepository <Hotel, Integer> {
    
    @Query(value = "SELECT * FROM hoteles", nativeQuery=true)
    Collection<Hotel> darHoteles();

    @Query(value= "SELECT * FROM hoteles WHERE id= :id", nativeQuery=true)
    Hotel darHotel(@Param("id") long id);

    @Modifying
    @Transactional
    @Query(value= "INSERT INTO hoteles(nombre, ciudad) VALUES (parranderos_sequence.nextval, :nombre, :ciudad)", nativeQuery=true)
    void insertarHotel(@Param("nombre") String nombre, @Param("ciudad") String ciudad);

    @Modifying
    @Transactional
    @Query(value ="UPDATE hoteles SET nombre= :nombre, ciudad= :ciudad WHERE id = :id", nativeQuery = true)
    void updateHotel(@Param("id") int id, @Param("nombre") String nombre, @Param("ciudad") String ciudad);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM hoteles  WHERE id= :id", nativeQuery = true)
    void eliminarHotel(@Param("id") int id);

}


