package uniandes.edu.co.proyecto.repositorio;

import uniandes.edu.co.proyecto.modelo.Producto;

import java.sql.Timestamp;
import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ProductoRepository extends JpaRepository<Producto, Integer>{
        
        /*The only attributes are Integer idProducto and Integer precio */
        @Query(value = "SELECT * FROM productos", nativeQuery = true)
        Collection<Producto> darProductos();

        @Query(value = "SELECT * FROM productos WHERE idProducto = :idProducto", nativeQuery = true)
        Producto darProductoPorId(@Param("idProducto") Integer idProducto);

        @Modifying
        @Transactional
        @Query(value = "INSERT INTO productos (idProducto, precio) VALUES (parranderos_sequence.nextval, :precio)", nativeQuery = true)
        void insertarProducto(@Param("precio") Integer precio);

        @Modifying
        @Transactional
        @Query(value = "UPDATE productos SET precio = :precio WHERE idProducto = :idProducto", nativeQuery = true)
        void actualizarProducto(@Param("idProducto") Integer idProducto, @Param("precio") Integer precio);

        @Modifying
        @Transactional
        @Query(value = "DELETE FROM productos WHERE idProducto = :idProducto", nativeQuery = true)
        void eliminarProducto(@Param("idProducto") Integer idProducto);

    
}
