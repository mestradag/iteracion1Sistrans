package uniandes.edu.co.proyecto.repositorio;

import uniandes.edu.co.proyecto.modelo.Producto;

import java.util.List;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.DeleteQuery;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Update;

public interface ProductoRepository extends MongoRepository<Producto, Integer>{
        
        /*The only attributes are Integer idproducto and Integer precio */
        @Query("{}")
        List<Producto> darProductos();

        @Query("{_id: ?0}")
        Producto darProductoPorId(Integer idproducto);

        // @Modifying
        // @Transactional
        // @Query(value = "INSERT INTO productos (idproducto, precio) VALUES (parranderos_sequence.nextval, :precio)", nativeQuery = true)
        // void insertarProducto(@Param("precio") Integer precio);

        @Query("{_id: ?0}")
        @Update("{$push:{precio:?1}}")
        void actualizarProducto(Integer idproducto, Integer precio);

        @Query(value="{_id: ?0}", delete = true)
        void eliminarProducto(Integer idproducto);
}
