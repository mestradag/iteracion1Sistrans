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

    @Query(value = "SELECT * FROM productos_ecomerciales WHERE idServicio = :idServicio AND idProducto = :idProducto", nativeQuery = true)
    ProductosOfrecidos darProductoOfrecido(@Param("idServicio") int idServicio, @Param("idProducto") int idProducto);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO productos_ecomerciales (idServicio, idProducto) VALUES (:idServicio, :idProducto)", nativeQuery = true)
    void insertarProductoOfrecido(@Param("idServicio") int idServicio, @Param("idProducto") int idProducto);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM productos_ecomerciales WHERE idServicio = :idServicio AND idProducto = :idProducto", nativeQuery = true)
    void eliminarProductoOfrecido(@Param("idServicio") int idServicio, @Param("idProducto") int idProducto);
    
}
