package uniandes.edu.co.proyecto.repositorio;
import uniandes.edu.co.proyecto.modelo.Habitacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.Update;

import java.util.List;

public interface HabitacionRepository extends JpaRepository<Habitacion, Integer>{

    public class RespuestadarTipodeHabitacion{
        
        String tipo;

        public RespuestadarTipodeHabitacion(Integer capacidad, Boolean disponible, String tipo, String dotacion, Integer precionoches) {
             this.tipo = tipo;
        }
        public String getTipo() {
            return tipo;
        }
        public void setTipo(String tipo) {
            this.tipo = tipo;
        }
    }

    public interface RespuestaDineroRecolectado {
        
        int getID_HAB();
        int getDINERO_REC();

    }

    //RF2 Consultar habitacion
    @Query("{_id: ?0}")
    List<Habitacion> buscarPorId(int id);

    //RF1 Actualizar tipo de habitacion
    @Query("{_id: ?0}")
    @Update("{$set:{tipo:{tipoH:?3}}}")
    void aniadirServicioAHotel(String id_hotel, String tipoH);


    //RF1 Consultar tipo de habitacion  
    @Query("{_id: ?0},{tipo:1}")
    List<RespuestadarTipodeHabitacion> darTipodeHabitacion();

    
}

