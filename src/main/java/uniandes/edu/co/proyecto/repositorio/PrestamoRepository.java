package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Prestamo;

public interface PrestamoRepository extends JpaRepository<Prestamo, Integer> {
    @Query(value="SELECT * FROM prestamos", nativeQuery=true) 
    Collection<Prestamo> darPrestamos();

    @Query(value="SELECT * FROM prestamos WHERE id = :id", nativeQuery = true)
    Prestamo darPrestamo(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value="INSERT INTO prestamos (id, utensilio, cantidad) VALUES(parranderos_sequence.nextval, :id, :utensilio, :cantidad", nativeQuery=true) 
    void insertarPrestamo(@Param("utensilio") String utensilio,@Param("cantidad") Integer cantidad);

    @Modifying
    @Transactional
    @Query (value ="UPDATE prestamos SET utensilio=:utensilio, cantidad=:cantidad", nativeQuery = true)
    void actualizarPrestamo(@Param("id") Integer id,@Param("utenislio") String utensilio,@Param("cantidad") Integer cantidad);

    @Modifying
    @Transactional
    @Query (value ="DELETE FROM prestamos WHERE id=:id", nativeQuery=true)
    void eliminarPrestamo(@Param("id") int id);
}
