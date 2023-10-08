package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Lavado;

public interface LavadoRepository extends JpaRepository<Lavado, Integer> {
    @Query(value="SELECT * FROM lavado", nativeQuery=true) 
    Collection<Lavado> darLavados();

    @Query(value="SELECT * FROM lavados WHERE idservicio = :idservicio", nativeQuery = true)
    Lavado darLavado(@Param("idservicio") Integer idservicio);

    @Modifying
    @Transactional
    @Query(value="INSERT INTO lavados (idservicio, numeroPrendas, paresZapatos) VALUES(parranderos_sequence.nextval, :numeroPrendas, :paresZapatos", nativeQuery=true) 
    void insertarLavado(@Param("numeroPrendas") Integer numeroPrendas,@Param("paresZapatos") Integer paresZapatos);

    @Modifying
    @Transactional
    @Query (value ="UPDATE lavados SET  numeroPrendas=:numeroPrendas, paresZapatos=:paresZapatos WHERe idservicio:=idservicio", nativeQuery = true)
    void actualizarLavado(@Param("idservicio") Integer idservicio,@Param("numeroPrendas") Integer numeroPrendas,@Param("paresZapatos") Integer paresZapatos);

    @Modifying
    @Transactional
    @Query (value ="DELETE FROM lavados WHERE idservicio=:idservicio", nativeQuery=true)
    void eliminarLavado(@Param("idservicio") Integer idservicio);
}
