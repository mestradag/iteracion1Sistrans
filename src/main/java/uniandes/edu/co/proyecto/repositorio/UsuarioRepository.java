package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Hotel;
import uniandes.edu.co.proyecto.modelo.TipoUsuario;
import uniandes.edu.co.proyecto.modelo.Usuario;

public interface UsuarioRepository extends JpaRepository <Usuario, Integer>{
    
    @Query(value = "SELECT * FROM usuarios", nativeQuery=true)
    Collection<Usuario> darUsuarios();

    @Query(value= "SELECT * FROM usuarios WHERE idUsuario= :idUsuario", nativeQuery=true)
    Usuario darUsuario(@Param("idUsuario") Integer idUsuario);

    @Modifying
    @Transactional
    @Query(value= "INSERT INTO usuarios(idUsuario, nombre, correo, rol, nombrehotel) VALUES (parranderos_sequence.nextval, :nombre, :correo, :rol, :nombreHotel)", nativeQuery=true)
    void insertarUsuario(@Param("nombre") String nombre, @Param("correo") String correo, @Param("rol") TipoUsuario rol, @Param("nombreHotel") Hotel nombreHotel);

    @Modifying
    @Transactional
    @Query(value ="UPDATE usuarios SET nombre= :nombre, correo= :correo, rol= :rol, nombreHotel= :nombreHotel WHERE idUsuario = :idUsuario", nativeQuery = true)
    void actualizarUsuario(@Param("idUsuario") Integer idUsuario, @Param("nombre") String nombre, @Param("correo") String correo, @Param("rol") TipoUsuario rol, @Param("nombreHotel") Hotel nombreHotel);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM usuarios  WHERE idUsuario= :idUsuario", nativeQuery = true)
    void eliminarUsuario(@Param("idUsuario") Integer idUsuario);
}
