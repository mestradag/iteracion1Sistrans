package uniandes.edu.co.proyecto.repositorio;

import uniandes.edu.co.proyecto.modelo.ProductosOfrecidos;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ProductosOfrecidosRepository extends JpaRepository<ProductosOfrecidos, Integer>{
    @Query(value = "SELECT * FROM productos_ecomerciales", nativeQuery = true)
    Collection<ProductosOfrecidos> darProductosOfrecidos();

    @Query(value = "SELECT * FROM productos_ecomerciales WHERE idservicio = :idservicio AND idproducto = :idproducto", nativeQuery = true)
    ProductosOfrecidos darProductoOfrecido(@Param("idservicio") int idservicio, @Param("idproducto") int idproducto);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO productos_ecomerciales (idservicio, idproducto) VALUES (:idservicio, :idproducto)", nativeQuery = true)
    void insertarProductoOfrecido(@Param("idservicio") int idservicio, @Param("idproducto") int idproducto);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM productos_ecomerciales WHERE idservicio = :idservicio AND idproducto = :idproducto", nativeQuery = true)
    void eliminarProductoOfrecido(@Param("idservicio") int idservicio, @Param("idproducto") int idproducto);
    
}
