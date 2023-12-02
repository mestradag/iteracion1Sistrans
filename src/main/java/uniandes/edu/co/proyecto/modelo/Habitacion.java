package uniandes.edu.co.proyecto.modelo;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;

@Document(collection="habitaciones")
public class Habitacion {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer idhabitacion;
    
    private Integer capacidad;
    private Boolean disponible;
    private String tipo;
    private String dotacion;
    private Integer precionoche;

    public Habitacion(
        Integer capacidad, 
        Boolean disponible, 
        String tipo, 
        String dotacion, 
        Integer precionoche
        ) {
        this.capacidad = capacidad;
        this.disponible = disponible;
        this.tipo = tipo;
        this.dotacion = dotacion;
        this.precionoche = precionoche;
    }

    public Habitacion()
    {;}
    public Integer getIdhabitacion() {
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
    public void setIdhabitacion(Integer idhabitacion) {
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
   
    @Override
    public String toString() {
        return "Habitacion [capacidad=" + capacidad + ", disponible=" + disponible + ", dotacion=" + dotacion
                + ", idhabitacion=" + idhabitacion + ", precionoche=" + precionoche
                + ", tipo=" + tipo + "]";
    }
}