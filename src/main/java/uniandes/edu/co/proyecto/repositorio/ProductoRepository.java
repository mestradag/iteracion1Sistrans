package uniandes.edu.co.proyecto.repositorio;

import uniandes.edu.co.proyecto.modelo.Producto;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ProductoRepository extends JpaRepository<Producto, Integer>{
        
        /*The only attributes are Integer idproducto and Integer precio */
        @Query(value = "SELECT * FROM productos", nativeQuery = true)
        Collection<Producto> darProductos();

        @Query(value = "SELECT * FROM productos WHERE idproducto = :idproducto", nativeQuery = true)
        Producto darProductoPorId(@Param("idproducto") Integer idproducto);

        @Modifying
        @Transactional
        @Query(value = "INSERT INTO productos (idproducto, precio) VALUES (parranderos_sequence.nextval, :precio)", nativeQuery = true)
        void insertarProducto(@Param("precio") Integer precio);

        @Modifying
        @Transactional
        @Query(value = "UPDATE productos SET precio = :precio WHERE idproducto = :idproducto", nativeQuery = true)
        void actualizarProducto(@Param("idproducto") Integer idproducto, @Param("precio") Integer precio);

        @Modifying
        @Transactional
        @Query(value = "DELETE FROM productos WHERE idproducto = :idproducto", nativeQuery = true)
        void eliminarProducto(@Param("idproducto") Integer idproducto);

    
}
