package uniandes.edu.co.proyecto.repositorio;
import java.util.List;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.DeleteQuery;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;

import uniandes.edu.co.proyecto.modelo.Hotel;

public interface HotelRepository extends MongoRepository<Hotel, String> {
    
    public class RespuestadarHotelesPorCiudad{
        String ciudad;
        
        public RespuestadarHotelesPorCiudad(String ciudad) {
            this.ciudad = ciudad;
        }
        public void setCiudad(String ciudad) {
            this.ciudad = ciudad;
        }
        public String getCiudad() {
            return ciudad;
        }
    }

    public class RespuestadarServicios{
        List<Integer> servicios;

        public RespuestadarServicios(List<Integer> servicios){
            this.servicios = servicios;
        }

        public List<Integer> getServicios() {
            return servicios;
        }

        public void setServicios(List<Integer> servicios) {
            this.servicios = servicios;
        }
        
    }

    //find
    @Query("{_id: ?0}")
    Hotel darHotel(String nombre);

    @Query("")
    List<Hotel> darHoteles();

    @Query("{_id: ?0}")
    @Update("{$push:{ciudad:?1}}")
    void actualizarHotel(String nombre,  String ciudad);


    //aggregate
    @Aggregation(pipeline={"{$group:{_id:'$ciudad', cantidad:{$sum:1}}}","{$project:{'ciudad':'$_id',cantidad:1}}"})
    List<RespuestadarHotelesPorCiudad> darHotelesPorCiudad();

    //update
    @Query("{_id: ?0}")
    @Update("{$push:{servicios:{nombre:?1, descripcion:?2, costototal:?3}}}")
    void aniadirServicioAHotel(int id_hotel, String nombre, String descripcion, int costototal);

    //RF Dar servicios hotel
    @Query("{_id: ?0},{servicios:1}")
    List<RespuestadarServicios> darServicioHotel(int id);
    //Retorna algo del tipo
    // {
    //     _id: 288,
    //     servicios: [
    //       46,
    //       55,
    //       16 ]
    // }

    @DeleteQuery("{_id: ?0}")
    void eliminarHotel(String nombre);

}



