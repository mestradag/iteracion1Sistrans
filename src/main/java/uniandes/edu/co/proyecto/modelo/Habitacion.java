package uniandes.edu.co.proyecto.modelo;
import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;   
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.GenerationType;

@Entity
@Table(name="habitaciones")
public class Habitacion {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer idhabitacion;
    private Integer capacidad;
    private Boolean disponible;
    private String tipo;
    private String dotacion;
    private Integer precionoche;

    @ManyToOne
    @JoinColumn(name = "nombrehotel", referencedColumnName = "nombre")
    private Hotel nombrehotel;


    public Habitacion(
        Integer capacidad, 
        Boolean disponible, 
        String tipo, 
        String dotacion, 
        Integer precionoche,
        Hotel nombrehotel
        ) {
        this.capacidad = capacidad;
        this.disponible = disponible;
        this.tipo = tipo;
        this.dotacion = dotacion;
        this.precionoche = precionoche;
        this.nombrehotel = nombrehotel;
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
    public Hotel getNombrehotel() {
        return nombrehotel;
    }
    public void setNombrehotel(Hotel nombrehotel) {
        this.nombrehotel = nombrehotel;
    }
    @Override
    public String toString() {
        return "Habitacion [capacidad=" + capacidad + ", disponible=" + disponible + ", dotacion=" + dotacion
                + ", idhabitacion=" + idhabitacion + ", nombrehotel=" + nombrehotel.getNombre() + ", precionoche=" + precionoche
                + ", tipo=" + tipo + "]";
    }
}