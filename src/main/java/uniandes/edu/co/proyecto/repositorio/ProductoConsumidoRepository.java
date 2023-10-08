package uniandes.edu.co.proyecto.repositorio;

import uniandes.edu.co.proyecto.modelo.ProductoConsumido;
import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ProductoConsumidoRepository extends JpaRepository<ProductoConsumido, Integer>{
        
        @Query(value = "SELECT * FROM productos_c", nativeQuery = true)
        Collection<ProductoConsumido> darProductosConsumidos();
    
        @Query(value = "SELECT * FROM productos_c WHERE idproducto = :idproducto AND idcuenta = :idcuenta", nativeQuery = true)
        ProductoConsumido darProductoConsumido(@Param("idproducto") int idproducto, @Param("idcuenta") int idcuenta);
    
        @Modifying
        @Transactional
        @Query(value = "INSERT INTO productos_c (idproducto, idcuenta) VALUES (:idproducto, :idcuenta)", nativeQuery = true)
        void insertarProductoConsumido(@Param("idproducto") int idproducto, @Param("idcuenta") int idcuenta);
    
        @Modifying
        @Transactional
        @Query(value = "DELETE FROM productos_c WHERE idproducto = :idproducto AND idcuenta = :idcuenta", nativeQuery = true)
        void eliminarProductoConsumido(@Param("idproducto") int idproducto, @Param("idcuenta") int idcuenta);
    

    
}
