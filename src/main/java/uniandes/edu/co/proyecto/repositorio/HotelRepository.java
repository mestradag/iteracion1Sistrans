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

    @Query(value= "SELECT * FROM hoteles WHERE nombrehotel= :nombrehotel", nativeQuery=true)
    Hotel darHotel(@Param("nombrehotel") String nombrehotel);


    //@Param("nombre") String nombre
    @Modifying
    @Transactional
    @Query(value= "INSERT INTO hoteles(nombrehotel, ciudad) VALUES (:nombrehotel, :ciudad)", nativeQuery=true)
    void insertarHotel(@Param("ciudad") String ciudad);

    @Modifying
    @Transactional
    @Query(value ="UPDATE hoteles SET ciudad= :ciudad WHERE nombrehotel = :nombrehotel", nativeQuery = true)
    void actualizarHotel(@Param("nombrehotel") String nombrehotel, @Param("ciudad") String ciudad);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM hoteles WHERE nombrehotel= :nombrehotel", nativeQuery = true)
    void eliminarHotel(@Param("nombrehotel") String nombrehotel);

}


