package uniandes.edu.co.proyecto.modelo;
import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;   
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;
@Entity
@Table(name="habitaciones")
public abstract class Habitacion {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private Integer cantidad;
    private Boolean disponible;
    private String tipo;
    private String dotacion;
    private Integer precioNoche;

    public Habitacion(Integer id, Integer cantidad, Boolean disponible, String tipo, String dotacion, Integer precioNoche) {
        this.id = id;
        this.cantidad = cantidad;
        this.disponible = disponible;
        this.tipo = tipo;
        this.dotacion = dotacion;
        this.precioNoche = precioNoche;
    }
    public Habitacion()
    {;}
    public Integer getId() {
        return id;
    }
    public Integer getCantidad() {
        return cantidad;
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
    public Integer getPrecioNoche() {
        return precioNoche;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
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
    public void setPrecioNoche(Integer precioNoche) {
        this.precioNoche = precioNoche;
    }
    

}

