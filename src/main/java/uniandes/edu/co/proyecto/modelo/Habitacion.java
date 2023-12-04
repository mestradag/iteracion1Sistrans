package uniandes.edu.co.proyecto.modelo;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;
import org.springframework.data.annotation.Id;


@Document(collection="habitaciones")
public class Habitacion {

    @Id
    private String idhabitacion;
    
    private Integer capacidad;
    private Boolean disponible;
    private String tipo;
    private String dotacion;
    private Integer precionoche;
    private List<ReservaServicio> reservasservicios;

    public Habitacion(
        Integer capacidad, 
        Boolean disponible, 
        String tipo, 
        String dotacion, 
        Integer precionoche,
        List<ReservaServicio> reservasservicios
        ) {
        this.capacidad = capacidad;
        this.disponible = disponible;
        this.tipo = tipo;
        this.dotacion = dotacion;
        this.precionoche = precionoche;
        this.reservasservicios = reservasservicios;
    }

    public Habitacion()
    {;}
    public String getIdhabitacion() {
        return idhabitacion;
    }
    public Integer getCapacidad() {
        return capacidad;
    }
    public Boolean getDisponible() {
        return disponible;
    }
    public String getTipo() {
        return tipo;
    }
    public String getDotacion() {
        return dotacion;
    }
    public Integer getPrecionoche() {
        return precionoche;
    }
    public void setIdhabitacion(String idhabitacion) {
        this.idhabitacion = idhabitacion;
    }
    public void setCapacidad(Integer cantidad) {
        this.capacidad = cantidad;
    }
    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public void setDotacion(String dotacion) {
        this.dotacion = dotacion;
    }
    public void setPrecionoche(Integer precionoche) {
        this.precionoche = precionoche;
    }
    public List<ReservaServicio> getReservasservicios() {
        return reservasservicios;
    }
    public void setReservasservicios(List<ReservaServicio> reservasservicios) {
        this.reservasservicios = reservasservicios;
    }
    @Override
    public String toString() {
        return "Habitacion [capacidad=" + capacidad + ", disponible=" + disponible + ", dotacion=" + dotacion
                + ", _id=" + idhabitacion + ", precionoche=" + precionoche
                + ", tipo=" + tipo + "]";
    }

   
}