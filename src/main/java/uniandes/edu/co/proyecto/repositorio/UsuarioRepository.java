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

    @Query(value= "SELECT * FROM usuarios WHERE id= :id", nativeQuery=true)
    Usuario darUsuario(@Param("id") long id);

    @Modifying
    @Transactional
    @Query(value= "INSERT INTO usuarios(idUsuario, nombre, correo, rol) VALUES (parranderos_sequence.nextval, :idUsuario, :nombre, :correo, :rol)", nativeQuery=true)
    void insertarUsuario(@Param("idUsuario") int idUsuario, @Param("nombre") String nombre, @Param("correo") String correo, @Param("rol") String rol);

    //ID_usuario?
    @Modifying
    @Transactional
    @Query(value ="UPDATE usuarios SET id= :id, idUsuario= :idUsuario, nombre= :nombre, correo= :correo, rol= :rol WHERE id = :id", nativeQuery = true)
    void updateUsuario(@Param("id") int id, @Param("idUsuario") int idUsuario, @Param("nombre") String nombre, @Param("rol") String rol);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM usuarios  WHERE id= :id", nativeQuery = true)
    void eliminarUsuario(@Param("id") int id);
}
