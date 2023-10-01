package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Usuario;

public interface UsuarioRepository extends JpaRepository <Usuario, Integer>{
    
    @Query(value = "SELECT * FROM usuarios", nativeQuery=true)
    Collection<Usuario> darUsuario();

    @Query(value= "SELECT * FROM usuarios WHERE idUsuario= :idUsuario", nativeQuery=true)
    Usuario darUsuario(@Param("idUsuario") Integer idUsuario);

    @Modifying
    @Transactional
    @Query(value= "INSERT INTO usuarios(idUsuario, nombre, correo, rol, id_hotel) VALUES (parranderos_sequence.nextval, :nombre, :correo, :rol, :idHotel)", nativeQuery=true)
    void insertarUsuario(@Param("nombre") String nombre, @Param("correo") String correo, @Param("rol") String rol, @Param("idHotel") Integer idHotel);

    @Modifying
    @Transactional
    @Query(value ="UPDATE usuarios SET nombre= :nombre, correo= :correo, rol= :rol idHotel= :idHotel WHERE idUsuario = :idUsuario", nativeQuery = true)
    void updateUsuario(@Param("idUsuario") Integer idUsuario, @Param("nombre") String nombre, @Param("rol") String rol, @Param("idHotel") Integer idHotel);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM usuarios  WHERE idUsuario= :idUsuario", nativeQuery = true)
    void eliminarUsuario(@Param("idUsuario") Integer idUsuario);
}
