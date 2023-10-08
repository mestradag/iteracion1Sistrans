package uniandes.edu.co.proyecto.repositorio;

import uniandes.edu.co.proyecto.modelo.ProductosMenu;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ProductosMenuRepository extends JpaRepository<ProductosMenu, Integer>{

    @Query(value = "SELECT * FROM productos_e", nativeQuery = true)
    Collection<ProductosMenu> darProductosMenu();

    @Query(value = "SELECT * FROM productos_e WHERE idservicio = :idservicio AND idproducto = :idproducto", nativeQuery = true)
    ProductosMenu darProductoMenu(@Param("idservicio") int idservicio, @Param("idproducto") int idproducto);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO productos_e (idservicio, idproducto) VALUES (:idservicio, :idproducto)", nativeQuery = true)
    void insertarProductoMenu(@Param("idservicio") int idservicio, @Param("idproducto") int idproducto);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM productos_e WHERE idservicio = :idservicio AND idproducto = :idproducto", nativeQuery = true)
    void eliminarProductoMenu(@Param("idservicio") int idservicio, @Param("idproducto") int idproducto);
    
}
