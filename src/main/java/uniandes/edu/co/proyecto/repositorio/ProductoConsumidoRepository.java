package uniandes.edu.co.proyecto.repositorio;

import uniandes.edu.co.proyecto.modelo.ProductoConsumido;
import java.sql.Timestamp;
import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ProductoConsumidoRepository extends JpaRepository<ProductoConsumido, Integer>{
        
        @Query(value = "SELECT * FROM productos_c", nativeQuery = true)
        Collection<ProductoConsumido> darProductosConsumidos();
    
        @Query(value = "SELECT * FROM productos_c WHERE idProducto = :idProducto AND idCuenta = :idCuenta", nativeQuery = true)
        ProductoConsumido darProductoConsumido(@Param("idProducto") int idProducto, @Param("idCuenta") int idCuenta);
    
        @Modifying
        @Transactional
        @Query(value = "INSERT INTO productos_c (idProducto, idCuenta) VALUES (:idProducto, :idCuenta)", nativeQuery = true)
        void insertarProductoConsumido(@Param("idProducto") int idProducto, @Param("idCuenta") int idCuenta);
    
        @Modifying
        @Transactional
        @Query(value = "DELETE FROM productos_c WHERE idProducto = :idProducto AND idCuenta = :idCuenta", nativeQuery = true)
        void eliminarProductoConsumido(@Param("idProducto") int idProducto, @Param("idCuenta") int idCuenta);
    

    
}
